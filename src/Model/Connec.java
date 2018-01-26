/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class Connec{
    private String dbURL;
    private String username;
    private String password;
    private java.sql.Connection conn;

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public java.sql.Connection getConn() {
        return conn;
    }

    public void setConn(java.sql.Connection conn) {
        this.conn = conn;
    }

    public Connec(){
        
    }
    
    public void khoiTao() throws SQLException{
        this.dbURL = "jdbc:mysql://localhost/QuanLyPhongKham?useUnicode=true&characterEncoding=UTF-8";
        this.username = "root";
        this.password = "";
        this.conn = DriverManager.getConnection(this.dbURL, this.username, this.password);
    }
}
