package com.xinmu.Demo4;

import javax.swing.*;
import java.awt.*;

/**
 * @author xinmu
 * @date 2022/1/22 15:50
 * @description:
 */
public class Test5 {
    public static void main(String[] args) {
        JFrame jFrame=new JFrame("test5");
        JButton button1=new JButton("1");
        JButton button2=new JButton("2");
        JButton button3=new JButton("3");
        JButton button4=new JButton("4");
        JButton button5=new JButton("5");
        jFrame.setBounds(100,100,400,400);
        jFrame.setLayout(null);

        jFrame.add(button2, BorderLayout.CENTER);
        jFrame.add(button3,BorderLayout.EAST);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);



    }
}
