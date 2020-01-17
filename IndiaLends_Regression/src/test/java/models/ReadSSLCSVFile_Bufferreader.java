package models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Page_Objects_IndiaLends.Check_CC_Eligibility;
import SSLAlert.Check_SSL_Alert;
import Utility.Base;
public class ReadSSLCSVFile_Bufferreader {
	private static final String COMMA_DELIMITER = ",";

	public static void main(String args[]) {
		BufferedReader br = null;
		try {

						
			br = new BufferedReader(new FileReader(Base.loadPropertiesFile("SSL.properties","csv_path")));

			List<SSL_DATA> empList = new ArrayList<SSL_DATA>();
			
			String line = "";

			br.readLine();

			while ((line = br.readLine()) != null) {

				String[] eligibilityDetails = line.split(COMMA_DELIMITER);
				
				
							
			//	while (line != null) {
				if (eligibilityDetails.length > 0) {

				//	System.out.println("data is coming");
					SSL_DATA emp = new SSL_DATA(eligibilityDetails[0], eligibilityDetails[1],(eligibilityDetails[2]),(eligibilityDetails[3]),(eligibilityDetails[4]),(eligibilityDetails[5]));
					empList.add(emp);
				   }	
			     // for()
						for (SSL_DATA data : empList) {									
						System.out.println("Domanename :" + data.getDomainname()+ "Validfrom :"+ data.getvalidfrom()+ "Validto :" +data.getValidto());
								
					}
				}		
			

		//	Check_CC_Eligibility CC_Eligibility = new Check_CC_Eligibility();
		//	Check_SSL_Alert SSL_Alert = new Check_SSL_Alert();
			
		//	SSL_Alert.execute(empList);
		//	CC_Eligibility.execute(empList);
			
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ie) {
				System.out.println("Error occured while closing the BufferedReader");
				ie.printStackTrace();
			}
		}
	}

}
