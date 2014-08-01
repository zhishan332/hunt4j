package com.yermoon.server.restful.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
public class PhotoPageDto implements Serializable {
    private String title;
    private int imgNum;
    private Set<String> imgUrls;
    private long cdate;
    private long udate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgNum() {
        return imgNum;
    }

    public void setImgNum(int imgNum) {
        this.imgNum = imgNum;
    }

    public Set<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(Set<String> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public long getCdate() {
        return cdate;
    }

    public void setCdate(long cdate) {
        this.cdate = cdate;
    }

    public long getUdate() {
        return udate;
    }

    public void setUdate(long udate) {
        this.udate = udate;
    }
}
