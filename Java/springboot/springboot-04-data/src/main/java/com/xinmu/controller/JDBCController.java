package com.xinmu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * author: xinmu
 * date: 2022/4/16
 * time: 21:26
 */

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库的所有信息
    //没有实体类,数据库中的东西怎么获取
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql ="select * from user";
        return jdbcTemplate.queryForList(sql);
    }

    @GetMapping("/addUser")
    public String addUser(){
        String sql ="insert into mybatis.user(id,name,pwd) values (5,'小明','123456')";
        jdbcTemplate.update(sql);
        return "update-ok";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql ="update mybatis.user set name=? ,pwd=? where id="+id;
        //封装
        Object[] objects = new Object[2];
        objects[0]="小米2";
        objects[1]="zzzzzzz";
        jdbcTemplate.update(sql,objects);
        return "update-ok";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql ="delete from mybatis.user where id = ?";
        //封装
        jdbcTemplate.update(sql,id);
        return "delete-ok";
    }
}
