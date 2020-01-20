package com.baomidou.com.example.demo.asepct;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志切面，打印制定目录下的请求日志
 * */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(public * com.baomidou.com.example.demo.controller.*.*(..))")
    public void webLog() {
    }

    @Before(value = "webLog()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("{} <<<<< {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) {
        log.info("{} >>>>> {}", joinPoint.getSignature().getName(), ret==null?null:ret.toString());
    }

}