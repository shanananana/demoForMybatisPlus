package com.baomidou.com.example.demo.util.responseUtil;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 *返回结果封装
 */
@Data
@Accessors(chain = true)
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    /**
     * 无参的成功响应
     * */
    public static<T> Result<T> success(){
        Result result=new Result();
        result.code=ResponseCode.Code.SUCCESS;
        result.message=ResponseCode.Message.SUCCESS;
        result.data=null;
        return result;
    }

    /**
     * 带数据的成功响应
     * */
    public static<T> Result<T> success(T t){
        Result result=new Result();
        result.code=ResponseCode.Code.SUCCESS;
        result.message=ResponseCode.Message.SUCCESS;
        result.data=t;
        return result;
    }

    /**
     * 无参的失败响应
     * */
    public static<T> Result<T> fail(){
        Result result=new Result();
        result.code=ResponseCode.Code.REQ_FAIL;
        result.message=ResponseCode.Message.REQ_FAIL;
        result.data=null;
        return result;
    }

    /**
     * 带状态码的失败响应
     * */
    public static<T> Result<T> fail(Integer code){
        Result result=new Result();
        result.code=code;
        result.message=ResponseCode.Message.REQ_FAIL;
        result.data=null;
        return result;
    }

    /**
     * 带消息的失败响应
     * */
    public static<T> Result<T> fail(String message){
        Result result=new Result();
        result.code=ResponseCode.Code.SERVER_ERROR;
        result.message=message;
        result.data=null;
        return result;
    }

    /**
     * 带消息和状态码的响应
     * */
    public  static<T> Result<T> fail(Integer code,String message){
        Result result=new Result();
        result.code=code;
        result.message=message;
        result.data=null;
        return result;
    }

}

