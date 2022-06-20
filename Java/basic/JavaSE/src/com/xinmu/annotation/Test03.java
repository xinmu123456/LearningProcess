package com.xinmu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xinmu
 * @date 2022/3/4 11:20
 * @description:自定义注解
 */
public class Test03 {
    //注解可以显示复制,如果没有默认值,我们就必须给注解赋值
    @MyAnnotation2(name = "xinmu")
    public void test(){
        
    }
    @MyAnnotation3("111")
    public void test2(){
        
    }
}

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    //注解的参数:参数类型+参数名();
    String name() default "";//默认值default
    int age() default 0;
    int id() default -1;//如果默认值为-1,代表不存在

    String[] schools() default {"cdut","qinhua"};

}

@interface MyAnnotation3 {
    String value();//value默认可以省掉参数名
}


