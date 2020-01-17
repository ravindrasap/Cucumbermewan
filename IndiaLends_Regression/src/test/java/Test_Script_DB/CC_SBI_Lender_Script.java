package Test_Script_DB;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page_Object_DB.CC_SBI_LenderPage;
import Utility.Base;

public class CC_SBI_Lender_Script extends Base
{
	@Test(priority=1)
	public void CCBasicDetailsPage() throws Exception 
	{
		
		System.out.println("Driver valueE inside fillBasicDetailsPage() method is "+ driver);
		Page_Object_DB.CC_SBI_LenderPage detailsPage = PageFactory.initElements(driver, Page_Object_DB.CC_SBI_LenderPage.class);
		detailsPage.enterBasicdetailsToCheckLoanEligibility();	
		
	}
	
	@Test(priority=2)
	public void CC_Eligibility_check() throws Exception {
		Page_Object_DB.CC_SBI_LenderPage detailsPage = PageFactory.initElements(driver, Page_Object_DB.CC_SBI_LenderPage.class);;
		detailsPage.check_Eligibility();
		
	}
	@Test(priority=3)
	public void CC_general_information() throws Exception {
		Page_Object_DB.CC_SBI_LenderPage detailsPage = PageFactory.initElements(driver, Page_Object_DB.CC_SBI_LenderPage.class);
		detailsPage.general_Information();
	}
	@Test(priority=4,enabled=true)
	public void CC_contact_Details() throws Exception {
		Page_Object_DB.CC_SBI_LenderPage detailsPage = PageFactory.initElements(driver, Page_Object_DB.CC_SBI_LenderPage.class);
		detailsPage.contact_Details();
	}
}
