package service;

import com.xinmu.dao.UserDao;
import com.xinmu.dao.UserDaoImpl;

/**
 * author: xinmu
 * date: 2022/4/1
 * time: 9:58
 */


public class UserServiceImpl implements UserService{

     private UserDao userDao=new UserDaoImpl();

    @Override
    public void getUser() {
        userDao.getUser();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
