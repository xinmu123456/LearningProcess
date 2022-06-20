package com.xinmu.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * author: xinmu
 * date: 2022/3/24
 * time: 11:05
 */


public class TestJDBC3 {

    @Test
    public  void test() throws ClassNotFoundException, SQLException {
        Connection connection=null;

        try {
            //配置信息
            //useUnicode=true&characterEncoding=utf-8解决中文乱码问题
            String url ="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
            String username ="root";
            String password ="123456";

            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.连接数据库,代表了数据库
            connection = DriverManager.getConnection(url, username, password);

            //3.通知数据库开启事务,false是开启
            connection.setAutoCommit(false);

            String sql="update account set money =money-100 where name='A';";
            connection.prepareStatement(sql).executeUpdate();

            //制造错误
           // int i=1/0;

            String sql2 ="update account set money =money+100 where name='B';";
            connection.prepareStatement(sql2).executeUpdate();

            //若以上两条sql都执行成功了,就提交事务
            connection.commit();
            System.out.println("success");
        } catch (Exception e) {
            //如果出现异常就通知数据库回滚事务
            connection.rollback();
            e.printStackTrace();
        }finally {
            connection.close();
        }

    }
}
