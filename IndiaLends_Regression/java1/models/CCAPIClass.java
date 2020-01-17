package models;

import java.util.Properties;

public class CCAPIClass {
	
	protected static Properties properties;
	
	 String pincode = loadPropertiesFile("CC_SP_Data.properties", "pincode");
	   String FName = loadPropertiesFile("CC_SP_Data.properties", "FName");
	   String LName = loadPropertiesFile("CC_SP_Data.properties", "LName");
	   
	private String loadPropertiesFile(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	
	
	/*pstmt.setString(1, data.get(i).getPincode());	/// Data read from DB output @lead_track_id      output,
	pstmt.setString(1, data.get(i).getPincode());// @lead_unique_id     output,
	pstmt.setString(1, FName);  */

}
