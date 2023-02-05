/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author anzt
 */
public class OrderDetail {
    
    private Integer id;
    private Order orders;
    private Item items;
    private Integer qty;
    private Double subtotal;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Order getOrders() {
	return orders;
    }

    public void setOrders(Order orders) {
	this.orders = orders;
    }

    public Item getItems() {
	return items;
    }

    public void setItems(Item items) {
	this.items = items;
    }

    public Integer getQty() {
	return qty;
    }

    public void setQty(Integer qty) {
	this.qty = qty;
    }

    public Double getSubtotal() {
	return subtotal;
    }

    public void setSubtotal(Double subtotal) {
	this.subtotal = subtotal;
    }
    
    private Connection koneksiItem;

    public void setConnection(Connection koneksiItem) {
	this.koneksiItem = koneksiItem;
    }
    
    public void insert(OrderDetail orderDetails) throws SQLException{
	String queryInsert
		= "INSERT INTO order_details (order_id, item_id, qty, subtotal) "
		+ "VALUES (?,?,?,?)";
	PreparedStatement insertStatement = this.koneksiItem.prepareStatement(queryInsert);
	insertStatement.setString(1, orderDetails.getOrders().getId());
	insertStatement.setString(2, orderDetails.getItems().getId());
	insertStatement.setInt(3, orderDetails.getQty());
	insertStatement.setDouble(4, orderDetails.getSubtotal());
	insertStatement.executeUpdate();
    }
}
