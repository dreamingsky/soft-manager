package com.young.application.business.image.impl;

import com.young.application.business.image.ImageService;
import com.young.application.dao.ImageDao;
import com.young.application.dao.impl.ImageDaoImpl;
import com.young.application.entity.Image;
import com.young.application.page.Pager;
import com.young.application.system.request.ImageBean;
import com.young.application.system.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


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

        Optional<Image> image = imageDao.findById(id);
        return image.get();
    }

    @Override
    public void deleteImage(Image image) {
        imageDao.deleteById(image.getId());
        FileUtil.delete(image.getFileName());
    }
}
