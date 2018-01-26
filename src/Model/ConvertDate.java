/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class ConvertDate {
    public java.util.Date convertFromSQLDateToJAVADate(java.sql.Date sqlDate) {
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return javaDate;
    }
    
    public java.sql.Date convertFromJavaDateToSQLDate(java.util.Date utilDate) {
        java.sql.Date sqlDate = null;
        if (utilDate != null) {
            sqlDate = new java.sql.Date(utilDate.getTime());
        }
        return sqlDate;
    }
}
