package com.young.application.service.impl;

import com.young.application.dao.ImageDao;
import com.young.application.dao.impl.ImageDaoImpl;
import com.young.application.entity.Image;
import com.young.application.request.ImageBean;
import com.young.application.request.Pager;
import com.young.application.service.ImageService;
import com.young.application.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
@Service
public class ImageServiceImpl implements ImageService {

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
