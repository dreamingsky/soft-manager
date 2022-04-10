package com.young.application.auth;

import com.young.application.business.user.UserService;
import com.young.application.entity.SysUserInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
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
            SysUserInfo userInfo = userService.findUserInfo(username);
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

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        if (StringUtils.isNoneEmpty(username)){

            SysUserInfo userInfo = userService.findUserInfo(username,String.valueOf(token.getPassword()));
            if (userInfo == null){

                return null;
            }

            return new SimpleAuthenticationInfo(username,userInfo.getPassword(),getName());
        }
        return null;
    }
}
