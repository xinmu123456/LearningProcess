package com.xinmu.test;

import java.sql.*;

/**
 * author: xinmu
 * date: 2022/3/24
 * time: 10:10
 */


public class TestJdbc {

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

        //3.向数据库发送sql的对象statement:crud
        Statement statement=connection.createStatement();



        //4.编写sql
        String sql="DELETE from users WHERE id =4;";

        //返回值是受影响的行数,增删改都是executeUpdate即可
        //int i = statement.executeUpdate(sql);

        //5.执行查询sql,返回一个resultset的一个结果集
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("name"));
            System.out.println("password="+resultSet.getObject("password"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birthday="+resultSet.getObject("birthday"));
        }

        //6.关闭连接释放资源,先开的后关
        resultSet.close();
        statement.close();
        connection.close();



    }
}
