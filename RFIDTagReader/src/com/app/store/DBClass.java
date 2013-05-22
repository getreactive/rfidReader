/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.store;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author rahul
 */
public class DBClass {
    
    String sDriverName = "org.sqlite.JDBC";
    String sTempDb = "rfidDB.db";
    String sJdbc = "jdbc:sqlite";
    String sDbUrl = sJdbc + ":" + sTempDb;
    Connection conn = null;
    
    
    public Connection conn() { 
        try{
        Class.forName(sDriverName);
        }catch(Exception e) { System.out.println("Connection Exception "+e);}
        try {
            conn = DriverManager.getConnection(sDbUrl);
        } catch (SQLException ex) {
            Logger.getLogger(DBClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
