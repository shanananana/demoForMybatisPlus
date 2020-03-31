package com.baomidou.com.example.demo.exception.handler;

public interface CommonError {
    public int getErrorCode();

    public String getErrorMsg();

    public CommonError setErrorMsg(String errorMsg);
}
