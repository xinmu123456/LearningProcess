package com.xinmu.lesson1;

import java.sql.*;

/**
 * @author xinmu
 * @date 2022/3/18 10:04
 * @description:我的第一个jdbc程序
 */
public class JdbcFirstDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.用户信息和url
        String url="jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username="root";
        String password="123456";
        //3.连接成功,返回数据库对象 connection 代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        
        //4.执行sql的对象 statement 执行sql的对象
        Statement statement = connection.createStatement();

        //5/执行sql的对象,去执行sql
        String sql="select * from users";

        ResultSet resultSet = statement.executeQuery(sql); //返回结果集,结果集中封装了我们全部查询出来的结果




        while(resultSet.next()){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("name"));
            System.out.println("pwd="+resultSet.getObject("password"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birth="+resultSet.getObject("birthday"));
            System.out.println("==================");
        }

        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();


    }

}
