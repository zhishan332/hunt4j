package com.yermoon.server.dao.impl;

import com.yermoon.server.dao.AbstractDao;
import com.yermoon.server.dao.SeqDao;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
@Repository
public class SeqDaoImpl  extends AbstractDao implements SeqDao{

    @Override
    public Long getSeq(final String seqName) {
        String sql="replace into sequence(seqname) VALUES(?)";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setObject(1, seqName);
            }
        });
        return jdbcTemplate.queryForLong("select seq from sequence where seqname=?", seqName);
    }
}
