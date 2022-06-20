package com.xinmu.lesson2.untils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author xinmu
 * @date 2022/3/18 11:38
 * @description:
 */
public class JdbcUntils {

    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;


    static{
        try{
            InputStream in = JdbcUntils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);

            driver = properties.getProperty("driver");
            url=properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            //1.驱动只用加载一次
            Class.forName(driver);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取连接
    public static Connection getConnection () throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    //释放资源
    public static void release(Connection conn, Statement st, ResultSet rs) throws SQLException{
        if (rs!=null){
            rs.close();
        }
        if (st!=null){
            st.close();
        }
        if (conn!=null){
            conn.close();
        }
    }

}
