package View;


import Controller.model_chitietthuoc;
import Controller.model_donthuoc;
import Controller.model_thuoc;
import Model.donthuoc;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luong Thanh Long
 */
public class phatthuoc extends javax.swing.JFrame {
    public static String id2;
    public static String id=Jfr_login.id;
    model_thuoc t = new model_thuoc();
    model_donthuoc c=new model_donthuoc();
    model_chitietthuoc ct= new model_chitietthuoc();
private String className="com.mysql.jdbc.Driver";
	private String table="donthuoc";
	private final String url="jdbc:mysql://localhost:3306/qlphongkham?useUnicode=true&characterEncoding=UTF-8";
	private Connection connection;
        
    /**
     * Creates new form phatthuoc
     */
    public phatthuoc() throws SQLException {
        initComponents();
        try {
			Class.forName(className);
			connection = DriverManager.getConnection(url,"root","");
			System.out.print("connect sucessfull \n");
		} catch (ClassNotFoundException e) {
			System.out.print("Class not found \n");
		} catch (SQLException e) {
			System.out.print("Error connection \n");
		}
        
        this.loadcombo();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//       jComboBox1.addItem("1");
    }

    
    public ResultSet searchDS(String id)
    {
        ResultSet rs=null;
           String sqlcomand = "select * from `nhanvien`  where `maNhanVien` like ?" ;
           PreparedStatement pst=null;
       try {
           pst = connection.prepareStatement(sqlcomand);
           pst.setString(1,id);
           rs=pst.executeQuery();
       } catch (SQLException e) {
           System.out.println("select error \n"+e.toString());
       }
       return rs;
       
    }
     
     
    public ResultSet searchBn(String name)
    {
        ResultSet rs=null;
           String sqlcomand = "select * from `benhnhan`  where `tenBenhNhan` like ?" ;
           PreparedStatement pst=null;
       try {
           pst = connection.prepareStatement(sqlcomand);
           pst.setString(1,name);
           rs=pst.executeQuery();
       } catch (SQLException e) {
           System.out.println("select error \n"+e.toString());
       }
       return rs;
    }
    void loadData(ResultSet rs, JTable table )
    {
        DefaultTableModel model = new DefaultTableModel();
        
        try {
            ResultSetMetaData rsMD = rs.getMetaData();
            int columNumber = rsMD.getColumnCount();
            String[] arr= new String [columNumber];
            for (int i=0;i<columNumber;i++){
                arr[i]=rsMD.getColumnName(i+1);}
            model.setColumnIdentifiers(arr);
            while (rs.next())
            {
                for(int i=0;i<columNumber;i++)
                {
                    arr[i]=rs.getString(i+1);
                }
                model.addRow(arr);
            }
        } catch (SQLException ex) { 
        }   
        table.setModel(model);        
    }
     public void loadcombo() throws SQLException
    {
       ResultSet rs= tenbs();
        
             // TODO add your handling code here
             while(rs.next())
             {
                 jComboBox1.addItem(rs.getString(1)+"-"+rs.getString(2));
             }
         
    }
public ResultSet tenbs()
{
  ResultSet rs=null;
           String sqlcomand = "select * from `nhanvien` where `chucVu` like \"Bac si\" " ;
           PreparedStatement pst=null;
       try {
           pst = connection.prepareStatement(sqlcomand);
           rs=pst.executeQuery();
       } catch (SQLException e) {
           System.out.println("select error \n"+e.toString());
       }   
       return rs;
}
public ResultSet ds(String id)
    {
         ResultSet rs=null;
           String sqlcomand = "select * from `donthuoc`  where `maBenhNhan` like ?" ;
           PreparedStatement pst=null;
       try {
           pst = connection.prepareStatement(sqlcomand);
           pst.setString(1,id);
           rs=pst.executeQuery();
       } catch (SQLException e) {
           System.out.println("select error \n"+e.toString());
       }
       return rs;
    }
    
 public void loaddata()
    {
        int row=jTable1.getSelectedRow();
        ResultSet rs=null;
        rs= c.getDataID((String) jTable1.getValueAt(row, 0),"maBenhNhan");
        DefaultTableModel model = new DefaultTableModel();
        
        try {
            ResultSetMetaData rsMD = rs.getMetaData();
            int columNumber = rsMD.getColumnCount();
            String[] arr= new String [columNumber];
            for (int i=0;i<columNumber;i++){
                arr[i]=rsMD.getColumnName(i+1);}
            model.setColumnIdentifiers(arr);
            while (rs.next())
            {
                for(int i=0;i<columNumber;i++)
                {
                    arr[i]=rs.getString(i+1);
                }
                model.addRow(arr);
            }
        } catch (SQLException ex) { 
        }   
        jTable3.setModel(model);        
    
    }
 
