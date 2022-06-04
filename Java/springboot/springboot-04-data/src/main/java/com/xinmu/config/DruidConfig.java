package com.xinmu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletOutputStream;
import javax.sql.DataSource;
import java.util.HashMap;

/**
 * author: xinmu
 * date: 2022/4/16
 * time: 22:32
 */

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控
    //因为spingboot内置了servlet容器,所以没有web.xml 替代方法ServletRegistrationBean
    @Bean
    public ServletRegistrationBean a(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台需要有人登录账号密码
        HashMap<String,String> initParameters = new HashMap<>();

        //增加配置
        initParameters.put("loginUsername","admin");//登录key 是固定的
        initParameters.put("loginPassword","123456");

        //允许谁能访问
        initParameters.put("allow","");



        bean.setInitParameters(initParameters);//初始化参数
        return bean;
    }

    //filter
    public FilterRegistrationBean webStartFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        //可以获取哪些请求呢?
        HashMap<String,String> initParameters = new HashMap<>();

        //这些东西不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParameters);

        return bean;
    }

}
