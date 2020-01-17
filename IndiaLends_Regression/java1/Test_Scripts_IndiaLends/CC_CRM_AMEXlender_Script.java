package Test_Scripts_IndiaLends;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Utility.Base;

public class CC_CRM_AMEXlender_Script extends Base {
	@Test(priority = 1)
	public void CC_BasicDetailsPage() throws Exception {

		System.out.println("Driver valueE inside fillBasicDetailsPage() method is " + driver);
		
	  CRM.CC_CRM_AMEXLender_Page AMEXITCPage = PageFactory.initElements(driver, CRM.CC_CRM_AMEXLender_Page.class);
	
	  AMEXITCPage.enterBasicdetailsToCheckLoanEligibility();
		
		}
}
