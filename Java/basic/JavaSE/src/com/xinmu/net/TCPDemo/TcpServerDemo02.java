package com.xinmu.net.TCPDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xinmu
 * @date 2022/2/26 19:45
 * @description:
 */
public class TcpServerDemo02 {
    public static void main(String[] args) throws Exception {

        //1.创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        //2.监视客户端的连接
        Socket socket = serverSocket.accept();//阻塞式连接,会一直等待客户端的连接
        //3.获取输入流
        InputStream is=socket.getInputStream();

        //4.文件输出
        FileOutputStream fos = new FileOutputStream(new File("receive.jpg"));
        byte[] buffer=new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        //通知客户端传输完毕了
        OutputStream os = socket.getOutputStream();
        os.write("我接收完毕,你可以断开了".getBytes());

        //5.关闭资源
        fos.close();
        is.close();
        socket.close();





    }
}
