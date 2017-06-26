package com.creditease.application.service;

import com.creditease.application.query.Pager;
import com.creditease.application.entity.User;
import com.creditease.application.query.UserBean;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public interface UserService {

    public User findUserInfo(String userName, String pass);


    Pager findUserListByPage(UserBean bean);

    void saveUserInfo(User user);

    void deleteUser(Long id);
}
