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

/**
 *
 * @author anzt
 */
public class Customer {
    
    private String id;
    private String name;
    private Boolean status;
    private String handphone;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Boolean getStatus() {
	return status;
    }

    public void setStatus(Boolean status) {
	this.status = status;
    }

    public String getHandphone() {
	return handphone;
    }

    public void setHandphone(String handphone) {
	this.handphone = handphone;
    }
    
    private Connection koneksiItem;

    public void setConnection(Connection koneksiItem) {
	this.koneksiItem = koneksiItem;
    }
    
    public Customer getById(String id) throws SQLException {
	String queryId = "SELECT * FROM customers WHERE id = ?";
	PreparedStatement getIdStatement = this.koneksiItem.prepareStatement(queryId);
	getIdStatement.setString(1, id);
	ResultSet rs = getIdStatement.executeQuery();
	Customer customers = new Customer();
	if(rs.first()){
	    customers.setId(rs.getString("id"));
	    customers.setName(rs.getString("name"));
	    customers.setStatus(rs.getBoolean("status"));
	    customers.setHandphone(rs.getString("handphone"));
//	    return items;
	}
	return customers;
    }
}
