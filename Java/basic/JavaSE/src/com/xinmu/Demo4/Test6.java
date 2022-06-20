package com.xinmu.Demo4;

import java.awt.*;

import static java.awt.Color.black;

/**
 * @author xinmu
 * @date 2022/1/23 15:02
 * @description:
 */
public class Test6 {
    public static void main(String[] args) {
        //总的框架
        Frame frame=new Frame("test");

        frame.setSize(400,300);
        frame.setLocation(300,400);
        frame.setBackground(black);
        frame.setVisible(true);

        //设置为列表的布局，2行1列
        frame.setLayout(new GridLayout(2,1));

        Panel p1=new Panel(new BorderLayout());
        Panel p2=new Panel(new GridLayout(2,1));
        Panel p3=new Panel(new BorderLayout());
        Panel p4=new Panel(new GridLayout(2,2));

        p1.add(new Button("EAST1"),BorderLayout.EAST);
        p1.add(new Button("WEST1"),BorderLayout.WEST);
        p2.add(new Button("p2-button1"));
        p2.add(new Button("p2-button2"));

        p1.add(p2,BorderLayout.CENTER);
        frame.add(p1);//添加p1


        p3.add(new Button("EAST2"),BorderLayout.EAST);
        p3.add(new Button("WEST2"),BorderLayout.WEST);

        for (int i = 0; i < 4; i++) {
            p4.add(new Button("for-button-"+(i+1)));
        }

        p3.add(p4,BorderLayout.CENTER);

        frame.add(p3);







    }
}
