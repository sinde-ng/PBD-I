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
import model.Mahasiswa;
import view.View_Mahasiswa;

/**
 *
 * @author naufa
 */
public class Controller_Mahasiswa {
    
    private final Mahasiswa mhs;
    private final View_Mahasiswa viewMhs;
    private List<Mahasiswa> listMhs;

    public Controller_Mahasiswa(View_Mahasiswa viewMhs) {
        this.viewMhs = viewMhs;
        mhs = new Mahasiswa();
        mhs.setConnection(Koneksi.getKoneksi());
    }
    
    public void refreshTabel(){
	try {
	    listMhs = mhs.getAll();
	    ItemTableModel itemTableModel = new ItemTableModel(listMhs);
	    viewMhs.getTableMhs().setModel(itemTableModel);
	} catch (SQLException ex) {
	    Logger.getLogger(Controller_Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public static class ItemTableModel extends AbstractTableModel {

	private final List<Mahasiswa> listMhs;
	private final String[] columnNames = {"NIM", "Nama", "Jenis Kelamin"};

	public ItemTableModel(List<Mahasiswa> listMhs) {
	    this.listMhs = listMhs;
	}

	@Override
	public String getColumnName(int i) {
	    return columnNames[i];
	}

	@Override
	public int getRowCount() {
	    return this.listMhs.size();
	}

	@Override
	public int getColumnCount() {
	    return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	    Mahasiswa mhs = listMhs.get(rowIndex);
            
	    switch (columnIndex) {
		case 0:
		    return mhs.getNim();
		case 1:
		    return mhs.getNama();
		case 2:
		    return mhs.getJenis_kelamin();
		default:
		    return "";
	    }
	}

    }
    
    public void actionInsert() {
        try {
            mhs.setNim(Integer.parseInt(viewMhs.getText_nim().getText()));
            mhs.setNama(viewMhs.getText_nama().getText());
            
            String jk = "";
            if (viewMhs.getCombo_jk().getSelectedIndex() == 0) {
                jk = "Laki Laki";
            } else {
                jk = "Perempuan";
            }
            mhs.setJenis_kelamin(jk);
            
            mhs.insert(mhs);
        } catch (SQLException ex) {
            Logger.getLogger(Controller_Mahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clear() {
        viewMhs.getText_nim().setText(null);
        viewMhs.getText_nama().setText("");
        viewMhs.getCombo_jk().setSelectedIndex(0);
    }
    
}
