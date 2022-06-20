package com.xinmu.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @author xinmu
 * @date 2022/3/5 16:16
 * @description:练习反射操作注解
 */
public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Class c1 = Class.forName("com.xinmu.reflection.Student2");

        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的value的值
        Tablexinmu annotation = (Tablexinmu) c1.getAnnotation(Tablexinmu.class);
        String value = annotation.value();
        System.out.println(value);

        //获得类指定的注解
        Field f = c1.getDeclaredField("name");
        Fieldxinmu annotation1 = f.getAnnotation(Fieldxinmu.class);
        System.out.println(annotation1.columnName());
        System.out.println(annotation1.type());
        System.out.println(annotation1.length());


    }


}

@Tablexinmu("db_student")
class Student2 {
    @Fieldxinmu(columnName = "db_id",type = "int",length = 10)
    private int id;
    @Fieldxinmu(columnName = "db_age",type = "int",length = 10)
    private int age;
    @Fieldxinmu(columnName = "db_name",type = "varchar",length = 3)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tablexinmu{
    String value();

}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldxinmu{
    String columnName();
    String type();
    int length();
}

