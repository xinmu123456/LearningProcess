package com.xinmu.test;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * author: xinmu
 * date: 2022/3/24
 * time: 10:40
 */


public class TestJDBC2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8解决中文乱码问题
        String url ="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username ="root";
        String password ="123456";

        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.连接数据库,代表了数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.编写sql
        String sql="insert into users (id, name ,password,email,birthday) values (?,?,?,?,?)";

        //4.预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,4);//给第一个占位符?
        preparedStatement.setString(2,"新木");//给第二个占位符?
        preparedStatement.setString(3,"123456");//给第三个占位符?
        preparedStatement.setString(4,"861238515@qq.com");//给第四个占位符?
        preparedStatement.setDate(5,
                new Date(new java.util.Date().getTime())); //给第五个占位符?

        //5.执行查询sql
        int i = preparedStatement.executeUpdate();

        if (i>0){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }


        //6.关闭连接释放资源,先开的后关
        preparedStatement.close();
        connection.close();
    }
}
