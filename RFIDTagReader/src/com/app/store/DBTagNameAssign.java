/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rahul
 */
public class DBTagNameAssign {
    
    static Connection connection;
   
    public void createMainTagList(ArrayList uniqueTagList){
        
       int iTimeout = 30;
       DBClass dc = new DBClass();
       connection = dc.conn();
       String sMakeTable = "CREATE TABLE TagWithName (slNo numeric, TagID text)";
       String sMakeInsert;
       String sMakeSelect= "SELECT * from TagWithName";
        try {
            Statement stmt = connection.createStatement();

            stmt.setQueryTimeout(iTimeout);
            stmt.executeUpdate("drop table if exists TagWithName;");
            stmt.executeUpdate( sMakeTable );
            PreparedStatement prep = connection.prepareStatement("insert into TagWithName values (?, ?);");
            
            for(int i=0;i<= uniqueTagList.size()-1;i++){
                //System.out.println(uniqueTagList.get(i).toString());
                prep.setInt(1,i);
                prep.setString(2, uniqueTagList.get(i).toString());
                prep.addBatch();
            }
          
            
             connection.setAutoCommit(false);
             prep.executeBatch();
            connection.setAutoCommit(true);
           try (ResultSet rs = stmt.executeQuery(sMakeSelect)) {
               try {
                       while(rs.next())
                       {
                       //int sResult = rs.getInt("id");
                       String sResult = rs.getString("TagID");
                       System.out.println("From data Base "+ sResult);
                       }
                   }catch(Exception e){}
           }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBTagNameAssign.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
