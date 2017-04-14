package com.creditease.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huiyangchen1 on 2017/3/30.
 */
@SpringBootApplication
public class CreditApplication {
    public static void  main(String[] args){
        SpringApplication.run(CreditApplication.class,args);
    }
}
