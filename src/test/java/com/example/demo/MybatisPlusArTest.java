package com.example.demo;

import com.baomidou.com.example.demo.DemoApplication;
import com.baomidou.com.example.demo.entity.User;
import com.baomidou.com.example.demo.mapper.UserMapper;
import com.baomidou.com.example.demo.service.IUserService;
import com.baomidou.com.example.demo.util.Constant;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
/**
 * 演示mybatisPlus AR模式相关功能
 * */
@SpringBootTest(classes = DemoApplication.class)
class MybatisPlusArTest {

    @Test
    void contextLoads() {
    }

    @Test
    void mybatisPlusARForSelect() {
        User user = new User();
        user.setId(10L);
        List<User> userList = user.selectAll();
        System.out.println("查询全部user结果打印");
        userList.forEach(o-> System.out.println(o.toString()));

        LambdaQueryWrapper<User> lambdaQueryWrapper= Wrappers.<User>lambdaQuery();
        lambdaQueryWrapper.eq(User::getNames,"lisi").ge(User::getId,5);
        IPage<User> userIPage = user.selectPage(Constant.defaultPage, lambdaQueryWrapper);
        System.out.println("查询分页user结果打印");
        userIPage.getRecords().forEach(o-> System.out.println(o.toString()));
        User userResp = user.selectById(user);
        System.out.println(userResp.toString());
    }

}
