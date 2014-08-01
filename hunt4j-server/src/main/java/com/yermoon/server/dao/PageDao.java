package com.yermoon.server.dao;

import com.yermoon.server.entity.Page;

import java.util.List;

/**
 * To change this template use File | Settings | File Templates.
 * @author wangqing
 * @since 1.0.0
 */
public interface PageDao {

    public int insert(Page page);

    /**
     * 以主键ID删除
     *
     * @param id
     */
    public int delete(int  id);

    /**
     * 以主键ID删除
     *
     * @param ids
     */
    public int delete(int[]  ids);

    /**
     * 以hashcode查询是否存在该记录
     *
     * @param hashcode
     */
    public int getCount(long hashcode);

    /**
     * 根据关键字模糊搜索
     *
     * @param keyWord 如果为空的话，按更新时间进行排序搜索
     * @return
     */
    public List<Page> find(String keyWord, int start, int limit);

    /**查询总数
     *
     * @param keyword
     * @return
     */
    public int count(String keyword);
}
