package com.yermoon.server.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class AbstractWorker implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(AbstractWorker.class);
    private ScheduledExecutorService scheduler;//JDK1.5+
    private String executorMethod = "scheduleWithFixedDelay";
    private int initialDelay = 1; //首次执行的延迟时间 默认1  单位秒
    private int delay = 10;//一次执行终止和下一次执行开始之间的延迟 默认10s  单位秒
    private int period = 10;//连续执行之间的周期
    private int threadNum = 1;//线程数

    /**
     * 定时器启动
     */
    public void start() {
        scheduler = Executors.newScheduledThreadPool(threadNum);
        if (initialDelay <= 0) initialDelay = 1; //如果配置值小于1则设置为默认值为1
        if (delay <= 0) delay = 10; //如果间隔小于1则设置为默认值10s
        if (period <= 0) period = 10; //如果间隔小于1则设置为默认值10s
        if ("scheduleAtFixedRate".equals(executorMethod)) {
            scheduler.scheduleAtFixedRate(this, initialDelay, period, TimeUnit.SECONDS);
        } else {
            scheduler.scheduleWithFixedDelay(this, initialDelay, delay, TimeUnit.SECONDS);
        }
        log.info("worker：[" + getTimerName() + "]开始执行,initialDelay:" + initialDelay +
                "delay:" + delay + "executorMethod:" + executorMethod + "period:" + period);
    }

    /**
     * 定时器销毁
     */
    @PreDestroy
    public void stop() {
        if (scheduler != null) {
            scheduler.shutdown();
        }
        log.info("定时器：[" + getTimerName() + "]已正常关闭>>>>>>>>>>>>>>>>");
    }

    /**
     * 设置启动延迟时间
     *
     * @param initialDelay 启动延迟时间（秒）
     */
    public void setInitialDelay(int initialDelay) {
        this.initialDelay = initialDelay;
    }

    /**
     * 设置间隔执行时间
     *
     * @param delay 一次执行终止和下一次执行开始之间的延迟
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }

    protected abstract String getTimerName();

    /**
     * 设置执行的方法
     *
     * @param executorMethod “scheduleAtFixedRate”或者“scheduleWithFixedDelay”
     */
    public void setExecutorMethod(String executorMethod) {
        this.executorMethod = executorMethod;
    }


    public int getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }
}