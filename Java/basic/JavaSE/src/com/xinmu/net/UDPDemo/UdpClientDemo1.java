package com.xinmu.net.UDPDemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author xinmu
 * @date 2022/2/27 20:02
 * @description:
 */
public class UdpClientDemo1 {

    public static void main(String[] args) throws Exception {
        //1.建立一个Socket
        DatagramSocket socket=new DatagramSocket();

        //2.建立一个包
        String msg="Hello Server";
        int port=9090;


        //发送给谁
        InetAddress localhost=InetAddress.getByName("localhost");

        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);


        //3.发送包
        socket.send(packet);

        //4.关闭流
        socket.close();



    }

}
