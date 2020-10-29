package com.young.application.system.request;


import lombok.Data;

/**
 * Created by huiyangchen1 on 2017/6/24.
 */

@Data
public class RoleBean extends QueryPageBean {

    private String userName;
    private String password;

}
