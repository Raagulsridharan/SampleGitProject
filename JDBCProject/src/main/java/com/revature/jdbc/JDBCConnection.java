package com.revature.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    private static JDBCConnection connect = null;
    private  Connection con = null;
    private final String url  = "jdbc:mysql://localhost:3306/my_db";
    private final String user = "root";
    private final String password = "root";
    private JDBCConnection(){
        try {
            con = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException("Here some Connection Exception....!!! "+e);
        }
    }
    public Connection getConnect(){
        return con;
    }
    public static JDBCConnection createInstance(){
        if(connect == null){
            connect = new JDBCConnection();
        }
        else{
            try {
                connect.getConnect().close();
                connect = new JDBCConnection();
            } catch (SQLException e) {
                throw new RuntimeException("Something happen in close connection...!!!"+e);
            }
        }
        return connect;
    }
}
