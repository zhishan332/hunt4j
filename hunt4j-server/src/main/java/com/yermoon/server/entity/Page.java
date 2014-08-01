package com.yermoon.server.entity;

import java.io.Serializable;

/**
 * To change this template use File | Settings | File Templates.
 * @author wangqing
 * @since 1.0.0
 */
public class Page implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private long pageId;
    private String title;
    private String cover;
    private int imgNum;
    private long cuserId;
    private String cusername;
    private long cdate;
    private long udate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPageId() {
        return pageId;
    }

    public void setPageId(long pageId) {
        this.pageId = pageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getImgNum() {
        return imgNum;
    }

    public void setImgNum(int imgNum) {
        this.imgNum = imgNum;
    }

    public long getCuserId() {
        return cuserId;
    }

    public void setCuserId(long cuserId) {
        this.cuserId = cuserId;
    }

    public String getCusername() {
        return cusername;
    }

    public void setCusername(String cusername) {
        this.cusername = cusername;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Page{");
        sb.append("id=").append(id);
        sb.append(", pageid=").append(pageId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", cover='").append(cover).append('\'');
        sb.append(", imgNum=").append(imgNum);
        sb.append(", cuserid=").append(cuserId);
        sb.append(", cusername='").append(cusername).append('\'');
        sb.append(", cdate=").append(cdate);
        sb.append(", udate=").append(udate);
        sb.append('}');
        return sb.toString();
    }
}
