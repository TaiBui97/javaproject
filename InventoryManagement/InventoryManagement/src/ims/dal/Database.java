/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agfor
 */
public class Database {
    static  final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL= "jdbc:mysql://localhost/quanlynhanvien"; 
    static  final String USER = "root"; 
    static  final String PASS = ""; 
    static Connection conn = null; 
    
    public Connection getConnection(){
        try { 
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { 
            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            System.out.println("Không thể kết nối đến Server");
        }
        return conn; 
    }
    public ResultSet loadData(String sql) {
        ResultSet result = null;
        try {
            Statement statement = conn.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
        }
        return result;
    }

    public void updateData(String sql){        
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
        } 
        catch (SQLException e) {
        }
    }
    public static void dispose() throws SQLException {
       conn.close();
    }
}
    

