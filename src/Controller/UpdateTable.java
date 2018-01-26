/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author NGUYEN DUY DOAN
 */

import java.sql.*;
import javax.swing.*;
import Connection.DBConnection;
import java.util.*;
import net.proteanit.sql.DbUtils;


public class UpdateTable {

    public static void loadData(String sql,JTable tb){
        try{
            PreparedStatement ps = DBConnection.ThucThiTruyVan(sql);
            ResultSet rs=ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e,"       Thông Báo Lỗi",1);
        }
    }
}
