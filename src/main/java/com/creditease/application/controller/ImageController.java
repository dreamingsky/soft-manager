package com.creditease.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.creditease.application.entity.Image;
import com.creditease.application.entity.User;
import com.creditease.application.query.ImageBean;
import com.creditease.application.query.Pager;
import com.creditease.application.query.ResultInfo;
import com.creditease.application.query.UserBean;
import com.creditease.application.service.ImageService;
import com.creditease.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huiyangchen1 on 2017/6/16.
 */
@Controller
@RequestMapping(value = "/image")
public class ImageController {

    @Autowired
    private ImageService imageService;


    @RequestMapping("/to/list")
    public String tolist(HttpServletRequest request){
        return "image/list";
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo imageList(ImageBean bean, HttpServletRequest request){
        ResultInfo info = new ResultInfo();
        Pager user = imageService.findImageListByPage(bean);

        info.setRows(user.getResults());
        info.setTotal(user.getTotalResult());
        return info;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String userSave(Image image, HttpServletRequest request){
        imageService.saveImage(image);
        return "redirect:/image/to/list";
    }

}
