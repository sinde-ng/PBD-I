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
import view.View_Mahasiswa;

/**
 *
 * @author naufa
 */
public class Mahasiswa {
    
    private int nim;
    private String nama;
    private String jenis_kelamin;

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }
    
    private Connection koneksiMHS;
    
    public void setConnection(Connection koneksiMHS) {
	this.koneksiMHS = koneksiMHS;
    }
    
    public void insert(Mahasiswa mhs) throws SQLException {
	String queryInsert
		= "INSERT INTO mahasiswa (nim, nama, jenis_kelamin) "
		+ "VALUES (?,?,?)";
	PreparedStatement insertStatement = this.koneksiMHS.prepareStatement(queryInsert);
	insertStatement.setInt(1, mhs.getNim());
	insertStatement.setString(2, mhs.getNama());
	insertStatement.setString(3, mhs.getJenis_kelamin());
	insertStatement.executeUpdate();
    }
    
    public List<Mahasiswa> getAll() throws SQLException {
	List<Mahasiswa> listMhs = new ArrayList<>();
	String queryAll = "SELECT * FROM mahasiswa";
	PreparedStatement getAllStatement = this.koneksiMHS.prepareStatement(queryAll);
	ResultSet rs = getAllStatement.executeQuery();
	while(rs.next()){
	    Mahasiswa mhs = new Mahasiswa();
	    mhs.setNim(rs.getInt("nim"));
	    mhs.setNama(rs.getString("nama"));
            mhs.setJenis_kelamin(rs.getString("jenis_kelamin"));
	    listMhs.add(mhs);
	}
	return listMhs;
    }

//    public void update(Item items) throws SQLException {
//	String queryUpdate
//		= "UPDATE item SET name=?, stock=?, price=? "
//		+ "WHERE id=?";
//	PreparedStatement updateStatement = this.koneksiItem.prepareStatement(queryUpdate);
//	updateStatement.setString(1, items.getName());
//	updateStatement.setInt(2, items.getStock());
//	updateStatement.setDouble(3, items.getPrice());
//	updateStatement.setString(4, items.getId());
//	updateStatement.executeUpdate();
//    }
//
//    public void delete(Item items) throws SQLException {
//	String queryDelete = "DELETE FROM item WHERE id = ?";
//	PreparedStatement deleteStatement = this.koneksiItem.prepareStatement(queryDelete);
//	deleteStatement.setString(1, items.getId());
//	deleteStatement.executeUpdate();
//    }
    
}
