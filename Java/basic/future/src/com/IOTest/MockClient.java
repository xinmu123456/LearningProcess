package com.IOTest;

import java.io.*;
import java.net.Socket;

public class MockClient {
    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = new Socket("localhost", 1234);

        while (true) {
            Thread.sleep(1000);
            OutputStream outputStream = socket.getOutputStream();

            outputStream.write("hello bio".getBytes());

            InputStream inputStream = socket.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String s = br.readLine();

            System.out.println(s);
        }


    }
}
