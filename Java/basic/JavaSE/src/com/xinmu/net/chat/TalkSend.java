package com.xinmu.net.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

import static java.lang.System.in;

/**
 * @author xinmu
 * @date 2022/3/3 17:23
 * @description:
 */
public class TalkSend implements Runnable{

    DatagramSocket socket=null;
    BufferedReader reader=null;

    private int fromPort;
    private  String toIP;
    private  int toPort;


    public TalkSend(int fromPort ,String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;

        try {
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(in));
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    @Override
    public void run() {

        while (true){


            try {
                String data=reader.readLine();
                byte[] datas = data.getBytes();
                DatagramPacket packet=new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.toIP,this.toPort));


                socket.send(packet);
                if (data.equals("bye")){
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        socket.close();
    }
}
