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
 * @author anzt
 */
public class Item {

    private String id;
    private String name;
    private int stock;
    private Double price;

    // getter dan setter
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

    public int getStock() {
	return stock;
    }

    public void setStock(int stock) {
	this.stock = stock;
    }

    public Double getPrice() {
	return price;
    }

    public void setPrice(Double price) {
	this.price = price;
    }

    private Connection koneksiItem;

    public void setConnection(Connection koneksiItem) {
	this.koneksiItem = koneksiItem;
    }

    public void insert(Item items) throws SQLException {
	String queryInsert
		= "INSERT INTO item (id, name, stock, price) "
		+ "VALUES (?,?,?,?)";
	PreparedStatement insertStatement = this.koneksiItem.prepareStatement(queryInsert);
	insertStatement.setString(1, items.getId());
	insertStatement.setString(2, items.getName());
	insertStatement.setInt(3, items.getStock());
	insertStatement.setDouble(4, items.getPrice());
	insertStatement.executeUpdate();
    }

    public void update(Item items) throws SQLException {
	String queryUpdate
		= "UPDATE item SET name=?, stock=?, price=? "
		+ "WHERE id=?";
	PreparedStatement updateStatement = this.koneksiItem.prepareStatement(queryUpdate);
	updateStatement.setString(1, items.getName());
	updateStatement.setInt(2, items.getStock());
	updateStatement.setDouble(3, items.getPrice());
	updateStatement.setString(4, items.getId());
	updateStatement.executeUpdate();
    }

    public void delete(Item items) throws SQLException {
	String queryDelete = "DELETE FROM item WHERE id = ?";
	PreparedStatement deleteStatement = this.koneksiItem.prepareStatement(queryDelete);
	deleteStatement.setString(1, items.getId());
	deleteStatement.executeUpdate();
    }

    public List<Item> getAll() throws SQLException {
	List<Item> listItems = new ArrayList<>();
	String queryAll = "SELECT * FROM item";
	PreparedStatement getAllStatement = this.koneksiItem.prepareStatement(queryAll);
	ResultSet rs = getAllStatement.executeQuery();
	while(rs.next()){
	    Item items = new Item();
	    items.setId(rs.getString("id"));
	    items.setName(rs.getString("name"));
	    items.setStock(rs.getInt("stock"));
	    items.setPrice(rs.getDouble("price"));
	    listItems.add(items);
	}
	return listItems;
    }
    
    public List<Item> findBy(String cari) throws SQLException {
	List<Item> listItems = new ArrayList<>();
	String queryAll = "SELECT * FROM item WHERE id LIKE ?";
	PreparedStatement findStatement = this.koneksiItem.prepareStatement(queryAll);
	findStatement.setString(1, "%"+cari+"%");
	ResultSet rs = findStatement.executeQuery();
	while(rs.next()){
	    Item items = new Item();
	    items.setId(rs.getString("id"));
	    items.setName(rs.getString("name"));
	    items.setStock(rs.getInt("stock"));
	    items.setPrice(rs.getDouble("price"));
	    listItems.add(items);
	}
	return listItems;
    }

    public Item getById(String id) throws SQLException {
	String queryId = "SELECT * FROM item WHERE id = ?";
	PreparedStatement getIdStatement = this.koneksiItem.prepareStatement(queryId);
	getIdStatement.setString(1, id);
	ResultSet rs = getIdStatement.executeQuery();
	Item items = new Item();
	if(rs.first()){
	    items.setId(rs.getString("id"));
	    items.setName(rs.getString("name"));
	    items.setStock(rs.getInt("stock"));
	    items.setPrice(rs.getDouble("price"));
	}
	return items;
    }
} // end of class
