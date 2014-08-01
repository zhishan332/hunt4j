package com.yermoon.server.worker;

import com.yermoon.hunt4j.Hunt4j;
import com.yermoon.hunt4j.core.cache.DefultCacheManager;
import com.yermoon.parser.HtmlParser;
import com.yermoon.parser.JsoupHtmlParser;
import com.yermoon.parser.pojo.Link;
import com.yermoon.parser.pojo.WebPage;
import com.yermoon.server.context.ServerContext;
import com.yermoon.server.dao.UrlHashDao;
import com.yermoon.server.dao.UrlTaskDao;
import com.yermoon.server.entity.HashCodeEntity;
import com.yermoon.server.entity.UrlTask;
import com.yermoon.server.helper.HashAlgorithm;
import com.yermoon.server.helper.PageHelper;
import com.yermoon.server.service.PageSaver;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
@Component
public class LinkTaskWorker extends AbstractWorker {
    private static final Logger log = LoggerFactory.getLogger(LinkTaskWorker.class);
    @Value("#{settings['clutch.deep']}")
    private int clutchDeep;
    @Value("#{settings['is.save.img']}")
    private int isSaveImg;
    @Resource
    private UrlHashDao urlHashDao;
    @Resource
    private UrlTaskDao urlTaskDao;
    @Resource
    private PageSaver pageSaver;

    @Override
    public String getTimerName() {
        return "【任务Worker】";
    }

    @Override
    public void run() {
        try {
            int maxTryNum = ServerContext.getInstance().getIVal("worker.retry.num");
            List<UrlTask> tasks = urlTaskDao.findSome(ServerContext.getInstance().getIVal("urltask.grap.num"), maxTryNum);
            log.info(this.getTimerName() + "开始执行，获取到任务数：" + (tasks == null ? 0 : tasks.size()) + "...........");
            if (tasks == null || tasks.isEmpty()) return;
            int count = 0;
            for (UrlTask task : tasks) {
                if (StringUtils.isBlank(task.getUrl())) {
                    log.warn("获取到任务：" + task + ",url不合法！");
                    continue;
                }
                log.debug("获取到任务：" + task + "，开始分析........");
                Hunt4j hunt4j = new Hunt4j();
                String html = hunt4j.getHtml(task.getUrl(),task.getCharset(), 15);
                if (StringUtils.isBlank(html)) {
                    log.warn(task + ",获取到内容为空！");
                    continue;
                }
                HtmlParser htmlParser = new JsoupHtmlParser(null);
                WebPage page = htmlParser.parse(html, task.getUrl());
                if (page == null) {
                    task.setExcNum(task.getExcNum() + 1);
                    String cdate = DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss.SSS");
                    task.setUpdate(cdate);
                    urlTaskDao.update(task);
                    log.info(this.getTimerName() + "稍后进行重试:" + task.getUrl() + ",pageTask:" + page);
                    continue;
                }
                pageSaver.savePage(page,isSaveImg==1);
                //如果深度允许继续生成任务
                if (task.getDeep() < clutchDeep) {
                    for (Link link : page.getLinks()) {
                        long hashcode = HashAlgorithm.MurMurHash.hash(link.getHref());
                        Object cacheWebPage = DefultCacheManager.getInstance().getCache("hashcode-cache").get(link.getHref());
                        if (cacheWebPage != null) {
                            continue;
                        } else if (urlHashDao.getId(hashcode) > 0) continue;
                        if (!StringUtils.isBlank(task.getRegx())) {
                            boolean flag = PageHelper.isValidUrl(task.getRegx(), link.getHref());
                            if (!flag) continue;
                        }
                        UrlTask urlTask = new UrlTask();
                        urlTask.setUrl(link.getHref());
                        urlTask.setHashCode(hashcode);
                        urlTask.setCharset(task.getCharset());
                        String cdate = DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss.SSS");
                        urlTask.setCdate(cdate);
                        urlTask.setUpdate(cdate);
                        urlTask.setExcNum(0);
                        urlTask.setRegx(task.getRegx());
                        urlTask.setDeep(task.getDeep() + 1);
                        urlTaskDao.insert(urlTask);
                        urlHashDao.insert(new HashCodeEntity(hashcode));
                        DefultCacheManager.getInstance().getCache("hashcode-cache").put(link.getHref(), hashcode);
                    }
                }
                urlTaskDao.delete(task.getId());
                count++;
            }
            log.info(this.getTimerName() + "处理任务数：" + count + ">>>>>>>>>>>>>");
        } catch (Exception e) {
            log.error(getTimerName(), e);
            e.printStackTrace();
        }
    }
}
