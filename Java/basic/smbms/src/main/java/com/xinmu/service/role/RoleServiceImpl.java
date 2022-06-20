package com.xinmu.service.role;

import com.xinmu.dao.BaseDao;
import com.xinmu.dao.role.RoleDao;
import com.xinmu.dao.role.RoleDaoImpl;
import com.xinmu.pojo.Role;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * author: xinmu
 * date: 2022/3/26
 * time: 14:26
 */


public class RoleServiceImpl implements RoleService{

    //引入Dao,因为要操作role的相关的数据库
    private RoleDao roleDao;
    public RoleServiceImpl() {
        roleDao =new RoleDaoImpl();
    }

    public List<Role> getRoleList() {

        Connection connection = BaseDao.getConnection();
        List<Role> roleList=null;


        try {
            connection=BaseDao.getConnection();
            roleList=roleDao.getRoleList(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection,null,null);
        }
        return roleList;
    }




}
