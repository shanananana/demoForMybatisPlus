package com.baomidou.com.example.demo.mapper;

import com.baomidou.com.example.demo.entity.Aa;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangjie
 * @since 2020-01-19
 */
@Mapper
public interface AaMapper extends BaseMapper<Aa> {

}
