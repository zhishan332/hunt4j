package com.yermoon.server.handler.impl;

import com.yermoon.hunt4j.core.http.SimpleDownLoader;
import com.yermoon.server.handler.ImageHandler;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author wangqing
 * @since 1.0.0
 */
@Component
public class AppImageHandler implements ImageHandler {
    private static final Logger log = LoggerFactory.getLogger(AppImageHandler.class);
    @Value("#{settings['image.save.path']}")
    private String savePath;
    @Value("#{settings['image.save.timeout']}")
    private int timeout;
    @Value("#{settings['image.min.size']}")
    private int minSize;

    @Override
    public boolean saveImage(String imgUrl, String newName) {
        SimpleDownLoader downLoader = new SimpleDownLoader(16);
        if (StringUtils.isBlank(imgUrl)) return false;
        File file;
        String path = savePath + File.separator + newName;
        File ff = new File(path);
        if (ff.exists()) return true;
        try {
            file = downLoader.downLoad(imgUrl, path, timeout);
        } catch (Exception e) {
            log.error("图片下载异常", e);
            return false;
        }
        if (file == null) return false;
        if (file.length() < minSize * 1024) {
            boolean flag = file.delete();
            if (!flag) System.out.printf("删除文件失败");
            return false;
        }
        return true;
    }
}
