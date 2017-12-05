package com.young.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.young.application.request.Pager;
import com.young.application.entity.User;
import com.young.application.request.ResultInfo;
import com.young.application.request.UserBean;
import com.young.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huiyangchen1 on 2017/6/16.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/info")
    @ResponseBody
    public JSONObject userInfo(){

        User userInfo = userService.findUserInfo("chen", "chen");

        Object o = JSONObject.toJSON(userInfo);

        return (JSONObject) o;

    }


    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo userList(UserBean bean, HttpServletRequest request){
        ResultInfo info = new ResultInfo();
        Pager user = userService.findUserListByPage(bean);

        info.setRows(user.getResults());
        info.setTotal(user.getTotalResult());
        return info;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String userSave(User user,HttpServletRequest request){
        userService.saveUserInfo(user);
        return "redirect:/user/to/list";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo userDelete(@PathVariable("id") Long id, HttpServletRequest request){
        ResultInfo info = new ResultInfo();
        userService.deleteUser(id);
        return info;
    }

}
