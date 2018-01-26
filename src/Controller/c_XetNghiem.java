/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.DBConnection;
import Model.m_XetNghiem;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author NGUYEN DUY DOAN
 */
public class c_XetNghiem {
    public static boolean f = true;
    public void insertPhieuKham(m_XetNghiem m){
        String sql = "insert into phieukhamchitiet "
                + "values(N?,N?,N?,N?,N?,N?,N?,N?);";    
        PreparedStatement ps = DBConnection.ThucThiTruyVan(sql);
        try {
            ps.setString(1,m.getMaXetNghiem());
            ps.setString(2,m.getMaBenhNhan());
            ps.setString(3,m.getMaNhanVien());
            ps.setString(4,m.getNgayKham());
            ps.setString(5,m.getChiSoSucKhoe());
            ps.setString(6,m.getKetLuan());
            ps.setString(7,m.getYeuCau());
            ps.setString(8,m.getMaPhieuKham());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm Thành Công", "Thông Báo !", 1);
            f = true;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e,"Gặp Lỗi !",0);
            f = false;
        }
    }
    public void updatePhieuKham(m_XetNghiem m,String maXetNghiem){
//        String sql = "update phieukhamchitiet set maPhieuKhamChiTiet = N?, "
//                + " maBenhNhan = N?, "
//                + " maNhanVien = N?, "
//                + " ngayKham = N? "
//                + " chiSoSucKhoe = N? "
//                + " ketLuan = N? "
//                + " yeuCau = N? "
//                + " maPhieuKham = N? "
//                + " where maPhieuKhamChitiet like N?";
        String sql = "update phieukhamchitiet set maPhieuKhamChiTiet = N?, "
                + " maBenhNhan = N?, "
                + " maNhanVien = N?, "
                + " ngayKham = N? ,"
                + " chiSoSucKhoe = N? ,"
                + " ketLuan = N? ,"
                + " yeuCau = N? ,"
                + " maPhieuKham = N? "
                + " where maPhieuKhamChitiet like N?";
        PreparedStatement ps = DBConnection.ThucThiTruyVan(sql);
        try {
            ps.setString(1,m.getMaXetNghiem());
            ps.setString(2,m.getMaBenhNhan());
            ps.setString(3,m.getMaNhanVien());
            ps.setString(4,m.getNgayKham());
            ps.setString(5,m.getChiSoSucKhoe());
            ps.setString(6,m.getKetLuan());
            ps.setString(7,m.getYeuCau());
            ps.setString(8,m.getMaPhieuKham());
            ps.setString(9,maXetNghiem);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa Thành Công", "Thông Báo !", 0);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e,"Gặp Lỗi !",0);
        }
    }
    
    public void deletePhieuKham(String maXetNghiem){
//        String sql = "update phieukhamchitiet set maPhieuKhamChiTiet = N?, "
//                + " maBenhNhan = N?, "
//                + " maNhanVien = N?, "
//                + " ngayKham = N? "
//                + " chiSoSucKhoe = N? "
//                + " ketLuan = N? "
//                + " yeuCau = N? "
//                + " maPhieuKham = N? "
//                + " where maPhieuKhamChitiet like N?";
        String sql = "delete from phieuKhamChiTiet where maPhieuKhamChiTiet like N? ";
        PreparedStatement ps = DBConnection.ThucThiTruyVan(sql);
        try {
            ps.setString(1,maXetNghiem);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa Thành Công", "Thông Báo !", 0);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e,"Gặp Lỗi !",0);
        }
    }
}
