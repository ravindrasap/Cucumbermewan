package Test_Scripts_IndiaLends;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import CRM.CC_CRM_RBLLender_Page;
import Utility.Base;

public class CC_CRM_RBLlender_Script extends Base {
	@Test(priority = 1)
	public void CC_BasicDetailsPage() throws Exception {

		System.out.println("Driver valueE inside fillBasicDetailsPage() method is " + driver);
		
	  CC_CRM_RBLLender_Page RBLITCPage = PageFactory.initElements(driver, CC_CRM_RBLLender_Page.class);
	
	  RBLITCPage.enterBasicdetailsToCheckLoanEligibility();
		
		}
}
