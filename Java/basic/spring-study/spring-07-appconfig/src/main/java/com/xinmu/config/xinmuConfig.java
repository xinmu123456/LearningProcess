package com.xinmu.config;

import com.xinmu.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * author: xinmu
 * date: 2022/4/2
 * time: 21:01
 */

//这个也会被Spring容器托管,注册到容器中,因为它本身就是一个@Component
// @Configuration代表这是一个配置类,就和我们之前看的beans.xml是一样的
@Configuration
@ComponentScan("com.xinmu.pojo")
@Import(xinmuConfig2.class)
public class xinmuConfig {

    //注册一个bean,就相当与我们之前写的一个bean标签
    //这个方法的名字,就相相当于bean标签这id属性
    //这个方法的返回值,就相当于备案标签中的class属性
    @Bean
    public User getUser() {
        return new User();//就是返回要注入到bean的对象
    }

}
