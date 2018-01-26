/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class BenhNhan {
    private String maBenhNhan;
    private String tenBenhNhan;
    private String gioiTinh;
    private Date ngaySinh;
    private String ngheNghiep;
    private Integer tinhTrangHonNhan;
    private String diaChi;
    private String tieuSuBenhAn;
    private String soDienThoai;
    private String SoCMND;

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public Integer getTinhTrangHonNhan() {
        return tinhTrangHonNhan;
    }

    public void setTinhTrangHonNhan(Integer tinhTrangHonNhan) {
        this.tinhTrangHonNhan = tinhTrangHonNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTieuSuBenhAn() {
        return tieuSuBenhAn;
    }

    public void setTieuSuBenhAn(String tieuSuBenhAn) {
        this.tieuSuBenhAn = tieuSuBenhAn;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getSoCMND() {
        return SoCMND;
    }

    public void setSoCMND(String SoCMND) {
        this.SoCMND = SoCMND;
    }

    public BenhNhan(String maBenhNhan, String tenBenhNhan, String gioiTinh, Date ngaySinh, String ngheNghiep, Integer tinhTrangHonNhan, String diaChi, String tieuSuBenhAn, String soDienThoai, String SoCMND) {
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngheNghiep = ngheNghiep;
        this.tinhTrangHonNhan = tinhTrangHonNhan;
        this.diaChi = diaChi;
        this.tieuSuBenhAn = tieuSuBenhAn;
        this.soDienThoai = soDienThoai;
        this.SoCMND = SoCMND;
    }

    public BenhNhan() {
    }   
    
    
}
