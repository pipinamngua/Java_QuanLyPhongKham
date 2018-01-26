/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PhieuKham;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class QlPhieuKham extends Controller.PhieuKham{
    public ArrayList<Controller.PhieuKham> timKiem(String maBN) throws SQLException{
        ArrayList<Controller.PhieuKham> lstPhieuKham = new ArrayList<>();
        Model.PhieuKham pk = new Model.PhieuKham();
        if(maBN.isEmpty()){
            lstPhieuKham = pk.findAll();
        }
        else
            lstPhieuKham = pk.findId(maBN);
        
        return lstPhieuKham;
    }
    
    public Controller.PhieuKham timKiemId(String maPK) throws SQLException{
        Model.PhieuKham pk = new Model.PhieuKham();
        Controller.PhieuKham phieuKham = pk.findIdPK(maPK);
        
        return phieuKham;
    }
    
    public Boolean update(Controller.PhieuKham phieuKham) throws SQLException{
        Model.PhieuKham pkModel = new Model.PhieuKham();
        
        return pkModel.update(phieuKham);
    }
    
    public Boolean themMoiPhieuKham(Controller.PhieuKham phieuKham) throws SQLException{
        Model.PhieuKham  pkModel = new Model.PhieuKham();
        
        return pkModel.themMoiPhieuKham(phieuKham);
    }
}
