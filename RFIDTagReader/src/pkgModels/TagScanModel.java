/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModels;

import javax.swing.table.AbstractTableModel;
import pkgDataSource.CDatabaseLayer;

/**
 *
 * @author rahul
 */
public class TagScanModel extends AbstractTableModel{
     private String [] columnNames = {"SL No","Tag ID","Name","Lap1","Lap2","Lap3","lab4","Result"};

     public TagScanModel(){}
     
    
     
     
     
    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
