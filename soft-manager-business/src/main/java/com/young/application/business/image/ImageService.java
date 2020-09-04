package com.young.application.business.image;

import com.young.application.entity.Image;
import com.young.application.page.Pager;
import com.young.application.system.request.ImageBean;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public interface ImageService {

    Pager findImageListByPage(ImageBean bean);

    void saveImage(Image image);
    Image findImageById(Long id);

    void deleteImage(Image image);
}
