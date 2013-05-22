/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgDataSource;

import com.app.store.DBTagNameAssign;
import java.util.ArrayList;

/**
 *
 * @author rahul
 */
public class StoteTagInDataBase {
    public static void main(String[] args){
        ArrayList<String> _tempTagFiledata = new ArrayList<>();
        CDatabaseLayer cl = new CDatabaseLayer();
        DBTagNameAssign db = new DBTagNameAssign();
        _tempTagFiledata = cl.getAllUnoqueTagId();
        db.createMainTagList(_tempTagFiledata);
              
        
    
    }
}
