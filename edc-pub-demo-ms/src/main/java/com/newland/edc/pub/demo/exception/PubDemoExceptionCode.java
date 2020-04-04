package com.newland.edc.pub.demo.exception;

/**
 * @author fujm
 * history 1.0.0 2020/2/17 created by fujm
 */
public class PubDemoExceptionCode {
    public static final String PARAM_IS_BLANK = "DEMO-00001";
    public static final String PARAM_IS_BLANK_DESC = "请求参数为空";

    public static final String BUS_HANDLE_FAIL = "DEMO-00002";
    public static final String BUS_HANDLE_FAIL_DESC = "业务处理失败";

    public static final String PARAM_NAME_IS_ERROR = "DEMO-00003";
    public static final String PARAM_NAME_IS_ERROR_DESC = "参数名称设置错误";

    public static final String PARAM_VALUE_IS_ERROR = "DEMO-00004";
    public static final String PARAM_VALUE_IS_ERROR_DESC = "参数值设置错误";

    public static final String UNKNOWN = "DEMO-99999";
    public static final String UNKNOWN_DESC = "未知异常";
}
