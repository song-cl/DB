package com.jou.personalManegement;

import com.jou.dbc.DBConnect;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class login extends JFrame implements ActionListener {
    //    private static Connection con;
    final static int X1 = 75;
    final static int Y1 = 30;
    final static int WIDTH = 80;
    final static int HEIGHT = 30;
    final static int X2=180;
    final static int Y2 = 30;
    final static int WIDTH2 = 180;
    final static int HEIGHT2 = 30;

    String code;

    private JButton jbtLogin, jbtReset;
    private JLabel jlbUser, jlbPassword,  jlbCode, jlbCodeNum;

    private JTextField jtfUser, jtfCode;
    private JPasswordField jpfPassword;
//    JLabel jlbAuthority;
//    private JComboBox jcbAuthority;
//    private JPanel jp1;
    JFrame Login_Window;

    /**
     * 产生随机字符验证码
     *
     * @return
     */
    public static String randomStr() {
        StringBuffer bu = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            char c = (char) (Math.random() * 26 + 'A');
            bu.append(c);
        }
        return bu.toString();
    }

    public login() {
        Login_Window=new JFrame("人事管理系统");   //设置窗口标题
//        setSize(900, 600);   //窗口大小
//        setBackground(Color.pink);
        Login_Window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Login_Window.setBounds(750, 360, 450, 300);

        MatteBorder matteBorder = new MatteBorder(0, 0, 1, 0, Color.BLACK);   //输入框的border样式
        Font charFont = new Font("宋体", Font.BOLD, 18);    //设置输入框的字体格式

        Container container = Login_Window.getContentPane();
        container.setLayout(null);  //绝对布局
        {
            jlbUser = new JLabel("用 户", JLabel.CENTER);
            jlbUser.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            jlbUser.setFont(charFont);  //设置字体格式
            jlbUser.setBounds(X1, Y1, WIDTH, HEIGHT);   //设置label位置
            container.add(jlbUser);   //添加jlbUser到jFrame上
            jtfUser = new JTextField(15);
            jtfUser.setFont(charFont);
            jtfUser.setBorder(matteBorder);
            jtfUser.setBounds(X2, Y2, WIDTH2, HEIGHT2);
            container.add(jtfUser);
        }

        {
            jlbPassword = new JLabel("密 码",JLabel.CENTER);
            jlbPassword.setFont(charFont);
            jlbPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            jlbPassword.setBounds(X1, Y1+60, WIDTH, HEIGHT);
            container.add(jlbPassword);
            jpfPassword = new JPasswordField(15);
            jpfPassword.setBorder(matteBorder);
            jpfPassword.setBounds(X2, Y2+60, WIDTH2, HEIGHT2);
            container.add(jpfPassword);
        }

//        jlbAuthority = new JLabel("权限");
//        jlbAuthority.setBounds(460, 250, 80, 50);
//        add(jlbAuthority);
//        jcbAuthority = new JComboBox(new String[]{"管理员", "员工"});
//        jcbAuthority.setBounds(570, 250, 150, 50);
//        add(jcbAuthority);

        {
            jlbCode = new JLabel("验证码", JLabel.CENTER);
            jlbCode.setFont(charFont);
            jlbCode.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            jlbCode.setBounds(X1, Y1+120, WIDTH, HEIGHT);
            container.add(jlbCode);
            jtfCode = new JTextField(4);
            jtfCode.setFont(charFont);
            jtfCode.setBounds(X2, Y2+120, 70, HEIGHT2);
            container.add(jtfCode);
            code = randomStr();
            jlbCodeNum = new JLabel(code);
            jlbCodeNum.setFont(new Font("腾祥铁山楷书简", Font.HANGING_BASELINE, 25));
            jlbCodeNum.setBorder(BorderFactory.createEtchedBorder());
            jlbCodeNum.setBounds(X2+100, Y2+118, 80, 35);
            container.add(jlbCodeNum);
        }

        {
            jbtLogin = new JButton("登录");
            jbtLogin.setFont(charFont);
            jbtLogin.setBounds(110, 200, 80, 35);
            jbtReset = new JButton("重置");
            jbtReset.setFont(charFont);
            jbtReset.setBounds(245, 200, 80, 35);
            container.add(jbtLogin);
            container.add(jbtReset);
        }

        jbtLogin.addActionListener(this::actionPerformed);
        jbtReset.addActionListener(this);

        Login_Window.setResizable(false);
        Login_Window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
//        int authorityCode = jcbAuthority.getSelectedIndex();
        //获取JComboBox的值，0代表“管理员”，1代表“员工”
//        System.out.println(authorityCode);
        if (a.getSource()==jbtReset){
            jtfUser.setText("");
            jpfPassword.setText("");
            jtfCode.setText("");
        }
        if (a.getSource() == jbtLogin) {
            String user=jtfUser.getText();
            String  pwd=new String(jpfPassword.getPassword());    //获取的密码为char类型，转换为String

            if (Login_Check(user,pwd)&&code.equals(jtfCode.getText())){
                JOptionPane.showMessageDialog(this,"登陆成功");
                Login_Window.dispose();
                new mainManagement();
            }else {
                JOptionPane.showMessageDialog(this,"输入有误，请重新输入");
            }
        }
    }

    public boolean Login_Check(String user,String pwd){
        boolean flag=false;
        Connection con;
        Statement stmt;
        ResultSet rs;
        String query;

        query="SELECT * FROM admin_info WHERE login_no="+user+" and login_passwd="+pwd+"";

        try {
            con = DBConnect.getConnection();
            System.out.println("数据库连接成功");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                flag=true;
            }
            DBConnect.closeAll(con,stmt,rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("数据库连接失败");
        }
        return flag;
    }

    public static void main(String[] args) {
        new login();

    }
}
