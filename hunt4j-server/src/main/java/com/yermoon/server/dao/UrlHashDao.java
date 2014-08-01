package com.yermoon.server.dao;

import com.yermoon.server.entity.HashCodeEntity;

/**
 * Created with IntelliJ IDEA.
 * User: wangq
 * Date: 14-5-17
 * Time: 下午8:38
 * To change this template use File | Settings | File Templates.
 */
public interface UrlHashDao {

    public void insert(HashCodeEntity hashCodeEntity);

    public int getId(long hashCode);
}
