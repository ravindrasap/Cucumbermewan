

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utility.Base;

public class PLFLow_Page extends Base{
	
	protected WebDriver driver;
	
	String Conversion="955414164";
	String gtag="AW-955414164";
	String RemarketingTag1="803650867";
	String RemarketingTag2="803650924";
	String RemarketingTag3="955414164";
	String Google_Analytics="UA-58036769-1";
	
	//=========================== Basic Details Page Locators =============================================================== //
	
	@FindBy(how=How.CSS, using="#mainNav > div.container-fluid.md-pad10b.sm-pad0b > div.col-xs-12.col-sm-12.col-md-9.pad0 > div.collapse.navbar-collapse.navbar-ex1-collapse.pad10t.sm-pad0t.full-width > ul > li:nth-child(1) > a")
	private WebElement clickPl;
	
	@FindBy(how=How.CSS, using="#li_display_name")
	private WebElement FullName;
	
	@FindBy(how=How.CSS, using="#div_frmc>div>div>div:nth-child(4)>h1")
	private WebElement header;
	
	@FindBy(how=How.CSS, using="#email")
	private WebElement email;
	
	@FindBy(how=How.CSS, using="#pincode")
	private WebElement pincode;
	
	@FindBy(how=How.CSS, using="#employment")
	private WebElement employment;
	
	@FindBy(how=How.CSS, using="#salaried12")
	private WebElement salaried;
	
	@FindBy(how=How.CSS, using="#companyName")
	private WebElement companyname;
	
	@FindBy(how=How.CSS, using="#monthlyIncome")
	private WebElement salary;
	
	@FindBy(how=How.CSS, using="#mobile")
	private WebElement mobile;
	
	@FindBy(how=How.CSS, using="#li_submit")
	private WebElement clickNextBtn;
	
	//=========================== Basic Details Page Locators End =============================================================== //
	
	//=========================== Otp Screen & I-lite Locators  =============================================================== //
	
