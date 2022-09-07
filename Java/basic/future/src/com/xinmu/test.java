package com.xinmu;

import java.util.ArrayList;
import java.util.List;

class Animal{
    public void eat(){

    }
}

class Dog extends Animal{
    public List<? extends Animal> others;
    public int data = 1;
}


public class test {


    public static void main(String[] args) {
        List<? extends Animal> animals = new ArrayList<Dog>();

        animals.add(null);
        //animals.add(new Dog());
        animals.get(0);

        //new Dog().others.add(new Dog());

        final Integer i = Integer.valueOf(1);
        final Dog d = new Dog();
        d.data = 2;
        while(true){
            System.out.println(d.data);
        }
    }
}
