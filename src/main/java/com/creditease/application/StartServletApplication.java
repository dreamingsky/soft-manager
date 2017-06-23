package com.creditease.application;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public class StartServletApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){

        SpringApplicationBuilder sources = builder.sources(CreditApplication.class);

        return sources;
    }


}