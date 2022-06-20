import com.xinmu.dao.UserMapper;
import com.xinmu.pojo.User;
import com.xinmu.untils.MybatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * author: xinmu
 * date: 2022/3/31
 * time: 11:13
 */


public class MyTest {

    @Test
    public void test(){
        SqlSession sqlSession= MybatisUtils.getSqlsession();
        SqlSession sqlSession2=MybatisUtils.getSqlsession();



/*
        User user = mapper.queryUserById(1);
        System.out.println(user);

        //mapper.updateUser(new User(4,"aaa","111111"));
        sqlSession.clearCache();
        System.out.println("+++++++++++++++++++++++++++");

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);

 */
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();

        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user1 = mapper2.queryUserById(1);
        System.out.println(user1);

        User user2 = mapper2.queryUserById(2);
        System.out.println(user2);

        User user3 = mapper2.queryUserById(2);
        System.out.println(user3);
        sqlSession2.close();
    }


}
