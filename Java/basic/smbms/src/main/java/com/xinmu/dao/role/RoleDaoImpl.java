package com.xinmu.dao.role;

import com.xinmu.dao.BaseDao;
import com.xinmu.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * author: xinmu
 * date: 2022/3/26
 * time: 14:19
 */


public class RoleDaoImpl implements RoleDao{
    //获取角色列表
    public List<Role> getRoleList(Connection connection) throws SQLException {
        PreparedStatement pstm=null;
        ResultSet resultSet = null;
        ArrayList<Role> roleList = new ArrayList<Role>();
        if (connection!=null){
            String sql ="select * from smbms_role";
            Object[] params={};
            resultSet = BaseDao.execute(connection, pstm, resultSet, sql, params);


            while(resultSet.next()){
                Role _role=new Role();
                _role.setRoleCode(resultSet.getString("roleCode"));
                _role.setRoleName(resultSet.getString("roleName"));
                _role.setId(resultSet.getInt("id"));
                roleList.add(_role);
            }
            BaseDao.closeResource(null,pstm,resultSet);
        }
        return roleList;
    }
}
