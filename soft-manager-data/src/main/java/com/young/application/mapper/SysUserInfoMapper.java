package com.young.application.mapper;

import com.young.application.base.BaseDao;
import com.young.application.entity.SysUserInfo;
import com.young.application.system.request.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserInfoMapper extends BaseDao<SysUserInfo> {


    SysUserInfo findUserByUserInfo(@Param("userName") String userName,@Param("password") String pass);


    List<SysUserInfo> findUserByPage(UserBean bean);
}