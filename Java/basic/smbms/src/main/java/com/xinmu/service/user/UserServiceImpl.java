package com.xinmu.service.user;

import com.xinmu.dao.BaseDao;
import com.xinmu.dao.user.UserDao;
import com.xinmu.dao.user.UserDaoImpl;
import com.xinmu.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * author: xinmu
 * date: 2022/3/25
 * time: 10:42
 */


public class UserServiceImpl implements UserService {
    //业务层都会调用dao层所以我们要引入dao层
    private UserDao userDao;
    public UserServiceImpl() {
        userDao=new UserDaoImpl();
    }

    public User login(String userCode, String password) {
        Connection connection=null;
        User user=null;
        try {
            connection= BaseDao.getConnection();
            //通过业务层调用对应的具体的数据库操作
            user=userDao.getLoginUser(connection,userCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;

    }

    public boolean updatePwd(int id, String pwd) {
        Connection connection=null;
        boolean flag=false;

        connection=BaseDao.getConnection();
        //修改密码
        try {
            if (userDao.updatePwd(connection,id,pwd)>0)
                flag=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    //查询记录数
    public int getUserCount(String username, int userRole) {

        Connection connection=null;
        int count=0;


        try {
            connection = BaseDao.getConnection();
            count=userDao.getUserCount(connection,username,userRole);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection,null,null);
        }

        return count;

    }

    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<User> userList = null;
        System.out.println("queryUserName ---- > " + queryUserName);
        System.out.println("queryUserRole ---- > " + queryUserRole);
        System.out.println("currentPageNo ---- > " + currentPageNo);
        System.out.println("pageSize ---- > " + pageSize);
        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection, queryUserName,queryUserRole,currentPageNo,pageSize);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return userList;
    }
}
