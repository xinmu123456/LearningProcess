import com.xinmu.pojo.People;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author: xinmu
 * date: 2022/4/2
 * time: 15:55
 */


public class MyTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        People people = context.getBean("people", People.class);
        people.getDog().shout();
        people.getCat().shout();

    }
}
