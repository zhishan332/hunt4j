package com.yermoon.server.dao;

import com.yermoon.server.entity.ConfigEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wangq
 * Date: 14-5-17
 * Time: 下午5:41
 * 获取配置
 */
public interface ConfigDao {

    public List<ConfigEntity> findAll();

}
