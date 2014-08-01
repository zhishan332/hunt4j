package com.yermoon.hunt4j.core.http;


import com.yermoon.hunt4j.core.cache.DefultCacheManager;
import com.yermoon.hunt4j.core.exception.HuntException;
import com.yermoon.hunt4j.core.io.FileUtils;

import java.io.File;

/**
 * 默认的抓取实现
 *
 * @author wangqing
 * @since 1.0.0
 */
public class DefalutHunter implements Hunter {
    private SimpleDownLoader downLoader;

    public DefalutHunter(SimpleDownLoader downLoader) {
        this.downLoader = downLoader;
    }

    @Override
    public String getHtml(String url) throws Exception {
        return getHtml(url,"UTF-8", 10);
    }

    @Override
    public String getHtml(String url,String charsetName, int timeout) throws Exception {
        //首先从缓存中查询
        Object cacheHtml = DefultCacheManager.getInstance().getCache().get(url);
        if (cacheHtml != null) {
            return String.valueOf(cacheHtml);
        }
        File ff = downLoader.downLoad(url, null, timeout);
        if (ff.exists()) {
            String html = FileUtils.getFileContent(ff,charsetName);
            boolean flag=ff.delete();
            if(!flag) System.out.println("临时文件删除失败");
            //写入缓存
            DefultCacheManager.getInstance().getCache().put(url, html);
            return html;
        } else throw new HuntException("html temp file is not exist!");
    }

}
