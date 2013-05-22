/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgDataSource;

import com.app.store.DBClass;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pkgModels.TagData;

public class CDatabaseLayer {
   
   ArrayList<String> _tempTagFiledata = new ArrayList<>();
   ArrayList<String> _uniqueTagData = new ArrayList<>();
   BufferedReader br = null;
   String sCurrentLine;
   TagData rec = new TagData();
   

  public ArrayList<TagData> getTagRecord() {

        ArrayList<TagData> ret = new ArrayList();
        ArrayList<TagData> tagRecord = new ArrayList();

         _tempTagFiledata = getTagFileData();
         TagDataParser tp = new TagDataParser();

        for (String item: _tempTagFiledata){

            tagRecord.add(tp.getTableRow(item));
        }

        DBClass dc = new DBClass();
            Connection connection = dc.conn();
          
            Statement stmt = null ;
        
          String sMakeSelect= "SELECT * from TagWithName";
        try {
           stmt = connection.createStatement();
        }catch(Exception e){}
        
        try (ResultSet rs = stmt.executeQuery(sMakeSelect)) {
               try {
                       while(rs.next())
                       {
                       int _slNo = rs.getInt("id");
                        
                       String _tagID = rs.getString("TagID");
                       
                      // rec.slNo=_slNo;
                      // rec.tagId=_tagID;
                      //ret.add(rec);
                       System.out.println("From data *&*&*& "+ _tagID);
                       }
                   }catch(Exception e){}
           }catch(Exception e){}
            //connection.close();
        
        
        
        
        
        
        
        
        // write finction to fill the data
        
//        rec.tagId="12333333";
//        rec.userName = "Rahul";
//        rec.lap1 ="1/2/2001";
//        rec.lap2="1/2/2001";
//        rec.lap3="1/2/2001";
//        rec.lap4="1/2/2001";
//        rec.result="1/2/2001";
//        ret.add(rec);
//        
//        TagData rec1 = new TagData();
//        // write finction to fill the data
//        rec1.slNo="2";
//        rec1.tagId="1444556333";
//        rec1.userName = "Kumar";
//        rec1.lap1 ="1/2/2031";
//        rec1.lap2="1/2/2005";
//        rec1.lap3="1/2/2006";
//        rec1.lap4="1/2/2001";
//        rec1.result="1/2/2001";
//        ret.add(rec1);
        
        return tagRecord;      
    }
    
    public ArrayList getTagFileData() {
    
    ArrayList<String> tagFiledata = new ArrayList<>();
    String[] _tempdata = new String[10000];
    
    try{
     br = new BufferedReader(new FileReader("C:\\HexData\\log_hex (4).txt"));
    int i = 0;
    while ((sCurrentLine = br.readLine()) != null) {
            i = i + 1; 
            _tempdata[i] = sCurrentLine;
    }
    } catch(Exception e){
      System.out.println("getTagFileData Exception "+e);
   }
    
   for(int j = 0; j <= _tempdata.length-1;j++){

     String pattern ="32 12 (\\d+) 0E 30 00";
     Pattern r = Pattern.compile(pattern);
     Matcher m;
     
    if(_tempdata[j] != null){
         m = r.matcher(_tempdata[j]);
         if(m.find())
         {
            tagFiledata.add(_tempdata[j]); 
         }
     }
 }
return tagFiledata;
}
   
    
    public static void main(String [] args){
        CDatabaseLayer c = new CDatabaseLayer();
        c.getTagRecord();
       
        
    }
 
    
   public ArrayList getAllUnoqueTagId(){
        ArrayList<String> _tempFiledata;
       _tempFiledata = new ArrayList<>();
       _tempFiledata = getTagFileData();
       //System.out.println("SIZE"+_tempFiledata.size());
        ArrayList<String> _UniqueIdList = new ArrayList<>();
       int count = 0; 
       for(int j = 0; j <= _tempFiledata.size()-1;j++){

        String pattern ="32 12 (\\d+\\w*) 0E 30 00"; 
        Pattern r = Pattern.compile(pattern);
         Matcher m;
        if(_tempFiledata.get(j) != null){
         m = r.matcher(_tempFiledata.get(j).toString());
         if(m.find())
         {          
          String _temp = _tempFiledata.get(j).toString();
          for (String retval: _temp.split("32 12 (\\d+\\w*) 0E 30 00")){
          // _UniqueIdList.add(retval); 
           //System.out.println(retval);
            if(retval.indexOf(":")!=-1 || retval.length()< 37 ){
            } else {
               // System.out.println("Retval Length"+retval.length());
                retval = retval.substring(0,36);
                  _UniqueIdList.add(retval);  
              }  
         }
         
     }
       
 }     
}
       for(String item : _UniqueIdList){
       //    System.out.println(item);
       }

       Set<String> uniqueTag = new HashSet<>(_UniqueIdList);
      // System.out.println("Unique gas count: " + uniqueTag.size());
       for (Iterator<String> it = uniqueTag.iterator(); it.hasNext();) {
           String item = it.next();
          // System.out.println(item);
       }
       ArrayList<String> list = new ArrayList<>(uniqueTag);
       return list; 
      
}
    
}
   
    

