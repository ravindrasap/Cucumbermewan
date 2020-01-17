package Test_Scripts_IndiaLends;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Page_Objects_IndiaLends.CC_SBILender_Page;
import Utility.Base;

public class CC_SF_SP  {
	
//	public static WebDriver driver;

	//public static void main(String[] args) 
	//{
	//public class CC_SBILender_Script extends Base {
		
		@Test(dataProvider = "create", dataProviderClass = Utility.ExcelRead.class)
		public void fillBasicDetailsPage(String FullName, String EmailAddress, String Pincode, String Company,
				String Salary, String MobileNumber , String EmpType , String ITR) {
			
			System.out.println("FullName " + FullName + "EmailAddress " + EmailAddress + "Pincode " + Pincode + "Company "
					+ Company + "Salary " + Salary + "MobileNumber " + MobileNumber + "EmpType" + EmpType + "ITR" + ITR);
			ArrayList<String> list = new ArrayList<String>();
			list.addAll(Arrays.asList(FullName, EmailAddress, Pincode, Company, Salary, MobileNumber ,EmpType ,ITR ));
			//System.out.println(list);
			
			/*CC_SBILender_Page detailsPage = new CC_SBILender_Page(driver);
			detailsPage.enterBasicdetailsToCheckEligibility(list);*/
			
		}

	}

//}
