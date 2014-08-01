package com.yermoon.server.dao.impl;

import com.yermoon.server.dao.AbstractDao;
import com.yermoon.server.dao.PageImgDao;
import com.yermoon.server.entity.PageImg;
import org.springframework.stereotype.Repository;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
@Repository
public class PageImgDaoImpl extends AbstractDao implements PageImgDao {
    @Override
    public int insert(PageImg pageImg) {
        String sql = "insert into page_img(pageid,img) " +
                "values(?,?)";
       return jdbcTemplate.update(sql,pageImg.getPageId(),pageImg.getImg());
    }
}
