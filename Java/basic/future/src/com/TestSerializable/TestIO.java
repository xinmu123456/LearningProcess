package com.TestSerializable;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class TestIO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //int i = System.in.read();

        byte[] bytes = new byte[1024];

        System.in.read(bytes, 0, 3);
        System.out.println(Arrays.toString(bytes));

        //int i = System.in.read();
        //System.out.println(i);


        //InputStream inputStream = new InputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(bufferedReader.readLine());

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./out.txt")));
        System.out.println(br.readLine());
        br.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./out.txt"));
        Student o = (Student) ois.readObject();
        System.out.println(o);
        ois.close();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./new.txt"));
        oos.writeObject(o);
        oos.close();
    }
}
