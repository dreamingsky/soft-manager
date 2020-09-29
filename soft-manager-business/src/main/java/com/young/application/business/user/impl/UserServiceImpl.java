package com.young.application.business.user.impl;

import com.young.application.business.user.UserService;
import com.young.application.mapper.SysUserInfoMapper;
import com.young.application.entity.SysUserInfo;
import com.young.application.page.Pager;
import com.young.application.system.request.UserBean;
import com.young.application.system.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;


    @Override
    public SysUserInfo findUserInfo(String userName, String pass) {

        SysUserInfo userInfo = sysUserInfoMapper.findUserByUserInfo(userName, pass);
        return userInfo;
    }

    public SysUserInfo findUserInfo(String userName) {

        SysUserInfo userInfo = sysUserInfoMapper.findUserByUserInfo(userName,null);
        return userInfo;
    }

    @Override
    public Pager findUserListByPage(UserBean bean) {
        Pager pager = new Pager();
        List<SysUserInfo> userInfoList = sysUserInfoMapper.findUserByPage(bean);
        pager.initPage(userInfoList,bean.getPage(),bean.getRows(),bean.getTotal());
        return pager;
    }

    @Override
    public void saveUserInfo(SysUserInfo user) {
        String password = user.getPassword();
        user.setPassword(Md5Util.MD5Encode(password));
        sysUserInfoMapper.insert(user);
    }

    @Override
    public void deleteUser(Long id) {
        sysUserInfoMapper.deleteByPrimaryKey(id);
    }
}
