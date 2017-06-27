package com.creditease.application.controller;

import com.creditease.application.annotation.AnnoUtil;
import com.creditease.application.request.ImageBean;
import com.creditease.application.request.Pager;
import com.creditease.application.request.ResultInfo;
import com.creditease.application.response.entity.ImageRes;
import com.creditease.application.service.ImageService;
import com.creditease.application.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huiyangchen1 on 2017/6/26.
 */
@Controller
@RequestMapping("/app")
public class AppController {

    private static Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private ImageService imageService;

    @RequestMapping("/image/list")
    @ResponseBody
    public ResultInfo imageList(ImageBean bean){

        ResultInfo info = new ResultInfo();
        try {
            Pager pager = imageService.findImageListByPage(bean);
            info.setTotal(pager.getTotalResult());
            info.setRows(AnnoUtil.convertBean(ImageRes.class,pager.getResults()));
        }catch (Exception e){
            logger.error("image/app",e);
            info.setCode(Constant.failCode);
            info.setDesc(e.getMessage());
        }

        return info;

    }
}
