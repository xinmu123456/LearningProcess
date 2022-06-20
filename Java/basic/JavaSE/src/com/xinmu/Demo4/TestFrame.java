package com.xinmu.Demo4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author xinmu
 * @date 2022/1/20 22:46
 * @description:
 */
public class TestFrame {
    public static void main(String[] args) {
        MyFrame myFrame1=new MyFrame(100,100,200,200,Color.blue);
        MyFrame myFrame2=new MyFrame(200,200,200,200,Color.pink);
        MyFrame myFrame3=new MyFrame(300,300,200,200,Color.red);
        MyFrame myFrame4=new MyFrame(400,400,200,200,Color.black);

    }

}
class MyFrame extends Frame {
   static int id=0;

   public MyFrame(int x,int y,int w,int h,Color color) {
       super("MyFrame"+(++id));
       setBackground(color);
       setBounds(x,y,w,h);
       setVisible(true);
       addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               super.windowClosing(e);
               System.exit(0);

           }
       });
   }
}
