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
import com.helper.redishelper.RedisHelper;
import com.helper.responsehelper.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("saveUser")
    @ApiOperation("新增用户")
    public BaseResponse save(@RequestBody User user) {
        if (true) {
            throw new BusinessException(EmBusinessError.ERROR_THREE);
        }
        user.setPassword(Constant.getMD5(user.getPassword()));
        Boolean res = iUserService.save(user);
        return BaseResponse.success(res);
    }

    @GetMapping("getUserById")
    @ApiOperation("根据id查询用户")
    public BaseResponse getUserById(@RequestParam Long id) {
        User user =new User().setId(id);
        User resp=user.selectById(user);
        redisHelper.setModel("11",resp);
        User user1= (User) redisHelper.getModel("11",User.class);
        return BaseResponse.success(resp);
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
                .eq(sex!=null, User::getSex, sex);
        IPage<User> userIPage = new Page<>(page, pageSize);
        IPage page1 = iUserService.page(userIPage, lambdaQuery);
        return BaseResponse.success(page1);
    }

}
