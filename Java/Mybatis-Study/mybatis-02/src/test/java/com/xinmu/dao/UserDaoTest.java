package com.xinmu.dao;

import com.xinmu.pojo.User;
import com.xinmu.untils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: xinmu
 * date: 2022/3/27
 * time: 19:46
 */


public class UserDaoTest {

    @Test
    public void test(){

        //第一步:获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlsession();

        //方式一:getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

//        //方式二:
//        List<User> userList = sqlSession.selectList("com.xinmu.dao.UserDao.getUserList");
//
//        for (User user : userList) {
//            System.out.println(user);
//        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById(){

        SqlSession sqlSession=MybatisUtils.getSqlsession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();

    }




}
