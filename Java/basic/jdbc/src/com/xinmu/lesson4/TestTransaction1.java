package com.xinmu.lesson4;

import com.xinmu.lesson2.untils.JdbcUntils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xinmu
 * @date 2022/3/18 19:41
 * @description:
 */
public class TestTransaction1 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;


        try {
            conn=JdbcUntils.getConnection();

            //关闭数据库的自动提交,自动会开启事务
            conn.setAutoCommit(false);

            String sql1="update account set money =money-100 where name ='A'";

            st=conn.prepareStatement(sql1);
            st.executeUpdate();

            String sql2="update account set money =money+100 where name='B'";
            st=conn.prepareStatement(sql2);
            st.executeUpdate(sql2);

            //业务完毕,提交事务
            conn.commit();
            System.out.println("successful");



        } catch (SQLException e) {
            try {
                conn.rollback();//如果失败则回滚,默认回滚
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                JdbcUntils.release(conn,st,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
