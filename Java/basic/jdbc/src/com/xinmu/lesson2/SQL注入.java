package com.xinmu.lesson2;

import com.xinmu.lesson2.untils.JdbcUntils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author xinmu
 * @date 2022/3/18 17:55
 * @description:
 */
public class SQL注入 {
    public static void main(String[] args) {
        login("'or '1=1","123456");
    }

    //登录业务
    public static void login(String username, String password){

        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            conn = JdbcUntils.getConnection();
            st = conn.createStatement();

            //SQL
            String sql="select * from users where `NAME` = '"+username+"' AND `password` = '"+password+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("NAME"));
                System.out.println(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                JdbcUntils.release(conn,st,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
