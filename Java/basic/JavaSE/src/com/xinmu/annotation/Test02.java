package com.xinmu.annotation;

import java.lang.annotation.*;

/**
 * @author xinmu
 * @date 2022/3/4 10:55
 * @description:测试元注解
 */


public class Test02 {


    @MyAnnotation
    public void test(){


    }

}



//定义一个元注解
//Target 表示我们的注解可以用在那些地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})
//表示我们的注解在什么地方还有效
//runtime>class>sources
@Retention(value= RetentionPolicy.RUNTIME)

//Documented 表示是否将我们的注解生产在javadoc 中
@Deprecated

//Inherited 表示子类可以继承父类的注解
@Inherited
@interface MyAnnotation{

}