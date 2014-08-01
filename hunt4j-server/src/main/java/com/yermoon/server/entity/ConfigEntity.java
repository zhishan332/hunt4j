package com.yermoon.server.entity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: wangq
 * Date: 14-5-17
 * Time: 下午5:48
 * 配置
 */
public class ConfigEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String key;
    private String val;
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
