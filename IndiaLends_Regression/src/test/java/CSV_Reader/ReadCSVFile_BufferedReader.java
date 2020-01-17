package CSV_Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Page_Objects_IndiaLends.Check_CC_Eligibility;
import Utility.Base;

public class ReadCSVFile_BufferedReader {

	private static final String COMMA_DELIMITER = ",";

	public static void main(String args[]) {
		BufferedReader br = null;
		try {

			br = new BufferedReader(new FileReader(Base.loadPropertiesFile("DB.properties", "csv_path")));

			List<PL_DATA> empList = new ArrayList<PL_DATA>();

			String line = "";

			br.readLine();

			while ((line = br.readLine()) != null) {

				String[] eligibilityDetails = line.split(COMMA_DELIMITER);

				if (eligibilityDetails.length > 0) {

					PL_DATA emp = new PL_DATA(eligibilityDetails[0], eligibilityDetails[1], eligibilityDetails[2],
							Integer.parseInt(eligibilityDetails[3]), Integer.parseInt(eligibilityDetails[4]),
							Integer.parseInt(eligibilityDetails[5]), Integer.parseInt(eligibilityDetails[6]),
							eligibilityDetails[7], eligibilityDetails[8], Integer.parseInt(eligibilityDetails[9]),
							Integer.parseInt(eligibilityDetails[10]), Integer.parseInt(eligibilityDetails[11]),
							Integer.parseInt(eligibilityDetails[12]), Integer.parseInt(eligibilityDetails[13]),
							eligibilityDetails[14], Integer.parseInt(eligibilityDetails[15]),
							Integer.parseInt(eligibilityDetails[16]), Integer.parseInt(eligibilityDetails[17]));
					empList.add(emp);
				}
			}

			Check_CC_Eligibility pl_Eligibility = new Check_CC_Eligibility();
		//	pl_Eligibility.execute(empList);

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