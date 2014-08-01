package com.yermoon.server.entity;

import java.io.Serializable;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
public class PageExt  implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private long pageId;
    private String keywords;
    private String orgurl;
    private String description;

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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getOrgurl() {
        return orgurl;
    }

    public void setOrgurl(String orgurl) {
        this.orgurl = orgurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
