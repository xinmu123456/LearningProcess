package com.xinmu.dynamicProxy;

import com.xinmu.simpleProxy.Person;

import java.lang.reflect.Proxy;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 18:01
 */


public class ProxyClient {

    public static void main(String[] args) {
        //被代理的对象
        Person zhangsan = new Student("张三");

        //创建一个与代理对象关联的InvocationHandler
        StuInvocationHandler<Person> stuHandler = new StuInvocationHandler<>(zhangsan);

        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);

        //执行代理方法
        stuProxy.giveMoney();
    }

}
