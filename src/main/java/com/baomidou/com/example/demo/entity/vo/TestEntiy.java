package com.baomidou.com.example.demo.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TestEntiy {
    private String account;

    private String password;
}
