/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author naufa
 */
public class Model_KasWarga {
    private int id;
    private String nik;
    private String tanggal_bayar;
    private int jumlah;
    
    private String nama;
    private String no_rumah;
    private int rt;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_rumah() {
        return no_rumah;
    }

    public void setNo_rumah(String no_rumah) {
        this.no_rumah = no_rumah;
    }

    public int getRt() {
        return rt;
    }

    public void setRt(int rt) {
        this.rt = rt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getTanggal_bayar() {
        return tanggal_bayar;
    }

    public void setTanggal_bayar(String tanggal_bayar) {
        this.tanggal_bayar = tanggal_bayar;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Connection getKoneksiKasWarga() {
        return koneksiKasWarga;
    }

    public void setKoneksiKasWarga(Connection koneksiKasWarga) {
        this.koneksiKasWarga = koneksiKasWarga;
    }
    
    private Connection koneksiKasWarga;
    
    public void setConnection(Connection koneksiKasWarga) {
	this.koneksiKasWarga = koneksiKasWarga;
    }
    
    public void insert(String nik, String tanggal_bayar, int jumlah) throws SQLException {
	String queryInsert
		= "INSERT INTO kas_warga (no_ktp, tanggal_bayar, jumlah) "
		+ "VALUES (?,?,?)";
        
        
        try {
            PreparedStatement insertStatement = this.koneksiKasWarga.prepareStatement(queryInsert);
	
            insertStatement.setString(1, nik);
            insertStatement.setString(2, tanggal_bayar);
            insertStatement.setInt(3, jumlah);
            
            insertStatement.executeUpdate();
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "Ganti NIK yang lain, karena NIK ("+nik+") sudah terdaftar!");
            }
        }
    }
    
    public void update(Model_KasWarga kasWarga) throws SQLException {
	String queryUpdate
		= "UPDATE kas_warga SET no_ktp=?, tanggal_bayar=?, jumlah=? "
		+ "WHERE id_kas=?";
        
	PreparedStatement updateStatement = this.koneksiKasWarga.prepareStatement(queryUpdate);
	
	updateStatement.setString(1, kasWarga.getNik());
	updateStatement.setString(2, kasWarga.getTanggal_bayar());
	updateStatement.setInt(3, kasWarga.getJumlah());
        updateStatement.setInt(4, kasWarga.getId());
	
        updateStatement.executeUpdate();
    }
    
    public void delete(int id_kas) throws SQLException {
	String queryDelete = "DELETE FROM kas_warga WHERE id_kas=?";
        
	PreparedStatement deleteStatement = this.koneksiKasWarga.prepareStatement(queryDelete);
	
        deleteStatement.setInt(1, id_kas);
	
        deleteStatement.executeUpdate();
    }
    
    public List<Model_KasWarga> getAll() throws SQLException {
	List<Model_KasWarga> listKasWarga = new ArrayList<>();
	
        String queryAll = "SELECT * FROM kas_warga";
	
        PreparedStatement getAllStatement = this.koneksiKasWarga.prepareStatement(queryAll);
	ResultSet rs = getAllStatement.executeQuery();
        
	while(rs.next()){
	    Model_KasWarga kasWarga = new Model_KasWarga();
           
            kasWarga.setId(rs.getInt("id_kas"));
	    kasWarga.setNik(rs.getString("no_ktp"));
	    kasWarga.setTanggal_bayar(rs.getString("tanggal_bayar"));
	    kasWarga.setJumlah(rs.getInt("jumlah"));
            
	    listKasWarga.add(kasWarga);
	}
	return listKasWarga;
    }
    
    public List<Model_KasWarga> getDataforBook(String by) throws SQLException {
        List<Model_KasWarga> listDataKas = new ArrayList<>();
        
        String query = "";
        if (by.equalsIgnoreCase("name")) {
            query = "SELECT w.nama, w.no_rumah, w.rt, k.tanggal_bayar, k.jumlah FROM warga AS w, kas_warga AS k WHERE w.no_ktp = k.no_ktp ORDER BY w.nama ASC";
        } else if(by.equalsIgnoreCase("house")) {
            query = "SELECT w.nama, w.no_rumah, w.rt, k.tanggal_bayar, k.jumlah FROM warga AS w, kas_warga AS k WHERE w.no_ktp = k.no_ktp ORDER BY w.no_rumah ASC;";
        } else if(by.equalsIgnoreCase("rt")) {
            query = "SELECT w.nama, w.no_rumah, w.rt, k.tanggal_bayar, k.jumlah FROM warga AS w, kas_warga AS k WHERE w.no_ktp = k.no_ktp ORDER BY w.rt ASC;";
        } else if(by.equalsIgnoreCase("money")) {
            query = "SELECT w.nama, w.no_rumah, w.rt, k.tanggal_bayar, k.jumlah FROM warga AS w, kas_warga AS k WHERE w.no_ktp = k.no_ktp ORDER BY k.jumlah DESC";
        } else {
            query = "SELECT w.nama, w.no_rumah, w.rt, k.tanggal_bayar, k.jumlah FROM warga AS w, kas_warga AS k WHERE w.no_ktp = k.no_ktp ORDER BY k.tanggal_bayar DESC";
        }
        
        PreparedStatement getAllStatement = this.koneksiKasWarga.prepareStatement(query);
	ResultSet rs = getAllStatement.executeQuery();
        
        while(rs.next()) {
            Model_KasWarga detailKas = new Model_KasWarga();
            
            detailKas.setNama(rs.getString("w.nama"));
            detailKas.setNo_rumah(rs.getString("w.no_rumah"));
            detailKas.setRt(rs.getInt("w.rt"));
            detailKas.setTanggal_bayar(rs.getString("k.tanggal_bayar"));
            detailKas.setJumlah(rs.getInt("k.jumlah"));
            
            listDataKas.add(detailKas);
        }
        
        return listDataKas;
    }
    
    public List<Model_KasWarga> findBy(String cari) throws SQLException {
	List<Model_KasWarga> listKasWarga = new ArrayList<>();
        
	String queryAll = "SELECT * FROM kas_warga WHERE id_kas LIKE ?";
        
	PreparedStatement findStatement = this.koneksiKasWarga.prepareStatement(queryAll);
	findStatement.setString(1, "%"+cari+"%");
	ResultSet rs = findStatement.executeQuery();
        
	while(rs.next()){
	    Model_KasWarga kasWarga = new Model_KasWarga();
            
	    kasWarga.setId(rs.getInt("id_kas"));
	    kasWarga.setNik(rs.getString("no_ktp"));
	    kasWarga.setTanggal_bayar(rs.getString("tanggal_bayar"));
	    kasWarga.setJumlah(rs.getInt("jumlah"));
            
	    listKasWarga.add(kasWarga);
	}
	return listKasWarga;
    }
    
    public Model_KasWarga getById(String id) throws SQLException {
	String queryId = "SELECT * FROM kas_warga WHERE id_kas=?";
        
	PreparedStatement getIdStatement = this.koneksiKasWarga.prepareStatement(queryId);
	getIdStatement.setString(1, id);
	ResultSet rs = getIdStatement.executeQuery();
        
	Model_KasWarga kasWarga = new Model_KasWarga();
        
	if(rs.first()){
	    kasWarga.setId(rs.getInt("id_kas"));
	    kasWarga.setNik(rs.getString("no_ktp"));
	    kasWarga.setTanggal_bayar(rs.getString("tanggal_bayar"));
	    kasWarga.setJumlah(rs.getInt("jumlah"));
	}
	return kasWarga;
    }
}
