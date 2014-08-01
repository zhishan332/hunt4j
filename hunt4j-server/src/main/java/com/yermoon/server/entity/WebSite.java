package com.yermoon.server.entity;

import java.io.Serializable;

/**
 * To change this template use File | Settings | File Templates.
 * @author wangqing
 * @since 1.0.0
 */
public class WebSite implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String url;
    private String charset;
    private String regx;
    private long udate;

    public long getUdate() {
        return udate;
    }

    public void setUdate(long udate) {
        this.udate = udate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getRegx() {
        return regx;
    }

    public void setRegx(String regx) {
        this.regx = regx;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("WebSite");
        sb.append("{id=").append(id);
        sb.append(", url='").append(url).append('\'');
        sb.append(", charset='").append(charset).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
