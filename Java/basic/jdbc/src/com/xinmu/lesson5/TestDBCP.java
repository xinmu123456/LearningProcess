package com.xinmu.lesson5;

import com.xinmu.lesson2.untils.JdbcUntils;
import com.xinmu.lesson5.untils.JdbcUntils_C3P0;
import com.xinmu.lesson5.untils.JdbcUntils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author xinmu
 * @date 2022/3/19 10:50
 * @description:
 */

public class TestDBCP {
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs = null;
        try {
            conn= JdbcUntils_DBCP.getConnection();

            //区别
            //使用?占位符代替参数
            String sql="insert into users(id,`NAME`,`PASSWORD`,`email`,`birthday`)values(?,?,?,?,?)";

            st=conn.prepareStatement(sql);//预编译sql,先写sql,但不执行

            //手动给参数赋值
            st.setInt(1,4);
            st.setString(2,"王五");
            st.setString(3,"123456");
            st.setString(4,"861238515@qq.com");
            st.setDate(5,new java.sql.Date(new Date().getTime()));

            //执行
            int i = st.executeUpdate();
            if (i>0){
                System.out.println("插入成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUntils_C3P0.release(conn,st,rs);
        }

    }
}
