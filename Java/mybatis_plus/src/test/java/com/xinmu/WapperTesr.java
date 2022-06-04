package com.xinmu;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xinmu.mapper.UserMapper;
import com.xinmu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * author: xinmu
 * date: 2022/4/30
 * time: 22:51
 */

@SpringBootTest
class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads(){
        //查询name不为空的用户,并且邮箱不为空的用户,年龄大于等于12
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name").isNotNull("email").ge("age",12);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void test2(){
        //名字是新木的
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","新木");
        User user = userMapper.selectOne(wrapper);// 查询一个可以selectone 多个可以用list
        System.out.println(user);
    }

    @Test
    void test3(){
        //查询年龄在 20到30岁 之间的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,30);// 区间
        Integer count = userMapper.selectCount(wrapper);// 查询结果数
        System.out.println(count);
    }

    @Test
    void test4(){
        //查询年龄在 20到30岁 之间的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.notLike("name","e").likeRight("email","t");

        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    void test5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // id 在子查询中查出来
        wrapper.inSql("id","select id from user where id < 3");


        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    void test6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //通过id进行降序排序
        wrapper.orderByDesc("id");

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }


}
