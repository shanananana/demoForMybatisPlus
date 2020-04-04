package com.example.demo;

import com.baomidou.com.example.demo.DemoApplication;
import com.baomidou.com.example.demo.entity.vo.TestEntiy;
import com.baomidou.com.example.demo.entity.User;
import com.baomidou.com.example.demo.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * 演示redis工具类redisUtil相关操作
 * */
@SpringBootTest(classes = DemoApplication.class)
public class RedisUtilTest {

    @Autowired
    RedisUtil redisUtil;

    /**
     *普通的get set
     * */
    @Test
    void test1(){
        redisUtil.setString("key1",10);
        System.out.println("redis result:    "+redisUtil.getString("key1"));
    }

    /**
     * 带有失效时间的set
     * */
    @Test
    void test2() throws InterruptedException {
        redisUtil.setStringWithExpiredSeconds("key2",15,5L);
        System.out.println("redis result:   "+redisUtil.getString("key2"));
        Thread.sleep(3000);
        System.out.println("redis result:   "+redisUtil.getString("key2"));
        Thread.sleep(2000);
        System.out.println("redis result:   "+redisUtil.getString("key2"));
    }

    @Test
    void test3(){
        User user=new User();
        user.setId(10L).setAccount("账号").setPassword("密码123456").setNames("姓名").setSex(1);
        redisUtil.setModel("user",user);
        User user2= (User) redisUtil.getModel("user",User.class);
        System.out.println(user2.toString());
    }

    /**
     * redis直接存储/取出 未序列化的对象
     * */
    @Test
    void test4(){
        TestEntiy testEntiy=new TestEntiy()
                .setAccount("123")
                .setPassword("456");
        redisUtil.setModel("entity",testEntiy);
        TestEntiy result= (TestEntiy) redisUtil.getModel("entity",TestEntiy.class);
        System.out.println(result.toString());
    }
}
