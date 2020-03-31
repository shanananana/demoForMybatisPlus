package com.baomidou.com.example.demo.aspect;

import com.baomidou.com.example.demo.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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

    @AfterReturning(value = "webLog()", returning = "resp")
    public void doAfterReturning(JoinPoint joinPoint, Object resp) {
        log.info("{} >>>>> {}", joinPoint.getSignature().getName(), Constant.convert2String(resp));
    }

}