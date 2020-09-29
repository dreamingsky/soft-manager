package com.young.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by huiyangchen1 on 2017/3/30.
 */
@SpringBootApplication
@MapperScan(basePackages = "com.young.application.mapper")
public class YoungApplication {
    public static void  main(String[] args){

        SpringApplication.run(YoungApplication.class,args);
    }
}
