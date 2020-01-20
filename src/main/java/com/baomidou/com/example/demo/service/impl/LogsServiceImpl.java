package com.baomidou.com.example.demo.service.impl;

import com.baomidou.com.example.demo.entity.Logs;
import com.baomidou.com.example.demo.mapper.LogsMapper;
import com.baomidou.com.example.demo.service.ILogsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangjie
 * @since 2020-01-19
 */
@Service
public class LogsServiceImpl extends ServiceImpl<LogsMapper, Logs> implements ILogsService {

}
