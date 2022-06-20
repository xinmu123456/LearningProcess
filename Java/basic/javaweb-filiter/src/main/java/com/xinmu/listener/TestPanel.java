package com.xinmu.listener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * author: xinmu
 * date: 2022/3/23
 * time: 22:30
 */


public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame("happy coding");
        Panel panel = new Panel(null);//面板
        frame.setLayout(null);//设置窗体的布局

        frame.setBounds(300,300,500,500);

        frame.setBackground(new Color(0,0,255));

        panel.setBounds(50,50,300,300);
        panel.setBackground(new Color(0,255,0));

        frame.add(panel);

        frame.setVisible(true);

        //监听关闭事件
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("打开");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("关闭ing");
                System.exit(0);
            }

        });


    }
}

