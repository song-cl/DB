package com.jou.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * 维护表格模型
 * 实现向JTable表格中添加新数据行，修改表格中某一单元格的值，
 * 以及从表格中删除指定的数据行
 */
public class JTableDemo extends JFrame{
    private JTextField aTextField;
    private JTextField bTextField;
    private JTextField cTextField;
    int selectedRow;

    public static void main(String[] args) {
        new JTableDemo().setVisible(true);
    }

    /**
     * 构造方法
     */
    public JTableDemo(){
        this.setTitle("JTable表格的增、删、改");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 450);
        //JFrame窗体居中
        this.setLocationRelativeTo(null);

        //创建JScrollPane（滚动面板）
        final JScrollPane scrollPane = new JScrollPane();
        this.getContentPane().add(scrollPane, BorderLayout.CENTER);
        //设置JTable中的列名
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Row-one");
        columnNames.add("Row-tow");
        columnNames.add("Row-three");
        //设置JTable的表格数据
        Vector<Vector<String>> tableValues = new Vector<>();
        for(int row=1; row<6; row++){
            Vector<String> rowV = new Vector<>();
            rowV.add("A"+ row);
            rowV.add("B"+ row);
            rowV.add("C"+ row);
            tableValues.add(rowV);
        }
        //创建JTable （表格）
        JTable table = new JTable();
        //创建表格模型
        DefaultTableModel defaultTableModel = new DefaultTableModel(tableValues, columnNames);
        //设置JTable的表格模型
        table.setModel(defaultTableModel);
        /*
         * 将JTable添加到JScrollPane中，
         * */
        scrollPane.setViewportView(table);

        final JPanel panel = new JPanel();
        panel.setBackground(Color.gray);
        this.getContentPane().add(panel, BorderLayout.SOUTH);
        panel.add(new JLabel("A: "));
        aTextField = new JTextField("A-one", 10);
        panel.add(aTextField);
        panel.add(new JLabel("B: "));
        bTextField = new JTextField("B-tow", 10);
        panel.add(bTextField);
        panel.add(new JLabel("C: "));
        cTextField = new JTextField("C-three", 10);
        panel.add(cTextField);

        JButton insertButton = new JButton("添加");
        JButton deleteButton = new JButton("删除");
        JButton updateButton = new JButton("修改");
        panel.add(insertButton);
        panel.add(deleteButton);
        panel.add(updateButton);

        //设置表格的选择模式---为单选模式
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        /**
         * 点击JScrollPane滚动面板，取消选中的行
         */
        scrollPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //取消掉选中行，但是选中行的索引值还是在的，没有取消掉
                table.clearSelection();
                //显示选中行的索引值。
                System.out.println("-----------------"+selectedRow);


                //设置JTextField的默认值
                aTextField.setText("A-one");
                bTextField.setText("B-two");
                cTextField.setText("C-three");
            }
        });


        /**
         * 将选中的JTable行的的信息传递给--aTestField、bTextField、cTextField
         */
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //获取到JTable中选定行的---索引值
                selectedRow = table.getSelectedRow();
                //获取到指定单元格的值
                Object oa = defaultTableModel.getValueAt(selectedRow, 0);
                Object ob = defaultTableModel.getValueAt(selectedRow, 1);
                Object oc = defaultTableModel.getValueAt(selectedRow, 2);
                //将获取去到的DefaultTableModel中指定单元格的值，传递给JTextField
                aTextField.setText(oa.toString());
                bTextField.setText(ob.toString());
                cTextField.setText(oc.toString());
            }
        });


        /**
         * 增加
         */
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置要添加到DefaultTableModel中的---行数据内容
                String[] rowValues = {aTextField.getText(),
                        bTextField.getText(), cTextField.getText()};
                //在DefaultTableModel---添加行
                defaultTableModel.addRow(rowValues);

                //设置JTextField的默认值
                aTextField.setText("A-one");
                bTextField.setText("B-two");
                cTextField.setText("C-three");
            }
        });


        /**
         * 删除
         */
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取到JTable中选定行的---索引值
                selectedRow = table.getSelectedRow();
                //JTable中行的索引值是从0,1,2.3...开始的，
                //只有选中行时，才能修改内容
                if(selectedRow != -1){
                    //删除DefaultTableModel中---指定索引值得行
                    defaultTableModel.removeRow(selectedRow);
                }
            }
        });


        /**
         * 修改
         */
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取到JTable中选定行的---索引值
                selectedRow = table.getSelectedRow();
                //JTable中行的索引值是从0,1,2.3...开始的，
                //只有选中行时，才能修改内容
                if(selectedRow != -1){
                    //通过获取到JTextField的中的值，来修改指定单元格的内容
                    defaultTableModel.setValueAt(aTextField.getText(), selectedRow, 0);
                    defaultTableModel.setValueAt(bTextField.getText(), selectedRow, 1);
                    defaultTableModel.setValueAt(cTextField.getText(), selectedRow, 2);
                }
            }
        });

    }

}