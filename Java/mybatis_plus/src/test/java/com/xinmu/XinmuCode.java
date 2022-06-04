package com.xinmu;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * author: xinmu
 * date: 2022/4/30
 * time: 23:28
 */

//代码自动生成器
public class XinmuCode {

    public static void main(String[] args) {
        //需要构建一个代码自动生成器
        AutoGenerator mpg = new AutoGenerator();

        //配置策略

        //1.配置策略
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java"); //生成到哪
        gc.setAuthor("xinmu");
        gc.setOpen(false); //是否打开资源管理器
        gc.setFileOverride(false); //是否覆盖
        gc.setServiceName("%sService"); //去service的I前缀
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //2.设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis_plus?userSSL=false&userUnicode=true&characterEncoding=utf-8");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        mpg.setDataSource(dsc);

        //3.包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("blog");
        pc.setParent("com.xbz");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //策略配置
        StrategyConfig sc = new StrategyConfig();
        //设置要映射的表名(可以同时写多张表名)
        sc.setInclude("user");
        //下划线改驼峰命名
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        //开启Lombok
        sc.setEntityLombokModel(true);
        //逻辑删除
        sc.setLogicDeleteFieldName("deleted");

        //自动填充配置
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        sc.setTableFillList(tableFills);

        //乐观锁
        sc.setVersionFieldName("version");

        sc.setRestControllerStyle(true);
        sc.setControllerMappingHyphenStyle(true); //下划线命名

        mpg.setStrategy(sc);

        mpg.execute();//执行
    }

}
