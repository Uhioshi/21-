package com.uhiroshi.biyesheji;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.uhiroshi.biyesheji.mapper")
public class BiyeshejiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BiyeshejiApplication.class, args);
    }

}
