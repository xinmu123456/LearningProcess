package com.xinmu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xinmu.pojo.User;
import org.springframework.stereotype.Repository;

//在对应的mapper上面继承基本的类 BadeMapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    //所有的crud操作都已经编写完成
    //不需要像以前配置一大堆文件了
}
