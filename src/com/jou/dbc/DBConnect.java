package com.jou.dbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 进行数据库连接的操作
 */
public class DBConnect {
    public static String driver;// 驱动
    public static String url;// url
    public static String user;// 用户名
    public static String password;// 密码

    public DBConnect() {

    }

    static {
        File file = new File("src/com/jou/jdbc.properties");
        Properties pro = new Properties();
        try {
            FileInputStream in = new FileInputStream(file);
            pro.load(in);// 读取属性配置文件
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库对象
     *
     * @param con
     * @param stmt
     * @param rs
     */
    public static void closeAll(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            rs = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            stmt = null;
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            con = null;
        }
    }

    /**
     * 测试数据库连接
     *
     * @param args
     */
    public static void main(String[] args) {
        Connection conn = DBConnect.getConnection();
        System.out.println(conn);
        System.out.println("连接成功");
        System.out.println(driver+"--"+user+"--"+password+"--"+url);
    }
}