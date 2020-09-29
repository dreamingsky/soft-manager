package com.young.application.controller;

import com.young.application.business.image.ImageService;
import com.young.application.entity.SysImage;
import com.young.application.page.Pager;
import com.young.application.system.request.ImageBean;
import com.young.application.system.request.ResultInfo;
import com.young.application.system.util.FileUtil;
import com.young.application.vo.ImageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
    public String userSave(ImageVO imageVO, HttpServletRequest request){
        try {
            MultipartFile file = imageVO.getFile();
            if(!file.isEmpty()){
                imageVO.setFileName(file.getOriginalFilename());
                imageVO.setFileUrl(FileUtil.upload(file.getOriginalFilename(),file.getInputStream()));
            }
            //复制
            SysImage image = new SysImage();
            BeanUtils.copyProperties(imageVO,image);
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
            SysImage image = imageService.findImageById(id);
            if(image!=null){
                imageService.deleteImage(image);
            }

        }catch (Exception e){

            logger.error("image",e);
        }

        return info;
    }

}
