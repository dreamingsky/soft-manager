package com.creditease.application.controller;

import com.creditease.application.entity.Image;
import com.creditease.application.request.ImageBean;
import com.creditease.application.request.Pager;
import com.creditease.application.request.ResultInfo;
import com.creditease.application.service.ImageService;
import com.creditease.application.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huiyangchen1 on 2017/6/16.
 */
@Controller
@RequestMapping(value = "/image")
public class ImageController {
    private static Logger logger = LoggerFactory.getLogger(ImageController.class);

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
        try {
            MultipartFile file = image.getFile();
            if(!file.isEmpty()){
                image.setFileName(file.getOriginalFilename());
                image.setFileUrl(FileUtil.upload(file.getOriginalFilename(),file.getInputStream()));
            }
            imageService.saveImage(image);
        }catch (Exception e){
            logger.error("image",e);
        }

        return "redirect:/image/to/list";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo userDelete(@PathVariable("id") Long id, HttpServletRequest request){
        ResultInfo info = new ResultInfo();
        try {
            Image image = imageService.findImageById(id);
            if(image!=null){
                imageService.deleteImage(image);
            }

        }catch (Exception e){

            logger.error("image",e);
        }

        return info;
    }

}
