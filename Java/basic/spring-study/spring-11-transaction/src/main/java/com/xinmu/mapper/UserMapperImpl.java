package com.xinmu.mapper;

import com.xinmu.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * author: xinmu
 * date: 2022/4/4
 * time: 20:56
 */


public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper{

    @Override
    public List<User> selectUser() {
        User user = new User(5, "小王", "123456");

        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);

        mapper.addUser(user);
        mapper.deleteUser(5);

        return mapper.selectUser();
    }

    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}
