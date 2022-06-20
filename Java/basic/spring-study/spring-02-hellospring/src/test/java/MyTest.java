import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author: xinmu
 * date: 2022/3/31
 * time: 23:15
 */


public class MyTest {
    public static void main(String[] args) {
        //获取spring的上下文对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //我们的对象现在都在spring中管理,需要使用取出来就行了
        Object hello = context.getBean("hello");
        System.out.println(hello);
        
    }
}
