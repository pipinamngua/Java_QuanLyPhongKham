/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class PhieuKham {
    private String maPhieuKham;
    private String maNhanVien;
    private String maBenhNhan;
    private String lyDoKham;
    private String ghiChu;
    private String tenBenhNhan;
    private String tenBacSi;
    private Double thanhToan;
    
    public Double getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(Double thanhToan) {
        this.thanhToan = thanhToan;
    }
    
    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getTenBacSi() {
        return tenBacSi;
    }

    public void setTenBacSi(String tenBacSi) {
        this.tenBacSi = tenBacSi;
    }
    
    public String getMaPhieuKham() {
        return maPhieuKham;
    }

    public void setMaPhieuKham(String maPhieuKham) {
        this.maPhieuKham = maPhieuKham;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getLyDoKham() {
        return lyDoKham;
    }

    public void setLyDoKham(String lyDoKham) {
        this.lyDoKham = lyDoKham;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public PhieuKham(String maPhieuKham, String maNhanVien, String maBenhNhan, String lyDoKham, String ghiChu, String tenBacSi, Double thanhToan) {
        this.maPhieuKham = maPhieuKham;
        this.maNhanVien = maNhanVien;
        this.maBenhNhan = maBenhNhan;
        this.lyDoKham = lyDoKham;
        this.ghiChu = ghiChu;
        this.tenBacSi = tenBacSi;
        this.thanhToan = thanhToan;
    }

    public PhieuKham() {
    }
    
    
}