	@FindBy(how=How.XPATH, using="//*[@id=\"txt_otp\"]")
	private WebElement otptake;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"btn_mobile_verify\"]")
	private WebElement otpVerify;
	
	@FindBy(how=How.CSS, using="#control-indicator")
	private WebElement terms;
	
	@FindBy(how=How.CSS, using="#btn_call_now_continue")
	private WebElement iLite;
	
	@FindBy(how=How.CSS, using="#btn_sales_call_logger")
	private WebElement iLiteText;
	//=========================== Otp & I-lite Screen Locators End =============================================================== //
	//===========================Additional details Locators ===================================================================== //
	
	@FindBy(how=How.CSS, using="#loanAmt")
	private WebElement loanAmt;
	
	@FindBy(how=How.CSS, using="#div_gender > label > span")
	private WebElement gender;
	
	/*@FindBy(how=How.CSS, using="//*[@id=\"dobYear\"]")
	private WebElement DOB_Yr;*/
	
	@FindBy(how=How.CSS, using="#panNo")
	private WebElement Pan_no;
	
	@FindBy(how=How.CSS, using="#div_payment_mode > div:nth-child(1) > label > span > span")
	private WebElement salary_mode;
	
	@FindBy(how=How.CSS, using="#address")
	private WebElement address;
	
	@FindBy(how=How.CSS, using="#locality")
	private WebElement locality;
	
	@FindBy(how=How.CSS, using="#btn_continue")
	private WebElement Click_btn;
	
	@FindBy(how=How.CSS, using="body > div.col-md-6.col-sm-8.xs-pad0.xs-pad30b > div > div > div:nth-child(4) > div > label > span > div > div > div > div.wrapping > div.col-lg-12.col-md-12.col-sm-12.pad0r.sm-pad0l > div.wrapping.text-l-sm.sm-marg10l.border-right-none-sm")
	private WebElement offer_select;
	
	@FindBy(how=How.CSS, using="#div_offer_selected")
	private WebElement offer_btn;
	
	//======================================== General Information Locators ========================================================= //
	@FindBy(how=How.CSS, using="#div_general_panel > div.col-xs-12 > div > div:nth-child(2) > div.form-group.marg0b > div.radio-check-icon-pl > div.form-item.pad0l.col-xs-4.pad0r > label > span")
	private WebElement education;
	
	@FindBy(how=How.CSS, using="#div_marital > label > span")
	private WebElement marital;
	
	@FindBy(how=How.CSS, using="#div_general_panel > div.col-xs-12 > div > div:nth-child(2) > div:nth-child(5) > div.radio-check-icon-pl > div:nth-child(2) > label > span")
	private WebElement residence_type;
	
	@FindBy(how=How.CSS, using="#btn_general")
	private WebElement general_btn;
	
	//========================================= Office Information Locators ============================================================ //
	@FindBy(how=How.CSS, using="#officePincode")
	private WebElement office_pincode;
	
	@FindBy(how=How.CSS, using="#offAddress")
	private WebElement office_address;
	
	@FindBy(how=How.CSS, using="#offLocality")
	private WebElement office_locality;
	
	@FindBy(how=How.CSS, using="#scroll_cc > div.radio-check-icon-pl > div.form-item.pad10l.col-xs-6.pad5l.pad0r > label > span")
	private WebElement employment_card;
	
	@FindBy(how=How.CSS, using="#btn_employment")
	private WebElement office_btn;
	
	
	public PLFLow_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	
	}
	
	public void enterBasicdetailsToCheckLoanEligibility() 
	{
	// ========== Verify Basic Details Page Header =================================//
	/*	WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(header));
		String headerText = header.getText();
		Assert.assertEquals(headerText, "Check Loan Eligibility by providing your basic details");*/
		try {
			clickPl.click();
		//	analyticsGA();
			 
			
			
			FullName.sendKeys(Base.loadPropertiesFile("PL_Data.properties", "full_name"));
			email.sendKeys(Base.loadPropertiesFile("PL_Data.properties", "email"));
			pincode.sendKeys(Base.loadPropertiesFile("PL_Data.properties", "pincode"));
			employment.click();
			Thread.sleep(2000);
			salaried.click();

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,400)");

			companyname.sendKeys(Base.loadPropertiesFile("PL_Data.properties", "company"));

			//WebDriverWait wait = new WebDriverWait(driver, 20);
			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#a_loc1"))));
			Thread.sleep(4000);
           // driver.findElement(By.cssSelector("#a_loc1")).click();
			WebElement textbox = driver.findElement(By.cssSelector("#companyName"));
			textbox.sendKeys(Keys.ENTER);

			Thread.sleep(8000);
			salary.sendKeys(Base.loadPropertiesFile("PL_Data.properties", "salary"));
			mobile.sendKeys(mobileno);
			// System.out.println(mobileno);
			clickNextBtn.click();
			

		} catch (Exception e1) {
			// SendMail.sendmail(e1.getMessage());
			System.out.println("Failed on Baisc Detailed Page :" + e1.getMessage());
			
			tearDown();

		}

		// ============== OTP Verify ===================================================

		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(otptake));
			
			String passwrd = Utility.Otp_Call.request_otp(otpURL, mobileno);
			System.out.println("Mobile no is:" + mobileno);
			System.out.println("OTP Is:" + passwrd);

			otptake.sendKeys(passwrd);
			terms.click();
			otpVerify.click();

			Thread.sleep(8000);
			
			System.out.println("Sucessfully submitted OTP");

		} catch (Exception e) { // SendMail.sendmail(e.getMessage());
			System.out.println("Otp screen failure " + e.getMessage());
			tearDown();
		}

		// ================ I-lite screen click
		// ============================================= //
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,400)");
		
		try {
			
			

			if (iLiteText.getText().contains("Get A Call Now")) {
				iLite.click();
				System.out.println("Clicked I-lite screen");

			} else {
				System.out.println("I-lite screen is not coming.");
			}
		} catch (Exception e) {

			//SendMail.sendmail("I-lite screen failure" + e.getMessage());
			System.out.println("I-lite screen failure " + e.getMessage());
			//tearDown();
		}

	
		}
	

	public void enterAdditionaldetailsToCheckLoanEligibility()  {

		// Additional details

		try {
			loanAmt.sendKeys(Base.loadPropertiesFile("PL_Data.properties", "Loan_Amt"));
			gender.click();

			// DOB Fileds
			driver.findElement(By.cssSelector(
					"#frm > div > div > div:nth-child(2) > div.col-xs-4.pad0l > div > div.select-selected")).click();
			driver.findElement(By.cssSelector(
					"#frm > div > div > div:nth-child(2) > div.col-xs-4.pad0l > div > div.select-items > div:nth-child(3)"))
					.click();

			driver.findElement(By
					.cssSelector("#frm > div > div > div:nth-child(2) > div.col-xs-4.pad0 > div > div.select-selected"))
					.click();
			driver.findElement(By.cssSelector(
					"#frm > div > div > div:nth-child(2) > div.col-xs-4.pad0 > div > div.select-items > div:nth-child(3)"))
					.click();

			WebElement DOBYr = driver.findElement(By.xpath("//*[@id=\"dobYear\"]"));
			Select dropdown = new Select(DOBYr);
			dropdown.selectByVisibleText(Base.loadPropertiesFile("PL_Data.properties", "DOB_Year"));
			// Thread.sleep(4000);

			Pan_no.sendKeys(Base.loadPropertiesFile("PL_Data.properties", "Pan_no"));
			salary_mode.click();
			driver.findElement(By.cssSelector("#bankName")).sendKeys("HDFC");
			address.sendKeys(Base.loadPropertiesFile("PL_Data.properties", "address"));
			locality.sendKeys(Base.loadPropertiesFile("PL_Data.properties", "locality"));
			// Thread.sleep(4000);
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("window.scrollBy(0,400)");

			// Cibil Scenario for UAT Only
			/*
			 * driver.findElement(By.
			 * cssSelector("#frm > div > div > div:nth-child(2) > div:nth-child(26) > div > div.select-selected"
			 * )).click(); driver.findElement(By.
			 * cssSelector("#frm > div > div > div:nth-child(2) > div:nth-child(26) > div > div.select-items > div:nth-child(1)"
			 * )).click();
			 */
			Click_btn.click();
			Thread.sleep(4000);

			//driver.findElement(By.cssSelector("#btn_update_continue")).click();

			System.out.println("Additional details form submited");

			Thread.sleep(5000);
			// Select Offer
			offer_select.click();
			offer_btn.click();

			System.out.println("Offer screen submitted");
			Thread.sleep(2000);

		} catch (Exception e) {
			// SendMail.sendmail(e.getMessage());
			System.out.println("Additional details page failure " + e.getMessage());
			driver.close();
			tearDown();
			
		}
	}

	public void enterGeneralInformation()  {

		 try {
		education.click();
		marital.click();
		residence_type.click();
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,400)");

		//How long you have been staying here?
		driver.findElement(By.cssSelector("#scroll_res_years > div.custom-select > div.select-selected")).click();
		driver.findElement(By.cssSelector("#scroll_res_years > div.custom-select > div.select-items > div:nth-child(3)")).click();
		general_btn.click();

		System.out.println("Genral information sucessfully submitted");
		Thread.sleep(4000);
		 } catch (Exception e) {
		// SendMail.sendmail(e.getMessage());
		 System.out.println("Failure occur in Genral information form: " +e.getMessage());
		 tearDown();
		 }
	}

	public void enterOfficeInformation()  {

		 try {
		driver.findElement(By.cssSelector("#lbl_currentExpmMonths > div.select-selected")).click();
		driver.findElement(By.cssSelector("#lbl_currentExpmMonths > div.select-items > div:nth-child(3)")).click(); // 0 year

		//driver.findElement(By.cssSelector("#lbl_currentExpmMonths > div.select-selected")).click();
		//driver.findElement(By.cssSelector("#lbl_currentExpmMonths > div.select-items > div:nth-child(7)")).click(); // 6
																													// months

		office_pincode.sendKeys(Base.loadPropertiesFile("PL_Data.properties", "office_pincode"));
		Thread.sleep(2000);
		office_address.sendKeys(Base.loadPropertiesFile("PL_Data.properties", "office_address"));
		office_locality.sendKeys(Base.loadPropertiesFile("PL_Data.properties", "office_locality"));

		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,400)");

		// Total Years Of exp
		driver.findElement(By.cssSelector("#lbl_totalExpMonths > div.select-selected")).click();
		driver.findElement(By.cssSelector("#lbl_totalExpMonths > div.select-items > div:nth-child(3)")).click(); // 0
																												// year

		//driver.findElement(By.cssSelector("#lbl_totalExpMonths > div.select-selected")).click();
	//	driver.findElement(By.cssSelector("#lbl_totalExpMonths > div.select-items > div:nth-child(7)")).click();
		employment_card.click();
		office_btn.click();

		Thread.sleep(1000);
		
		boolean isTheTextPresent4 = driver.getPageSource().contains(Conversion);
		 Assert.assertTrue(isTheTextPresent4, "gtag Pixel is Not fired "+Conversion);
		 

		System.out.println("Office information sucessfully submitted");
		 } catch (Exception e) {
		// SendMail.sendmail(e.getMessage());
		System.out.println("Failure occure in office information: " +e.getMessage());
	   tearDown();
		 }
	}
	/*public void analyticsGA()throws Exception {
		// TODO Auto-generated method stub

			
			String Conversion="803650867";
			String Conversion2="955414164";
			String gtag="AW-955414164";
			String RemarketingTag1="803650867";
			String RemarketingTag2="803650924";
			String RemarketingTag3="955414164";
			String Google_Analytics="UA-58036769-1";
			
			boolean TextPresentNoIndex=driver.getPageSource().contains("nofollow, noindex");
		     Assert.assertFalse(TextPresentNoIndex,"NO index present in pagesource");
			
			 boolean isTheTextPresent = driver.getPageSource().contains(gtag);
			 Assert.assertTrue(isTheTextPresent, "gtag Pixel is Not fired "+gtag);
			 
			 boolean TextPresent = driver.getPageSource().contains(RemarketingTag1);
			 Assert.assertTrue(TextPresent, "Remarketing Tag1 Pixel is Not fired "+RemarketingTag1);
			
			 boolean TextPresent1 = driver.getPageSource().contains(RemarketingTag2);
			 Assert.assertTrue(TextPresent1, "Remarketing Tag2 Pixel is Not fired "+RemarketingTag2);
			 
			 boolean TextPresent2 = driver.getPageSource().contains(RemarketingTag3);
			 Assert.assertTrue(TextPresent2, "Remarketing Tag3 Pixel is Not fired "+RemarketingTag3);
			 
			 boolean TextPresent3 = driver.getPageSource().contains(Google_Analytics);
			 Assert.assertTrue(TextPresent3, "Google_Analytics Pixel is Not fired "+Google_Analytics);
			
			
		}
*/}
	






