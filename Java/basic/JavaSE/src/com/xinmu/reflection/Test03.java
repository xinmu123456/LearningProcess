package com.xinmu.reflection;

/**
 * @author xinmu
 * @date 2022/3/4 19:50
 * @description:测试class类的创建方式有哪些
 */
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person=new Student();
        System.out.println("这个人是:"+person.name);

        //方式1:通过对象获得
        Class c1=person.getClass();
        System.out.println(c1.hashCode());

        //方式2:forname获得
        Class c2=Class.forName("com.xinmu.reflection.Student");
        System.out.println(c2.hashCode());

        //方式3:通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        //方式4:基本内置类型的包装都有一个Type属性
        Class<Integer> c4 = Integer.TYPE;
        System.out.println(c4);

        //获得父类类型
        Class c5=c1.getSuperclass();
        System.out.println(c5);


    }
}

class Person{

    public String name;

    public  Person() throws ClassNotFoundException {


    }

    public Person(String name){
        this.name = name;

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {

    public Student() throws ClassNotFoundException {
        super();

        this.name = "Student";
    }
}


class Teacher extends Person {
    public Teacher() throws ClassNotFoundException {
        super();

        this.name = "Teacher";
    }

}
