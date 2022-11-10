package com.IOTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOTest {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(1234);

        while (true) {
            Socket client = serverSocket.accept();

            OutputStream os = client.getOutputStream();
            InputStream is = client.getInputStream();

            System.out.println(client.getInetAddress() + "连接到服务器");

            new Thread(() -> {
                try {
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = is.read(buffer)) > 0) {
                        System.out.println(client.getRemoteSocketAddress() + "发送数据: " + new String(buffer, 0, len));
                        os.write((new String(buffer, 0, len) + "\n").getBytes());
                    }
                } catch (IOException e) {

                }

            }).start();

        }

    }
}
