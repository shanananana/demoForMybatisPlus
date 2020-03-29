package com.baomidou.com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
@MapperScan({"com.baomidou.mybatisplus.samples.quickstart.mapper","com.baomidou.com.example.demo.mapper"})
public class DemoApplication {

        public static void main(String[] args) {
                SpringApplication.run(DemoApplication.class,args);
        }


}
