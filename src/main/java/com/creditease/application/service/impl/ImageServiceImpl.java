package com.creditease.application.service.impl;

import com.creditease.application.dao.ImageDao;
import com.creditease.application.dao.UserDao;
import com.creditease.application.dao.impl.ImageDaoImpl;
import com.creditease.application.dao.impl.UserDaoImpl;
import com.creditease.application.entity.Image;
import com.creditease.application.entity.User;
import com.creditease.application.query.ImageBean;
import com.creditease.application.query.Pager;
import com.creditease.application.query.UserBean;
import com.creditease.application.service.ImageService;
import com.creditease.application.service.UserService;
import com.creditease.application.util.FileUtil;
import com.creditease.application.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageDao imageDao;
    @Autowired
    private ImageDaoImpl imageDaoImpl;

    @Override
    public Pager findImageListByPage(ImageBean bean) {
        Pager page = imageDaoImpl.findImageByPage(bean);
        return page;
    }

    @Override
    public void saveImage(Image image) {
       imageDao.saveAndFlush(image);
    }

    @Override
    public Image findImageById(Long id) {

        Image one = imageDao.findOne(id);
        return one;
    }

    @Override
    public void deleteImage(Image image) {
        imageDao.delete(image.getId());
        FileUtil.delete(image.getFileName());
    }
}
