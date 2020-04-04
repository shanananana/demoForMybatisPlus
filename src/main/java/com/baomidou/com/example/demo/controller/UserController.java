package com.baomidou.com.example.demo.controller;


import com.baomidou.com.example.demo.entity.User;
import com.baomidou.com.example.demo.enums.EmBusinessError;
import com.baomidou.com.example.demo.exception.BusinessException;
import com.baomidou.com.example.demo.mapper.UserMapper;
import com.baomidou.com.example.demo.service.IUserService;
import com.baomidou.com.example.demo.util.Constant;
import com.baomidou.com.example.demo.util.responseUtil.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Name;

/**
 * <p>
 * 前端控制器
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

    @Autowired
    SqlSession sqlSession;

    @Autowired
    RedisTemplate redisTemplate;
    @PostMapping("saveUser")
    @ApiOperation("新增用户")
    public Result<Boolean> save(@RequestBody User user) {
        if (true) {
            throw new BusinessException(EmBusinessError.ERROR_ONE);
        }
        user.setPassword(Constant.getMD5(user.getPassword()));
        Boolean res = iUserService.save(user);
        return Result.success(res);
    }

    @GetMapping("getUserById")
    @ApiOperation("根据id查询用户")
    public Result<User> getUserById(@RequestParam Long id) {
        User user =new User().setId(id);
        User resp=user.selectById(user);
        return Result.success(resp);
    }

    @GetMapping("getUserList")
    @ApiOperation("分页接口")
    public Result getUserList(@RequestParam(value = "names", required = false) String names,
                              @RequestParam(value = "sex", required = false) Integer sex,
                              @RequestParam(value = "page") Integer page,
                              @RequestParam(value = "pageSize") Integer pageSize
    ) {
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery
                .eq(StringUtils.isNotBlank(names), User::getNames, names)
                .eq(sex!=null, User::getSex, sex);
        IPage<User> userIPage = new Page<>(page, pageSize);
        IPage page1 = iUserService.page(userIPage, lambdaQuery);
        return Result.success(page1);
    }

}
