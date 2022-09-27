package com.TestSerializable;

import java.io.*;

public class MainTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./out.txt"));
        //oos.writeObject(new Student(1, "xinmu"));
        //oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./out.txt"));
        Student s = (Student)ois.readObject();
        System.out.println(s);
    }
}
