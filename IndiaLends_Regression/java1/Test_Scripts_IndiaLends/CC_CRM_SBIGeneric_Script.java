package Test_Scripts_IndiaLends;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import CRM.CC_CRM_SBIGeneric_Page;
import Utility.Base;

public class CC_CRM_SBIGeneric_Script extends Base {
	@Test(priority=1)
	public void CC_BasicDetailsPage() throws Exception 
	{
		
		System.out.println("Driver valueE inside fillBasicDetailsPage() method is "+ driver);
		CRM.CC_CRM_SBIGeneric_Page SBIGenericPage = PageFactory.initElements(driver, CC_CRM_SBIGeneric_Page.class);
		SBIGenericPage.enterBasicdetailsToCheckLoanEligibility();
				
			
	}
   /*@Test(priority=2)
	public void CC_Eligibility_check() throws Exception {
		CRM.CC_CRM_SBIGeneric_Page SBIGenericPage = PageFactory.initElements(driver, CC_CRM_SBIGeneric_Page.class);
	//	SBIGenericPage.CC_check_Eligibility();
		
}*/	
	
}
