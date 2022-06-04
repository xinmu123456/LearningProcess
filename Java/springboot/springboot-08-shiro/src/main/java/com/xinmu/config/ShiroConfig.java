package com.xinmu.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author: xinmu
 * date: 2022/4/18
 * time: 21:48
 */

@Configuration
public class ShiroConfig {

    //shiroFilterFactoryBean 3.
    @Bean
    public ShiroFilterFactoryBean  getShiroFilterFactoryBean(@Qualifier("securityManager")  DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
         anon无需认证就可以访问
         authc:必须认证了才可以访问
         user: 必须拥有了记住我功能后才可以用
         perm: 拥有对某个资源的权限才可以访问
         role: 拥有某个角色的权限才可以访问
         */

        Map<String,String> filterMap= new LinkedHashMap<String,String>();

        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        //设置登录页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");

        return shiroFilterFactoryBean;
    }

    //DefaultWebSecurityManager 2.
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    //常见realm对象 1.
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

}
