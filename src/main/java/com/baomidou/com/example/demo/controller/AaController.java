package com.baomidou.com.example.demo.controller;


import com.baomidou.com.example.demo.entity.Aa;
import com.baomidou.com.example.demo.service.IAaService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;

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
    @PostMapping("/add")
    public Boolean add(@RequestBody Aa aa){
        return iAaService.save(aa);
    }
    @PostMapping("/update")
    public void update(@RequestBody Aa aa){
        iAaService.updateById(aa);
    }
    @PostMapping("/selectOne")
    public Aa selectOne(@RequestParam("id")Long id){
        return iAaService.getById(id);
    }
}
