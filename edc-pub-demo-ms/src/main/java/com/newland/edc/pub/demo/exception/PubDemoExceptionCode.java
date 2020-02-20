package com.newland.edc.pub.demo.exception;

/**
 * @author fujm
 * history 1.0.0 2020/2/17 created by fujm
 */
public class PubDemoExceptionCode {
    public static final String PARAM_IS_NULL = "demo-000001";
    public static final String PARAM_IS_NULL_DESC = "请求参数为空";

    public static final String BUS_HANDLE_FAIL = "demo-000002";
    public static final String BUS_HANDLE_ERROR_DESC = "业务处理失败";

    public static final String PARAM_NAME_IS_ERROR = "demo-000003";
    public static final String PARAM_NAME_IS_ERROR_DESC = "参数名称设置错误";

    public static final String PARAM_VALUE_IS_ERROR = "demo-000004";
    public static final String PARAM_VALUE_IS_ERROR_DESC = "参数值设置错误";

    public static final String UNKNOWN = "demo-999999";
    public static final String UNKNOWN_DESC = "未知异常";
}