    public void them() throws SQLException, ParseException
    {
        
        int row = jTable1.getSelectedRow();
        
        String mabn = ((String) jTable1.getValueAt(row,0));
        String mabs = ((String) jComboBox1.getSelectedItem()).substring(0, 4);
        ResultSet rs= null;
        rs=c.gettime();
        while (rs.next())
        {
                
        c.insertID(new donthuoc(mabn ,id, mabs,rs.getString(1)+"-"+rs.getString(3)+"-"+rs.getString(2), 0));
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Xem đơn thuốc");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Thêm đơn thuốc");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jButton4.setText("Chi Tiết đơn thuốc");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Xóa đơn thuốc");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Load");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("xuất đơn thuốc");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Thông tin cá nhân");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("kho thuốc");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("đăng xuất");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(41, 41, 41)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(188, 188, 188)
                                .addComponent(jButton3)
                                .addGap(47, 47, 47)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(147, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton4)
                    .addComponent(jButton7))
                .addGap(185, 185, 185))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        loadData(searchBn(jTextField1.getText()), jTable1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int row;
        row= jTable1.getSelectedRow();
        loadData(ds((String) jTable1.getValueAt(row, 0)), jTable3);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            them();
        } catch (SQLException ex) {
            Logger.getLogger(phatthuoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(phatthuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        int row;
        row= jTable1.getSelectedRow();
        loadData(ds((String) jTable1.getValueAt(row, 0)), jTable3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row;
        row=jTable3.getSelectedRow();
        this.id2=(String) jTable3.getValueAt(row, 0);
        ChiTietDonThuoc m=new ChiTietDonThuoc();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int row2= jTable1.getSelectedRow();
        int row= jTable3.getSelectedRow();
        ResultSet rs= null;
        ResultSet rs1=null;
        int tong =0;
        rs=ct.getDataID((String) jTable3.getValueAt(row, 0), "maDonThuoc");
        try {
            while(rs.next())
            {
                rs1= t.getDataID(rs.getString("maThuoc"), "maThuoc");
              try {
                 while (rs1.next())
                  {  
                     tong= tong + rs.getInt("soLuong")*rs1.getInt("donGia");
                  }
              } catch (SQLException ex) {
                  Logger.getLogger(phatthuoc.class.getName()).log(Level.SEVERE, null, ex);
                   }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(phatthuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            c.updateID1((String) jTable3.getValueAt(row, 0), tong);
        } catch (ParseException ex) {
            Logger.getLogger(phatthuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
       loadData(ds((String) jTable1.getValueAt(row2, 0)), jTable3);
        System.out.println(tong);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        int row = jTable3.getSelectedRow();
        ResultSet rs=ct.getDataID((String) jTable3.getValueAt(row, 0), "maDonThuoc");
        try {
            while(rs.next())
            {
                t.updateID2(rs.getString("maThuoc"), rs.getInt("soLuong"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(phatthuoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(phatthuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (row<0)
        {
             JOptionPane.showMessageDialog(null, "you must chose a row",
                     "delete error", JOptionPane.ERROR_MESSAGE);
             return;
        }
       int select= JOptionPane.showOptionDialog(null, "Are you sure ?", "Delete",0 ,
               JOptionPane.YES_NO_OPTION,null, null, 1);
       if (select==0){
        try {
            c.deleteID((String) jTable3.getValueAt(row, 0));
        } catch (SQLException ex) {
            Logger.getLogger(phatthuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        loaddata();
       }
    }//GEN-LAST:event_jButton5ActionPerformed

 
    private void export1() throws FileNotFoundException, IOException, SQLException
     {
         int row = jTable3.getSelectedRow();
         int row_1=jTable1.getSelectedRow(); 
         ResultSet rs= ct.getDataID((String) jTable3.getValueAt(row, 0), "maDonThuoc");
         java.sql.ResultSet rs1=null;
        rs1=c.gettime();
         try{               
             try (FileOutputStream outStream = new FileOutputStream("Đơn Thuốc mã "+jTable3.getValueAt(row, 0)+".docx")) {
                 XWPFDocument doc = new XWPFDocument() ;
                 XWPFParagraph pratit = doc.createParagraph();
                 pratit.setAlignment(ParagraphAlignment.CENTER);
                 XWPFRun pratitRun = pratit.createRun();
                 pratitRun.setBold(true);
                 pratitRun.setFontSize(30);
                 pratitRun.setText("Trường Đại học Bách Khoa Hà Nội ");
                 pratitRun.addBreak();
                 pratitRun.setText(" Lương Thành Long ");
                 pratitRun.addBreak();
                 pratitRun.setText(" BK HOSPITAL ");
                 pratitRun.addBreak();
                 pratitRun.setText("Đơn Thuốc");
                 pratitRun.addBreak();
                 XWPFParagraph pratit1 = doc.createParagraph();
                 pratit1.setAlignment(ParagraphAlignment.LEFT);                
                 XWPFRun pratitRun1 = pratit1.createRun();
                 pratitRun1.setBold(true);
                 pratitRun1.setText( "mã bệnh nhân :" + (String) jTable1.getValueAt(row_1, 0));
                 pratitRun1.addBreak();
                 pratitRun1.setText( "tên bệnh nhân :" + (String) jTable1.getValueAt(row_1, 1));
                 pratitRun1.addBreak();
                 pratitRun1.setText( "Giới tính :" + (String) jTable1.getValueAt(row_1, 2));
                 pratitRun1.addBreak();
                 pratitRun1.setText( "ngày sinh  : " + (String) jTable1.getValueAt(row_1, 3));
                 pratitRun1.addBreak();
                 pratitRun1.setText( "nghề nghiệp :" + (String) jTable1.getValueAt(row_1, 4));
                 pratitRun1.addBreak();
                 pratitRun1.setText( "địa chỉ :" + (String) jTable1.getValueAt(row_1, 6));
                 pratitRun1.addBreak();
                 pratitRun1.setText( "Tiểu sử bệnh án :" + (String) jTable1.getValueAt(row_1, 7));
                 pratitRun1.addBreak();
                 pratitRun1.setText( "sđt   :" + (String) jTable1.getValueAt(row_1, 8));
                 pratitRun1.addBreak();
                 pratitRun1.setText( "số cmt :" + (String) jTable1.getValueAt(row_1, 9));
                 pratitRun1.addBreak();
                 
                 XWPFTable pra = doc.createTable();
                 pra.setCellMargins(50, 0, 0, 200);
                 XWPFTableRow row1=pra.getRow(0);
                 row1.getCell(0).setText("mã Đơn Thuốc");
                 row1.addNewTableCell().setText("mã bệnh nhân");
                 row1.addNewTableCell().setText("mã dược sĩ");
                 row1.addNewTableCell().setText("mã bác sĩ");
                 row1.addNewTableCell().setText("ngày lấy thuốc");
                 row1.addNewTableCell().setText("tổng tiền");
                 
                 XWPFTableRow row2= pra.createRow();
                 row2.getCell(0).setText((String) jTable3.getValueAt(row, 0));
                 row2.getCell(1).setText((String) jTable3.getValueAt(row, 1));
                 row2.getCell(2).setText((String) jTable3.getValueAt(row, 2));
                 row2.getCell(3).setText((String) jTable3.getValueAt(row, 3));
                 row2.getCell(4).setText((String) jTable3.getValueAt(row, 4));
                 row2.getCell(5).setText((String) jTable3.getValueAt(row, 5));
                 XWPFParagraph pratit2 = doc.createParagraph();
                 pratit2.setAlignment(ParagraphAlignment.CENTER);                
                 XWPFRun pratitRun2 = pratit2.createRun();
                 pratitRun2.addBreak();
                 pratitRun2.setText("Chi Tiết");
                 XWPFTable pra1 = doc.createTable();
                 pra1.setCellMargins(50, 0, 0, 200);
                 XWPFTableRow row3=pra1.getRow(0);
                 row3.getCell(0).setText("mã Đơn Thuốc chi tiết");
                 row3.addNewTableCell().setText("mã thuốc");
                 row3.addNewTableCell().setText("số lượng");                
                 while (rs.next())
                 {  
                    XWPFTableRow rownext=pra1.createRow();
                    rownext.getCell(0).setText(rs.getString("maDonThuocChiTiet"));
                    rownext.getCell(1).setText(rs.getString("maThuoc"));
                    rownext.getCell(2).setText(rs.getString("soLuong"));
                }
                      XWPFParagraph right =doc.createParagraph();
                right.setAlignment((ParagraphAlignment.RIGHT));
               
                 XWPFRun righttit = right.createRun();
                 righttit.setFontSize(12);
                 righttit.setBold(true);
                 righttit.addBreak();
                 righttit.addBreak();
                 while (rs1.next())
                 {
                 righttit.setText("Hà nội, ngày "+rs1.getString(2) + " Tháng " + rs1.getString(3)+" Năm "+rs1.getString(1));
                 
                 }
                 righttit.addBreak();
                 righttit.addBreak();
                 righttit.setText("Người lập bảng");
                 
                 
                  doc.write(outStream);
                  System.out.println("create successfull \n");
                  JOptionPane.showMessageDialog(null, "Created", "notice",
                JOptionPane.INFORMATION_MESSAGE);
             }
             }catch(IOException e){
             System.out.println("created error..." +e.toString());
         }
     } 
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        new KhoThuoc();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            // TODO add your handling code here:
            export1();
        } catch (IOException ex) {
            Logger.getLogger(phatthuoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(phatthuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(phatthuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(phatthuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(phatthuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(phatthuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new phatthuoc().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(phatthuoc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    
}
