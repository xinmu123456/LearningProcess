package com.xinmu.lesson5.untils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xinmu.lesson2.untils.JdbcUntils;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author xinmu
 * @date 2022/3/19 11:23
 * @description:
 */
public class JdbcUntils_C3P0 {
    private static ComboPooledDataSource dataSource=null;

    static{
        try{
//            //代码配置
//            dataSource= new ComboPooledDataSource();
//            dataSource.setDriverClass();
//            dataSource.setDataSourceName();
//

            //创建数据源 工厂-->创建
            dataSource =new ComboPooledDataSource("MySQL");//配置文件写法


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
