/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
                konek = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_atm","root","");
            } catch(SQLException e) {
                System.out.println("SQL Error: " + e);
            }
        } catch(ClassNotFoundException e) {
            System.out.println("Driver Error: " + e);
        }
    }
    
    public Statement createStatement() throws SQLException {
        return stmt = konek.createStatement();
    }
    
}
