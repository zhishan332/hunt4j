package com.yermoon.server.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

/**
 * To change this template use File | Settings | File Templates.
 * @author wangqing
 * @since 1.0.0
 */
public class AbstractDao {
    @Resource
    protected JdbcTemplate jdbcTemplate;
}
