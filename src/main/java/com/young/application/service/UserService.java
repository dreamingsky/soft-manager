package com.young.application.service;

import com.young.application.request.Pager;
import com.young.application.entity.User;
import com.young.application.request.UserBean;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public interface UserService {

    public User findUserInfo(String userName, String pass);


    Pager findUserListByPage(UserBean bean);

    void saveUserInfo(User user);

    void deleteUser(Long id);
}
