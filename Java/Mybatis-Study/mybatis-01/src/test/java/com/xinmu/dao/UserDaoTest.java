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

        User user = mapper.getUserById(1);

        System.out.println(user);


        sqlSession.close();

    }

    @Test
    public void getUserBuId2(){
        SqlSession sqlSession =MybatisUtils.getSqlsession();

        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("id",1);

        User user = mapper.getUserById2(map);

        System.out.println(user);

        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession=MybatisUtils.getSqlsession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.addUser(new User(4, "zhangsan", "123123"));
        if (res>0){
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void addUser2(){
        SqlSession sqlSession=MybatisUtils.getSqlsession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userid",4);
        map.put("userName","zhangsan");
        map.put("passWord","123456");

        mapper.addUser2(map);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUser(){

        SqlSession sqlSession=MybatisUtils.getSqlsession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(4,"呵呵","123123"));

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession=MybatisUtils.getSqlsession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(4);

        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession=MybatisUtils.getSqlsession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> user = mapper.getUserLike("%李%");


        for (User user1 : user) {
            System.out.println(user1);
        }

        sqlSession.close();

    }




}
