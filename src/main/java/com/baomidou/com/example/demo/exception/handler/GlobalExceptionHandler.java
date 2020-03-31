package com.baomidou.com.example.demo.exception.handler;

import com.baomidou.com.example.demo.util.responseUtil.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.baomidou.com.example.demo")
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public Result exception(Exception e,CommonError commonError){
        log.error(" "+e);
        return Result.fail(commonError.getErrorCode(),commonError.getErrorMsg());
    }
}
