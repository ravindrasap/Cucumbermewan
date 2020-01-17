package TestScript;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page_Objects_IndiaLends.PL_Page;
import Utility.Base;

public class PL_Script extends Base
{
	@Test(priority=1,enabled=true)
	public void verifyBasicDetails() throws Exception {
		
		System.out.println("Driver valueE inside fillBasicDetailsPage() method is " + driver);
		PL_Page detailsPage = PageFactory.initElements(driver, PL_Page.class);
		detailsPage.enterBasicdetailsToCheckLoanEligibility();
	}
	@Test(priority=2,enabled=true)
	public void verifyAdditionalDetails() {
		PL_Page detailsPage = PageFactory.initElements(driver, PL_Page.class);
		detailsPage.enterAdditionaldetailsToCheckLoanEligibility();
	}
	@Test(priority=3,enabled=true)
	public void verifyGeneralDetails() throws Exception {
		PL_Page detailsPage = PageFactory.initElements(driver, PL_Page.class);
		detailsPage.enterGeneralInformation();
	}
	@Test(priority=4,enabled=true)
	public void verifyOfficeDetails() throws Exception {
		PL_Page detailsPage = PageFactory.initElements(driver, PL_Page.class);
		detailsPage.enterOfficeInformation();
		
		
	}

}
