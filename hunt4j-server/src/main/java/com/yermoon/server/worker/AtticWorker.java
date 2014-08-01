package com.yermoon.server.worker;

import com.yermoon.hunt4j.Hunt4j;
import com.yermoon.hunt4j.core.cache.DefultCacheManager;
import com.yermoon.hunt4j.core.http.DefalutHunter;
import com.yermoon.hunt4j.core.http.Hunter;
import com.yermoon.hunt4j.core.http.SimpleDownLoader;
import com.yermoon.parser.HtmlParser;
import com.yermoon.parser.JsoupHtmlParser;
import com.yermoon.parser.pojo.Link;
import com.yermoon.parser.pojo.WebPage;
import com.yermoon.server.dao.UrlHashDao;
import com.yermoon.server.dao.UrlTaskDao;
import com.yermoon.server.dao.WebSiteDao;
import com.yermoon.server.entity.HashCodeEntity;
import com.yermoon.server.entity.UrlTask;
import com.yermoon.server.entity.WebSite;
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
 * 网站入口扫描Worker
 *
 * @author wangqing
 * @since 1.0.0
 */
@Component
public class AtticWorker extends AbstractWorker {
    private static final Logger log = LoggerFactory.getLogger(AtticWorker.class);
    @Value("#{settings['temp.download.path']}")
    private String tempDownLoadPath;
    @Value("#{settings['cache.key.hashcode']}")
    private String hashCodeCacheKey;
    @Value("#{settings['is.save.img']}")
    private int isSaveImg;
    @Resource
    private WebSiteDao webSiteDao;
    @Resource
    private UrlHashDao urlHashDao;
    @Resource
    private UrlTaskDao urlTaskDao;
    @Resource
    private PageSaver pageSaver;

    @Override
    public String getTimerName() {
        return "【网站扫描Worker】";
    }

    @Override
    public void run() {
        try {
            List<WebSite> sites = webSiteDao.findAll();
            if (sites == null || sites.isEmpty()) return;
            for (WebSite webSite : sites) {
                if (StringUtils.isBlank(webSite.getUrl())) {
                    log.warn("获取到网站：" + webSite + ",url不合法！");
                    continue;
                }
                log.debug("获取到网站：" + webSite + "，开始分析........");
                SimpleDownLoader downloader = new SimpleDownLoader(16);
                downloader.setTempFilePath(tempDownLoadPath);
                Hunter hunter = new DefalutHunter(downloader);
                Hunt4j hunt4j = new Hunt4j(hunter);
                String html = hunt4j.getHtml(webSite.getUrl(), webSite.getCharset(), 15);
                log.debug("网站：" + webSite + "，解析完成，开始处理........");
                if (StringUtils.isBlank(html)) {
                    log.warn(webSite + ",获取到内容为空！");
                    continue;
                }
                HtmlParser htmlParser = new JsoupHtmlParser(null);
                WebPage page = htmlParser.parse(html, webSite.getUrl());
                log.debug("网站：" + webSite + "，构建页面元素完成，获取到链接数：" + (page == null ? 0 : page.getLinks().size()));
                if (page == null) {
                    log.warn(webSite + ",解析页面元素为空！");
                    continue;
                }
                log.debug("page:"+ page.toString());
                long pageHashcode = HashAlgorithm.MurMurHash.hash(webSite.getUrl());
                if (urlHashDao.getId(pageHashcode) <=0 ){
                    pageSaver.savePage(page, isSaveImg == 1);
                    urlHashDao.insert(new HashCodeEntity(pageHashcode));
                }
                for (Link link : page.getLinks()) {
                    long hashcode = HashAlgorithm.MurMurHash.hash(link.getHref());
                    Object cacheWebPage = DefultCacheManager.getInstance().getCache(hashCodeCacheKey).get(link.getHref());
                    if (cacheWebPage != null) {
                        continue;
                    } else if (urlHashDao.getId(hashcode) > 0) continue;
                    if (!StringUtils.isBlank(webSite.getRegx())) {
                        boolean flag = PageHelper.isValidUrl(webSite.getRegx(), link.getHref());
                        log.warn("链接规则校验结果："+flag+"，链接："+link.getHref()+",规则："+webSite.getRegx());
                        if (!flag) continue;
                    }
                    UrlTask urlTask = new UrlTask();
                    urlTask.setUrl(link.getHref());
                    urlTask.setHashCode(hashcode);
                    urlTask.setCharset(webSite.getCharset());
                    urlTask.setRegx(webSite.getRegx());
                    String cdate = DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss.SSS");
                    urlTask.setCdate(cdate);
                    urlTask.setUpdate(cdate);
                    urlTask.setExcNum(0);
                    urlTask.setDeep(1);
                    urlTaskDao.insert(urlTask);
                    urlHashDao.insert(new HashCodeEntity(hashcode));
                    DefultCacheManager.getInstance().getCache(hashCodeCacheKey).put(link.getHref(), hashcode);
                }
                webSite.setUdate(System.currentTimeMillis());
                webSiteDao.update(webSite);
            }
        } catch (Exception e) {
            log.error(getTimerName() + "分析失败", e);
        }
    }
}
