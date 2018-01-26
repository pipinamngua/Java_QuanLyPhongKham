/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class Connect {
    private Connection conn;
    
     public Connect(){
        try {
            String dbURL = "jdbc:mysql://localhost/QuanLyPhongKham?useUnicode=true&characterEncoding=UTF-8";
            String username = "root";
            String password = "";
            this.conn = DriverManager.getConnection(dbURL, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    
}
