package com.creditease.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.creditease.application.entity.User;
import com.creditease.application.request.Pager;
import com.creditease.application.request.ResultInfo;
import com.creditease.application.request.UserBean;
import com.creditease.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huiyangchen1 on 2017/6/16.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping("/index")
    public String toLogin(HttpServletRequest request){
        return "index";
    }
    @RequestMapping("/")
    public String login(HttpServletRequest request){
        return "login";
    }

    @RequestMapping("/info")
    public String loginInfo(UserBean bean,HttpServletRequest request){

        return "index";
    }
}
