package com.baomidou.com.example.demo.controller;


import com.baomidou.com.example.demo.entity.Aa;
import com.baomidou.com.example.demo.mapper.AaMapper;
import com.baomidou.com.example.demo.service.IAaService;
import com.baomidou.com.example.demo.service.impl.AaServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.java2d.pipe.AAShapePipe;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangjie
 * @since 2020-01-19
 */
@RestController
@RequestMapping("/com.example.demo/aa")
public class AaController {

    @Autowired
    IAaService iAaService;

    @Autowired
    AaMapper aaMapper;

    @PostMapping("/add")
    public Boolean add(@RequestBody Aa aa) {
        return iAaService.save(aa);
    }

    @PostMapping("/update")
    public void update(@RequestBody Aa aa) {
        iAaService.updateById(aa);
    }

    @PostMapping("/selectOne")
    public Aa selectOne(@RequestParam("id") Long id) {
        return iAaService.getById(id);
    }

    @PostMapping("/selectList")
    public List<Aa> selectList(@RequestParam(value = "page" ,required = false)Integer page,
                               @RequestParam(value = "pageSize",required = false)Integer pageSize) {
       // IPage<Aa> userPage = new Page<>(page, pageSize);//参数一是当前页，参数二是每页个数
        IPage<Aa> userPage = new Page<>(1, 10);//参数一是当前页，参数二是每页个数
        userPage = aaMapper.selectPage(userPage, null);
        List<Aa> list = userPage.getRecords();
        return list;
    }
}