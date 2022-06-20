import com.xinmu.service.UserService;
import com.xinmu.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author: xinmu
 * date: 2022/4/4
 * time: 16:34
 */


public class Mytest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理代理的是接口,注意点
        UserService userService = (UserService) context.getBean("userService");

        userService.query();
    }
}
