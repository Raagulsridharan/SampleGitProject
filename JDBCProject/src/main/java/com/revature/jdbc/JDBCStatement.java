package com.revature.jdbc;

import java.sql.*;

public class JDBCStatement {
    public static void main(String[] args) throws RuntimeException{
        //STEP - 0 -- Load the Driver , Optional Since 1.6, we will not use it
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        // STEP - 1 -- Creating a connection to DB
            String url = "jdbc:mysql://localhost:3306/my_db";
            String user = "root";
            String pwd = "root";
            Connection con = DriverManager.getConnection(url,user,pwd);
            //step - 2 -- create statement
            Statement stmt = con.createStatement();
            //step - 2.1 -- create query string
            String query = "select * from contacts";
            //step - 3 -- execute query and store result in resultset
            ResultSet result = stmt.executeQuery(query);
            //steo - 4 --pross the result
            while(result.next()){
                //we can pass a argument as index or fieldname also
                int id = result.getInt(1);
                String name = result.getString("name");
                long mob = result.getLong("mobnum");
                String email = result.getString(4);

                System.out.println(id+" - "+name+" - "+mob+" - "+email);
            }
            //step - 5 -- close connection
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
