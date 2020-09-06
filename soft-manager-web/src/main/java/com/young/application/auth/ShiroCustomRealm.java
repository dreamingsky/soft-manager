package com.young.application.auth;

import com.young.application.business.user.UserService;
import com.young.application.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroCustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object principal = principalCollection.getPrimaryPrincipal();
        if (principal != null){
            String username = principal.toString();
            User userInfo = userService.findUserInfo(username);
            if (userInfo == null){

                return null;
            }
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addRole("admin");
            simpleAuthorizationInfo.addStringPermission("add");

            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        Object principal = authenticationToken.getPrincipal();
        if (principal != null){
            String username = principal.toString();
            User userInfo = userService.findUserInfo(username);
            if (userInfo == null){

                return null;
            }

            return new SimpleAuthenticationInfo(username,userInfo.getPassword(),"");
        }
        return null;
    }
}
