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

/**
 *
 * @author Administrator
 */
public class QlBenhNhan extends BenhNhan{
    public ArrayList<BenhNhan> timKiem(String maBenhNhan, String tenBenhNhan, String gioiTinh, String thang) throws SQLException, ParseException{
        ArrayList<BenhNhan> lstBenhNhan = new ArrayList<>();
        Model.BenhNhan bn = new Model.BenhNhan();
        lstBenhNhan = bn.findBenhNhan(maBenhNhan, tenBenhNhan, gioiTinh);
        return lstBenhNhan;
    }
    
    public ArrayList<BenhNhan> getAll() throws SQLException, ParseException{
        ArrayList<BenhNhan> lstBenhNhan = new ArrayList<>();
        Model.BenhNhan bn = new Model.BenhNhan();
        lstBenhNhan = bn.findAll();
        return lstBenhNhan;
    }
    
    public BenhNhan find(String maBN) throws SQLException, ParseException{
        Model.BenhNhan bn = new Model.BenhNhan();
        BenhNhan benhNhan = bn.findMaBN(maBN);
        
        return benhNhan;
    }
    
    public Boolean update(Controller.BenhNhan benhNhan) throws SQLException{
        Model.BenhNhan bnModel = new Model.BenhNhan();
        
        return bnModel.insertBN(benhNhan);
    }
    
    public Boolean themMoiBenhNhan(Controller.BenhNhan benhNhan) throws SQLException{
        Model.BenhNhan bnModel = new Model.BenhNhan();
        
        return bnModel.themMoiBenhNhan(benhNhan);
    }
}
