package com.yermoon.server.dao.impl;

import com.yermoon.server.dao.AbstractDao;
import com.yermoon.server.dao.ConfigDao;
import com.yermoon.server.entity.ConfigEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangq
 * Date: 14-5-17
 * Time: 下午5:42
 * 获取配置的数据库操作
 */
@Repository
public class ConfigDaoMysqlImpl extends AbstractDao implements ConfigDao {

    @Override
    public List<ConfigEntity> findAll() {
        List<ConfigEntity> resList = new ArrayList<ConfigEntity>();
        List list = jdbcTemplate.queryForList("select * from config");
        if (null == list) return resList;
        Iterator iterator = list.iterator();
        ConfigEntity config = null;
        while (iterator.hasNext()) {
            Map data = (Map) iterator.next();
            config = new ConfigEntity();
            config.setId(Integer.parseInt(String.valueOf(data.get("id"))));
            config.setKey(String.valueOf(data.get("key")));
            config.setVal(String.valueOf(data.get("val")));
            config.setRemark(String.valueOf(data.get("remark")));
            resList.add(config);
        }
        return resList;
    }
}
