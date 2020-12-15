package com.jou.test;

import com.jou.dbc.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    List<Staff> list=new ArrayList<>();

    public static void main(String[] args) {
	// write your code here
        try{
            Connection con = DBConnect.getConnection();
            System.out.println("连接成功");
            Statement stat = con.createStatement();
            String sql="SELECT * FROM staff";
            ResultSet rs=stat.executeQuery(sql);

            while (rs.next()){

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
