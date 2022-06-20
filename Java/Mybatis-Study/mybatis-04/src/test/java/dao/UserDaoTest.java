package dao;

import com.xinmu.dao.UserMapper;
import com.xinmu.pojo.User;
import com.xinmu.untils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


/**
 * author: xinmu
 * date: 2022/3/27
 * time: 19:46
 */


public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class);


    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession=MybatisUtils.getSqlsession();

        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);


        List<User> userList = sqlSession.selectList("com.xinmu.dao.UserMapper.getUserByRowBounds",null,rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();

    }

    @Test
    public  void  getUserByLimit(){
        SqlSession sqlSession =MybatisUtils.getSqlsession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.put("startIndex",0);
        map.put("pageSize",2);

        List<User> userList = mapper.getUserByLimit(map);

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById(){

        SqlSession sqlSession=MybatisUtils.getSqlsession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);

        System.out.println(user);

        sqlSession.close();

    }

    @Test
    public void testLog4j(){

        logger.info("info:进入了testLog4j的方法");

        logger.debug("debug:进入了testLog4j");

        logger.error("error:进入了testLog4j");
    }




}
