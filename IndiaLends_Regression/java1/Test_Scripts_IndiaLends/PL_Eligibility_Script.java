package Test_Scripts_IndiaLends;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Page_Objects_IndiaLends.PL_Eligibility_Page;
import Page_Objects_IndiaLends.PL_Page;
import Utility.Base;

public class PL_Eligibility_Script extends Base {
	@Test(dataProvider = "create", dataProviderClass = Utility.ExcelRead.class)
	public void fillBasicDetailsPage(String FullName, String EmailAddress, String Pincode, String Company,
			String Salary, String MobileNumber) {
		System.out.println("FullName " + FullName + "EmailAddress " + EmailAddress + "Pincode " + Pincode + "Company "
				+ Company + "Salary " + Salary + "MobileNumber " + MobileNumber);
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList(FullName, EmailAddress, Pincode, Company, Salary, MobileNumber));
		//System.out.println("Driver value inside fillBasicDetailsPage() method is " + driver);
		PL_Eligibility_Page detailsPage = new PL_Eligibility_Page(driver);
		detailsPage.enterBasicdetailsToCheckLoanEligibility(list);
		
	}
	
	/*@Test(priority=2)
	public void verifyAdditionalDetails() {
		PL_Page detailsPage = PageFactory.initElements(driver, PL_Page.class);
		detailsPage.enterAdditionaldetailsToCheckLoanEligibility();
	}
	@Test(priority=3)
	public void verifyGeneralDetails() {
		PL_Page detailsPage = PageFactory.initElements(driver, PL_Page.class);
		detailsPage.enterGeneralInformation();
	}
	@Test(priority=4)
	public void verifyOfficeDetails() {
		PL_Page detailsPage = PageFactory.initElements(driver, PL_Page.class);
		detailsPage.enterOfficeInformation();
	}*/

  }
