package com.yermoon.server.dao;

import com.yermoon.server.entity.WebSite;

import java.util.List;

/**
 * To change this template use File | Settings | File Templates.
 * @author wangqing
 * @since 1.0.0
 */
public interface WebSiteDao {
    /**
     * 查询所有的待扫描网站
     *
     * @return
     */
    public List<WebSite> findAll();


    public void update(WebSite webSite);
}
