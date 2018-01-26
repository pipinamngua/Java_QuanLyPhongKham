/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.QlPhieuKhamChiTiet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class PhieuKham {
    public ArrayList<Controller.PhieuKham> findAll() throws SQLException{
        ArrayList<Controller.PhieuKham> lstPhieuKham = new ArrayList<>();
        Connec conn = new Connec();
        conn.khoiTao();
        
        Statement sta = null;
        ResultSet rs = null;
        
        String sql = "select * from phieukham join benhnhan on phieukham.maBenhNhan = benhnhan.maBenhNhan";

        sta = conn.getConn().createStatement();
        rs = sta.executeQuery(sql);
        while(rs.next()){
            Controller.PhieuKham phieuKham = new Controller.PhieuKham();
            phieuKham.setMaPhieuKham(rs.getString("maPhieuKham"));
            phieuKham.setMaBenhNhan(rs.getString("maBenhNhan"));
            phieuKham.setMaNhanVien(rs.getString("maNhanVien"));
            phieuKham.setLyDoKham(rs.getString("lyDoKham"));
            phieuKham.setTenBacSi(rs.getString("tenBacSi"));
            phieuKham.setGhiChu(rs.getString("ghiChu"));
            lstPhieuKham.add(phieuKham);
        }
        return lstPhieuKham;
    }
    
    public ArrayList<Controller.PhieuKham> findId(String maBN) throws SQLException{
        ArrayList<Controller.PhieuKham> lstPhieuKham = new ArrayList<>();
        Connec conn = new Connec();
        conn.khoiTao();
        
        Statement sta = null;
        ResultSet rs = null;
        
        String sql = "select * from phieukham join benhnhan on phieukham.maBenhNhan = benhnhan.maBenhNhan where benhnhan.maBenhNhan = '"+maBN+"'";

        sta = conn.getConn().createStatement();
        rs = sta.executeQuery(sql);
        while(rs.next()){
            Controller.PhieuKham phieuKham = new Controller.PhieuKham();
            phieuKham.setMaPhieuKham(rs.getString("maPhieuKham"));
            phieuKham.setMaBenhNhan(rs.getString("maBenhNhan"));
            phieuKham.setMaNhanVien(rs.getString("maNhanVien"));
            phieuKham.setLyDoKham(rs.getString("lyDoKham"));
            phieuKham.setTenBacSi(rs.getString("tenBacSi"));
            phieuKham.setGhiChu(rs.getString("ghiChu"));
            lstPhieuKham.add(phieuKham);
        }
        return lstPhieuKham;
    }
    
    public Controller.PhieuKham findIdPK(String maPK) throws SQLException{
        Controller.PhieuKham phieuKham = new Controller.PhieuKham();
        Connec conn = new Connec();
        conn.khoiTao();
        
        Statement sta = null;
        ResultSet rs = null;
        
        String sql = "select * from phieukham where maPhieuKham = '"+maPK+"'";

        sta = conn.getConn().createStatement();
        rs = sta.executeQuery(sql);
        while(rs.next()){
            
            phieuKham.setMaPhieuKham(rs.getString("maPhieuKham"));
            phieuKham.setMaBenhNhan(rs.getString("maBenhNhan"));
            phieuKham.setMaNhanVien(rs.getString("maNhanVien"));
            phieuKham.setLyDoKham(rs.getString("lyDoKham"));
            phieuKham.setTenBacSi(rs.getString("tenBacSi"));
            phieuKham.setGhiChu(rs.getString("ghiChu"));
        }
        
        return phieuKham;
    }
    
    public Boolean update(Controller.PhieuKham phieuKham) throws SQLException{
        Connec conn = new Connec();
        conn.khoiTao();
        String sql = "update PhieuKham set lyDoKham=N?, ghiChu=?, tenBacSi=? where maPhieuKham=?";
        try {
            PreparedStatement ps = conn.getConn().prepareStatement(sql);
            ps.setString(1, phieuKham.getLyDoKham());
            ps.setString(2, phieuKham.getGhiChu());
            ps.setString(3, phieuKham.getTenBacSi());
            ps.setString(4, phieuKham.getMaPhieuKham());
          
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public Boolean themMoiPhieuKham(Controller.PhieuKham phieuKham) throws SQLException{
        try{
            Model.ConvertDate convert = new Model.ConvertDate();
            Model.Connec conn = new Model.Connec();
            conn.khoiTao();
            Statement sta = null;
            ResultSet rs = null;
            
            Date today=new Date(System.currentTimeMillis());
            SimpleDateFormat timeFormat= new SimpleDateFormat("yyyy-MM-dd");
            String ngayKham=timeFormat.format(today.getTime());

            String sql = "insert into phieukham (maPhieuKham, maNhanVien, tenBacSi, maBenhNhan, lyDoKham, ghiChu, ngayKham, thanhToan)\n" +
    "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            /*System.out.println(sql);
            sta = conn.getConn().createStatement();
            rs = sta.executeQuery(sql);*/
            PreparedStatement ps = conn.getConn().prepareStatement(sql);
            ps.setString(1, phieuKham.getMaPhieuKham());
            ps.setString(2, phieuKham.getMaNhanVien());
            ps.setString(3, phieuKham.getTenBacSi());
            ps.setString(4, phieuKham.getMaBenhNhan());
            ps.setString(5, phieuKham.getLyDoKham());
            ps.setString(6, phieuKham.getGhiChu());
            ps.setDate(7, convert.convertFromJavaDateToSQLDate(today));
            ps.setDouble(8, 0.0);

            return (ps.executeUpdate() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Double thanhToan(String maBN, String maPK) throws SQLException{
        QlPhieuKhamChiTiet qlPKCT = new QlPhieuKhamChiTiet();
        Double tong = qlPKCT.soBS(maPK, maBN) * 120000.0 + qlPKCT.soLuongXN(maPK, maBN)*200000;
        
        Connec conn = new Connec();
        conn.khoiTao();
        String sql = "update PhieuKham set thanhToan=? where maPhieuKham=?";
        try {
            PreparedStatement ps = conn.getConn().prepareStatement(sql);
            ps.setDouble(1, tong);
            ps.setString(2, maPK);
          
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return tong;
    }
}
