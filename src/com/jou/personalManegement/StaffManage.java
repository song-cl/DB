package com.jou.personalManegement;

import com.sun.jmx.mbeanserver.JmxMBeanServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffManage implements ActionListener {
    final static int X=50;
    final static int Y=55;
    final static int WIDTH=200;
    final static int HEIGHT=30;

    JFrame staffMange_Window;

    JMenuBar jMenuBar=new JMenuBar();
    JMenu jmStaffShow=new JMenu("查询");
    JMenu jmStaffAdd=new JMenu("添加");
    JMenu jmStaffUpdate=new JMenu("修改");
    JMenu jmStaffDel=new JMenu("删除");
    JMenu jmStaffExit=new JMenu("");
//    JMenu jmStaffReturn=new JMenu("返回");

    JMenuItem jmiShow1=new JMenuItem("基本信息");
    JMenuItem jmiShow2=new JMenuItem("详细信息");

    JMenuItem jmExit=new JMenuItem("退出");
    JMenuItem jmReturn=new JMenuItem("返回");

    final static Font charFont = new Font("宋体", Font.PLAIN, 15);    //设置字体格式

    public StaffManage(){
        staffMange_Window=new JFrame("职工信息管理");
        staffMange_Window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        staffMange_Window.setBounds(500,360,600,450);

        jMenuBar.add(jmStaffShow);
            jmStaffShow.add(jmiShow1);
            jmStaffShow.add(jmiShow2);
        jMenuBar.add(jmStaffAdd);
        jMenuBar.add(jmStaffUpdate);
        jMenuBar.add(jmStaffDel);
        jMenuBar.add(jmStaffExit);
            jmStaffExit.add(jmExit);
            jmStaffExit.add(jmReturn);
//        jmStaffExit.addActionListener(this);
//        jMenuBar.add(jmStaffReturn);
//        jmStaffReturn.addActionListener(this);


//        jMenuBar.add(jmExit);
//        jMenuBar.add(jmReturn);
        jmExit.addActionListener(this);
        jmReturn.addActionListener(this);

        staffMange_Window.setJMenuBar(jMenuBar);

        staffMange_Window.setResizable(false);
        staffMange_Window.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jmExit.equals(e.getSource())){
            System.out.println("退出");
            System.exit(0);
        }
        if (jmReturn.equals(e.getSource())){
            new mainManagement();
            staffMange_Window.dispose();
        }
        if (jmiShow1.equals(e.getSource())){
            System.out.println("视图，基本信息");
        }
        if (jmiShow2.equals(e.getSource())){
            System.out.println("视图，详细信息");
        }

    }

    public static void main(String[] args) {
        new StaffManage();
    }


}
