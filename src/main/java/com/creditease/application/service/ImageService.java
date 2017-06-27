package com.creditease.application.service;

import com.creditease.application.entity.Image;
import com.creditease.application.request.ImageBean;
import com.creditease.application.request.Pager;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public interface ImageService {

    Pager findImageListByPage(ImageBean bean);

    void saveImage(Image image);
    Image findImageById(Long id);

    void deleteImage(Image image);
}
