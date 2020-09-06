package com.young.application.business.user.impl;

import com.young.application.business.user.UserService;
import com.young.application.page.Pager;
import com.young.application.dao.UserDao;
import com.young.application.dao.impl.UserDaoImpl;
import com.young.application.entity.User;
import com.young.application.system.request.UserBean;
import com.young.application.system.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDaoImpl userDaoImpl;
    @Override
    public User findUserInfo(String userName, String pass) {

        User userInfo = userDaoImpl.findUserByUserInfo(userName, pass);
        return userInfo;
    }

    public User findUserInfo(String userName) {

        User userInfo = userDao.findUserInfoByName(userName);
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

    @Override
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }
}
