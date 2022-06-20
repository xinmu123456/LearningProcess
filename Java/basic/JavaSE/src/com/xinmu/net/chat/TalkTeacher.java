package com.xinmu.net.chat;

/**
 * @author xinmu
 * @date 2022/3/3 22:12
 * @description:
 */
public class TalkTeacher {

    public static void main(String[] args) {
        new Thread(new TalkSend(5555,"localhost",8888)).start();
        new Thread(new TalkReceive(9999,"学生")).start();
    }
}
