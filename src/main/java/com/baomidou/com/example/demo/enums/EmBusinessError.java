package com.baomidou.com.example.demo.enums;

import com.baomidou.com.example.demo.exception.handler.CommonError;

public enum EmBusinessError implements CommonError {
    ERROR_ONE(10001,"错误1"),
    ERROR_TWO(10002,"错误2"),
    ERROR_THREE(10003,"错误3"),
    ERROR_FOUR(10004,"错误4"),


    CONVERT_ERROR(500,"转换失败");



    private int errCode;
    private String errMsg;
    private EmBusinessError(int errCode,String errMsg ) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrorMsg(String errMsg) {
       this.errMsg= errMsg;
       return this;
    }
}
