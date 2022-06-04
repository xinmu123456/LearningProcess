package com.xinmu.mapper;


import com.xinmu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解表示了这个是个mybatis的
@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(@Param("uid") int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(@Param("uid") int id);

}
