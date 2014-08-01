package com.yermoon.server.service;

import com.yermoon.server.dao.PageDao;
import com.yermoon.server.entity.Page;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 检索业务
 *
 * @author wangqing
 * @since 1.0.0
 */
@Component
public class PageService {
    @Resource
    private PageDao pageDao;

    public List<Page> findPage(String keyword, int start, int limit) {
        return pageDao.find(keyword, start, limit);
    }

    public int getTotal(String keyword) {
        return pageDao.count(keyword);
    }

    public int delPage(int id) {
        return pageDao.delete(id);
    }

    public int delPage(int[] id) {
        return pageDao.delete(id);
    }
}
