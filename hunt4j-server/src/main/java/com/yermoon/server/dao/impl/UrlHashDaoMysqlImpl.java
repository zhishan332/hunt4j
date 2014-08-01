package com.yermoon.server.dao.impl;

import com.yermoon.server.dao.AbstractDao;
import com.yermoon.server.dao.UrlHashDao;
import com.yermoon.server.entity.HashCodeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: wangq
 * Date: 14-5-17
 * Time: 下午8:38
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UrlHashDaoMysqlImpl extends AbstractDao implements UrlHashDao {
    private static final Logger log = LoggerFactory.getLogger(UrlHashDaoMysqlImpl.class);

    @Override
    public void insert(final HashCodeEntity hashCodeEntity) {
        String sql = "insert url_hash(id,hashcode) values(null,?)";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setObject(1, hashCodeEntity.getHashCode());
            }
        });
    }

    @Override
    public int getId(long hashCode) {
        return jdbcTemplate.queryForInt("select  count(1) from url_hash where hashcode= " + hashCode);
    }
}
