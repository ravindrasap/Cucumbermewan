package Test_Scripts_IndiaLends;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page_Objects_IndiaLends.CC_YESLender_Page;
import Utility.Base;

public class CC_YESLender_script extends Base {
	
	@Test
	public void CCBasicDetailsPage() throws Exception {
		
		CC_YESLender_Page detailsPage=PageFactory.initElements(driver,CC_YESLender_Page.class);
		detailsPage.enterBasicdetailsToCheckLoanEligibility();
	
	}
	@Test(priority=2)
	public void CC_Eligibility_check() throws Exception {
		CC_YESLender_Page detailsPage = PageFactory.initElements(driver, CC_YESLender_Page.class);
		detailsPage.check_Eligibility();
		
	}
	@Test(priority=3)
	public void CC_general_information() throws Exception {
		CC_YESLender_Page detailsPage = PageFactory.initElements(driver, CC_YESLender_Page.class);
		detailsPage.general_Information();
	}
	@Test(priority=4)
	public void CC_contact_Details() throws Exception {
		CC_YESLender_Page detailsPage = PageFactory.initElements(driver, CC_YESLender_Page.class);
		detailsPage.contact_Details();
	}

}
