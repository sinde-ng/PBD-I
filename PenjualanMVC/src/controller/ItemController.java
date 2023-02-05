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
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import model.Item;
import view.ItemView;

/**
 *
 * @author anzt
 */
public class ItemController {

    private final Item item; // model item
    private final ItemView itemView; // view item
    private List<Item> listItems; // list item untuk menyimpan semua item

    public ItemController(ItemView itemView) {
	this.itemView = itemView;
	item = new Item();
	item.setConnection(Koneksi.getKoneksi());
    }
    
    public void refreshTabel(){
	try {
	    listItems = item.getAll();
	    ItemTableModel itemTableModel = new ItemTableModel(listItems);
	    itemView.getTabelItem().setModel(itemTableModel);
	} catch (SQLException ex) {
	    Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public static class ItemTableModel extends AbstractTableModel {

	private final List<Item> listItems;
	private final String[] columnNames = {"ID", "Name", "Stock", "Price"};

	public ItemTableModel(List<Item> listItems) {
	    this.listItems = listItems;
	}

	@Override
	public String getColumnName(int i) {
	    return columnNames[i];
	}

	@Override
	public int getRowCount() {
	    return this.listItems.size();
	}

	@Override
	public int getColumnCount() {
	    return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	    Item item = listItems.get(rowIndex);
	    switch (columnIndex) {
		case 0:
		    return item.getId();
		case 1:
		    return item.getName();
		case 2:
		    return item.getStock();
		case 3:
		    return item.getPrice();
		default:
		    return "";
	    }
	}

    }

    public static class ItemTableSelectionListener implements ListSelectionListener {

        private JTable tabel;
	private List<Item> listItems;
	private Item item;
	
        public ItemTableSelectionListener(JTable tabel, List<Item> listItems) {
            this.tabel = tabel;
	    this.listItems = listItems;
        }

	public Item getItem() {
	    return item;
	}

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (tabel.getSelectedRow() >= 0) {
                item = listItems.get(tabel.getSelectedRow());
            }
        }

    }
}
