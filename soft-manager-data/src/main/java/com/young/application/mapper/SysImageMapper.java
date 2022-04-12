package com.young.application.mapper;

import com.young.application.base.BaseDao;
import com.young.application.entity.SysImage;
import com.young.application.page.Pager;
import com.young.application.system.request.ImageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface SysImageMapper extends BaseDao<SysImage> {

    List<SysImage> findImageByPage(ImageBean bean);
}