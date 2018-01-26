package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luong Thanh Long
 */
public class thuoc {
    private String mathuoc;
    private String tenthuoc;
    private int soluong;
    private int dongia;
    public thuoc(String mathuoc, String tenthuoc,int soluong, int dongia)
    {
        this.dongia=dongia;
        this.mathuoc=mathuoc;
        this.soluong=soluong;
        this.tenthuoc=tenthuoc;
    }

    public String getMathuoc() {
        return mathuoc;
    }

    public void setMathuoc(String mathuoc) {
        this.mathuoc = mathuoc;
    }

    public String getTenthuoc() {
        return tenthuoc;
    }

    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
    
    
}
