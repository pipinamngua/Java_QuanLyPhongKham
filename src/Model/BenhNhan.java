/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import Model.ConvertDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import Model.Connec.*;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Administrator
 */
public class BenhNhan {
    public ArrayList<Controller.BenhNhan> findBenhNhan(String maBenhNhan, String tenBenhNhan, String gioiTinh) throws SQLException, ParseException{
        ArrayList<Controller.BenhNhan> rsBenhNhan = new ArrayList<>();
        
        Connec conn = new Connec();
        conn.khoiTao();
        
        Statement sta = null;
        ResultSet rs = null;
        
        String sql = "select * from benhnhan where maBenhNhan = '"+maBenhNhan+"' OR tenBenhNhan LIKE '%"+tenBenhNhan+"%' OR gioiTinh = '"+gioiTinh+"'";

        sta = conn.getConn().createStatement();
        rs = sta.executeQuery(sql);
        while(rs.next()){
            Controller.BenhNhan benhNhan = new Controller.BenhNhan();
            benhNhan.setMaBenhNhan(rs.getString("maBenhNhan"));
            benhNhan.setTenBenhNhan(rs.getString("tenBenhNhan"));
            benhNhan.setGioiTinh(rs.getString("gioiTinh"));
            String ngaySinh = rs.getString("ngaySinh");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(ngaySinh);
            benhNhan.setNgaySinh(date);
            benhNhan.setNgheNghiep(rs.getString("ngheNghiep"));
            benhNhan.setTinhTrangHonNhan(rs.getString("tinhTrangHonNhan").equals("0")?0:1);
            benhNhan.setDiaChi(rs.getString("diaChi"));
            benhNhan.setTieuSuBenhAn(rs.getString("tieuSuBenhAn"));
            benhNhan.setSoDienThoai(rs.getString("soDienThoai"));
            benhNhan.setSoCMND(rs.getString("soCMND"));
            rsBenhNhan.add(benhNhan);
        }
        
        return rsBenhNhan;
    }
    
    public ArrayList<Controller.BenhNhan> findAll() throws SQLException, ParseException{
        ArrayList<Controller.BenhNhan> rsBenhNhan = new ArrayList<>();
        
        Connec conn = new Connec();
        conn.khoiTao();
        
        Statement sta = null;
        ResultSet rs = null;
        
        String sql = "select * from benhnhan";

        sta = conn.getConn().createStatement();
        rs = sta.executeQuery(sql);
        while(rs.next()){
            Controller.BenhNhan benhNhan = new Controller.BenhNhan();
            benhNhan.setMaBenhNhan(rs.getString("maBenhNhan"));
            benhNhan.setTenBenhNhan(rs.getString("tenBenhNhan"));
            benhNhan.setGioiTinh(rs.getString("gioiTinh"));
            String ngaySinh = rs.getString("ngaySinh");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(ngaySinh);
            benhNhan.setNgaySinh(date);
            benhNhan.setNgheNghiep(rs.getString("ngheNghiep"));
            benhNhan.setTinhTrangHonNhan(rs.getString("tinhTrangHonNhan").equals("0")?0:1);
            benhNhan.setDiaChi(rs.getString("diaChi"));
            benhNhan.setTieuSuBenhAn(rs.getString("tieuSuBenhAn"));
            benhNhan.setSoDienThoai(rs.getString("soDienThoai"));
            benhNhan.setSoCMND(rs.getString("soCMND"));
            rsBenhNhan.add(benhNhan);
        }
        
        return rsBenhNhan;
    } 
    public Controller.BenhNhan findMaBN(String maBN) throws SQLException, ParseException{
        Controller.BenhNhan benhNhan = new Controller.BenhNhan();
        Connec conn = new Connec();
        conn.khoiTao();
        
        Statement sta = null;
        ResultSet rs = null;
        
        String sql = "select * from benhnhan where maBenhNhan = '"+maBN+"'";

        sta = conn.getConn().createStatement();
        rs = sta.executeQuery(sql);
        while(rs.next()){
            
            benhNhan.setMaBenhNhan(rs.getString("maBenhNhan"));
            benhNhan.setTenBenhNhan(rs.getString("tenBenhNhan"));
            benhNhan.setGioiTinh(rs.getString("gioiTinh"));
            String ngaySinh = rs.getString("ngaySinh");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(ngaySinh);
            benhNhan.setNgaySinh(date);
            benhNhan.setNgheNghiep(rs.getString("ngheNghiep"));
            benhNhan.setTinhTrangHonNhan(rs.getString("tinhTrangHonNhan").equals("0")?0:1);
            benhNhan.setDiaChi(rs.getString("diaChi"));
            benhNhan.setTieuSuBenhAn(rs.getString("tieuSuBenhAn"));
            benhNhan.setSoDienThoai(rs.getString("soDienThoai"));
            benhNhan.setSoCMND(rs.getString("soCMND"));
        }
        return benhNhan;
    }
    
