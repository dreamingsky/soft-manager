package com.creditease.application.service;

import com.creditease.application.entity.Image;
import com.creditease.application.entity.User;
import com.creditease.application.query.ImageBean;
import com.creditease.application.query.Pager;
import com.creditease.application.query.UserBean;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public interface ImageService {

    Pager findImageListByPage(ImageBean bean);

    void saveImage(Image image);
}
