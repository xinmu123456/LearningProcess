package com.xinmu.dao.user;

import com.xinmu.pojo.Role;
import com.xinmu.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * author: xinmu
 * date: 2022/3/25
 * time: 10:13
 */


public interface UserDao {
    //得到要登录的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException;

    //修改当前的用户密码
    public int updatePwd(Connection connection,int id,String pwd) throws SQLException;

    //查询用户总数
    public int getUserCount(Connection connection,String username,int userRole) throws SQLException;

    //通过条件查询-userlist
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception;


}
