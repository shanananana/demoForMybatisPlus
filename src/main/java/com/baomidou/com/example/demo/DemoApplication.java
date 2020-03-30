package com.baomidou.com.example.demo;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
@MapperScan({"com.baomidou.mybatisplus.samples.quickstart.mapper","com.baomidou.com.example.demo.mapper"})
@EnableSwagger2
public class DemoApplication {

        public static void main(String[] args) {
                SpringApplication.run(DemoApplication.class,args);
        }

        @Bean
        public PaginationInterceptor paginationInterceptor() {
                return new PaginationInterceptor();
        }
}
