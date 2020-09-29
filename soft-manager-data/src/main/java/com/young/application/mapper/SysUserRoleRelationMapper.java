package com.young.application.mapper;

import com.young.application.entity.SysUserRoleRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserRoleRelation record);

    int insertSelective(SysUserRoleRelation record);

    SysUserRoleRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRoleRelation record);

    int updateByPrimaryKey(SysUserRoleRelation record);
}