package com.yermoon.server.entity;

import java.io.Serializable;

/**
 * 抓取任务
 *
 * @author wangqing
 * @since 1.0.0
 */
public class UrlTask implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String url;
    private String charset;
    private int excNum;
    private long hashCode;
    private int deep;
    private String regx;
    private String cdate;
    private String update;

    public String getRegx() {
        return regx;
    }

    public void setRegx(String regx) {
        this.regx = regx;
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

    public int getExcNum() {
        return excNum;
    }

    public void setExcNum(int excNum) {
        this.excNum = excNum;
    }

    public long getHashCode() {
        return hashCode;
    }

    public void setHashCode(long hashCode) {
        this.hashCode = hashCode;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UrlTask)) return false;

        UrlTask task = (UrlTask) o;

        return hashCode == task.hashCode;

    }

    @Override
    public int hashCode() {
        return (int) (hashCode ^ (hashCode >>> 32));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("UrlTask");
        sb.append("{hashCode=").append(hashCode);
        sb.append(", id=").append(id);
        sb.append(", deep=").append(deep);
        sb.append(", url='").append(url).append('\'');
        sb.append(", excNum=").append(excNum);
        sb.append('}');
        return sb.toString();
    }
}
