package com.yermoon.hunt4j.core.exception;

/**
 * HuntException
 *
 * @author wangqing
 * @since 1.0.0
 */
public class HuntException extends Exception {

    public HuntException(String msg) {
        super(msg);
    }

    public HuntException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
