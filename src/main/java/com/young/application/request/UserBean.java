package com.young.application.request;

/**
 * Created by huiyangchen1 on 2017/6/24.
 */
public class UserBean extends QueryPageBean{

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
