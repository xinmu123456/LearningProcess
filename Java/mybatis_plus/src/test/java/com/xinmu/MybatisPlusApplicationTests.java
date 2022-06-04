package com.xinmu;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xinmu.mapper.UserMapper;
import com.xinmu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    //继承了BaseMapper所有的方法都来自父类
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        //参数是一个wrapper,条件构造器,我们先不用
        //查询全部的用户
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    //测试插入
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("新木java");
        user.setAge(3);
        user.setEmail("861238515@qq.com");

        int ret = userMapper.insert(user);//帮我们自动生成id
        System.out.println(ret); //受影响的行数
        System.out.println(user);

    }


    //测试更新
    @Test
    public void testUpdate(){
        User user = new User();

        //通过条件自动拼接sql
        user.setId(1520360289446752259L);
        user.setName("xinmu");
        user.setAge(20);

        // 注意 : updateById 但是参数是一个对象
        int i = userMapper.updateById(user);
    }


    //测试乐观锁成功
    @Test
    public void testOptimisticLocker(){

        //1.查询用户信息
        User user = userMapper.selectById(1L);

        //2.修改用户信息
        user.setName("xinmu");
        user.setEmail("861238515@qq.com");

        //3.执行更新操作
        userMapper.updateById(user);

    }

    //测试乐观锁失败,多线程
    @Test
    public void testOptimisticLocker2(){

        //线程 1
        User user = userMapper.selectById(1L);
        user.setName("xinmu1");
        user.setEmail("861238515@qq.com");

        // 模拟另外哟个线程执行插队操作
        User user2 = userMapper.selectById(1L);
        user2.setName("xinmu2");
        user2.setEmail("861238515@qq.com");
        userMapper.updateById(user2);

        //3.执行更新操作
        userMapper.updateById(user);  //如果没有乐观锁就会覆盖插队线程的值
    }

    //测试查询
    @Test
    public void testSelectById() {
        User user = new User();
        user.setId(1L);
        user.setName("xinmu"); //动态sql
        User user1 = userMapper.selectById(user);
        System.out.println(user1);
    }

    //测试批量查询
    @Test
    public void testSelectByBatchId() {
        List<User> users= userMapper.selectBatchIds(Arrays.asList(1,2,3));
        System.out.println(users);

        users.forEach(System.out::println);
    }

    //条件查询 map
    @Test
    public void testSelectByBatchIds(){
        HashMap<String, Object> map = new HashMap<>();
        //自定义查询
        map.put("name","xinmu");
        map.put("age",20);

        List<User> users = userMapper.selectByMap(map);

        users.forEach(System.out::println);
    }

    //测试分页查询
    @Test
    public void testPage(){

        //参数一:当前页,参数二:页面大小
        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page, null);

        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());

    }

    //测试删除
    @Test
    public void testDeleteById(){
        userMapper.deleteById(1520360289446752258L);
    }

    //通过id批量删除
    @Test
    public void testDeleteBatchId(){
        userMapper.deleteBatchIds(Arrays.asList(1520360289446752260L,1520360289446752259L));
    }

    //通过map删除
    @Test
    public void  testDeleteMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","新木1");
        userMapper.deleteByMap(map);
    }



}
