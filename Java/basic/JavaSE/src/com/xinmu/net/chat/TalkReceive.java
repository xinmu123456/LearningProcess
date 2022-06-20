package com.xinmu.net.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author xinmu
 * @date 2022/3/3 21:59
 * @description:
 */
public class TalkReceive implements Runnable {



    DatagramSocket socket=null;
    private int port;
    private String msgFrom;


    public TalkReceive(int port,String msgFrom){
        this.msgFrom = msgFrom;
        this.port=port;
        try {
            socket=new DatagramSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void run() {



        while (true) {
            try {
                //准备接收包裹
                byte[] container = new byte[1024];

                DatagramPacket packet=new DatagramPacket(container,0,container.length);
                socket.receive(packet);//接收

                //断开连接
                byte[] data = packet.getData();
                String receiveData = new String(data,0, data.length).trim();//trim去空格


                System.out.println(msgFrom+":"+receiveData);

                if (receiveData.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        socket.close();


    }
}
