import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import xinmu.untils.MybatisUtils;

/**
 * author: xinmu
 * date: 2022/3/30
 * time: 10:44
 */


public class UserMapperTest {
    @Test
    public void test(){
        SqlSession sqlsession = MybatisUtils.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
//        List<User> users = mapper.getUsers();
//
//        for (User user : users) {
//            System.out.println(user);
//        }

//        User user = mapper.getUserById(1);
//        System.out.println(user);

//        mapper.addUser(new User(5,"hello","123456"));

//        mapper.updateUser(new User(5,"to","123456"));
        mapper.deleteUser(5);
        sqlsession.close();
    }
}
