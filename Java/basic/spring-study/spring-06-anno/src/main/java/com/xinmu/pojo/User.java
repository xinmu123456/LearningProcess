package com.xinmu.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * author: xinmu
 * date: 2022/4/2
 * time: 17:31
 */

//等价于<bean id="user" class="com.xinmu.pojo.User"/>
//@Component 组件
@Component
@Scope("prototype")
public class User {

    //相当于
    //    <bean id="user" class="com.xinmu.pojo.User">
    //        <property name="name" value="新木"/>
    //    </bean>

    public String name;

    @Value("新木")
    public void setName(String name) {
        this.name = name;
    }
}
