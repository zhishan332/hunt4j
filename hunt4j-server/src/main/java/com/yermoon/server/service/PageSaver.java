package com.yermoon.server.service;

import com.yermoon.parser.pojo.Image;
import com.yermoon.parser.pojo.Meta;
import com.yermoon.parser.pojo.WebPage;
import com.yermoon.server.context.ServerConstant;
import com.yermoon.server.dao.PageDao;
import com.yermoon.server.dao.PageExtDao;
import com.yermoon.server.dao.PageImgDao;
import com.yermoon.server.dao.UserDao;
import com.yermoon.server.entity.Page;
import com.yermoon.server.entity.PageExt;
import com.yermoon.server.entity.PageImg;
import com.yermoon.server.entity.UserEntity;
import com.yermoon.server.handler.ImageHandler;
import com.yermoon.server.helper.HashAlgorithm;
import com.yermoon.server.helper.PageHelper;
import com.yermoon.server.helper.SeqHelper;
import com.yermoon.server.util.StringFormatUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
@Component
public class PageSaver {
    private static final Logger log = LoggerFactory.getLogger(PageSaver.class);
    @Resource
    private PageDao pageDao;
    @Resource
    private PageExtDao pageExtDao;
    @Resource
    private PageImgDao pageImgDao;
    @Resource
    private SeqHelper seqHelper;
    @Resource
    private UserDao userDao;
    @Resource
    private ImageHandler imageHandler;

    public void savePage(WebPage webPage, boolean isSaveImage) {
        String title = webPage.getTitle();
        if (StringUtils.isBlank(title)) {
            log.warn("页面标题为空，url:" + webPage.getUrl());
            return;
        }
        title = PageHelper.delHTMLTag(title);
//        title = PageHelper.removeAllBlank(title);
        if (title.length() > 100) title = title.substring(0, 90) + "..";
        title = title.trim();
        String newDesc = "";
        String desc = null;
        String keywords = null;
        if (webPage.getMetas() != null) {
            for (Meta meta : webPage.getMetas()) {
                if ("description".equalsIgnoreCase(meta.getName())) {
                    desc = meta.getContent();
                }
                if ("keywords".equalsIgnoreCase(meta.getName())) {
                    keywords = meta.getContent();
                }
            }
        }
        if (!StringUtils.isBlank(desc)) {
            newDesc = PageHelper.delHTMLTag(desc);
            newDesc = PageHelper.removeAllBlank(newDesc);
            if (newDesc.length() > 200) newDesc = newDesc.substring(0, 200) + "..";
            newDesc = newDesc.trim();
            if (newDesc.length() < 2) newDesc = "";//长度太小抛弃
        }

        Page page = new Page();
        PageExt pageExt = new PageExt();
        long pageId = seqHelper.getSeq(ServerConstant.SEQ_PAGE);
        String kws = StringFormatUtil.filter(keywords);
        kws = PageHelper.removeAllBlank(kws);
        if (kws.length() > 100) kws = kws.substring(0, 90) + "..";
        kws = kws.trim();
        pageExt.setDescription(newDesc);
        pageExt.setPageId(pageId);
        pageExt.setKeywords(kws);
        pageExt.setOrgurl(webPage.getUrl());
        page.setPageId(pageId);
        page.setTitle(title);
        long date = System.currentTimeMillis();
        page.setCdate(date);
        page.setUdate(date);
        UserEntity user = userDao.getRandUser();
        page.setCuserId(user.getUserid());
        page.setCusername(user.getUsername());

        if (isSaveImage) {
            StringBuilder sb = new StringBuilder();
            Set<Image> imgs = webPage.getImages();
            List<String> imgList = new ArrayList<String>();
            if (null != imgs) {
                String cover = "";
                int i = 0;
                for (Image img : imgs) {
                    long hashcode = HashAlgorithm.MurMurHash.hash(img.getSrc());
                    String newName = hashcode + ".jpg";
                    boolean flag = imageHandler.saveImage(img.getSrc());
                    if (flag) {
                        imgList.add(newName);
                        if (i == 0) cover = newName;
                        i++;
                    }
                }
                page.setImgNum(i);
                page.setCover(cover);
            }
            if (page.getImgNum() > 0) {
                int id = pageDao.insert(page);
                if (id > 0) {
                    pageExtDao.insert(pageExt);
                    for (String img : imgList) {
                        PageImg pageImg = new PageImg();
                        pageImg.setPageId(pageId);
                        pageImg.setImg(img);
                        pageImgDao.insert(pageImg);
                    }
                }

                log.info("收录页面：" + pageExt.getOrgurl());
            }
        } else {
            int id = pageDao.insert(page);
            if (id > 0) {
                pageExtDao.insert(pageExt);
            }
            log.info("收录页面：" + pageExt.getOrgurl());
        }
    }
}
