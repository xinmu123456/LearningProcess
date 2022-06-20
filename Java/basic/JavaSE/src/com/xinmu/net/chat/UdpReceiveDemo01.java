package com.xinmu.net.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author xinmu
 * @date 2022/3/2 16:36
 * @description:
 */
public class UdpReceiveDemo01 {
    public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket(6666);

        while (true) {
            //准备接收包裹
            byte[] container = new byte[1024];

            DatagramPacket packet=new DatagramPacket(container,0,container.length);
            socket.receive(packet);//接收

            //断开连接
            byte[] data = packet.getData();
            String receiveData = new String(data,0, data.length).trim();//trim去空格


            System.out.println(receiveData);

            if (receiveData.equals("bye")){
                break;
            }


        }
        socket.close();


    }
}
