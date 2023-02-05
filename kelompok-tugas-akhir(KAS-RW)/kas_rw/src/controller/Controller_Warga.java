/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.Koneksi;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Model_Warga;
import view.View_Warga;

/**
 *
 * @author naufa
 */
public class Controller_Warga {
    
    private final Model_Warga warga;
    private final View_Warga wargaView;
    private List<Model_Warga> listWarga;
    
    public Controller_Warga(View_Warga wargaView) {
        this.wargaView = wargaView;
        warga = new Model_Warga();
        warga.setConnection(Koneksi.getKoneksi());
    }
    
    public void refreshTabel(String by) {
        try {
            listWarga = warga.getAll(by);
            WargaTableModel wtm = new WargaTableModel(listWarga);
            wargaView.getTable_warga().setModel(wtm);
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Warga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actionDelete(String nik) {
        try {
            warga.delete(nik);
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Warga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actionInsert(String nik, String nama, String no_rumah, String no_handphone, String status, String jabatan, int rt) {
        try {
            warga.insert(nik, nama, no_rumah, no_handphone, status, jabatan, rt);
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Warga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actionUpdate(String nama, String no_rumah, String no_handphone, String status, String jabatan, int rt, String nik) {
        try {
            warga.update(nama, no_rumah, no_handphone, status, jabatan, rt, nik);
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Warga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public class WargaTableModel extends AbstractTableModel {
        
        private List<Model_Warga> listWarga;
        private String[] columnNames = {"No.KTP", "Nama", "No.Rumah", "No.HP", "Status", "Jabatan", "RT"};
        
        public WargaTableModel(List<Model_Warga> listWarga) {
            this.listWarga = listWarga;
        }
        
        @Override
        public int getRowCount() {
            return this.listWarga.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }
        
        @Override
        public String getColumnName(int i) {
            return columnNames[i];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Model_Warga w = listWarga.get(rowIndex);
            
            switch(columnIndex) {
                case 0:
                    return w.getNik();
                case 1:
                    return w.getNama();
                case 2:
                    return w.getNo_rumah();
                case 3:
                    return w.getNo_handphone();
                case 4:
                    return w.getStatus();
                case 5:
                    return w.getJabatan();
                case 6:
                    String rt = w.getRt() < 10 ? "0"+w.getRt() : ""+w.getRt();
                    return rt;
                default:
                    return "";
            }
        }
        
    }
    
}
