package log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * author: xinmu
 * date: 2022/4/4
 * time: 16:15
 */


public class AfterLog implements AfterReturningAdvice {

    //returnValue;返回值
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了"+method.getName()+"方法,返回结果为:"+returnValue);
    }
}
