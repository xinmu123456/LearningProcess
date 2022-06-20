package com.xinmu.lesson2;

import com.xinmu.lesson2.untils.JdbcUntils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author xinmu
 * @date 2022/3/18 17:41
 * @description:
 */
public class TestSelect {

    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            conn = JdbcUntils.getConnection();
            st = conn.createStatement();

            //SQL
            String sql="select * from users where id=1";
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUntils.release(conn,st,rs);
        }

    }
}
