package com.creditease.application.service;

import com.creditease.application.entity.User;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public interface UserService {

    public User findUserInfo(String userName, String pass);


}
