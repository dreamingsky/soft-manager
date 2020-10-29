package com.young.application.mapper;

import com.young.application.entity.SysImage;
import com.young.application.page.Pager;
import com.young.application.system.request.ImageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface SysImageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysImage record);

    int insertSelective(SysImage record);

    SysImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysImage record);

    int updateByPrimaryKey(SysImage record);

    List<SysImage> findImageByPage(ImageBean bean);
}