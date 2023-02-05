/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author anzt
 */
public class Order {
    
    private String id;
    private Timestamp orderDate;
    private Customer customer;
    private Double grandTotal;
    private List<OrderDetail> orderDetails;

    public List<OrderDetail> getOrderDetails() {
	return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
	this.orderDetails = orderDetails;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public Timestamp getOrderDate() {
	return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
	this.orderDate = orderDate;
    }

    public Customer getCustomer() {
	return customer;
    }

    public void setCustomer(Customer customer) {
	this.customer = customer;
    }

    public Double getGrandTotal() {
	return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
	this.grandTotal = grandTotal;
    }
    
    private Connection koneksiItem;

    public void setConnection(Connection koneksiItem) {
	this.koneksiItem = koneksiItem;
    }
    
    public void insert(Order orders) throws SQLException{
	String queryInsert
		= "INSERT INTO orders (id, order_date, customer_id, grand_total) "
		+ "VALUES (?,?,?,?)";
	PreparedStatement insertStatement = this.koneksiItem.prepareStatement(queryInsert);
	insertStatement.setString(1, orders.getId());
	insertStatement.setTimestamp(2, orders.getOrderDate());
	insertStatement.setString(3, orders.getCustomer().getId());
	insertStatement.setDouble(4, orders.getGrandTotal());
	insertStatement.executeUpdate();
    }
}
