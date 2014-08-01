package com.yermoon.server.dao.impl;

import com.yermoon.server.dao.AbstractDao;
import com.yermoon.server.dao.UrlTaskDao;
import com.yermoon.server.entity.UrlTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * To change this template use File | Settings | File Templates.
 * @author wangqing
 * @since 1.0.0
 */
@Repository
public class UrlTaskDaoMysqlImpl extends AbstractDao implements UrlTaskDao {
    private static final Logger log = LoggerFactory.getLogger(UrlTaskDaoMysqlImpl.class);

    @Override
    public void insert(UrlTask urlTask) {
        String sql = "insert into url_task(id,url,excnum,hashcode,charset,regx,cdate,udate) values(null,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, urlTask.getUrl(), urlTask.getExcNum(), urlTask.getHashCode(),
               urlTask.getCharset(),urlTask.getRegx(), urlTask.getCdate(), urlTask.getUpdate());
//        log.info("UrlTask插入结果:" + urlTask.getUrl() + "插入结果：" + count);
    }

    @Override
    public void delete(int id) {
        String sql = "delete from url_task where id=" + id;
        jdbcTemplate.update(sql);
    }

    @Override
    public List<UrlTask> findSome(int limit,int excnum) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from url_task where excnum <"+excnum+"  limit " + limit);
        List<UrlTask> resList = new ArrayList<UrlTask>();
        if (list == null) return resList;
        for (Map<String, Object> map : list) {
            UrlTask task = new UrlTask();
            task.setId(Integer.parseInt(String.valueOf(map.get("id"))));
            task.setUrl(String.valueOf(map.get("url")));
            task.setCharset(String.valueOf(map.get("charset")));
            task.setRegx(String.valueOf(map.get("regx")));
            task.setExcNum(Integer.parseInt(String.valueOf(map.get("excnum"))));
            task.setHashCode(Long.parseLong(String.valueOf(map.get("hashcode"))));
            resList.add(task);
        }
        return resList;
    }

    @Override
    public void update(UrlTask urlTask) {
        String sql = "update  url_task set excnum=?,udate=? where id=?";
        jdbcTemplate.update(sql, urlTask.getExcNum(), urlTask.getUpdate(), urlTask.getId());
    }

    @Override
    public void updateCharset(UrlTask urlTask) {
        String sql = "update  url_task set charset=?,udate=? where id=?";
        jdbcTemplate.update(sql, urlTask.getCharset(), urlTask.getUpdate(), urlTask.getId());
    }

    @Override
    public List<UrlTask> findNoCharset(int limit) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from url_task where  charset is null or charset ='' limit " + limit);
        List<UrlTask> resList = new ArrayList<UrlTask>();
        if (list == null) return resList;
        for (Map<String, Object> map : list) {
            UrlTask task = new UrlTask();
            task.setId(Integer.parseInt(String.valueOf(map.get("id"))));
            task.setUrl(String.valueOf(map.get("url")));
            task.setExcNum(Integer.parseInt(String.valueOf(map.get("excnum"))));
            task.setHashCode(Long.parseLong(String.valueOf(map.get("hashcode"))));
            task.setRegx(String.valueOf(map.get("regx")));
            resList.add(task);
        }
        return resList;
    }
}
