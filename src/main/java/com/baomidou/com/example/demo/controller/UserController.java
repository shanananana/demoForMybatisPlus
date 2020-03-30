package com.baomidou.com.example.demo.controller;


import com.baomidou.com.example.demo.entity.User;
import com.baomidou.com.example.demo.mapper.UserMapper;
import com.baomidou.com.example.demo.service.IUserService;
import com.baomidou.com.example.demo.util.Constant;
import com.baomidou.com.example.demo.util.responseUtil.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    UserMapper userMapper;

    @PostMapping("saveUser")
    @ApiOperation("新增用户")
    public Result<Boolean> save(@RequestBody User user){
       user.setPassword(Constant.getMD5(user.getPassword()));
       Boolean res=iUserService.save(user);
       return Result.success(res);
    }

    @GetMapping("getUserById")
    @ApiOperation("根据id查询用户")
    public Result<User> getUserById(@RequestParam Long id){
        User user=iUserService.getById(id);
        return Result.success(user);
    }
}
