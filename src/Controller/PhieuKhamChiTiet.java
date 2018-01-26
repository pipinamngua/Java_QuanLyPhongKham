/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class PhieuKhamChiTiet {
    private String maPhieuKhamChiTiet;
    private String maBenhNhan;
    private String maBacSi;
    private Date ngayKham;
    private String chiSoSucKhoe;
    private String ketLuan;
    private String yeuCau;
    private String maPhieuKham;
    private String tenBacSi;

    public String getTenBacSi() {
        return tenBacSi;
    }

    public void setTenBacSi(String tenBacSi) {
        this.tenBacSi = tenBacSi;
    }
    
    public String getMaPhieuKhamChiTiet() {
        return maPhieuKhamChiTiet;
    }

    public void setMaPhieuKhamChiTiet(String maPhieuKhamChiTiet) {
        this.maPhieuKhamChiTiet = maPhieuKhamChiTiet;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getMaBacSi() {
        return maBacSi;
    }

    public void setMaBacSi(String maBacSi) {
        this.maBacSi = maBacSi;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getChiSoSucKhoe() {
        return chiSoSucKhoe;
    }

    public void setChiSoSucKhoe(String chiSoSucKhoe) {
        this.chiSoSucKhoe = chiSoSucKhoe;
    }

    public String getKetLuan() {
        return ketLuan;
    }

    public void setKetLuan(String ketLuan) {
        this.ketLuan = ketLuan;
    }

    public String getYeuCau() {
        return yeuCau;
    }

    public void setYeuCau(String yeuCau) {
        this.yeuCau = yeuCau;
    }

    public String getMaPhieuKham() {
        return maPhieuKham;
    }

    public void setMaPhieuKham(String maPhieuKham) {
        this.maPhieuKham = maPhieuKham;
    }

    public PhieuKhamChiTiet(String maPhieuKhamChiTiet, String maBenhNhan, String maBacSi, Date ngayKham, String chiSoSucKhoe, String ketLuan, String yeuCau, String maPhieuKham) {
        this.maPhieuKhamChiTiet = maPhieuKhamChiTiet;
        this.maBenhNhan = maBenhNhan;
        this.maBacSi = maBacSi;
        this.ngayKham = ngayKham;
        this.chiSoSucKhoe = chiSoSucKhoe;
        this.ketLuan = ketLuan;
        this.yeuCau = yeuCau;
        this.maPhieuKham = maPhieuKham;
    }

    public PhieuKhamChiTiet() {
    }
    
    
}
