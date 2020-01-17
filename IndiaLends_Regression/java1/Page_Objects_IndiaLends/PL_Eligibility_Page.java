package Page_Objects_IndiaLends;


import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utility.Base;

public class PL_Eligibility_Page extends Base{
	
	protected WebDriver driver;
	
	//=========================== Basic Details Page Locators =============================================================== //
	
		@FindBy(how=How.XPATH, using="//*[@id=\"mainNav\"]/div[6]/div[1]/div[2]/ul/li[1]/a")
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
		
		
		@FindBy(how=How.CSS, using="#cbil_senerio > div.select-selected")
		private WebElement CibilScro;
		
		
		
		@FindBy(how=How.CSS, using="#cbil_senerio > div.select-items > div:nth-child(1)")
		private WebElement CibilScroselect;
		
		
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
		
		
	public PL_Eligibility_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterBasicdetailsToCheckLoanEligibility(ArrayList<String> list) 
	{
		// Verify Basic Details Page Header
	/*	WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(header));
		String headerText = header.getText();
		Assert.assertEquals(headerText, "Check Loan Eligibility by providing your basic details");*/
		
		try {
			clickPl.click();
			FullName.clear();
			FullName.sendKeys(list.get(0));
			email.clear();
			email.sendKeys(list.get(1));
			pincode.clear();
			pincode.sendKeys(list.get(2));
			employment.click();
			Thread.sleep(2000);
			salaried.click();
			companyname.clear();
			companyname.sendKeys(list.get(3));
			Thread.sleep(1000);
		//	driver.findElement(By.cssSelector("#a_loc1")).click();
		//	Thread.sleep(8000);
			salary.clear();
			salary.sendKeys(list.get(4));
			mobile.clear();
			
			mobile.sendKeys(list.get(5));
			System.out.println("Test Data From Excel"+list.get(5));
			System.out.println();
			clickNextBtn.click();
			Thread.sleep(2000);
			
		} catch (Exception e) {
			System.out.println("Failed on Baisc Detailed Page :"+e.getMessage());
		}
	/*  //  wait.until(ExpectedConditions.visibilityOf(header));
	
*/
	// ============== OTP Verify ===================================================

			try {
				WebDriverWait wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOf(otptake));
				
				String passwrd = Utility.Otp_Call.request_otp(otpURL, list.get(5));
				System.out.println("Mobile no is:" + list.get(5));
				System.out.println("OTP Is:" + passwrd);

				otptake.sendKeys(passwrd);
				terms.click();
				otpVerify.click();

				Thread.sleep(8000);
				
				System.out.println("Sucessfully submitted OTP");
			//	driver.get("https://indialends.com/personal-loan");
				driver.manage().window().maximize();
				Thread.sleep(3000);

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
				
				Thread.sleep(2000);
				
				
			} catch (Exception e) {

				//SendMail.sendmail("I-lite screen failure" + e.getMessage());
				System.out.println("I-lite screen failure " + e.getMessage());
				tearDown();
			}


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
            
			Pan_no.clear();
			Pan_no.sendKeys(Base.loadPropertiesFile("PL_Data.properties", "Pan_no"));
			salary_mode.click();
			
			driver.findElement(By.cssSelector("#bankName")).clear();
			driver.findElement(By.cssSelector("#bankName")).sendKeys("HDFC");
			
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#a_bank1")).click();
			
			JavascriptExecutor js12 = (JavascriptExecutor) driver;
			js12.executeScript("window.scrollBy(0,400)");
			
			address.clear();
			address.sendKeys(Base.loadPropertiesFile("PL_Data.properties", "address"));
			locality.clear();
			locality.sendKeys(Base.loadPropertiesFile("PL_Data.properties", "locality"));
			// Thread.sleep(4000);
			
			
		//	CibilScro.click();
		
		//	CibilScroselect.click();
			
			Click_btn.click();
			Thread.sleep(4000);

			driver.findElement(By.cssSelector("#btn_update_continue")).click();

			System.out.println("Additional details form submited");

			Thread.sleep(5000);
			
			offer_select.click();
			offer_btn.click();
			
			driver.manage().deleteAllCookies();
			Thread.sleep(1000);
			driver.get("https://indialends.com/personal-loan");
			driver.manage().window().maximize();
			Thread.sleep(3000);

		} catch (Exception e) {
			// SendMail.sendmail(e.getMessage());
			System.out.println("Additional details page failure " + e.getMessage());
		  driver.close();
			tearDown();
			
		}
		
		
	}
}

	