package com.baomidou.com.example.demo.util;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 常量类
 */
@Slf4j
public class Constant {

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
}
