package com.young.application.business.role;

import com.young.application.entity.SysRole;
import com.young.application.page.Pager;
import com.young.application.system.request.RoleBean;

public interface RoleService {



    Pager findRoleListByPage(RoleBean bean);

    void saveRole(SysRole role);

    void deleteRole(Long id);
}
