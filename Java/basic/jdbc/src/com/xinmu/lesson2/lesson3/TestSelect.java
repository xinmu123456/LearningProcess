package com.xinmu.lesson2.lesson3;

import com.xinmu.lesson2.untils.JdbcUntils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xinmu
 * @date 2022/3/18 18:38
 * @description:
 */
public class TestSelect {


    public static void main(String[] args) {
        Connection conn= null;
        PreparedStatement st=null;
        ResultSet rs=null;

        try {
            conn = JdbcUntils.getConnection();

            String sql="select * from users where id=?";//编写sql

            st=conn.prepareStatement(sql);

            st.setInt(1,1);

            rs=st.executeQuery();//执行

            if (rs.next()) {
                System.out.println(rs.getString("name"));
            }


        } catch (SQLException e) {
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
