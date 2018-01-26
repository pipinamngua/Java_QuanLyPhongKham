/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.DBConnection;
import java.io.File;
import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author NGUYEN DUY DOAN
 */
public class Printer {
  public void inPKCT(String maPhieuKhamChiTiet, String maNhanVien){
      
      String maBenhNhan = "", ngayKham = "";
      String chiSoSucKhoe = "", ketLuan = " ", yeuCau = "", maPhieuKham = "";
      String tenBenhNhan = "", tenNhanVien = "", ngaySinh = "";
      PreparedStatement ps = DBConnection.ThucThiTruyVan("select * from phieukhamchitiet where maPhieuKhamChiTiet "
                + "like '"+maPhieuKhamChiTiet+"'");
      try {
            ResultSet rs = ps.executeQuery();
            rs.next();
            maBenhNhan = rs.getString(2);
            maNhanVien = rs.getString(3);
            ngayKham = rs.getString(4);
            chiSoSucKhoe = rs.getString(5);
            ketLuan = rs.getString(6);
            yeuCau = rs.getString(7);
            maPhieuKham = rs.getString(8);
//        ps = DBConnection.ThucThiTruyVan("select * from phieuKhamChiTiet where maBenhNhan "
//                + "like '"+maBN+"'");
//        this.txtChiSoSucKhoe.setText(rs.getString(5));
//        this.txtKetLuan.setText(rs.getString(6));
//        this.txtYeuCau.setText(rs.getString(7));
      } catch (SQLException ex) {
        }
    ps = DBConnection.ThucThiTruyVan("select * from benhnhan where maBenhNhan "
                + "like '"+ maBenhNhan+"'");
    try{
        ResultSet rs = ps.executeQuery();
        rs.next();
        tenBenhNhan = rs.getString(2);
        ngaySinh = rs.getString(4);
    } catch( Exception e) {
    }
    ps = DBConnection.ThucThiTruyVan("select hoTen from nhanvien where maNhanVien "
                + "like '"+ maNhanVien+"'");
    try{
        ResultSet rs = ps.executeQuery();
        rs.next();
        tenNhanVien = rs.getString(1);
    } catch( Exception e) {
    }
    try {
     //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
     File f = new File("D:\\BKHN\\20171\\LT HDT\\Bai tap lon\\New folder\\Project\\file\\PhieuKhamChiTiet.html");
     FileWriter fw = new FileWriter(f);

     //Bước 2: Ghi dữ liệu
     fw.write("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<title> Phiếu Khám Chi Tiết</title>");
     fw.write("</head>");
     fw.write("\n<body>");
     fw.write("\t<h1 align = 'center' > Phòng Khám 17 Giải Phóng </h1>\n");
     fw.write("\t<h1 align = 'center' >Phiếu Khám Chi Tiết</h1><br><br><br>\n");
     fw.write("<p style=\"font-family:arial; color:BLACK; font-size: 32px\" >\n");
     fw.write("Mã Phiếu Khám: "+maPhieuKhamChiTiet+"<br>\n");
     fw.write("Bệnh Nhân: <Strong><I>"+tenBenhNhan+"</I></Strong>   (mã số: "+maBenhNhan+")<br>\n");
     fw.write("Ngày Sinh: <Strong><I>"+ngaySinh+"</I></Strong><br>\n");
     fw.write("Nhân Viên: "+tenNhanVien+" \t(mã số: "+maNhanVien+")<br>\n");
     fw.write("Ngày Khám: "+ngayKham+"<br>\n");
     fw.write("Chỉ Số Sức Khỏe: "+chiSoSucKhoe+"<br>\n");
     fw.write("Kết Luận: "+ketLuan+"<br>\n");
     fw.write("Yêu Cầu: "+yeuCau+"<br>\n");
     fw.write("Mã Phiếu Khám: "+maPhieuKham+"<br>\n");
     fw.write("<p>\n");
     fw.write("<p align = 'right' style=\" color:BLACK; font-size: 34px\" ><Strong>Người Lập Phiếu</Strong></p>\n");
     fw.write("<p align = 'right' style=\" color:BLACK; font-size: 34px\" ><I>"+tenNhanVien+"</I></p>\n");
     fw.write("</body>\n</html>");

     //Bước 3: Đóng luồng
     fw.close(); 
   } catch (Exception ex) {
     System.out.println("Loi ghi file: " + ex);
 }}
  
  public static void main(String args[]){
      
  }
 }
