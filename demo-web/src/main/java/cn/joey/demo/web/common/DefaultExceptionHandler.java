package cn.joey.demo.web.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
* @Description: 全局异常处理，捕获所有Controller中抛出的异常
* @Author: wangzhaoyu
* @Date: 2018/10/9 上午10:46
*/
@Slf4j
@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandler(Exception e) {
        log.error("customHandler", e);
        Response<Map> result = new Response<>();
        result.setError_code(ErrorCode.FAIL.code);

        if (e instanceof HttpRequestMethodNotSupportedException) {
            result.setErr_msg(ErrorCode.FAIL.message + ":" + e.getMessage());
        } else {
            result.setErr_msg(ErrorCode.FAIL.message);
        }

        return result;
    }
}