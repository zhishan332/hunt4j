package com.yermoon.server.entity;

import java.io.Serializable;

/**
 * To change this template use File | Settings | File Templates.
 * @author wangqing
 * @since 1.0.0
 */
public class HashCodeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private long hashCode;

    public HashCodeEntity(long hashCode) {
        this.hashCode = hashCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getHashCode() {
        return hashCode;
    }

    public void setHashCode(long hashCode) {
        this.hashCode = hashCode;
    }
}
