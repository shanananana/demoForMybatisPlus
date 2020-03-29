package com.baomidou.com.example.demo.service.impl;

import com.baomidou.com.example.demo.entity.User;
import com.baomidou.com.example.demo.mapper.UserMapper;
import com.baomidou.com.example.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangjie
 * @since 2020-03-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
