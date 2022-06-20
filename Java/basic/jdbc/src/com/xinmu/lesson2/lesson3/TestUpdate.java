package com.xinmu.lesson2.lesson3;

import com.xinmu.lesson2.untils.JdbcUntils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author xinmu
 * @date 2022/3/18 18:36
 * @description:
 */
public class TestUpdate {
    public static void main(String[] args) {

        Connection conn=null;
        PreparedStatement st=null;
        try {
            conn= JdbcUntils.getConnection();

            //区别
            //使用?占位符代替参数
            String sql="update users set `name`=? where id=?;";

            st=conn.prepareStatement(sql);//预编译sql,先写sql,但不执行

            //手动给参数赋值
            st.setString(1,"新木");
            st.setInt(2,1);

            //执行
            int i = st.executeUpdate();
            if (i>0){
                System.out.println("成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
