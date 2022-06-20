package com.xinmu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xinmu
 * @date 2022/3/5 15:11
 * @description:
 */
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得一个class对象
        Class c1 = Class.forName("com.xinmu.reflection.User");

        //构造一个对象
        User user = (User)c1.newInstance();//本质调用类的无参构造器
        System.out.println(user);

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 =(User) constructor.newInstance("xinmu", 001, 19);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        //通过反射获取方法
        Method setName = c1.getDeclaredMethod("setName", String.class);

        //invoke:激活
        //(对象,方法的值)
        setName.invoke(user3,"xinmu");
        System.out.println(user3.getName());

        //通过反射操作属性
        User user4=(User)c1.newInstance();
        Field name=c1.getDeclaredField("name");

        //不能支架操作私有属性,我们需要关闭重写的安全检测,属性或者方法的setAccessible(true)
        name.setAccessible(true);
        name.set(user4,"xinmu");
        System.out.println(user4.getName());





    }
}
