package com.baomidou.com.example.demo.util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@SuppressWarnings("unchecked")
public class RedisUtil {

    @Autowired
    RedisTemplate redisTemplate;

    public <T>void setModel(String key,T model) {
        HashMap<String, Object> map=Constant.convertToMap(model);
        redisTemplate.opsForHash().putAll(key,map);
    }

    public <T>Object getModel(String key,Class cls){
        Map res=redisTemplate.opsForHash().entries(key);
        Object resp=JSON.parseObject(JSON.toJSONString(res), cls);
        return resp;
    }




    public void setString(String key,Object value){
        redisTemplate.opsForValue().set(key,Constant.convert2String(value));
    }

    public void setStringWithExpiredSeconds(String key,Object value,Long expiredSeconds){
        redisTemplate.opsForValue().set(key,Constant.convert2String(value),expiredSeconds, TimeUnit.SECONDS);
    }

    public String getString(String key){
        Object result=redisTemplate.opsForValue().get(key);
        return result==null?null:String.valueOf(result);
    }




    public Boolean delKey(String key){
        return redisTemplate.delete(key);
    }

    public Long delKeyList(List<String> keys){
        if(keys!=null&&keys.size()>0){return 0L;}
        Long resp=redisTemplate.delete(keys);
        return resp;
    }
}
