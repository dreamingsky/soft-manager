package com.young.application.business.user;

import com.young.application.business.base.BaseService;
import com.young.application.entity.SysUserInfo;
import com.young.application.page.Pager;
import com.young.application.system.request.UserBean;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public interface UserService extends BaseService<SysUserInfo> {

    SysUserInfo findUserInfo(String userName, String pass);

    SysUserInfo findUserInfo(String userName);

    void saveUserInfo(SysUserInfo user);

}
