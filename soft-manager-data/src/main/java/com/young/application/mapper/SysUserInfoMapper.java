package com.young.application.mapper;

import com.young.application.entity.SysUserInfo;
import com.young.application.system.request.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserInfo record);

    int insertSelective(SysUserInfo record);

    SysUserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserInfo record);

    int updateByPrimaryKey(SysUserInfo record);

    SysUserInfo findUserByUserInfo(@Param("userName") String userName,@Param("password") String pass);


    List<SysUserInfo> findUserByPage(UserBean bean);
}