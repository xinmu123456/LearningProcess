import com.xinmu.mapper.UserMapper;
import com.xinmu.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * author: xinmu
 * date: 2022/4/4
 * time: 21:52
 */


public class MyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);

        List<User> userList=userMapper.selectUser();

        for (User user : userList) {
            System.out.println(user);
        }

    }
}
