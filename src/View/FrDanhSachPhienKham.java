/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.NhanVien;
import Controller.PhieuKhamChiTiet;
import Controller.QlPhieuKhamChiTiet;
import Model.QuanLyNhanVien;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class FrDanhSachPhienKham extends javax.swing.JFrame {

    /**
     * Creates new form FrDanhSachPhienKham
     */
    private ArrayList<PhieuKhamChiTiet> lstPhieuKhamCT;
    private String maBN;
    private String maPK;
    private NhanVien Username;

    public NhanVien getUsername() {
        return Username;
    }

    public void setUsername(NhanVien Username) {
        this.Username = Username;
    }
    
    public String getMaBN() {
        return maBN;
    }

    public void setMaBN(String maBN) {
        this.maBN = maBN;
    }

    public String getMaPK() {
        return maPK;
    }

    public void setMaPK(String maPK) {
        this.maPK = maPK;
    }
    
    public ArrayList<PhieuKhamChiTiet> getLstPhieuKhamCT() {
        return lstPhieuKhamCT;
    }

    public void setLstPhieuKhamCT(ArrayList<PhieuKhamChiTiet> lstPhieuKhamCT) {
        this.lstPhieuKhamCT = lstPhieuKhamCT;
    }
    
    public FrDanhSachPhienKham() {
        initComponents();
    }
    
    public FrDanhSachPhienKham(String maBN, String maPK, String maBS) throws SQLException{
        initComponents();
        loadData(maBN, maPK, maBS);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public void loadData(String maBN, String maPK, String maBS) throws SQLException{
        QlPhieuKhamChiTiet qlPKCT = new QlPhieuKhamChiTiet();
        QuanLyNhanVien qlNhanVien = new QuanLyNhanVien();
        this.setUsername(qlNhanVien.timKiemMaNhanVien(maBS));
        this.jLabelTenDangNhapDSPK.setText(this.getUsername().getHoTen());
        this.setLstPhieuKhamCT(qlPKCT.find(maBN, maPK));
        this.setMaBN(maBN);
        this.setMaPK(maPK);
        Vector vtColumn=new Vector(); 
        Vector vtRow=new Vector(); 
        Vector vtData=new Vector();
        vtColumn.add("Mã phiếu khám");
        vtColumn.add("Mã bệnh nhân");
        vtColumn.add("Bác sĩ khám");
        vtColumn.add("Ngày  khám");
        vtColumn.add("Chỉ số sức khỏe");
        vtColumn.add("Kết luận");
        vtColumn.add("Yêu cầu của bác sĩ");
        
        try{
            if(this.lstPhieuKhamCT.size() > 0){
                for(Controller.PhieuKhamChiTiet phieuKham :lstPhieuKhamCT){
                    
                    vtRow=new Vector();
                    vtRow.add(phieuKham.getMaPhieuKhamChiTiet());
                    vtRow.add(phieuKham.getMaBenhNhan());
                    vtRow.add(phieuKham.getTenBacSi());
                    vtRow.add(phieuKham.getNgayKham());
                    vtRow.add(phieuKham.getChiSoSucKhoe()); 
                    vtRow.add(phieuKham.getKetLuan());
                    vtRow.add(phieuKham.getYeuCau());
                    vtData.add(vtRow);                
                } 
            }
            tblDanhSachPhienKham.setModel(new DefaultTableModel(vtData, vtColumn));
            jLabelSoBanGhi.setText("Có "+getLstPhieuKhamCT().size()+" bản ghi được tìm thấy");
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachPhienKham = new javax.swing.JTable();
        jLabelSoBanGhi = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        txtTongTien = new javax.swing.JTextField();
        jLabelTenDangNhapDSPK = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phiên khám", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tblDanhSachPhienKham.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDanhSachPhienKham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachPhienKhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachPhienKham);

        jLabelSoBanGhi.setText("Có 0 mục được tìm thấy");

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });

        jLabelTenDangNhapDSPK.setText("Tên người đăng nhập");

        jButton1.setText("Đăng xuất");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(txtTongTien)
                        .addGap(18, 18, 18)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelSoBanGhi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelTenDangNhapDSPK)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSoBanGhi, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTenDangNhapDSPK)
                    .addComponent(jButton1))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhSachPhienKhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachPhienKhamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDanhSachPhienKhamMouseClicked

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        try {
            // TODO add your handling code here:
            Model.PhieuKham pk = new Model.PhieuKham();
            Double rs = pk.thanhToan(this.getMaBN(), this.getMaPK());
            txtTongTien.setText(rs.toString());
        } catch (SQLException ex) {
            Logger.getLogger(FrDanhSachPhienKham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        Jfr_login login = new Jfr_login();
        login.show();
        this.dispose();
        
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(FrDanhSachPhienKham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrDanhSachPhienKham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrDanhSachPhienKham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrDanhSachPhienKham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrDanhSachPhienKham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelSoBanGhi;
    private javax.swing.JLabel jLabelTenDangNhapDSPK;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDanhSachPhienKham;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
