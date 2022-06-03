package com.xinmu.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * JDK动态代理实现InvocationHandler接口
 */
public class JdkProxy implements InvocationHandler {
 
    private Object targetObject;  //需要代理的目标对象
 
 
    //定义获取代理对象的方法（将目标对象传入进行代理）
    public Object getJDKProxy(Object targetObject){
        //为目标对象target赋值
        this.targetObject = targetObject;
        //JDK动态代理只能针对实现了接口的类进行代理，newProxyInstance 函数所需参数就可看出
        Object proxyObject = Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);
        //返回代理对象
        return proxyObject;
    }
 
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理，监听开始！");
        // 调用invoke方法，result存储该方法的返回值
        Object result = method.invoke(targetObject,args);
        System.out.println("JDK动态代理，监听结束！");
        return result;
    }
 
//    public static void main(String[] args) {
//        JdkProxy jdkProxy = new JdkProxy();  //实例化JDKProxy对象
//        UserManager user = (UserManager) jdkProxy.getJDKProxy(new UserManagerImpl());   //获取代理对象
//        user.addUser("admin","123456");
//    }
}