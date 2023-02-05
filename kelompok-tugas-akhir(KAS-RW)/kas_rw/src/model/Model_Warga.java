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

/**
 *
 * @author naufa
 */
public class Model_Warga {
    private String nik;
    private String nama;
    private String no_rumah;
    private String no_handphone;
    private String status;
    private String jabatan;
    private int rt;

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRt() {
        return rt;
    }

    public void setRt(int rt) {
        this.rt = rt;
    }

    public String getNo_handphone() {
        return no_handphone;
    }

    public void setNo_handphone(String no_handphone) {
        this.no_handphone = no_handphone;
    }

    public Connection getKoneksiWarga() {
        return koneksiWarga;
    }

    public void setKoneksiWarga(Connection koneksiWarga) {
        this.koneksiWarga = koneksiWarga;
    }
    
    private Connection koneksiWarga;
    
    public void setConnection(Connection koneksiWarga) {
	this.koneksiWarga = koneksiWarga;
    }
    
    public void insert(String nik, String nama, String no_rumah, String no_handphone, String status, String jabatan, int rt) throws SQLException {
	String queryInsert
		= "INSERT INTO warga (no_ktp, nama, no_rumah, no_handphone, status, jabatan, rt) "
		+ "VALUES (?,?,?,?,?,?,?)";
	
        PreparedStatement insertStatement = this.koneksiWarga.prepareStatement(queryInsert);
	
        insertStatement.setString(1, nik);
        insertStatement.setString(2, nama);
        insertStatement.setString(3, no_rumah);
        insertStatement.setString(4, no_handphone);
        insertStatement.setString(5, status);
        insertStatement.setString(6, jabatan);
        insertStatement.setInt(7, rt);
        
	insertStatement.executeUpdate();
    }
    
    public void update(String nama, String no_rumah, String no_handphone, String status, String jabatan, int rt, String nik) throws SQLException {
	String queryUpdate
		= "UPDATE warga SET nama=?, no_rumah=?, no_handphone=?, status=?, jabatan=?, rt=? "
		+ "WHERE no_ktp=?";
        
	PreparedStatement updateStatement = this.koneksiWarga.prepareStatement(queryUpdate);
	
        updateStatement.setString(1, nama);
        updateStatement.setString(2, no_rumah);
        updateStatement.setString(3, no_handphone);
        updateStatement.setString(4, status);
        updateStatement.setString(5, jabatan);
        updateStatement.setInt(6, rt);
        updateStatement.setString(7, nik);
	
        updateStatement.executeUpdate();
    }
    
    public void delete(String nik) throws SQLException {
	String queryDelete = "DELETE FROM warga WHERE no_ktp=?";
        
	PreparedStatement deleteStatement = this.koneksiWarga.prepareStatement(queryDelete);
	
        deleteStatement.setString(1, nik);
	
        deleteStatement.executeUpdate();
    }
    
    public List<Model_Warga> getAll(String by) throws SQLException {
	List<Model_Warga> listWarga = new ArrayList<>();
	
        String queryAll = "";
        if (by.equalsIgnoreCase("house")) {
            queryAll = "SELECT * FROM warga ORDER BY no_rumah ASC;";
        } else if (by.equalsIgnoreCase("rt")) {
            queryAll = "SELECT * FROM warga ORDER BY rt ASC;";
        } else if (by.equalsIgnoreCase("name")) {
            queryAll = "SELECT * FROM warga ORDER BY nama ASC";
        } else {
            queryAll = "SELECT * FROM warga";
        }        
	
        PreparedStatement getAllStatement = this.koneksiWarga.prepareStatement(queryAll);
	ResultSet rs = getAllStatement.executeQuery();
        
	while(rs.next()){
	    Model_Warga warga = new Model_Warga();
            
            warga.setNik(rs.getString("no_ktp"));
            warga.setNama(rs.getString("nama"));
            warga.setNo_rumah(rs.getString("no_rumah"));
            warga.setNo_handphone(rs.getString("no_handphone"));
            warga.setStatus(rs.getString("status"));
            warga.setJabatan(rs.getString("jabatan"));
            warga.setRt(rs.getInt("rt"));
            
	    listWarga.add(warga);
	}
	return listWarga;
    }
    
    public List<Model_Warga> findBy(String cari) throws SQLException {
	List<Model_Warga> listWarga = new ArrayList<>();
        
	String queryAll = "SELECT * FROM warga WHERE no_ktp LIKE ?";
        
	PreparedStatement findStatement = this.koneksiWarga.prepareStatement(queryAll);
	findStatement.setString(1, "%"+cari+"%");
	ResultSet rs = findStatement.executeQuery();
        
	while(rs.next()){
	    Model_Warga warga = new Model_Warga();
            
	    warga.setNik(rs.getString("no_ktp"));
            warga.setNama(rs.getString("nama"));
            warga.setNo_rumah(rs.getString("no_rumah"));
            warga.setNo_handphone(rs.getString("no_handphone"));
            warga.setStatus(rs.getString("status"));
            warga.setJabatan(rs.getString("jabatan"));
            warga.setRt(rs.getInt("rt"));
            
	    listWarga.add(warga);
	}
	return listWarga;
    }
    
    public Model_Warga getById(String nik) throws SQLException {
	String queryId = "SELECT * FROM warga WHERE no_ktp=?";
        
	PreparedStatement getNikStatement = this.koneksiWarga.prepareStatement(queryId);
	getNikStatement.setString(1, nik);
	ResultSet rs = getNikStatement.executeQuery();
        
	Model_Warga warga = new Model_Warga();
        
	if(rs.first()){
	    warga.setNik(rs.getString("no_ktp"));
            warga.setNama(rs.getString("nama"));
            warga.setNo_rumah(rs.getString("no_rumah"));
            warga.setNo_handphone(rs.getString("no_handphone"));
            warga.setStatus(rs.getString("status"));
            warga.setJabatan(rs.getString("jabatan"));
            warga.setRt(rs.getInt("rt"));
	}
	return warga;
    }
}
