/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.Koneksi;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author naufa
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Koneksi konek = new Koneksi();
            Statement stmt = konek.createStatement();
            
            String sqlInsert = "INSERT INTO bukutelephone_tb " + "(nama,alamat,no_telp,no_hp) " + "VALUES ('Andi','Pekalongan','021678978','08583572782999')";
            stmt.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e);
        }
        
    }
    
}
