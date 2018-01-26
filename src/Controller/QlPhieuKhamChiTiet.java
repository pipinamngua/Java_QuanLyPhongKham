/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PhieuKhamChiTiet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class QlPhieuKhamChiTiet extends PhieuKhamChiTiet{
    public Boolean addPhieuKham(String maPhieuKhamChiTiet, String maBenhNhan, String maNhanVien, String ngayKham, String chiSoSucKhoe, String ketLuan, String yeuCau, String maPhieuKham) throws SQLException{
        PhieuKhamChiTiet pkct = new PhieuKhamChiTiet();
        Boolean rs = pkct.themMoiPhieuKhamCT(maPhieuKhamChiTiet, maBenhNhan, maNhanVien, ngayKham, chiSoSucKhoe, ketLuan, yeuCau, maPhieuKham);
        
        return rs;
    }
    
    public ArrayList<Controller.PhieuKhamChiTiet> find(String maBN, String maPK) throws SQLException{
        Model.PhieuKhamChiTiet pkModel = new Model.PhieuKhamChiTiet();
        ArrayList<Controller.PhieuKhamChiTiet> lstPhieuKham = pkModel.find(maBN, maPK);
        
        return lstPhieuKham;
    }
    
    public Integer soBS(String maPK, String maBN) throws SQLException{
        Model.PhieuKhamChiTiet pkModel = new Model.PhieuKhamChiTiet();
        
        return pkModel.soLuongBS(maPK, maBN);
    }
    
    public Integer soDS(String maPK, String maBN) throws SQLException{
        Model.PhieuKhamChiTiet pkModel = new Model.PhieuKhamChiTiet();
        
        return pkModel.soLuongXN(maPK, maBN);
    }
}
