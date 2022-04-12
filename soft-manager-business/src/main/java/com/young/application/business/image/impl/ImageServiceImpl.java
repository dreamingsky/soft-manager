package com.young.application.business.image.impl;

import com.young.application.base.BaseDao;
import com.young.application.business.base.impl.BaseServiceImpl;
import com.young.application.business.image.ImageService;
import com.young.application.mapper.SysImageMapper;
import com.young.application.entity.SysImage;
import com.young.application.page.Pager;
import com.young.application.system.request.ImageBean;
import com.young.application.system.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by huiyangchen1 on 2017/6/15.
 */
@Service
public class ImageServiceImpl extends BaseServiceImpl<SysImage> implements ImageService {

    @Autowired
    private SysImageMapper sysImageMapper;

    @Override
    public Pager findImageListByPage(ImageBean bean) {
        Pager pager = new Pager();
        List<SysImage> userInfoList = sysImageMapper.findImageByPage(bean);
        pager.initPage(userInfoList,bean.getPage(),bean.getRows(),bean.getTotal());
        return pager;
    }

    @Override
    public void saveImage(SysImage image) {
        sysImageMapper.insert(image);
    }

    @Override
    public SysImage findImageById(Long id) {

        SysImage image = sysImageMapper.selectByPrimaryKey(id);
        return image;
    }

    @Override
    public void deleteImage(SysImage image) {
        sysImageMapper.deleteByPrimaryKey(image.getId());
        FileUtil.delete(image.getFileName());
    }

    @Override
    protected BaseDao<SysImage> getDao() {
        return this.sysImageMapper;
    }
}
