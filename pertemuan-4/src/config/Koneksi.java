/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.mysql.jdbc.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author naufa
 */
public class Koneksi {
 
    protected Connection konek;
    protected Statement stmt;
    
    public Koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                konek = (Connection) DriverManager.getConnection("jdbc://localhost:3306/telephone_db","root","");
            } catch(SQLException e) {
                // Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("SQL Error" + e);
            }
        } catch(ClassNotFoundException e) {
            System.out.println("Driver Error: " + e);
        }
    }
    
    public Statement createStatement() throws SQLException {
        return stmt = konek.createStatement();
    }
    
}
