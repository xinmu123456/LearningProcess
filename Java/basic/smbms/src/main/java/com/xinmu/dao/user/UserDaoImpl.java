package com.xinmu.dao.user;

import com.mysql.jdbc.StringUtils;
import com.xinmu.dao.BaseDao;
import com.xinmu.pojo.Role;
import com.xinmu.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * author: xinmu
 * date: 2022/3/25
 * time: 10:17
 */


public class UserDaoImpl implements UserDao{
    //得到要登录的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        PreparedStatement pstm=null;
        ResultSet rs = null;
        User user=null;


        //如果连接不为空就执行sql
        if (connection != null){
            String sql="select * from smbms_user where userCode=?";
            Object[] params={userCode};

                rs=BaseDao.execute(connection,pstm,rs,sql,params);

                if (rs.next()) {
                    user=new User();
                    user.setId(rs.getInt("id"));
                    user.setUserCode(rs.getString("userCode"));
                    user.setUserPassword(rs.getString("userPassword"));
                    user.setGender(rs.getInt("gender"));
                    user.setBirthday(rs.getDate("birthday"));
                    user.setPhone(rs.getString("phone"));
                    user.setAddress(rs.getString("address"));
                    user.setUserRole(rs.getInt("userRole"));
                    user.setCreatedBy(rs.getInt("createdBy"));
                    user.setCreationDate(rs.getTimestamp("creationDate"));
                    user.setModifyBy(rs.getInt("modifyBy"));
                    user.setModifyDate(rs.getTimestamp("modifyDate"));
                }
                BaseDao.closeResource(null,pstm,rs);
            }
        return user;
    }

    //修改当前的用户密码
    public int updatePwd(Connection connection, int id, String password) throws SQLException {

        PreparedStatement pstm = null;
        int execute=0;

        if (connection!=null){
            String sql="update smbms_user set userPassword = ? where id= ?";
            Object params[]={password,id};
            execute = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(connection,pstm,null);
        }
        return execute;
    }

    //更具用户名或者角色查血用户的总数
    public int getUserCount(Connection connection, String username,int userRole) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Object> list = new ArrayList<Object>();//存放参数
        int count =0;

        if (connection!=null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from `smbms_user` u,smbms_role r where u.userRole=r.id");

            if (!StringUtils.isNullOrEmpty(username)) {
                sql.append(" and u.userName like ?");
                list.add("%+" + username + "%");//index=0
            }
            if (userRole > 0) {
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }

            //怎么把list转化为数组
            Object[] params = list.toArray();

            System.out.println("userdaoimpl->getusercount" + sql.toString());

            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);

            if (rs.next()) {
                count = rs.getInt("count");//从结果集中获取数量
            }

            BaseDao.closeResource(null, pstm, rs);


        }
        return count;
    }

    //通过用户输入的条件查询用户列表
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception {
        List<User> userList = new ArrayList<User>();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        if(connection!=null){
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
            List<Object> list = new ArrayList<Object>();
            if(!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and u.userName like ?");
                list.add("%"+userName+"%");
            }
            if(userRole > 0){
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }
            sql.append(" order by creationDate DESC limit ?,?");
            currentPageNo = (currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);

            Object[] params = list.toArray();
            System.out.println("sql ----> " + sql.toString());
            rs = BaseDao.execute(connection,pstm,rs,sql.toString(),params);
            while(rs.next()){
                User _user = new User();
                _user.setId(rs.getInt("id"));
                _user.setUserCode(rs.getString("userCode"));
                _user.setUserName(rs.getString("userName"));
                _user.setGender(rs.getInt("gender"));
                _user.setBirthday(rs.getDate("birthday"));
                _user.setPhone(rs.getString("phone"));
                _user.setUserRole(rs.getInt("userRole"));
                _user.setUserRoleName(rs.getString("userRoleName"));
                userList.add(_user);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return userList;
    }


}
