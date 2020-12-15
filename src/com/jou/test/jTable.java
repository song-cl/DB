package com.jou.test;
import javax.swing.*;
import java.awt.*;

//JTable 教程
//https://blog.csdn.net/xietansheng/article/details/78079806

public class jTable {
    JTable jTable;
    JFrame jFrame;

    jTable(){
        jFrame=new JFrame("JTable");

        Object[][] rowData= {
                {"001", "宋", "办公室", "主任"},
                {"002", "宋", "办公室", "主任"}
        };
        Object[] columnTitle={"工号","姓名","部门","职务"};
        jTable=new JTable(rowData,columnTitle);
        Container container=jFrame.getContentPane();
        container.setLayout(new GridLayout(2,4));
        container.add(jTable.getTableHeader());
        container.add(jTable);


        jFrame.setVisible(true);
        jFrame.setBounds(500,500,500,500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new jTable();
    }

}
