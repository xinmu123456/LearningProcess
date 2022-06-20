package com.xinmu.Demo4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author xinmu
 * @date 2022/1/23 15:27
 * @description:
 */
public class Test7 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Button button = new Button();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("click");
            }

        });

        frame.add(button, BorderLayout.CENTER);
        frame.pack();
        windowClose(frame);
        frame.setVisible(true);


    }

    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
