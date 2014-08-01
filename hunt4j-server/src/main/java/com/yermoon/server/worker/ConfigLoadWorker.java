package com.yermoon.server.worker;

import com.yermoon.server.context.ServerContext;
import com.yermoon.server.dao.ConfigDao;
import com.yermoon.server.entity.ConfigEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * 系统Worker,用于处理一些配置等
 *
 * @author wangqing
 * @since 14-5-16 下午6:42
 */
@Component
public class ConfigLoadWorker extends AbstractWorker {
    private static final Logger log = LoggerFactory.getLogger(ConfigLoadWorker.class);
    @Resource
    private ConfigDao configDao;
    @Value("#{settings['config.reload.delay']}")
    private int configReloadDelay;

    @Override
    public String getTimerName() {
        return this.getClass().getName();
    }

    @Override
    public void run() {
        try {
            List<ConfigEntity> configs = configDao.findAll();
            for (ConfigEntity configEntity : configs) {
                ServerContext.getInstance().setProperty(configEntity.getKey(), configEntity.getVal());
            }
        } catch (Exception e) {
            log.error("加载配置失败", e);
        }
    }
    /**
     * 定时器启动
     */
    @PostConstruct
    public void init() {
        this.start();
    }
}
