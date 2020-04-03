package com.baomidou.com.example.demo.util;

import com.baomidou.com.example.demo.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 常量类
 */
@Slf4j
public class Constant {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static final IPage<User> defaultPage=new Page<>(1,5);

    /**
     * MD5工具方法
     * */
    public static String getMD5(String str) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            log.error("md5 error" + e);
        }
        md.update(str.getBytes());
        return new BigInteger(1, md.digest()).toString(16);
    }

    //将任何对象转为String
    public static <T> String convert2String(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("convert object to json failed");
        }
    }
}
