/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModels;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pkgDataSource.CDatabaseLayer;

/**
 *
 * @author rahul
 */
public class CTableModel extends AbstractTableModel{
    
    private String [] columnNames = {"SL No","Tag ID","Name","Lap1","Lap2","Lap3","lab4","Result"};
   
   private ArrayList<TagData>  dat;// throws FileNotFoundException, IOException;

    public CTableModel() throws SQLException {
        this.dat = (new CDatabaseLayer()).getTagRecord();
    }

    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return dat.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
    TagData rec = dat.get(rowIndex);
    switch(columnIndex){
        case 0:
            return rec.slNo;
        case 1:
            return rec.tagId;
//        case 2:
//            return rec.userName;
//        case 3:
//            return rec.lap1;
//        case 4:
//            return rec.lap2;
//        case 5:
//            return rec.lap3;
//        case 6:
//            return rec.lap4;
//        case 7:
//            return rec.result;
        default:
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }
 
    @Override public String getColumnName(int col){
              
        return columnNames[col];
    
    }
    
}
