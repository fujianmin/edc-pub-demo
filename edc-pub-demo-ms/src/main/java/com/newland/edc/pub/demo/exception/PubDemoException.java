package com.newland.edc.pub.demo.exception;

import com.newland.bd.ms.core.exception.base.BaseRuntimeException;

/**
 * @author fujm
 * history 1.0.0 2020/2/17 created by fujm
 */
public class PubDemoException extends BaseRuntimeException {
    private static final String TYPE = "demo";

    public PubDemoException(String message, String code) {
        super(message, code);
    }

    public PubDemoException(Throwable throwable, String code) {
        super(throwable, code);
    }

    public PubDemoException(String message, Throwable throwable, String code) {
        super(message, throwable, code);
    }

    public String getType() {
        return "demo";
    }
}
