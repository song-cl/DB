package com.jou.test;

import javax.swing.*;
import java.awt.*;

public class AbsolutePosition extends JFrame {

    public AbsolutePosition() {
        setTitle("AbsolutePosition");
        setLayout(null);
        setBounds(0, 0, 200, 150);

        Container c = getContentPane();
        JButton b1 = new JButton("按钮1");
        JButton b2 = new JButton("按钮2");

        b1.setBounds(10, 80, 80, 30);
        b2.setBounds(60, 70, 100, 20);
        c.add(b1);
        c.add(b2);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        AbsolutePosition absolutePosition = new AbsolutePosition();
    }
}
