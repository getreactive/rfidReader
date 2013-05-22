/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.store;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rahul
 */
public class AppTagDb extends DbConnectionLite{
    String sUrlString = "jdbc:sqlite:hello.db";
    AppTagDb mydb = new AppTagDb("org.sqlite.JDBC",sUrlString);

    private AppTagDb(String orgsqliteJDBC, String sUrlString) {
        try {
            init(orgsqliteJDBC, sUrlString);
        } catch (Exception ex) {
            Logger.getLogger(AppTagDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(conn != null)
            {
            System.out.println("Connected OK using " + orgsqliteJDBC + " to " + sUrlString);
            }
        else
            {
            System.out.println("Connection failed");
            }
    }
    public static void main(String[] args){
     AppTagDb ab = new AppTagDb();
    }

    private AppTagDb() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
