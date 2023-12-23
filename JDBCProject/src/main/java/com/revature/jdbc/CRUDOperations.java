package com.revature.jdbc;

import java.sql.*;
import java.util.Scanner;

public class CRUDOperations {
    private static Connection con = null;
    private static final Scanner sc = new Scanner(System.in);
    public CRUDOperations(){
        con = JDBCConnection.createInstance().getConnect();
    }
    public void selectAll() throws SQLException {
        Statement stm = con.createStatement();
        String selectAllQuery = "select * from contacts";
        ResultSet resultSet = stm.executeQuery(selectAllQuery);
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            long mobnum = resultSet.getLong("mobnum");
            String email = resultSet.getString("email");
            System.out.println(id+" - "+name+" - "+mobnum+" - "+email);
        }
    }
    public void selectID() throws SQLException {
        String idSelectQuery = "select * from contacts where id=?";
        PreparedStatement pstm = con.prepareStatement(idSelectQuery);
        System.out.println("Enter the id : ");
        int id = sc.nextInt();
        pstm.setInt(1,id);
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()){
            id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            long mobnum = resultSet.getLong("mobnum");
            String email = resultSet.getString("email");
            System.out.println(id+" - "+name+" - "+mobnum+" - "+email);
        }
    }
    public void insert() throws SQLException {
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
    public void updateMobNum() throws SQLException {
        String updateQuery = "update contacts set mobnum=? where id=?";
        PreparedStatement pstm = con.prepareStatement(updateQuery);
        System.out.print("Enter the ID who's mobile number wants to update : ");
        int id = sc.nextInt();
        System.out.print("Enter the Mobile Number : ");
        long mobnum = sc.nextLong();
        pstm.setInt(2,id);
        pstm.setLong(1,mobnum);
        pstm.executeUpdate();
        System.out.println("Updated successfully");
    }
    public void delete() throws SQLException {
        String deleteQuery = "delete from contacts where id=?";
        PreparedStatement pstm = con.prepareStatement(deleteQuery);
        System.out.print("Enter the ID who's data wants to delete : ");
        int id = sc.nextInt();
        pstm.setInt(1,id);
        pstm.executeUpdate();
        System.out.println("Deleted successfully");
    }
    public static void main(String[] args) throws SQLException {
        CRUDOperations crud = new CRUDOperations();
//        crud.selectAll();
//        crud.selectID();
//        crud.insert();
//        crud.updateMobNum();
        crud.delete();
    }
}
