package com.baomidou.com.example.demo.controller;


import com.baomidou.com.example.demo.entity.User;
import com.baomidou.com.example.demo.mapper.UserMapper;
import com.baomidou.com.example.demo.service.IUserService;
import com.baomidou.com.example.demo.util.Constant;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.helper.exceptionhelper.BusinessException;
import com.helper.exceptionhelper.EmBusinessError;
import com.helper.permissionhelper.annotation.PermissionAnnotation;
import com.helper.redishelper.RedisHelper;
import com.helper.responsehelper.BaseResponse;
import com.helper.util.RedisLockUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    RedisHelper redisHelper;

    @Autowired
    RedisLockUtil redisLockUtil;

    @PostMapping("/login")
    @ApiOperation("登录")
    public Boolean login(HttpServletRequest request) {
        List<String> permissionList=new ArrayList<>();
        permissionList.add("getUserById999");
        HttpSession session = request.getSession();
        session.setAttribute("permissionList",permissionList);
        return true;
    }

    @PostMapping("saveUser")
    @ApiOperation("新增用户")
    public BaseResponse save(@RequestBody User user) {
        user.setPassword(Constant.getMD5(user.getPassword()));
        Boolean res = iUserService.save(user);
        return BaseResponse.success(res);
    }

    @GetMapping("getUserById")
    @ApiOperation("根据id查询用户")
  //  @PermissionAnnotation("getUserById")
    public BaseResponse getUserById(@RequestParam Long id) {
        Boolean getLockRes= redisLockUtil.getLock("test", String.valueOf(123456),5);
        System.out.println("获取锁"+getLockRes);
        Boolean releaseLockRes=redisLockUtil.releaseLock("test",String.valueOf(123456));
        System.out.println("释放锁"+releaseLockRes);
        return BaseResponse.success();
    }

    @GetMapping("getUserList")
    @ApiOperation("分页接口")
    public BaseResponse getUserList(@RequestParam(value = "names", required = false) String names,
                                    @RequestParam(value = "sex", required = false) Integer sex,
                                    @RequestParam(value = "page") Integer page,
                                    @RequestParam(value = "pageSize") Integer pageSize
    ) {
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery
                .eq(StringUtils.isNotBlank(names), User::getNames, names)
                .eq(sex != null, User::getSex, sex);
        IPage<User> userIPage = new Page<>(page, pageSize);
        IPage page1 = iUserService.page(userIPage, lambdaQuery);
        return BaseResponse.success(page1);
    }

}
