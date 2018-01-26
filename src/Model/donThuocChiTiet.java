package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luong Thanh Longv
 */
public class donThuocChiTiet {
    private int madonthuocchitiet;
    private String madonthuoc;
    private String mathuoc;
    private int soluong;
    public donThuocChiTiet(String madonthuoc,String mathuoc,int soluong)
    {
        this.madonthuoc=madonthuoc;
        
        this.mathuoc=mathuoc;
        this.soluong=soluong;
    }

    public int getMadonthuocchitiet() {
        return madonthuocchitiet;
    }

    public void setMadonthuocchitiet(int madonthuocchitiet) {
        this.madonthuocchitiet = madonthuocchitiet;
    }

    public String getMadonthuoc() {
        return madonthuoc;
    }

    public void setMadonthuoc(String madonthuoc) {
        this.madonthuoc = madonthuoc;
    }

    public String getMathuoc() {
        return mathuoc;
    }

    public void setMathuoc(String mathuoc) {
        this.mathuoc = mathuoc;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
}
