package com.revature.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCPreparedStatement {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/my_db";
        String user = "root";
        String pwd = "root";
        Connection con = DriverManager.getConnection(url,user,pwd);
        String insertQuery = "insert into contacts(name,mobnum,email) values(?,?,?)";
        PreparedStatement pstm = con.prepareStatement(insertQuery);
        System.out.print("Enter name : ");
        String name = sc.next();
        System.out.print("Enter mobnum : ");
        long mobnum = sc.nextLong();
        System.out.print("Enter email : ");
        String email = sc.next();

        pstm.setString(1,name);
        pstm.setLong(2,mobnum);
        pstm.setString(3,email);

        pstm.execute();
        System.out.println("Inserted successfully");
    }
}
