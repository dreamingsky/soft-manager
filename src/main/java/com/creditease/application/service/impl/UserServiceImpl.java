package com.creditease.application.service.impl;

import com.creditease.application.query.Pager;
import com.creditease.application.dao.UserDao;
import com.creditease.application.dao.impl.UserDaoImpl;
import com.creditease.application.entity.User;
import com.creditease.application.query.UserBean;
import com.creditease.application.service.UserService;
import com.creditease.application.util.Md5Util;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDaoImpl userDaoImpl;
    @Override
    public User findUserInfo(String userName, String pass) {

        User userInfo = userDaoImpl.findUserByUserInfo(userName, pass);
        return userInfo;
    }

    @Override
    public Pager findUserListByPage(UserBean bean) {
        Pager page = userDaoImpl.findUserByPage(bean);
        return page;
    }

    @Override
    public void saveUserInfo(User user) {
        String password = user.getPassword();
        user.setPassword(Md5Util.MD5Encode(password));
        userDao.saveAndFlush(user);
    }
}
