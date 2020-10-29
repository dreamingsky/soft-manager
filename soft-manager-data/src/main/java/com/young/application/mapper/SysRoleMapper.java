package com.young.application.mapper;

import com.young.application.entity.SysRole;
import com.young.application.system.request.RoleBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface SysRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);


    List<SysRole> findRoleByPage(RoleBean bean);

}