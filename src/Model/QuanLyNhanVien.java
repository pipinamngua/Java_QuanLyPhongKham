/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Administrator
 */
public class QuanLyNhanVien {
    DefaultTableModel model;
    
    public Connec conn;
    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public QuanLyNhanVien() throws SQLException {
        this.conn = new Connec();
        this.conn.khoiTao();
    }
    
    public String login(String maNV, String pass) throws SQLException{
        String maNhanVien = "";
        String sql = "SELECT * FROM `nhanvien` WHERE `maNhanVien`= '"+maNV+"' AND `password`= '"+pass+"'";
        Model.Connec conn = new Model.Connec();
        conn.khoiTao();
        Statement sta = null;
        ResultSet result = null;
            
        sta = conn.getConn().createStatement();
        result = sta.executeQuery(sql);
        if(result.next()){
            maNhanVien = maNV;
        }
        return maNhanVien;
    }
    
    public ArrayList<Controller.NhanVien> getListNhanVien()
    {
        ArrayList<Controller.NhanVien> list = new ArrayList();
        String sql = "select * from nhanvien";
        try {
            PreparedStatement ps = this.conn.getConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Model.ConvertDate convert = new Model.ConvertDate();
                Controller.NhanVien nv = new Controller.NhanVien();
                nv.setMaNhanVien(rs.getString("maNhanVien"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setNgaySinh(convert.convertFromSQLDateToJAVADate(rs.getDate("ngaySinh")));
                nv.setGioiTinh(rs.getString("gioiTinh"));
                nv.setMaNhanVien(rs.getString("maNhanVien"));
                nv.setChucVu(rs.getString("chucVu"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSoDienThoai(rs.getString("soDienThoai"));
                nv.setEmail(rs.getString("email"));
                nv.setSoCMND(rs.getString("soCMND"));
                nv.setPassword(rs.getString("password"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Controller.NhanVien> timKiem(String hoTen)
    {
        ArrayList<Controller.NhanVien> list = new ArrayList<>();
        String sql = "select * from nhanvien where hoTen like '%" + hoTen +"%'";
        
        try {
            PreparedStatement ps = this.conn.getConn().prepareStatement(sql);
            //ps.setString(1, hoTen);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                ConvertDate convert = new ConvertDate();
                Controller.NhanVien nv = new Controller.NhanVien();
                nv.setMaNhanVien(rs.getString("maNhanVien"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setNgaySinh(convert.convertFromSQLDateToJAVADate(rs.getDate("ngaySinh")));
                nv.setGioiTinh(rs.getString("gioiTinh"));
                nv.setMaNhanVien(rs.getString("maNhanVien"));
                nv.setChucVu(rs.getString("chucVu"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSoDienThoai(rs.getString("soDienThoai"));
                nv.setEmail(rs.getString("email"));
                nv.setSoCMND(rs.getString("soCMND"));
                nv.setPassword(rs.getString("password"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Controller.NhanVien timKiemMaNhanVien(String maNhanVien)
    {
        Controller.NhanVien nv = new Controller.NhanVien();
        String sql = "select * from nhanvien where maNhanVien=?";
        try {
            PreparedStatement ps = this.conn.getConn().prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ResultSet rs = ps.executeQuery();
            
             while(rs.next())
            {
                ConvertDate convert = new ConvertDate();
                nv.setMaNhanVien(rs.getString("maNhanVien"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setNgaySinh(convert.convertFromSQLDateToJAVADate(rs.getDate("ngaySinh")));
                nv.setGioiTinh(rs.getString("gioiTinh"));
                nv.setMaNhanVien(rs.getString("maNhanVien"));
                nv.setChucVu(rs.getString("chucVu"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSoDienThoai(rs.getString("soDienThoai"));
                nv.setEmail(rs.getString("email"));
                nv.setSoCMND(rs.getString("soCMND"));
                nv.setPassword(rs.getString("password"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return nv;
    }

    public boolean addNhanVien(Controller.NhanVien nv) {
        String sql = "insert into nhanvien(maNhanVien,hoTen,ngaySinh,gioiTinh,chucVu,diaChi,soDienThoai,email,soCMND,password) values(?,?,?,?,?,?,?,?,?,?) ";
        try {
            ConvertDate convert = new ConvertDate();
            PreparedStatement ps = this.conn.getConn().prepareStatement(sql);
            ps.setString(1,nv.getMaNhanVien());
            ps.setString(2, nv.getHoTen());
            ps.setDate(3, convert.convertFromJavaDateToSQLDate(nv.getNgaySinh()));
            ps.setString(4,nv.getGioiTinh());
            ps.setString(5, nv.getChucVu());
            ps.setString(6, nv.getDiaChi());
            ps.setString(7, nv.getSoDienThoai());
            ps.setString(8, nv.getSoDienThoai());
            ps.setString(9, nv.getSoCMND());
            ps.setString(10, nv.getPassword());
            
            return ps.executeUpdate() > 0 ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean updateNhanVien(Controller.NhanVien nv,String maNhanVien)
    {
        String sql = "update nhanvien set maNhanVien=? , hoTen=N?, ngaySinh=?,gioiTinh=?,chucVu=?,diaChi=?,soDienThoai=?,email=?,soCMND=? ,password=? where maNhanVien=?";
        try {
            Model.ConvertDate convert = new Model.ConvertDate();
            PreparedStatement ps = this.conn.getConn().prepareStatement(sql);
            ps.setString(1,nv.getMaNhanVien());
            ps.setString(2, nv.getHoTen());
            ps.setDate(3, convert.convertFromJavaDateToSQLDate(nv.getNgaySinh()));
            ps.setString(4,nv.getGioiTinh());
            ps.setString(5, nv.getChucVu());
            ps.setString(6, nv.getDiaChi());
            ps.setString(7, nv.getSoDienThoai());
            ps.setString(8,nv.getEmail());
            ps.setString(9, nv.getSoCMND());
            ps.setString(10, nv.getPassword());
            ps.setString(11, maNhanVien);
          
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    public boolean deleteNhanVien(String maNhanVien)
    {
        String sql ="delete from nhanvien where maNhanVien = ?";
        try {
            PreparedStatement ps = this.conn.getConn().prepareStatement(sql);
            ps.setString(1, maNhanVien);
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public ArrayList<Controller.NhanVien> findBacSi() throws SQLException{
        ArrayList<Controller.NhanVien> lstBacSi = new ArrayList<>();
        String sql = "Select * from nhanvien where maNhanVien LIKE 'BS%'";
        Connec conn = new Connec();
        conn.khoiTao();
        
        Statement sta = null;
        ResultSet rs = null;
        sta = conn.getConn().createStatement();
        rs = sta.executeQuery(sql);
        while(rs.next()){
            Model.ConvertDate convert = new Model.ConvertDate();
            Controller.NhanVien nhanvien = new Controller.NhanVien();
            nhanvien.setMaNhanVien(rs.getString("maNhanVien"));
            nhanvien.setHoTen(rs.getString("hoTen"));
            nhanvien.setNgaySinh(convert.convertFromSQLDateToJAVADate(rs.getDate("ngaySinh")));
            nhanvien.setGioiTinh(rs.getString("gioiTinh"));
            nhanvien.setChucVu(rs.getString("chucVu"));
            nhanvien.setDiaChi(rs.getString("diaChi"));
            nhanvien.setSoDienThoai(rs.getString("soDienThoai"));
            nhanvien.setEmail(rs.getString("email"));
            nhanvien.setPassword(rs.getString("password"));
            nhanvien.setSoCMND(rs.getString("soCMND"));
            lstBacSi.add(nhanvien);
        }
        return lstBacSi;
    }
}
