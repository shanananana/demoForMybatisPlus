package com.baomidou.com.example.demo.exception.handler;

import com.baomidou.com.example.demo.util.Constant;
import com.helper.exceptionhelper.CommonError;
import com.helper.responsehelper.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.baomidou.com.example.demo")
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public BaseResponse exception(Exception e, CommonError commonError){
        log.error("error msg"+commonError.getErrorMsg());
        return BaseResponse.fail(commonError.getErrorCode(),commonError.getErrorMsg());
    }
}
