package com.yermoon.server.dao.impl;

import com.yermoon.server.dao.AbstractDao;
import com.yermoon.server.dao.PageExtDao;
import com.yermoon.server.entity.PageExt;
import org.springframework.stereotype.Repository;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
@Repository
public class PageExtDaoImpl  extends AbstractDao  implements PageExtDao {
    @Override
    public void insert(PageExt pageExt) {
        String sql = "insert into page_ext(pageid,keywords,orgurl,description) " +
                "values(?,?,?,?)";
        jdbcTemplate.update(sql,pageExt.getPageId(), pageExt.getKeywords(),
                pageExt.getOrgurl(), pageExt.getDescription());
    }
}
