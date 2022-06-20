package com.xinmu.net.TCPDemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xinmu
 * @date 2022/2/26 16:56
 * @description:服务端
 */
public class TcpClientDemo01 {


    public static void main(String[] args) {

        ServerSocket serverSocket=null;
        Socket socket=null;
        InputStream is=null;
        ByteArrayOutputStream baos=null;



        try {
            //1.首先需要有一个地址
            serverSocket = new ServerSocket(9999);

            while (true) {
                //2.等待客户端连接过来
                System.out.println("服务端正在运行");
                socket = serverSocket.accept();
                //3.读取客户端的消息
                is = socket.getInputStream();

                //管道流
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }

                System.out.println(baos.toString());
            }



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("服务端结束");
        }
    }




}
