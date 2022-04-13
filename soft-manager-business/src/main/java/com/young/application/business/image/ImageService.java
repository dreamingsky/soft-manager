package com.young.application.business.image;

import com.young.application.business.base.BaseService;
import com.young.application.entity.SysImage;
import com.young.application.page.Pager;
import com.young.application.system.request.ImageBean;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public interface ImageService extends BaseService<SysImage> {


    SysImage findImageById(Long id);

    void deleteImage(SysImage image);
}
