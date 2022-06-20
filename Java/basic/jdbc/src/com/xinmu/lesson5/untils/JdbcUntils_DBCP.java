package com.xinmu.lesson5.untils;

import com.xinmu.lesson2.untils.JdbcUntils;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author xinmu
 * @date 2022/3/19 10:37
 * @description:
 */
public class JdbcUntils_DBCP {

    private static DataSource dataSource=null;

    static{
        try{
            InputStream in = JdbcUntils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties properties = new Properties();
            properties.load(in);

            //创建数据源 工厂-->创建
            dataSource = BasicDataSourceFactory.createDataSource(properties);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取连接
    public static Connection getConnection () throws SQLException {
        return dataSource.getConnection();//从数据源中获取连接
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
