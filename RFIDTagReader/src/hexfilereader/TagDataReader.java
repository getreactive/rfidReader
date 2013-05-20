/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hexfilereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rahul
 */
public class TagDataReader {
   // public ArrayList  getTagData(){ ArrayList  data; return data;}
    BufferedReader br = null;
    String sCurrentLine;
 
public ArrayList getTagList() throws FileNotFoundException, IOException{
     ArrayList<String> tagdata = new ArrayList<>();
     br = new BufferedReader(new FileReader("C:\\HexData\\log_hex (4).txt"));
     String[] tempdata = new String[10000];
      int i = 0;
      while ((sCurrentLine = br.readLine()) != null) {
            i = i + 1;
            tempdata[i] = sCurrentLine;
        
    }
      int k = 0;
 
      
    for(int j = 0; j <= tempdata.length-1;j++){
      System.out.println("Tempdata :: "+tempdata[j]);
     String pattern ="32 12 (\\d+) 0E 30 00";
     Pattern r = Pattern.compile(pattern);
     Matcher m;
//      if (m.find( )) {
//          System.out.println("Tag Data :: "+tempdata.length);
//      }
     if(tempdata[j] != null){
         m = r.matcher(tempdata[j]);
         if(m.find())
         {
            tagdata.add(tempdata[j]); 
         }
     }
      
//       if(tempdata[j] != null && tempdata[j].indexOf("32 12 01 0E 30 00") != -1){
//          tagdata.add(tempdata[j]);
//      }
    }
    System.out.println("Tag Data :: "+tagdata.size());
                    
    for (String item: tagdata){
                //String item = tagdata.get(w);
            System.out.println("Item " + item);
        }
    return tagdata;
}

}
