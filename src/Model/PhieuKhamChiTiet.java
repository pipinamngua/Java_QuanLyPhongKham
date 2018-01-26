/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class PhieuKhamChiTiet {
    public Boolean themMoiPhieuKhamCT(String maPhieuKhamChiTiet, String maBenhNhan, String maNhanVien, String ngayKham, String chiSoSucKhoe, String ketLuan, String yeuCau, String maPhieuKham) throws SQLException{
        Connec conn = new Connec();
        conn.khoiTao();
        
        Statement sta = null;
        ResultSet rs = null;
        
        String sql = "insert into phieukhamchitiet (maPhieuKhamChiTiet, maBenhNhan, maNhanVien, ngayKham, chiSoSucKhoe, ketLuan, yeuCau, maPhieuKham)\n" +
"VALUES\n" +
"('"+maPhieuKhamChiTiet+"', '"+maBenhNhan+"', '"+maNhanVien+"', '"+ngayKham+"', N'"+chiSoSucKhoe+"', N'"+ketLuan+"', N'"+yeuCau+"', '"+maPhieuKham+"');";

        sta = conn.getConn().createStatement();
        PreparedStatement ps = conn.getConn().prepareStatement(sql);
        return (ps.executeUpdate() > 0);
    }
    
    public ArrayList<Controller.PhieuKhamChiTiet> find(String maBN, String maPK) throws SQLException{
        Connec conn = new Connec();
        conn.khoiTao();
        ArrayList<Controller.PhieuKhamChiTiet> lstKetQua = new ArrayList<>();
        Statement sta = null;
        ResultSet rs = null;
        
        String sql = "select phieukhamchitiet.*, nhanvien.hoTen from phieukhamchitiet JOIN nhanvien on nhanvien.maNhanVien = phieukhamchitiet.maNhanVien where maBenhNhan = '"+maBN+"' AND maPhieuKham = '"+maPK+"'";
        
        sta = conn.getConn().createStatement();
        rs = sta.executeQuery(sql);
        
        while(rs.next()){
            Controller.PhieuKhamChiTiet phieuKham = new Controller.PhieuKhamChiTiet();
            phieuKham.setMaPhieuKhamChiTiet(rs.getString("maPhieuKhamChiTiet"));
            phieuKham.setMaBenhNhan(maBN);
            phieuKham.setMaBacSi(rs.getString("maNhanVien"));
            phieuKham.setNgayKham(rs.getDate("ngayKham"));
            phieuKham.setChiSoSucKhoe(rs.getString("chiSoSucKhoe"));
            phieuKham.setKetLuan(rs.getString("ketLuan"));
            phieuKham.setYeuCau(rs.getString("yeuCau"));
            phieuKham.setTenBacSi(rs.getString("hoTen"));
            
            phieuKham.setMaPhieuKham(maPK);
            lstKetQua.add(phieuKham);
        }
        
        return lstKetQua;
    }
    
    public Integer soLuongBS(String maPK, String maBN) throws SQLException{
        int tong = 0;
        Model.Connec conn = new Model.Connec();
        conn.khoiTao();
        Statement sta = null;
        ResultSet rs = null;
        String sql = "select count(*) as number from phieukhamchitiet where maNhanVien LIKE 'BS%' AND maBenhNhan = '"+maBN+"' AND maPhieuKham = '"+maPK+"'";
        sta = conn.getConn().createStatement();
        rs = sta.executeQuery(sql);
        while(rs.next()){
            tong = rs.getInt("number");
            break;
        }
        return tong;
        
    }
    
    public Integer soLuongXN(String maPK, String maBN) throws SQLException{
        int tong = 0;
        Model.Connec conn = new Model.Connec();
        conn.khoiTao();
        Statement sta = null;
        ResultSet rs = null;
        String sql = "select count(*) as number from phieukhamchitiet where maNhanVien LIKE 'XN%' AND maBenhNhan = '"+maBN+"' AND maPhieuKham = '"+maPK+"'";
        sta = conn.getConn().createStatement();
        rs = sta.executeQuery(sql);
        while(rs.next()){
            tong = rs.getInt("number");
            break;
        }
        return tong;
    }
}
