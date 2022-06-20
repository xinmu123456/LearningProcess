##常用依赖
```xml
    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.2.0.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
    </dependencies>
```

##注解说明
- @Autowired : 自动装配,通过类型,名字
||如果Autowired不能唯一自动装配上属性,则需要通过@Qualified(value="xxx")
- @Nullable 字段标记了这个注解,说明这个字段可以为null
- @Resource : 自动装配,通过名字,类型
- @Component: 组件,一般放在类上,说明这个类被Spring管理了,就是bean