    public Boolean insertBN(Controller.BenhNhan benhNhan) throws SQLException{
        ConvertDate convert = new ConvertDate();
        Connec conn = new Connec();
        conn.khoiTao();
        String sql = "update BenhNhan set tenBenhNhan=?, gioiTinh=?, ngaySinh=?, ngheNghiep=?, tinhTrangHonNhan=?, diaChi=?, tieuSuBenhAn=?, soDienThoai=?, soCMND=? where maBenhNhan=?";
        try {
            PreparedStatement ps = conn.getConn().prepareStatement(sql);
            ps.setString(1, benhNhan.getTenBenhNhan());
            ps.setString(2, benhNhan.getGioiTinh());
            java.sql.Date date = convert.convertFromJavaDateToSQLDate(benhNhan.getNgaySinh());
            ps.setDate(3, date);
            ps.setString(4,benhNhan.getNgheNghiep());
            ps.setInt(5, benhNhan.getTinhTrangHonNhan());
            ps.setString(6, benhNhan.getDiaChi());
            ps.setString(7, benhNhan.getTieuSuBenhAn());
            ps.setString(8, benhNhan.getSoDienThoai());
            ps.setString(9, benhNhan.getSoCMND());
            ps.setString(10,benhNhan.getMaBenhNhan());
          
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public Boolean themMoiBenhNhan(Controller.BenhNhan benhNhan) throws SQLException{
        Model.ConvertDate convert = new Model.ConvertDate();
        Model.Connec conn = new Model.Connec();
        conn.khoiTao();
        /*String sql = "insert into benhNhan(maBenhNhan, tenBenhNhan, gioiTinh, ngaySinh, ngheNghiep, tinhTrangHonNhan, diaChi, tieuSuBenhAn, soDienThoai, soCMND) values\n" +
"('"+benhNhan.getMaBenhNhan()+"', N'"+benhNhan.getTenBenhNhan()+"', N'"+benhNhan.getGioiTinh()+"', '"+convert.convertFromJavaDateToSQLDate(benhNhan.getNgaySinh())+"', N'"+benhNhan.getNgheNghiep()+"', "+benhNhan.getTinhTrangHonNhan()+", '"+benhNhan.getDiaChi()+"', '"+benhNhan.getTieuSuBenhAn()+"', '"+benhNhan.getSoDienThoai()+"', '"+benhNhan.getSoCMND()+"');";
        */String sql = "insert into benhNhan(maBenhNhan, tenBenhNhan, gioiTinh, ngaySinh, ngheNghiep, tinhTrangHonNhan, diaChi, tieuSuBenhAn, soDienThoai, soCMND) values\n" +
"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try {
            PreparedStatement ps = conn.getConn().prepareStatement(sql);
            ps.setString(1, benhNhan.getMaBenhNhan());
            ps.setString(2, benhNhan.getTenBenhNhan());
            ps.setString(3, benhNhan.getGioiTinh());
            java.sql.Date date = convert.convertFromJavaDateToSQLDate(benhNhan.getNgaySinh());
            ps.setDate(4, date);
            ps.setString(5,benhNhan.getNgheNghiep());
            ps.setInt(6, benhNhan.getTinhTrangHonNhan());
            ps.setString(7, benhNhan.getDiaChi());
            ps.setString(8, benhNhan.getTieuSuBenhAn());
            ps.setString(9, benhNhan.getSoDienThoai());
            ps.setString(10, benhNhan.getSoCMND());
            System.out.println(sql);
            return (ps.executeUpdate() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
