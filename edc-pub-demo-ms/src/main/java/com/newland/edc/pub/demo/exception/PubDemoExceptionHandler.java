package com.newland.edc.pub.demo.exception;

import com.newland.bd.ms.core.model.RespInfo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fujm
 * history 1.0.0 2020/2/20 created by fujm
 */
@RestControllerAdvice
public class PubDemoExceptionHandler {

    /**
     * 方法参数校验异常处理
     *
     * @param exception 异常
     * @return 返回对象
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseBody
    public RespInfo validExceptionHandler(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<String> messageList = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                messageList.add(fieldError.getDefaultMessage());
            }
        }

        RespInfo respInfo = new RespInfo();
        respInfo.setRespResult(RespInfo.RESP_FAILURE);
        respInfo.setRespErrorCode(PubDemoExceptionCode.PARAM_IS_BLANK);
        respInfo.setRespErrorDesc(messageList.toString());
        return respInfo;
    }
}
