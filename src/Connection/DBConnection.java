/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

/**
 *
 * @author NGUYEN DUY DOAN
 */


import java.sql.*;
import javax.swing.*;

public class DBConnection {
	
	public static Connection Connect(){
		
		//String url="jdbc:mysql://localhost:3306/phongkham?verifyServerCertificate=false&useSSL=true";
                String url="jdbc:mysql://localhost:3306/phongkham?useUnicode=true&characterEncoding=UTF-8&verifyServerCertificate=false&useSSL=true";
		String user="root";
		String password="";
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
                        //System.out.println("connect succeed");
                        return conn;
			} 
		 		catch (ClassNotFoundException e) {
                                //System.out.println("connect fail");
                                return null;
                        }
				catch (SQLException e) {
                                //System.out.println("connect fail");
                                return null;
			}
	}
        public static PreparedStatement ThucThiTruyVan(String sql){
                try{
                    //System.out.println("Excute Done");
                    return Connect().prepareStatement(sql);
                }
                catch (Exception e){
                    //System.out.println(e);
                }
            return null;
            }
        
        public static void main(String args[]){
//            DBConnection db = new DBConnection();
//            db.Connect();
//            db.ThucThiKetNoi("select * from thuoc");
        }
}

