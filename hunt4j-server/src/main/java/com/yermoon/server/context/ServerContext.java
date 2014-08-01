package com.yermoon.server.context;


import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统上下文配置
 *
 * @author wangqing
 * @since 14-5-16 下午5:49
 */
public class ServerContext {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ServerContext.class);
    private static volatile ServerContext instance = null; //必须设置为volatile否则double check可能无效（JDK1.5+）
    private Map<String, Object> properties = new HashMap<String, Object>();

    private ServerContext() {
        log.info("Context初始化成功>>>>>>>>>>>>>>>");
    }

    /**
     * 获取系统配置对象
     *
     * @return instance
     */
    public static ServerContext getInstance() {
        if (instance == null) { // double check (jdk1.5+)
            synchronized (ServerContext.class) {
                if (instance == null)
                    instance = new ServerContext();
            }
        }
        return instance;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperty(String key, Object val) {
        if (StringUtils.isBlank(key) || null == val) return;
        this.properties.put(key, val);
    }

    public String getSVal(String key) {
        return String.valueOf(properties.get(key));
    }

    public int getIVal(String key) {
        return Integer.parseInt(getSVal(key));
    }
}
