package com.creditease.application.service.impl;

import com.creditease.application.dao.UserDao;
import com.creditease.application.dao.impl.UserDaoImpl;
import com.creditease.application.entity.User;
import com.creditease.application.service.UserService;
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
}
