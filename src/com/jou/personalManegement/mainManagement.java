package com.jou.personalManegement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainManagement implements ActionListener {
    final static int X=50;
    final static int Y=55;
    final static int WIDTH=200;
    final static int HEIGHT=30;


    JFrame Main_Window;
    JLabel jlbTitle=new JLabel("欢迎使用人事管理系统",JLabel.CENTER);
    JButton jbtStaffManage=new JButton("职工信息管理");
    JButton jbtEduManage=new JButton("职工学习经历管理");
    JButton jbtWorkExpManage=new JButton("职工学习经历管理");
    JButton jbtFamilyManage=new JButton("职工家庭关系管理");
    JButton jbtRewardManage=new JButton("奖惩信息管理");
    JButton jbtDepPosTitManage=new JButton("部门职务职称管理");

    JButton jbtExit=new JButton("退出");
    final static Font charFont = new Font("宋体", Font.BOLD, 18);    //设置字体格式
    public mainManagement(){
        Main_Window=new JFrame("人事管理系统");
        Main_Window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Main_Window.setBounds(500,360,300,450);



        Container container=Main_Window.getContentPane();
        container.setLayout(null);

        jlbTitle.setFont(charFont);
        jlbTitle.setBounds(0,5,300,50);
        container.add(jlbTitle);

        jbtStaffManage.setFont(charFont);
        jbtStaffManage.setBounds(X,Y,WIDTH,HEIGHT);
        container.add(jbtStaffManage);
        jbtStaffManage.addActionListener(this);

        jbtEduManage.setFont(charFont);
        jbtEduManage.setBounds(X,Y+50,WIDTH,HEIGHT);
        container.add(jbtEduManage);
        jbtEduManage.addActionListener(this);

        jbtWorkExpManage.setFont(charFont);
        jbtWorkExpManage.setBounds(X,Y+100,WIDTH,HEIGHT);
        container.add(jbtWorkExpManage);
        jbtWorkExpManage.addActionListener(this);

        jbtFamilyManage.setFont(charFont);
        jbtFamilyManage.setBounds(X,Y+150,WIDTH,HEIGHT);
        container.add(jbtFamilyManage);
        jbtFamilyManage.addActionListener(this);

        jbtRewardManage.setFont(charFont);
        jbtRewardManage.setBounds(X,Y+200,WIDTH,HEIGHT);
        container.add(jbtRewardManage);
        jbtRewardManage.addActionListener(this);

        jbtDepPosTitManage.setFont(charFont);
        jbtDepPosTitManage.setBounds(X,Y+250,WIDTH,HEIGHT);
        container.add(jbtDepPosTitManage);
        jbtDepPosTitManage.addActionListener(this);

        jbtExit.setFont(charFont);
        jbtExit.setBounds(110,Y+300,80,HEIGHT);
        container.add(jbtExit);
        jbtExit.addActionListener(this);

        Main_Window.setResizable(false);
        Main_Window.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jbtExit){
            System.exit(0);
        }
        if (e.getSource()==jbtStaffManage){
            new StaffManage();
            Main_Window.dispose();
        }
        if (e.getSource()==jbtEduManage){

        }
        if (e.getSource()==jbtWorkExpManage){

        }
        if (e.getSource()==jbtFamilyManage){

        }
        if (e.getSource()==jbtRewardManage){

        }
        if (e.getSource()==jbtDepPosTitManage){

        }

    }

    public static void main(String[] args) {
        new mainManagement();
    }
}
