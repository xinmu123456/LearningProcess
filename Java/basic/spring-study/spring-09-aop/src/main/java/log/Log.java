package log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * author: xinmu
 * date: 2022/4/4
 * time: 16:10
 */


public class Log implements MethodBeforeAdvice {

    //method :要执行的目标对象的方法
    //args:参数
    //target: 目标对象

    @Override
    public void before(Method method, Object[] objects, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + "的"+method.getName() + "被执行了");
    }
}
