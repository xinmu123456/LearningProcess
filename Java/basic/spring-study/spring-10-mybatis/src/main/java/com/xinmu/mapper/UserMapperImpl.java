package com.xinmu.mapper;

import com.xinmu.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * author: xinmu
 * date: 2022/4/4
 * time: 20:56
 */


public class UserMapperImpl implements UserMapper{

    //在原来,我们的所有操作都是使用sqlSession来执行,现在都是SqlSessionTemplate
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> selectUser() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
