package com.yermoon.parser;

import com.yermoon.hunt4j.core.cache.DefultCacheManager;
import com.yermoon.parser.config.Constant;
import com.yermoon.parser.pojo.*;
import com.yermoon.parser.util.HtmlFormat;
import com.yermoon.parser.util.UrlUtil;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;

/**
 * 使用Jsoup的分析器
 *
 * @author wangqing
 * @since 1.0.0
 */
public class JsoupHtmlParser implements HtmlParser {

    private String url;
    private ImageParser imageParser;

    public JsoupHtmlParser(ImageParser imageParser) {
        this.imageParser = imageParser;
    }

    @Override
    public WebPage parse(String htmlStr, String url) {
        if (StringUtils.isBlank(htmlStr)) return null;
        this.url = url;
        Object cacheWebPage = DefultCacheManager.getInstance().getCache("webpage-cache").get(url);
        if (cacheWebPage != null && cacheWebPage instanceof WebPage) {
            return (WebPage) cacheWebPage;
        }
        WebPage webPage = new SimpleWebPage();
        webPage.setUrl(url);
        Set<Meta> metaSet = new HashSet<Meta>();
        Set<Image> imageSet = new HashSet<Image>();
        Set<Link> linkSet = new HashSet<Link>();
        Document doc;
        if (StringUtils.isBlank(url)) {
            doc = Jsoup.parse(htmlStr);
        } else doc = Jsoup.parse(htmlStr, url);
        String title = doc.title();
        if (!StringUtils.isBlank(title)) webPage.setTitle(title.trim());
        makeMeta(metaSet, doc);
        boolean containsDesc = false;
        for (Meta mt : metaSet) {
            if ("description".equalsIgnoreCase(mt.getName())) containsDesc = true;
            if ("description".equalsIgnoreCase(mt.getName()) && (null == mt.getContent() || "".equals(mt.getContent().trim()))) {
                String newDesc = HtmlFormat.removeAllBlank(HtmlFormat.delHTMLTag(htmlStr));
                if (newDesc.length() > 200) newDesc = newDesc.substring(0, 200) + "..";
                newDesc = newDesc.trim();
                mt.setContent(newDesc.replace(title,""));
            }
        }
        if (!containsDesc) {
            String newDesc = HtmlFormat.removeAllBlank(HtmlFormat.delHTMLTag(htmlStr));
            if (newDesc.length() > 200) newDesc = newDesc.substring(0, 200) + "..";
            newDesc = newDesc.trim();
            Meta mt = new Meta();
            mt.setName("description");
            mt.setContent(newDesc.replace(title,""));
            metaSet.add(mt);
        }
        webPage.setMetas(metaSet);
        makeImage(imageSet, doc);
        webPage.setImages(imageSet);
        makeLink(linkSet, doc);
        webPage.setLinks(linkSet);
        DefultCacheManager.getInstance().getCache("webpage-cache").put(url, webPage);
        return webPage;
    }

    private void makeLink(Set<Link> linkSet, Document doc) {
        String topUrl = UrlUtil.getTopUrl(url);
        Elements links = doc.getElementsByTag("a"); // 具有 href 属性的链接
        for (Element link : links) {
            String linkHref = link.absUrl("href");
            if (StringUtils.isBlank(linkHref) || !linkHref.contains(topUrl)) {
                continue;
            }
            String[] arry = linkHref.split("http://");
            Set<String> newLinkSet = new HashSet<String>();
            for (String str : arry) {
                if (StringUtils.isBlank(str)) continue;
                newLinkSet.add("http://" + str);
            }
            for (String newLink : newLinkSet) {
                String classd = link.attr("class");
                String target = link.attr("target");
                String id = link.attr("id");
                String linkDesc = link.attr("title");
                Link lk = new Link();
                lk.setTitle(linkDesc);
                lk.setClassName(classd);
                lk.setHref(newLink);
                lk.setId(id);
                lk.setTarget(target);
                lk.setText(link.text());
                linkSet.add(lk);
            }
        }
    }

    private void makeImage(Set<Image> imageSet, Document doc) {
        for (String suffix : Constant.IMG_SUFFIX) {
            Elements imgs = doc.select("img[src$=" + suffix + "]");// 所有引用 suffix 图片的元素
            for (Element link : imgs) {
                String linkHref = link.absUrl("src");
                if (!StringUtils.isBlank(linkHref)) {
                    Image image = new Image();
                    if (null != imageParser) {
                        image = imageParser.parse(linkHref);
                    }
                    if (image != null) {
                        image.setId(link.attr("id"));
                        image.setClassName(link.attr("class"));
                        image.setAlt(link.attr("alt"));
                        image.setTitle(link.attr("title"));
                        image.setSrc(linkHref);
                        imageSet.add(image);
                    }
                }
            }
        }
    }

    private void makeMeta(Set<Meta> metaSet, Document doc) {
        Elements metas = doc.select("meta");
        for (Element meta : metas) {
            if (meta == null) continue;
            Meta mt = new Meta();
            mt.setName(meta.attr("name"));
            mt.setContent(meta.attr("content"));
            mt.setHttpEquiv(meta.attr("http-equiv"));
            mt.setHttpEquiv(meta.attr("scheme"));
            metaSet.add(mt);
        }
    }

    public void setImageParser(ImageParser imageParser) {
        this.imageParser = imageParser;
    }
}
