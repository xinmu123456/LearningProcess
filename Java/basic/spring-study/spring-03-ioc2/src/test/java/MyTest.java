import com.xinmu.pojo.User;
import com.xinmu.pojo.UserT;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author: xinmu
 * date: 2022/4/1
 * time: 10:20
 */


public class MyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UserT user = (UserT) context.getBean("u2");
        user.show();

    }
}
