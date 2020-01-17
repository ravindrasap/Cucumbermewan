package models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Page_Objects_IndiaLends.Check_CC_Eligibility;
import Utility.Base;
public class WriteCSVFile_BufferedReader {
	private static final String COMMA_DELIMITER = ",";

	public static void main(String args[]) {
		BufferedReader br = null;
		BufferedReader br1 = null;
		try {

						
			br1 = new BufferedReader(new FileReader(Base.loadPropertiesFile("SP.properties","csv_pathw")));

			List<CC_DATA> empList = new ArrayList<CC_DATA>();

			String line = "";

			br1.readLine();

			while ((line = br1.readLine()) != null) {

				String[] eligibilityDetails = line.split(COMMA_DELIMITER);

				if (eligibilityDetails.length > 0) {

					CC_DATA emp = new CC_DATA(eligibilityDetails[0], eligibilityDetails[1], Integer.parseInt(eligibilityDetails[2]), Integer.parseInt(eligibilityDetails[3]),Integer.parseInt(eligibilityDetails[4]),Integer.parseInt(eligibilityDetails[5]),Integer.parseInt(eligibilityDetails[6]),
							(eligibilityDetails[7]),(eligibilityDetails[8]),(eligibilityDetails[9]),(eligibilityDetails[10]),Integer.parseInt(eligibilityDetails[11]),Integer.parseInt(eligibilityDetails[12]),Integer.parseInt(eligibilityDetails[13]),Integer.parseInt(eligibilityDetails[14]),(eligibilityDetails[15]),
							(eligibilityDetails[16]),(eligibilityDetails[17]),(eligibilityDetails[18]),Integer.parseInt(eligibilityDetails[19]),(eligibilityDetails[20]));
					empList.add(emp);
					
					
				}
			}

			/*for (PL_DATA e : empList) {
				System.out.println(e.getmobileNo() + "   " + e.getpincode() + "   " + e.getcompany() + "   "
					+ e.getSalary() + " " + e.getempType()+ ""+e.getisItr()+""+e.getStatus());
			}*/

			Check_CC_Eligibility CC_Eligibility = new Check_CC_Eligibility();
			
			CC_Eligibility.execute(empList);
			
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			try {
				br1.close();
			} catch (IOException ie) {
				System.out.println("Error occured while closing the BufferedReader");
				ie.printStackTrace();
			}
		}
	}

}
