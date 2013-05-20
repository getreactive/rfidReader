/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgDataSource;

import pkgModels.TagData;

/**
 *
 * @author rahul
 */
public class TagDataParser {
    public TagData getTableRow(String tagnewdata){
        
        TagData rec = new TagData();
        // write finction to fill the data
        rec.slNo = getSlNo(tagnewdata);
        rec.tagId = getTagID(tagnewdata);
        rec.userName = getName(tagnewdata);
        rec.lap1 ="1/2/2001";
        rec.lap2="1/2/2001";
        rec.lap3="1/2/2001";
        rec.lap4="1/2/2001";
        rec.result="1/2/2001";
        return rec;
}
    
private String getSlNo(String dataSting){ return null;}
    
private String getTagID(String tagID){ return null; } 

private String getName(String name){ return null;}

private String getLap1(String lap1){ return null;}

private String getLap2(String lap2){ return null;}

private String getLap3(String lap3){ return null;}

private String getLap4(String lap4){ return null;}

private String getResult(String result){ return null;}



}
