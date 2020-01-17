package Test_Scripts_IndiaLends;


import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page_Objects_IndiaLends.CC_SBILender_Page;
import Page_Objects_IndiaLends.PL_Eligibility_Page;
import Utility.Base;

public class CC_SBILender_Script extends Base {
	
	@Test(dataProvider = "create", dataProviderClass = Utility.ExcelRead.class)
	public void fillBasicDetailsPage(String FullName, String EmailAddress, String Pincode, String Company,
			String Salary, String MobileNumber) {
		System.out.println("FullName " + FullName + "EmailAddress " + EmailAddress + "Pincode " + Pincode + "Company "
				+ Company + "Salary " + Salary + "MobileNumber " + MobileNumber);
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList(FullName, EmailAddress, Pincode, Company, Salary, MobileNumber));
		//System.out.println("Driver value inside fillBasicDetailsPage() method is " + driver);
	   //PL_Eligibility_Page detailsPage = new PL_Eligibility_Page(driver);
		CC_SBILender_Page detailsPage = new CC_SBILender_Page(driver);
		detailsPage.enterBasicdetailsToCheckEligibility(list);
	}
	
	
	
	@Test(priority=1)
	public void CC_BasicDetailsPage() throws Exception 
	{
		
		System.out.println("Driver valueE inside fillBasicDetailsPage() method is "+ driver);
		CC_SBILender_Page detailsPage = PageFactory.initElements(driver, CC_SBILender_Page.class);
		//detailsPage.enterBasicdetailsToCheckLoanEligibility();
				
	}
	@Test(priority=2)
	public void CC_Eligibility_check() throws Exception {
		CC_SBILender_Page detailsPage = PageFactory.initElements(driver, CC_SBILender_Page.class);
		detailsPage.check_Eligibility();
		
	}
	@Test(priority=3)
	public void CC_general_information() throws Exception {
		CC_SBILender_Page detailsPage = PageFactory.initElements(driver, CC_SBILender_Page.class);
		detailsPage.general_Information();
	}
	@Test(priority=4)
	public void CC_contact_Details() throws Exception {
		CC_SBILender_Page detailsPage = PageFactory.initElements(driver, CC_SBILender_Page.class);
		detailsPage.contact_Details();
	}
	
}

