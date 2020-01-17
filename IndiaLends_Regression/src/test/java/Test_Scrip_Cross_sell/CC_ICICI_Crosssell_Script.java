package Test_Scrip_Cross_sell;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page_Object_cross_sell.CC_ICICI_Crosssell_Page;
import Page_Object_cross_sell.CC_YES_Crosssell_Page;
import Utility.Base;

public class CC_ICICI_Crosssell_Script extends Base {
	

	@Test(priority=1)
	public void CC_BasicDetailsPage() throws Exception 
	{
		
		System.out.println("Driver valueE inside fillBasicDetailsPage() method is "+ driver);
		CC_ICICI_Crosssell_Page detailsPage = PageFactory.initElements(driver, CC_ICICI_Crosssell_Page.class);
		detailsPage.enterBasicdetailsToCCEligibility();
				
	}
	@Test(priority=2)
	public void CC_Eligibility_check() throws Exception {
		CC_ICICI_Crosssell_Page detailsPage = PageFactory.initElements(driver, CC_ICICI_Crosssell_Page.class);
		detailsPage.check_CCEligibility();
		
	}
	@Test(priority=3)
	public void CC_general_information() throws Exception {
		CC_ICICI_Crosssell_Page detailsPage = PageFactory.initElements(driver, CC_ICICI_Crosssell_Page.class);
		detailsPage.general_CCInformation();
	}
	@Test(priority=4)
	public void CC_contact_Details() throws Exception {
		CC_ICICI_Crosssell_Page detailsPage = PageFactory.initElements(driver, CC_ICICI_Crosssell_Page.class);
		detailsPage.contact_CCDetails();
	}
	
	
	@Test(priority=5)
	public void CC_contact_Aditionaletails() throws Exception {
		CC_ICICI_Crosssell_Page detailsPage = PageFactory.initElements(driver, CC_ICICI_Crosssell_Page.class);
		detailsPage.contact_CCADDetails();
	}
	
}

