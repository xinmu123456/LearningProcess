package com.xinmu.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

/**
 * author: xinmu
 * date: 2022/4/30
 * time: 20:24
 */

//扫描文件夹
@MapperScan("com.xinmu.mapper")
@EnableTransactionManagement
@Configuration //配置类
public class MybatisPlusConfig {

    //注册乐观锁插件
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mybatisPlusInterceptor;
    }


    //新的分页插件
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor2() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //数据库类型
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

   // 逻辑删除字段
   // @Bean
   // public ISqlInjector sqlInjector(){
   //     return new LogicSqlInjector();
   // }

    //@Bean
    //public MetaObjectHandler metaObjectHandler(){
    //    return  new MetaObjectHandler() {
    //        @Override
    //        public void insertFill(MetaObject metaObject) {
    //            this.setFieldValByName("createTime",new Date(),metaObject);
    //            this.setFieldValByName("updateTime",new Date(),metaObject);
    //        }
    //
    //        @Override
    //        public void updateFill(MetaObject metaObject) {
    //            this.setFieldValByName("updateTime",new Date(),metaObject);
    //        }
    //    };
    //}


}

