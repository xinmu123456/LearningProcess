package TestAop;

/**
 * @Author: xinmu
 * @DateTime: 2022/9/27 11:14
 */


public class HelloInterceptor implements Interceptor {

    @Override
    public void invoke(Invoke invoke) {
        System.out.println("执行前");
        invoke.invoke();
        System.out.println("执行后");
    }
}