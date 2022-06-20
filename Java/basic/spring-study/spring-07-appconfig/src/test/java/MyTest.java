import com.xinmu.config.xinmuConfig;
import com.xinmu.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * author: xinmu
 * date: 2022/4/2
 * time: 21:03
 */


public class MyTest {
    public static void main(String[] args) {
        //如果完全使用了配置类方式去做,我们就只能通过AnnotationConfig 上下文来获取容器,通过配置类的class对象加载
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(xinmuConfig.class);
        User getUser =(User) context.getBean("getUser");
        System.out.println(getUser);


    }


}
