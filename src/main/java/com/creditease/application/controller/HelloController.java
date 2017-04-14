package com.creditease.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huiyangchen1 on 2017/3/30.
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String index(){
        return "Hello World";
    }
}
