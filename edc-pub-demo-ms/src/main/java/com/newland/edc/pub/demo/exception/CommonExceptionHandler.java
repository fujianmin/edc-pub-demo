package com.newland.edc.pub.demo.exception;

import com.newland.bd.ms.core.model.RespInfo;
import com.newland.bd.ngudap.exception.common.CommonErrorCode;
import org.apache.cxf.common.i18n.Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fujm
 * history 1.0.0 2020/2/20 created by fujm
 */
@RestControllerAdvice
@ResponseBody
public class CommonExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

    /**
     * 方法参数校验异常处理
     *
     * @param exception 异常
     * @return 返回对象
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RespInfo validExceptionHandler(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<String> messageList = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                messageList.add(fieldError.getDefaultMessage());
            }
        }

        return new RespInfo(PubDemoExceptionCode.PARAM_IS_BLANK, messageList.toString());
    }

    /**
     * SQL异常处理
     *
     * @param e SQL异常
     * @return 返回对象
     */
    @ExceptionHandler(value = {BadSqlGrammarException.class})
    public RespInfo sqlExceptionHandler(Throwable e) {
        logger.error("SQL执行异常 = {}", e.getMessage(), e);
        return new RespInfo(CommonErrorCode.DATABASE_ERROR_OCCURRED.getCode(), "工具内部出现SQL执行错误");
    }

    /**
     * 空指针异常处理
     *
     * @return 返回对象
     */
    @ExceptionHandler(NullPointerException.class)
    public RespInfo nullPointerExceptionHandler(Throwable e) {
        logger.error("空指针异常 = {}", e.getMessage(), e);
        return new RespInfo(CommonErrorCode.UNUSUAL_END_OF_PROGRAM.getCode(), "程序异常结束，异常原因是空指针异常");
    }

    /**
     * IO异常处理
     *
     * @param e IO异常
     * @return 返回对象
     */
    @ExceptionHandler(IOException.class)
    public RespInfo ioExceptionHandler(Throwable e) {
        logger.error("IO异常 = {}", e.getMessage(), e);
        return new RespInfo(CommonErrorCode.UNUSUAL_END_OF_PROGRAM.getCode(), "程序异常结束，异常原因是IO异常");
    }

    /**
     * 数组越界异常处理
     *
     * @param e 数组越界异常
     * @return 返回对象
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public RespInfo indexOutOfBoundsExceptionHandler(Throwable e) {
        logger.error("数组越界异常 = {}", e.getMessage(), e);
        return new RespInfo(CommonErrorCode.UNUSUAL_END_OF_PROGRAM.getCode(), "程序异常结束，异常原因是数组越界异常");
    }


    /**
     * 其他异常处理
     *
     * @param e 其他异常
     * @return 返回对象
     */
    @ExceptionHandler(Exception.class)
    public RespInfo exceptionHandler(Throwable e) {
        logger.error("未知异常 = {}", e.getMessage(), e);
        return new RespInfo(CommonErrorCode.UNUSUAL_END_OF_PROGRAM.getCode(), "程序异常结束，异常原因是未知异常");
    }
}
