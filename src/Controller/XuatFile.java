/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

/**
 *
 * @author Administrator
 */
public class XuatFile {
    public void export(String tenFile, String tenPhongKham, ArrayList<String> noiDung) throws FileNotFoundException, IOException, SQLException
     {
        String name;
        String number;
        java.sql.ResultSet rs1=null;
        //rs1=myconnect.gettime();
         try{               
             try (FileOutputStream outStream = new FileOutputStream(tenFile+".docx")) {
                XWPFDocument doc = new XWPFDocument() ;
                XWPFParagraph pratit = doc.createParagraph();
                 pratit.setAlignment(ParagraphAlignment.CENTER);
                 XWPFRun pratitRun = pratit.createRun();
                 pratitRun.setBold(true);
                 pratitRun.setFontSize(30);
                 
                 XWPFTable pra = doc.createTable();
                 pra.setCellMargins(50,800,25,800);
                /*
                 for(int i = 0; i < noiDung.size(); i++){
                    pratitRun.setText(noiDung.get(i));
                    pratitRun.addBreak();
                 }
                 */
                XWPFParagraph left =doc.createParagraph();
                left.setAlignment((ParagraphAlignment.LEFT));
                XWPFRun pratitLeft = left.createRun();
                for(int i = 0; i < noiDung.size(); i++){
                    pratitLeft.setText(noiDung.get(i));
                    pratitLeft.addBreak();
                }
                doc.write(outStream);
                System.out.println("create successfull \n");
                JOptionPane.showMessageDialog(null, "Created", "notice",
                JOptionPane.INFORMATION_MESSAGE);
             }
             }catch(IOException e){
             System.out.println("created error..." +e.toString());
         }
     } 
}
