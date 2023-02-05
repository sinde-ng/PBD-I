/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller_Warga;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author naufa
 */
public class View_Warga extends javax.swing.JInternalFrame {

    private Controller_Warga cw;
    /**
     * Creates new form View_Warga
     */
    public View_Warga() {
        initComponents();
        cw = new Controller_Warga(this);
        cw.refreshTabel("default");
    }

    public JTable getTable_warga() {
        return table_warga;
    }

    public JButton getBtn_daftar() {
        return btn_daftar;
    }

    public JButton getBtn_hapus() {
        return btn_hapus;
    }

    public JButton getBtn_ubah() {
        return btn_ubah;
    }

    public JComboBox<String> getInput_jabatan() {
        return input_jabatan;
    }

    public JTextField getInput_nama() {
        return input_nama;
    }

    public JTextField getInput_nik() {
        return input_nik;
    }

    public JTextField getInput_noHP() {
        return input_noHP;
    }

    public JTextField getInput_noRumah() {
        return input_noRumah;
    }

    public JTextField getInput_rt() {
        return input_rt;
    }

    public JComboBox<String> getInput_status() {
        return input_status;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btn_daftar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        input_noRumah = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        input_rt = new javax.swing.JTextField();
        input_nama = new javax.swing.JTextField();
        input_status = new javax.swing.JComboBox<>();
        input_noHP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        input_nik = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        input_jabatan = new javax.swing.JComboBox<>();
        btn_hapus = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_warga = new javax.swing.JTable();
        btn_clear = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_byName = new javax.swing.JButton();
        btn_byRt = new javax.swing.JButton();
        btn_byHouse = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pencatatan Warga");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Nama");

        btn_daftar.setBackground(new java.awt.Color(0, 102, 255));
        btn_daftar.setForeground(new java.awt.Color(255, 255, 255));
        btn_daftar.setText("Daftar");
        btn_daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daftarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("No Rumah");

        input_noRumah.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        input_noRumah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_noRumahActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Status");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("RT");

