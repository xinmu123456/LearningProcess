package com.xinmu.lesson2;

import com.xinmu.lesson2.untils.JdbcUntils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author xinmu
 * @date 2022/3/18 17:33
 * @description:
 */
public class TestUpdate {
    public static void main(String[] args) throws SQLException {

        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            conn= JdbcUntils.getConnection();//获取数据库的连接
            st= conn.createStatement();//获得sql的执行对象
            String sql="UPDATE users SET `name` ='xinmu',email='861238515@qq.com' WHERE id = 1";
            int i = st.executeUpdate(sql);
            if (i>0){
                System.out.println("successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUntils.release(conn,st,rs);
        }

    }
}
