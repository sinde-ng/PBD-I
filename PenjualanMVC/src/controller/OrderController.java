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
import model.Item;
import model.Order;
import model.OrderDetail;
import view.CariDialogView;
import view.MenuView;
import view.OrderView;

/**
 *
 * @author anzt
 */
public class OrderController {
    
    private Item item;
    
    private List<Item> listItems;
    
    private OrderView orderView;

    public OrderController(OrderView orderView) {
	this.orderView = orderView;
	item = new Item();
	item.setConnection(Koneksi.getKoneksi());
    }
    
    
    
    public void cariItem(String cari){
	try {
	    MenuView mv = new MenuView();
	    CariDialogView cdv = new CariDialogView(mv, true);
	    listItems = item.findBy(cari);
	    ItemController.ItemTableModel btm = new ItemController.ItemTableModel(listItems);
	    cdv.getTabelCari().setModel(btm);
	    ItemController.ItemTableSelectionListener its = new ItemController.ItemTableSelectionListener(cdv.getTabelCari(), listItems);
	    cdv.getTabelCari().getSelectionModel()
		    .addListSelectionListener(its);
	    cdv.setVisible(true);
	    orderView.getTextItemId().setText(its.getItem().getId());
	    orderView.getTextPrice().setText(its.getItem().getPrice().toString());
	} catch (SQLException ex) {
	    Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}
