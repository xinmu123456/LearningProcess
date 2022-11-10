package com.MultiThread;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFO {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("out.txt");

        byte[] bytes = "hello out".getBytes();

        fileOutputStream.write(bytes);

        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

        dataOutputStream.writeBoolean(true);


    }
}
