import com.xinmu.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author: xinmu
 * date: 2022/4/2
 * time: 17:34
 */


public class MyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user.name);
    }
}
