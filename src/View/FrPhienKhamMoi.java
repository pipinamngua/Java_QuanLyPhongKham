/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.BenhNhan;
import Controller.NhanVien;
import Controller.PhieuKhamChiTiet;
import Controller.PhieuKham;
import Controller.QlBenhNhan;
import Controller.QlPhieuKham;
import Controller.QlPhieuKhamChiTiet;
import Model.QuanLyNhanVien;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class FrPhienKhamMoi extends javax.swing.JFrame {

    /**
     * Creates new form FrPhienKhamMoi
     */
    private String maBN;
    private String tenBN;
    private String maBS;
    
    private BenhNhan benhNhan;
    private PhieuKham phieuKham;
    private NhanVien bacSi;

    public NhanVien getBacSi() {
        return bacSi;
    }

    public void setBacSi(NhanVien bacSi) {
        this.bacSi = bacSi;
    }
    
    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public void setBenhNhan(BenhNhan benhNhan) {
        this.benhNhan = benhNhan;
    }

    public PhieuKham getPhieuKham() {
        return phieuKham;
    }

    public void setPhieuKham(PhieuKham phieuKham) {
        this.phieuKham = phieuKham;
    }
    
    public String getMaBN() {
        return maBN;
    }

    public void setMaBN(String maBN) {
        this.maBN = maBN;
    }

    public String getTenBN() {
        return tenBN;
    }

    public void setTenBN(String tenBN) {
        this.tenBN = tenBN;
    }

    public String getMaBS() {
        return maBS;
    }

    public void setMaBS(String maBS) {
        this.maBS = maBS;
    }    
    
    public FrPhienKhamMoi() {
        initComponents();
    }
    public FrPhienKhamMoi(String maBN, String maPK, String maBS) throws SQLException, ParseException {
        
        initComponents();
        loadData(maBN,maPK, maBS);
    }
    public void loadData(String maBN, String maPK, String maBS) throws SQLException, ParseException{
        this.setMaBN(maBN);
        
        QlBenhNhan qlBenhNhan = new QlBenhNhan();
        this.setBenhNhan(qlBenhNhan.find(maBN));
        QlPhieuKham qlPhieuKham = new QlPhieuKham();
        this.setPhieuKham(qlPhieuKham.timKiemId(maPK));
        QuanLyNhanVien qlNhanVien = new QuanLyNhanVien();
        this.setBacSi(qlNhanVien.timKiemMaNhanVien(maBS));
        this.jLabelPKMTenDangNhap.setText(this.getBacSi().getHoTen());
        txtMaBenhNhan.setText(maBN);
        txtTenBacSi.setText(this.getBacSi().getHoTen());
        txtTenBenhNhan.setText(this.getBenhNhan().getTenBenhNhan());
        txtTrieuChung.setText(this.getPhieuKham().getLyDoKham());
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
        jLabel1 = new javax.swing.JLabel();
        txtTenBacSi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaBenhNhan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenBenhNhan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTrieuChung = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtChiSo = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtKetLuan = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDeNghi = new javax.swing.JTextArea();
        btnReset = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnInFile = new javax.swing.JButton();
        jLabelPKMTenPhongKham = new javax.swing.JLabel();
        btnPKMDangXuat = new javax.swing.JButton();
        jLabelPKMTenDangNhap = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaPhieuKhamCT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tạo phiên khám mới", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Tên bác sĩ thực hiện");

        txtTenBacSi.setEditable(false);
        txtTenBacSi.setText("Lấy từ tên đăng nhập");

        jLabel2.setText("Mã bệnh nhân");

        txtMaBenhNhan.setEditable(false);

        jLabel3.setText("Tên bệnh nhân");

        txtTenBenhNhan.setEditable(false);

        jLabel4.setText("Triệu chứng ban đầu");

        txtTrieuChung.setEditable(false);
        txtTrieuChung.setColumns(20);
        txtTrieuChung.setRows(5);
        jScrollPane1.setViewportView(txtTrieuChung);

        jLabel5.setText("Các chỉ số sức khỏe đo được");

        txtChiSo.setColumns(20);
        txtChiSo.setRows(5);
        jScrollPane2.setViewportView(txtChiSo);

        jLabel6.setText("Kết luận (*)");

        txtKetLuan.setColumns(20);
        txtKetLuan.setRows(5);
        jScrollPane3.setViewportView(txtKetLuan);

        jLabel7.setText("Đề nghị (*)");

        txtDeNghi.setColumns(20);
        txtDeNghi.setRows(5);
        jScrollPane4.setViewportView(txtDeNghi);

        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuMouseClicked(evt);
            }
        });

        btnInFile.setText("In file");

        jLabelPKMTenPhongKham.setText("Phòng khám XYZ");

        btnPKMDangXuat.setText("Đăng xuất");
        btnPKMDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPKMDangXuatMouseClicked(evt);
            }
        });

        jLabelPKMTenDangNhap.setText("Tên đăng nhập");

        jLabel8.setText("Mã phiếu khám (*)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtTenBacSi)
                            .addComponent(jLabel2)
                            .addComponent(txtMaBenhNhan)
                            .addComponent(jLabel3)
                            .addComponent(txtTenBenhNhan)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(txtMaPhieuKhamCT))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInFile)
                        .addGap(18, 18, 18)
                        .addComponent(btnLuu)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelPKMTenPhongKham)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelPKMTenDangNhap)
                        .addGap(18, 18, 18)
                        .addComponent(btnPKMDangXuat)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMaPhieuKhamCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenBacSi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenBenhNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnLuu)
                    .addComponent(btnInFile))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPKMTenPhongKham)
                    .addComponent(btnPKMDangXuat)
                    .addComponent(jLabelPKMTenDangNhap))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       
    }//GEN-LAST:event_formWindowClosed

    private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseClicked
        try {
            // TODO add your handling code here:
            String maPhieuKhamCT = txtMaPhieuKhamCT.getText();
            String chiSo = txtChiSo.getText();
            String ketLuan = txtKetLuan.getText();
            String deNghi = txtDeNghi.getText();
            Date today=new Date(System.currentTimeMillis());
            SimpleDateFormat timeFormat= new SimpleDateFormat("yyyy-MM-dd");
            String ngayKham=timeFormat.format(today.getTime());
            
            QlPhieuKhamChiTiet qlPKCT = new QlPhieuKhamChiTiet();
            //themMoiPhieuKhamCT(String maPhieuKhamChiTiet, String maBenhNhan, String maNhanVien, String ngayKham, String chiSoSucKhoe, String ketLuan, String yeuCau, String maPhieuKham)
            Boolean rs = qlPKCT.addPhieuKham(maPhieuKhamCT, getMaBN() , this.getBacSi().getMaNhanVien(), ngayKham, chiSo, ketLuan, deNghi, getPhieuKham().getMaPhieuKham());
            
            if(rs){
                JOptionPane.showMessageDialog(rootPane, "Tạo phiên khám bệnh thành công");
                this.setVisible(false);
                FrKhamTongQuat frTQ = new FrKhamTongQuat(this.getBacSi().getMaNhanVien());
                frTQ.show();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FrPhienKhamMoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnLuuMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
        txtDeNghi.setText("");
        txtKetLuan.setText("");
        txtChiSo.setText("");
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnPKMDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPKMDangXuatMouseClicked
        // TODO add your handling code here:
        Jfr_login login = new Jfr_login();
        login.show();
        this.dispose();
    }//GEN-LAST:event_btnPKMDangXuatMouseClicked

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
            java.util.logging.Logger.getLogger(FrPhienKhamMoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrPhienKhamMoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrPhienKhamMoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrPhienKhamMoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrPhienKhamMoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInFile;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnPKMDangXuat;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelPKMTenDangNhap;
    private javax.swing.JLabel jLabelPKMTenPhongKham;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea txtChiSo;
    private javax.swing.JTextArea txtDeNghi;
    private javax.swing.JTextArea txtKetLuan;
    private javax.swing.JTextField txtMaBenhNhan;
    private javax.swing.JTextField txtMaPhieuKhamCT;
    private javax.swing.JTextField txtTenBacSi;
    private javax.swing.JTextField txtTenBenhNhan;
    private javax.swing.JTextArea txtTrieuChung;
    // End of variables declaration//GEN-END:variables
}
