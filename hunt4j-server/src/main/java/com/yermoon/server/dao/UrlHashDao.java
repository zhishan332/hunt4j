package com.yermoon.server.dao;

import com.yermoon.server.entity.HashCodeEntity;

/**
 * To change this template use File | Settings | File Templates.
 * @author wangqing
 * @since 1.0.0
 */
public interface UrlHashDao {

    public void insert(HashCodeEntity hashCodeEntity);

    public int getId(long hashCode);
}
