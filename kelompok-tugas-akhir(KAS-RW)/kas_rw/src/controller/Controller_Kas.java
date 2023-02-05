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
import javax.swing.JOptionPane;
import model.Model_KasWarga;
import view.View_Kas;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author naufa
 */
public class Controller_Kas {
    
    private final Model_KasWarga kasWarga;
    private final View_Kas kasView;
    private List<Model_KasWarga> listKas;
    
    public Controller_Kas(View_Kas kasView) {
        this.kasView = kasView;
        kasWarga = new Model_KasWarga();
        kasWarga.setConnection(Koneksi.getKoneksi());
    }
    
    public void refreshTabel() {
        try {
            listKas = kasWarga.getAll();
            KasTableModel ktm = new KasTableModel(listKas);
            kasView.getTable_kas().setModel(ktm);
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Kas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actionDelete(int id_kas) {
        try {
            kasWarga.delete(id_kas);
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Kas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actionInsert(String nik, String tanggal_bayar, int jumlah) {
        try {
            kasWarga.insert(nik, tanggal_bayar, jumlah);
        } catch (SQLException ex) {
        }
    }
    
    public class KasTableModel extends AbstractTableModel {
        
        private List<Model_KasWarga> listKas;
        private String[] columnNames = {"ID", "No.KTP", "Tanggal", "Jumlah"};

        public KasTableModel(List<Model_KasWarga> listKas) {
            this.listKas = listKas;
        }
        
        @Override
        public int getRowCount() {
            return this.listKas.size();
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
            Model_KasWarga kw = listKas.get(rowIndex);
            
            switch(columnIndex) {
                case 0:
                    return kw.getId();
                case 1:
                    return kw.getNik();
                case 2:
                    return kw.getTanggal_bayar();
                case 3:
                    return kw.getJumlah();
                default:
                    return "";
            }
        }
    }
    
}
