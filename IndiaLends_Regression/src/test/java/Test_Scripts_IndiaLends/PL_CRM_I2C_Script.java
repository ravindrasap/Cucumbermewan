package Test_Scripts_IndiaLends;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Utility.Base;

public class PL_CRM_I2C_Script extends Base {
	@Test(priority = 1)
	public void PL_BasicDetailsPage() throws Exception {

		System.out.println("Driver valueE inside fillBasicDetailsPage() method is " + driver);
			
		CRM.PL_CRM_I2C_Page detailsPage = PageFactory.initElements(driver, CRM.PL_CRM_I2C_Page.class);
		detailsPage.enterBasicdetailsToCheckLoanITCEligibility();
		
		}
}
