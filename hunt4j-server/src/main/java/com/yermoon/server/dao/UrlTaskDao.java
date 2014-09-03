package com.yermoon.server.dao;


import com.yermoon.server.entity.UrlTask;

import java.util.List;

/**
 * To change this template use File | Settings | File Templates.
 * @author wangqing
 * @since 1.0.0
 */
public interface UrlTaskDao {

    public void insert(UrlTask urlTask);

    public void delete(int id);

    public List<UrlTask> findSome(int limit, int excnum);

    public void update(UrlTask urlTask);

    public void updateCharset(UrlTask urlTask);

    public List<UrlTask> findNoCharset(int limit);
}
