package TestAop;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: xinmu
 * @DateTime: 2022/9/27 11:04
 */


public class Aop {
    public static <T> T get(Class<T> clazz) {
        try {
            return clazz.getConstructor(int.class).newInstance(1);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static void invoke(Interceptor interceptor, Invoke invoke) {
        interceptor.invoke(invoke);
    }

    public static void main(String[] args) {
        Hello hello = Aop.get(Hello.class);
        Aop.invoke(new HelloInterceptor(), () -> {
            hello.test();
        });

        Aop.invoke((invoke) -> {
            System.out.println("lambda");
            invoke.invoke();
            System.out.println("lambda over");
        }, () -> {
            hello.test();
        });
    }
}


