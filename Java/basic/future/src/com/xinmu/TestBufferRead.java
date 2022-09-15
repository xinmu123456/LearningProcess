package com.xinmu;

import java.io.*;
import java.util.Arrays;

public class TestBufferRead {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //String str = br.readLine();

        //System.out.println(str);

        //int read = br.read();

        //char[] chars = new char[100];

        //br.read(chars, 0, 4);

        //System.out.println(read);
        //System.out.print(chars);

        //new ByteArrayInputStream()

        byte[] src = "bcdedit".getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(src);


        int len = -1;
        byte[] cache = new byte[4];

        while ((len = bais.read(cache)) != -1) {
            String s = new String(cache, 0, len);
            System.out.println(s);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] b = "abcdefg".getBytes();


        baos.write(b, 0, 6);

        baos.writeTo(System.out);

        System.out.println();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("wasd".getBytes());
        int c;

        while ((c = byteArrayInputStream.read()) != -1) {
            System.out.println(Character.toUpperCase((char)c));
        }

    }
}
