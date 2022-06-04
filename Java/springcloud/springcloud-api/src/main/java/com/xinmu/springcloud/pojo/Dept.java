package com.xinmu.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * author: xinmu
 * date: 2022/4/27
 * time: 20:01
 */

@Data
@NoArgsConstructor
@Accessors( chain = true )//链式写法
public class Dept implements Serializable { //实体类,orm  类表关系影视  mysql -- dept
        private Long deptno;//主键
        private String dname;

        //这个数据存在哪个数据库的字段~ ,微服务,一个服务对应一个数据库,同一个信息可能存在不同的数据库

        private String db_source;


        public Dept(String dname){
                this.dname=dname;
        }

        /*
        链式写法:
        Dept dept = new Dept();

        dept.setDeptNo(11).setDame("sss").setDb_source("001")

         */

}
