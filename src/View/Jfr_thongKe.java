/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Connect;
import Controller.model_donthuoc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Jfr_thongKe extends javax.swing.JFrame {
    private Connection connection;
    model_donthuoc c= new  model_donthuoc();
    private Connect connect = new Connect();
    /**
     * Creates new form Jfr_thongKe
     */
    public Jfr_thongKe() {
        
        initComponents();
        connection = connect.getConn();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton_ThongKe = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_ThongKe.setText("Thống kê");
        jButton_ThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThongKeActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "số lượng", "doanh thu trong tháng" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Thống kê bệnh nhân");

        jLabel3.setText("Thống kê nhân viên");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "số lượng bác sĩ", "số lượng dược sĩ", "số lượng nv" }));

        jButton1.setText("Thống kê");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, 0, 169, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_ThongKe)
                    .addComponent(jButton1))
                .addGap(19, 19, 19))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_ThongKe)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton_ThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThongKeActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("số lượng"))
        {
            try {
                loadData(thongkebenhnhan("maBenhNhan"), jTable1);
            } catch (SQLException ex) {
                Logger.getLogger(Jfr_thongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(jComboBox1.getSelectedItem().toString().equalsIgnoreCase("doanh thu trong tháng"))
        {
            ResultSet rs= null;
            ResultSet rs2=null;
            double tong=0;
            try {
                rs=c.gettime();
            } catch (SQLException ex) {
                Logger.getLogger(Jfr_thongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while(rs.next())
                {
                    rs2= thongkedoanhthu(rs.getString("month"));
                    while(rs2.next())
                    {
                        tong+=rs2.getDouble("thanhToan");
                    }
                    JOptionPane.showMessageDialog(rootPane, "tổng tiền trong tháng la "+ String.valueOf(tong));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Jfr_thongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_ThongKeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jComboBox2.getSelectedItem().toString().equals("số lượng bác sĩ"))
            try {
                loadData(thongkenhanvien("BS"), jTable1);
        } catch (SQLException ex) {
            Logger.getLogger(Jfr_thongKe.class.getName()).log(Level.SEVERE, null, ex);
        }else
            if(jComboBox2.getSelectedItem().toString().equals("số lượng dược sĩ"))
            try {
                loadData(thongkenhanvien("DS"), jTable1);
        } catch (SQLException ex) {
            Logger.getLogger(Jfr_thongKe.class.getName()).log(Level.SEVERE, null, ex);
        } else
                if(jComboBox2.getSelectedItem().toString().equals("số lượng nv"))
            try {
                loadData(thongkenhanvien("NV"), jTable1);
        } catch (SQLException ex) {
            Logger.getLogger(Jfr_thongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public ResultSet thongkebenhnhan(String text) throws SQLException
    {
        ResultSet rs =null;
        String sqlcommand= "select `"  + text +"` , count(`maBenhNhan`)As number  from `benhnhan`";
        Statement st=null;
       st=connection.createStatement();
       rs=st.executeQuery(sqlcommand);
                return rs;
    }
    public ResultSet thongkenhanvien(String text) throws SQLException
    {
        ResultSet rs =null;
        String sqlcommand= "select  count(`maNhanVien`)As number  from `nhanvien` where `maNhanVien` like '"+text+"%'";
        Statement st=null;
       st=connection.createStatement();
       rs=st.executeQuery(sqlcommand);
                return rs;
    }
    public ResultSet thongkedoanhthu(String text) throws SQLException
    {
        ResultSet rs = null;
        String sql = "select * from `phieukham` where month(ngayKham) like "+text;
        Statement st=null;
       st=connection.createStatement();
       rs=st.executeQuery(sql);
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
            java.util.logging.Logger.getLogger(Jfr_thongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jfr_thongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jfr_thongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jfr_thongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jfr_thongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_ThongKe;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}