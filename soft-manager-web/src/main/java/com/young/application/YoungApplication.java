package com.young.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by huiyangchen1 on 2017/3/30.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.young.application.dao",repositoryImplementationPostfix = "Impl")
@EntityScan(basePackages = "com.young.application.entity")
public class YoungApplication {
    public static void  main(String[] args){

        SpringApplication.run(YoungApplication.class,args);
    }
}