        input_rt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        input_rt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_rtActionPerformed(evt);
            }
        });

        input_nama.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        input_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_namaActionPerformed(evt);
            }
        });

        input_status.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        input_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kawin ", "Belum Kawin" }));
        input_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_statusActionPerformed(evt);
            }
        });

        input_noHP.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        input_noHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_noHPActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("No. Handphone");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Nomor Tanda Penduduk");

        input_nik.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        input_nik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_nikActionPerformed(evt);
            }
        });

        jLabel8.setText("*Pencatatan warga baru harus lapor ketua/wakil RT dan ketua/wakil RW");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Jabatan");

        input_jabatan.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        input_jabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Warga", "Ketua/Wakil RW", "Ketua/Wakil RT", "Sekretaris", "Bendahara", "Seksi" }));
        input_jabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_jabatanActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(new java.awt.Color(153, 0, 0));
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_ubah.setBackground(new java.awt.Color(153, 153, 0));
        btn_ubah.setForeground(new java.awt.Color(255, 255, 255));
        btn_ubah.setText("Ubah");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        table_warga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        table_warga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_wargaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_warga);

        btn_clear.setText("Bersihkan");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("(tidak boleh sama)");

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("(tidak boleh sama)");

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel11.setText("Filter");

        btn_byName.setText("By Nama");
        btn_byName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_byNameActionPerformed(evt);
            }
        });

        btn_byRt.setText("By RT");
        btn_byRt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_byRtActionPerformed(evt);
            }
        });

        btn_byHouse.setText("By Rumah");
        btn_byHouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_byHouseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_byName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_byHouse, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_byRt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(input_noRumah, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(input_rt)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_noHP)
                    .addComponent(input_status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(input_jabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_daftar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(input_nik)
                    .addComponent(input_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(btn_byName)
                    .addComponent(btn_byRt)
                    .addComponent(btn_byHouse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(input_nik, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(input_noRumah, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_rt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_noHP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_status, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_daftar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_clear))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void input_noRumahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_noRumahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_noRumahActionPerformed

    private void input_rtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_rtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_rtActionPerformed

    private void input_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_namaActionPerformed

    private void input_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_statusActionPerformed

    private void input_noHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_noHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_noHPActionPerformed

    private String getValueStatus(int index) {
        String status = "";
        
        switch(index) {
            case 0:
                status = "Kawin";
                break;
            default:
                status = "Belum Kawin"; 
        }
        
        return status;
    }
    
    private String getValueJabatan(int index) {
        String jabatan = "";
        
        switch(index) {
            case 0:
                jabatan = "Warga";
                break;
            case 1:
                jabatan = "Ketua/Wakil RW";
                break;
            case 2:
                jabatan = "Ketua/Wakil RT";
                break;
            case 3:
                jabatan = "Sekretaris";
                break;
            case 4:
                jabatan = "Bendahara";
                break;
            case 5:
                jabatan = "Seksi";
                break;
            default:
                jabatan = "Warga";
        }
        
        return jabatan;
    }
    
    private int getIndexStatus (String value) {
        int index = 0;
        
        if (value.equalsIgnoreCase("Kawin")) {
            index = 0;
        } else {
            index = 1;
        }
        
        return index;
    }
    
    private int getIndexJabatan (String value) {
        int index = 0;
        
        if (value.equalsIgnoreCase("Ketua/Wakil RW")) {
            index = 1;
        } else if(value.equalsIgnoreCase("Ketua/Wakil RT")) {
            index = 2;
        } else if(value.equalsIgnoreCase("Sekretaris")) {
            index = 3;
        } else if(value.equalsIgnoreCase("Bendahara")) {
            index = 4;
        } else if(value.equalsIgnoreCase("Seksi")) {
            index = 5;
        } else {
            index = 1;
        }
        
        return index;
    }
    
    private void btn_daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daftarActionPerformed
        String nik = "", nama = "", no_rumah = "", no_handphone = "", status = "", jabatan = "";
        int rt =  0;
        
        try {
            nik = input_nik.getText();
            rt = Integer.parseInt(input_rt.getText());
            nama = input_nama.getText();
            no_rumah = input_noRumah.getText();
            no_handphone = input_noHP.getText();
            status = getValueStatus(input_status.getSelectedIndex());
            jabatan = getValueJabatan(input_jabatan.getSelectedIndex());
            
            cw.actionInsert(nik, nama, no_rumah, no_handphone, status, jabatan, rt);
            cw.refreshTabel("default");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_daftarActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {        
          cw.actionDelete(input_nik.getText());
          cw.refreshTabel("default");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    public void tampilData() {
        int row = table_warga.getSelectedRow();
        input_nik.setText(table_warga.getValueAt(row, 0).toString());
        input_nama.setText(table_warga.getValueAt(row, 1).toString());
        input_noRumah.setText(table_warga.getValueAt(row, 2).toString());
        input_rt.setText(table_warga.getValueAt(row, 6).toString());
        input_noHP.setText(table_warga.getValueAt(row, 3).toString());
        input_status.setSelectedIndex(getIndexStatus(table_warga.getValueAt(row, 4).toString()));
        input_jabatan.setSelectedIndex(getIndexJabatan(table_warga.getValueAt(row, 5).toString()));
    }
    
    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        String nama = "", no_rumah = "", no_handphone = "", status = "", jabatan = "", nik = "";
        int rt = 0;
        
        try {
            nama = input_nama.getText();
            no_rumah = input_noRumah.getText();
            no_handphone = input_noHP.getText();
            status = getValueStatus(input_status.getSelectedIndex());
            jabatan = getValueJabatan(input_jabatan.getSelectedIndex());
            nik = input_nik.getText();
            rt = Integer.parseInt(input_rt.getText());
            
            cw.actionUpdate(nama, no_rumah, no_handphone, status, jabatan, rt, nik);
            cw.refreshTabel("default");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void input_nikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_nikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_nikActionPerformed

    private void table_wargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_wargaMouseClicked
        tampilData();
    }//GEN-LAST:event_table_wargaMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        input_nik.setText("");
        input_nama.setText("");
        input_noRumah.setText("");
        input_noHP.setText("");
        input_rt.setText("");
        input_status.setSelectedIndex(0);
        input_jabatan.setSelectedIndex(0);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void input_jabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_jabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_jabatanActionPerformed

    private void btn_byNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_byNameActionPerformed
        cw.refreshTabel("name");
    }//GEN-LAST:event_btn_byNameActionPerformed

    private void btn_byRtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_byRtActionPerformed
        cw.refreshTabel("rt");
    }//GEN-LAST:event_btn_byRtActionPerformed

    private void btn_byHouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_byHouseActionPerformed
        cw.refreshTabel("house");
    }//GEN-LAST:event_btn_byHouseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_byHouse;
    private javax.swing.JButton btn_byName;
    private javax.swing.JButton btn_byRt;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_daftar;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JComboBox<String> input_jabatan;
    private javax.swing.JTextField input_nama;
    private javax.swing.JTextField input_nik;
    private javax.swing.JTextField input_noHP;
    private javax.swing.JTextField input_noRumah;
    private javax.swing.JTextField input_rt;
    private javax.swing.JComboBox<String> input_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_warga;
    // End of variables declaration//GEN-END:variables
}
