package Model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luong Thanh Long
 */
public class donthuoc {
    private String madonthuoc;
    private String mabenhnhan;
    private String mabacsi;
    private String maduocsi;
    private String ngay;
    private int tien;
    public donthuoc(String mabenhnhan,String maduocsi,String mabacsi,String ngay,int tien)
    {
        
        this.mabenhnhan=mabenhnhan;
        this.mabacsi=mabacsi;
        this.ngay=ngay;
        this.tien=tien;
        this.maduocsi=maduocsi;
    }

    public String getMaduocsi() {
        return maduocsi;
    }

    public void setMaduocsi(String maduocsi) {
        this.maduocsi = maduocsi;
    }

    public String getMadonthuoc() {
        return madonthuoc;
    }

    public void setMadonthuoc(String madonthuoc) {
        this.madonthuoc = madonthuoc;
    }

    public String getMabenhnhan() {
        return mabenhnhan;
    }

    public void setMabenhnhan(String mabenhnhan) {
        this.mabenhnhan = mabenhnhan;
    }

    public String getMabacsi() {
        return mabacsi;
    }

    public void setMabacsi(String mabacsi) {
        this.mabacsi = mabacsi;
    }

   public String getNgay() throws ParseException 
   {
        java.util.Date date=  new SimpleDateFormat("yyyy-mm-dd").parse(ngay);
//        java.sql.Date sqldate= new java.sql.Date(date.getTime());
          
        return ngay; 
   }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }
    
}
