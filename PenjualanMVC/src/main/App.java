/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.Koneksi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import model.Item;
import model.OrderDetail;
import model.Order;
import view.MenuView;

/**
 *
 * @author anzt
 */
public class App {

    private static MenuView menuView;

    public static MenuView getMenuView() {
	return menuView;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	menuView = new MenuView();
	menuView.setVisible(true);
	    // TODO code application logic here
//	    Order orderanKedua = new Order();
//	    orderanKedua.setConnection(Koneksi.getKoneksi());
//	    orderanKedua.setId("TR002");
//	    java.util.Date now = new Date(); // ambil tanggal dan waktu sekarang
//	    orderanKedua.setOrderDate(new java.sql.Timestamp(now.getTime()));
//	    Customer pelangganSatu = new Customer();
//	    pelangganSatu.setConnection(Koneksi.getKoneksi());
//	    orderanKedua.setCustomer(pelangganSatu.getById("C001")); // ambil pelanggan C001
//	    orderanKedua.setGrandTotal(1500000.0);
//	    orderanKedua.insert(orderanKedua);
//	    
//	    
//	    Item item1 = new Item();
//	    item1.setConnection(Koneksi.getKoneksi());
//	    item1 = item1.getById("A001");
//	    OrderDetail detailOrderan = new OrderDetail();
//	    detailOrderan.setConnection(Koneksi.getKoneksi());
//	    detailOrderan.setOrders(orderanKedua);
//	    detailOrderan.setItems(item1);
//	    detailOrderan.setQty(5);
//	    detailOrderan.setSubtotal(item1.getPrice() * 5);
//	    detailOrderan.insert(detailOrderan);
	    
	
	
    }
    
}// end of class
