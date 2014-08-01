package com.yermoon.server.dao.impl;

import com.yermoon.server.dao.AbstractDao;
import com.yermoon.server.dao.PageDao;
import com.yermoon.server.entity.Page;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
@Repository
public class PageDaoMysqlImpl extends AbstractDao implements PageDao {
    private static final Logger log = LoggerFactory.getLogger(PageDaoMysqlImpl.class);

    @Override
    public int insert(Page page) {
        String sql = "insert into page(pageid,cover,title,imgnum,cuserid,cusername,cdate,udate) " +
                "values(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,page.getPageId(),page.getCover(), page.getTitle(), page.getImgNum(),
                page.getCuserId(),page.getCusername(),page.getCdate(), page.getUdate());
    }

    @Override
    public int delete(int id) {
        String sql = "delete from page where id=?";
        return jdbcTemplate.update(sql, id);
    }

    /**
     * 以主键ID删除
     *
     * @param ids
     */
    @Override
    public int delete(int[] ids) {
        StringBuilder sql = new StringBuilder("delete from page where id in (");
        int i = 0;
        for (int id : ids) {
            i++;
            sql.append(id);
            if (i != ids.length) {
                sql.append(",");
            }
        }
        sql.append(")");
        return jdbcTemplate.update(sql.toString());
    }

    @Override
    public int getCount(long hashcode) {
        String sql = "select count(1)  from page where hashcode=? ";
        return jdbcTemplate.queryForInt(sql, hashcode);
    }

    @Override
    public List<Page> find(String keyWord, int start, int limit) {
        String sql = "select id,title,url,description,udate,imgnum,imgurl from page where " +
                "description like '%" + keyWord + "%' or title like '%" + keyWord + "%' order by udate desc  limit ?,?";
        if (StringUtils.isBlank(keyWord)) {
            sql = "select id,title,url,description,udate,imgnum,imgurl from page order by udate desc limit ?,?";
        }
        log.debug("查询SQL:" + sql);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, Integer.valueOf(start), Integer.valueOf(limit));
        List<Page> resList = new ArrayList<Page>();
        if (list == null) return resList;
        for (Map<String, Object> map : list) {
            Page page = new Page();
            page.setId(Integer.parseInt(String.valueOf(map.get("id"))));
            page.setTitle(String.valueOf(map.get("title")));
            page.setUdate(Long.parseLong(String.valueOf(map.get("udate"))));
            page.setImgNum(Integer.parseInt(String.valueOf(map.get("imgnum"))));
            resList.add(page);
        }
        log.debug("查询结果：" + resList.size());
        return resList;
    }

    /**
     * 查询总数
     *
     * @param keyword
     * @return
     */
    @Override
    public int count(String keyword) {
        String sql = "select count(1) from page where " +
                "description like '%" + keyword + "%' or title like '%" + keyword + "%' ";
        if (StringUtils.isBlank(keyword)) {
            sql = "select count(1) from page  ";
        }
        return jdbcTemplate.queryForInt(sql);
    }
}
