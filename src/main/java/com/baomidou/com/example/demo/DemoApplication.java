package com.baomidou.com.example.demo;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan({"com.baomidou.mybatisplus.samples.quickstart.mapper","com.baomidou.com.example.demo.mapper"})
@ComponentScan({"com.helper.redishelper","com.baomidou.com.example.demo"})
@EnableSwagger2
public class DemoApplication {


        public static void main(String[] args) {
                SpringApplication.run(DemoApplication.class,args);
        }

        @Bean
        public PaginationInterceptor paginationInterceptor() {
                return new PaginationInterceptor();
        }

        @Bean
        /**
         * 配置REDIS序列器
         */
        public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
                RedisTemplate<String, Object> template = new RedisTemplate<>();
                template.setConnectionFactory(redisConnectionFactory);
                template.setKeySerializer(new StringRedisSerializer());
                Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
                ObjectMapper om = new ObjectMapper();
                om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
                om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
                jackson2JsonRedisSerializer.setObjectMapper(om);
                template.setHashValueSerializer(jackson2JsonRedisSerializer);
                template.setValueSerializer(jackson2JsonRedisSerializer);
                template.afterPropertiesSet();
                return template;
        }
}
