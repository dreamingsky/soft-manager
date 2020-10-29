package com.young.application.business.role.impl;

import com.young.application.business.role.RoleService;
import com.young.application.entity.SysRole;
import com.young.application.mapper.SysRoleMapper;
import com.young.application.page.Pager;
import com.young.application.system.request.RoleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Override
    public Pager findRoleListByPage(RoleBean bean) {

        Pager pager = new Pager();
        List<SysRole> roleList = sysRoleMapper.findRoleByPage(bean);

        pager.initPage(roleList,bean.getPage(),bean.getRows(),bean.getTotal());
        return pager;
    }

    @Override
    public void saveRole(SysRole role) {
        sysRoleMapper.insertSelective(role);
    }

    @Override
    public void deleteRole(Long id) {

        sysRoleMapper.deleteByPrimaryKey(id);
    }
}
