/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.Koneksi;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Model_KasWarga;
import view.View_BukuKas;

/**
 *
 * @author naufa
 */
public class Controller_Buku {
    
    private final Model_KasWarga kasWarga;
    private final View_BukuKas bukuView;
    private List<Model_KasWarga> listCatatan;

    public Controller_Buku(View_BukuKas bukuView) {
        this.bukuView = bukuView;
        kasWarga = new Model_KasWarga();
        kasWarga.setConnection(Koneksi.getKoneksi());
    }
    
    public void refreshTable(String by) {
        try {
            listCatatan = kasWarga.getDataforBook(by);
            BukuTableModel btm = new BukuTableModel(listCatatan);
            bukuView.getTable_kas().setModel(btm);
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Buku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public class BukuTableModel extends AbstractTableModel {
        
        private List<Model_KasWarga> listCatatan;
        private String[] columnNames = {"Nama", "No. Rumah", "RT", "Tanggal", "Jumlah"};

        public BukuTableModel(List<Model_KasWarga> listCatatan) {
            this.listCatatan = listCatatan;
        }

        @Override
        public int getRowCount() {
            return this.listCatatan.size();
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
            Model_KasWarga kw = listCatatan.get(rowIndex);
            
            switch(columnIndex) {
                case 0:
                    return kw.getNama();
                case 1:
                    return kw.getNo_rumah();
                case 2:
                    String rt = kw.getRt() < 10 ? "0"+kw.getRt() : ""+kw.getRt();
                    return rt;
                case 3:
                    return kw.getTanggal_bayar();
                case 4:
                    return kw.getJumlah();
                default:
                    return "";
            }
        }
    }
}
