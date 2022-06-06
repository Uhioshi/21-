package com.uhiroshi.biyesheji.config;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class CustomRealm /*extends AuthorizingRealm*/ {
 /*   @Autowired
    private LoginService loginService;


    *//* 权限配置类*//*
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String name=(String) principalCollection.getPrimaryPrincipal();
        User user=loginService.getUserbyName(name);
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        for(Role role: user.getRoleSet()){
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            //添加权限
            for(permissions permissions: role.getPermissionsSet())
                simpleAuthorizationInfo.addStringPermission(permissions.getPermission());
        }
        return simpleAuthorizationInfo;
    }

    *//*认证配置类*//*
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if(StringUtils.isEmpty(authenticationToken.getPrincipal()))
            return null;
        String name = authenticationToken.getPrincipal().toString();
        User user=loginService.getUserbyName(name);
        if (user==null)
            return null;
        else
        {
            SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(name,user.getPassword().toString(),getName());
            return simpleAuthenticationInfo;
        }

    }*/
}