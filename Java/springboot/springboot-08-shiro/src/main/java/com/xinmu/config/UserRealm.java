package com.xinmu.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Security;

/**
 * author: xinmu
 * date: 2022/4/18
 * time: 21:51
 */

//自定义的UserRealm
public class UserRealm extends AuthorizingRealm {




    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权");
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=>认证");

        String name="root";
        String password="123456";

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;


        if (!userToken.getUsername().equals(name)){
            return null;//抛出异常
        }

        //密码认证 shiro做
        return new SimpleAuthenticationInfo("",password,"");
    }
}
