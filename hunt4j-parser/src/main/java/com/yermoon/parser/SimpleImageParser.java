package com.yermoon.parser;

import com.yermoon.hunt4j.core.cache.DefultCacheManager;
import com.yermoon.hunt4j.core.http.DownLoader;
import com.yermoon.parser.pojo.Image;
import org.apache.commons.lang.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
public class SimpleImageParser implements ImageParser {

    private DownLoader downLoader;
    private String temPath;
    private int timeout;

    public SimpleImageParser(DownLoader downLoader) {
        this.downLoader = downLoader;
    }

    @Override
    public Image parse(String imgUrl) {
        if (downLoader == null || StringUtils.isBlank(imgUrl)) return null;
        Object cacheImg = DefultCacheManager.getInstance().getCache("image-cache").get(imgUrl);
        if (cacheImg != null && cacheImg instanceof Image) {
            return (Image) cacheImg;
        }
        File file = null;
        try {
            file = downLoader.downLoad(imgUrl, temPath, timeout);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        if (file != null && file.exists()) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            if (null != img) {
                Image image = new Image();
                image.setSrc(imgUrl);
                image.setLength(file.length());
                image.setWidth(img.getWidth());
                image.setHeight(image.getHeight());
                DefultCacheManager.getInstance().getCache("image-cache").put(imgUrl, image);
            }
            file.delete();
        }
        return null;
    }

    public void setTemPath(String temPath) {
        this.temPath = temPath;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
