package com.xinmu.opp;

/**
 * @author xinmu
 * @date 2022/1/18 23:30
 * @description:
 */
public class Student extends Person{
protected String name="222";
    public void test(String name){
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }

    @Override
    public void say() {
        System.out.println("Student say");
    }
    public void eat(){
        System.out.println("Person eat");
    }
}
