package com.baomidou.com.example.demo.controller;


import com.baomidou.com.example.demo.entity.User;
import com.baomidou.com.example.demo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangjie
 * @since 2020-03-29
 */
@RestController
@RequestMapping("/com.example.demo/user")
@Api("swagger2Demo")
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/saveUser")
    @ApiOperation("新增用户")
    public Boolean save(@RequestBody User user){
       return iUserService.save(user);
    }
}
