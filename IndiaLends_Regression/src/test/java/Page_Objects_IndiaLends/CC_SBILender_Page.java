package Page_Objects_IndiaLends;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class CC_SBILender_Page {
	
	
	//================ verify the tag and google analytics  =============================
			
	//	private static final String otpURL = null;
			//	private static final CharSequence mobileno = null;
			protected WebDriver driver;
			String Conversion="803650867";
			String Conversion2="955414164";
			String gtag="AW-955414164";
			String RemarketingTag1="803650867";
			String RemarketingTag2="803650924";
			String RemarketingTag3="955414164";
			String Google_Analytics="UA-58036769-1";
	
	//=========================== Short Form Page Locators =============================================================== //
	
	@FindBy(how=How.XPATH, using= "//li[@class='dropdown']")
	private WebElement clickCClink;
	
	//============ click CC SBI Lender link =====================
	
		@FindBy(how=How.XPATH, using= "//*[@id=\"mainNav\"]/div[6]/div[1]/div[2]/ul/li[2]/ul/li[2]/a")
		private WebElement clickSBIlender;	
		
		
	@FindBy(how=How.CSS, using="#li_first_name")
	private WebElement fname;
	
	@FindBy(how=How.CSS, using="#li_res_pin")
	private WebElement pincode;
	
	@FindBy(how=How.CSS, using="#li_emp_type")
	private WebElement empType;
	
	@FindBy(how=How.CSS, using="#li_company_name")
	private WebElement companyname;
	
	@FindBy(how=How.CSS, using="#li_monthly_salary")
	private WebElement salary;
	
	@FindBy(how=How.CSS, using="#apply_block > div:nth-child(4) > div")
	private WebElement email;
	
	@FindBy(how=How.CSS, using="#li_mobile_number")
	private WebElement mobile;
	
	@FindBy(how=How.CSS, using="#li_submit")
	private WebElement clickNextBtn;

	@FindBy(how=How.CSS, using="#li_card_type")
	private WebElement Cardselect;
	
	
	
	
	/*@FindBy(how=How.CSS, using="#a_loc1")
	private WebElement employment;*/
		
	
	//=========================== Basic Details Page Locators End =============================================================== //
	
	//=========================== Otp Screen & I-lite Locators  =============================================================== //
	
	@FindBy(how=How.XPATH, using="//*[@id=\"txt_otp\"]")
	private WebElement otptake;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"btn_mobile_verify\"]")
	private WebElement otpVerify;
	
	@FindBy(how=How.CSS, using="#control-indicator")
	private WebElement terms;
	
	//============================= Check Eligibility =======================================//
	
	@FindBy(how=How.CSS, using="#male")
	private WebElement gender;
	
	@FindBy(how=How.CSS, using="#radio-8")
	private WebElement existingCard;
	
	@FindBy(how=How.CSS, using="#li_off_pin")
	private WebElement Officepincode;
	
	@FindBy(how=How.CSS, using="#li_pan_number")
	private WebElement PanNo;
	
	@FindBy(how=How.CSS, using="#li_submit_pan_details")
	private WebElement Submit;
	
	
	@FindBy(how=How.CSS, using="#dv_karza_buttons > div.col-sm-5.col-xs-5.pad0.pad20t > span")
	private WebElement PanKarza;
		
 //============= General Information ========================================= //
	
	@FindBy(how=How.CSS, using="#married")
	private WebElement MaritalStatus;
	
	@FindBy(how=How.CSS, using="#employmentSelect")
	private WebElement Qualification;
		
	//Present residential address//
	
	@FindBy(how=How.CSS, using="#li_res_house_no")
	private WebElement houseNo;
	
	@FindBy(how=How.CSS, using="#li_res_street")
	private WebElement street;
	
	@FindBy(how=How.CSS, using="#li_res_area")
	private WebElement ResArea;
	 
	//Office address
	
	@FindBy(how=How.CSS, using="#li_off_house_no")
	private WebElement OfficeNo;
	
	@FindBy(how=How.CSS, using="#li_off_street")
	private WebElement Officestreet;
	
	@FindBy(how=How.CSS, using="#li_off_area")
	private WebElement OfficeArea;
	
	@FindBy(how=How.CSS, using="#generic_details_step1")
	private WebElement genricCLick;
	
	// ====================== Contact Details =====================================//
	@FindBy(how=How.CSS, using="#li_office")
	private WebElement Office;
	
	@FindBy(how=How.CSS, using="#landine_number")
	private WebElement landlineNo;
	
	
	@FindBy(how=How.CSS, using="#fathers_name")
	private WebElement fathersname;
	
	@FindBy(how=How.CSS, using="#mothers_name")
	private WebElement mothersname;
	
	@FindBy(how=How.CSS, using="#li_designation")
	private WebElement Employeetype;
	
	@FindBy(how=How.CSS, using="#office_address")
	private WebElement Officeaddress;
	
	@FindBy(how=How.CSS, using="#yes")
	private WebElement Currentadd;
	
	@FindBy(how=How.CSS, using="#li_add_proof")
	private WebElement addproof;
	
	//#div_nationality > label:nth-child(2) > input[type=radio]
	
	@FindBy(how=How.CSS, using="#div_nationality > label:nth-child(2) > input[type=radio]")
	private WebElement Nationality;		
			


	@FindBy(how=How.CSS, using="#no_senior_officer")
	private WebElement CitirelativNOe;
	
	
	@FindBy(how=How.CSS, using="#yes_senior_officer")
	private WebElement Citirelative;
	
	
	@FindBy(how=How.CSS, using="#bankwise_controls_submit")
	private WebElement finalSubmit;
	
   
	String mobileno = Base.randomMobile();
	
	
	
	public CC_SBILender_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// ========== Verify Basic Details Page Header =================================//
	//public void enterBasicdetailsToCheckLoanEligibility() 
	public void enterBasicdetailsToCheckEligibility(ArrayList<String> list) 
	{
		clickCClink.click();
		clickSBIlender.click();
				
		try {

			fname.clear();
			fname.sendKeys(list.get(0));
			pincode.clear();
			pincode.sendKeys(list.get(1));
			
			empType.click();
			Thread.sleep(1000);
			WebElement emply=driver.findElement(By.cssSelector("empType"));
			Select emptype=new Select(emply);
			emptype.selectByIndex(0);
			
			companyname.clear();
			companyname.sendKeys(list.get(2));
			Thread.sleep(1000);
			
			salary.clear();
			salary.sendKeys(list.get(3));
			
			email.clear();
		    email.sendKeys(list.get(4));
		
		    mobile.clear();			
			mobile.sendKeys(list.get(5));
		
			WebElement card=driver.findElement(By.cssSelector("Cardselect"));
			Select cardType=new Select(card);
			cardType.selectByIndex(1);
		
	//	driver.findElement(By.cssSelector("#a_loc1")).click();
	//	Thread.sleep(8000);
		
		
		
	/*	mobile.sendKeys(list.get(5));
		System.out.println("Test Data From Excel"+list.get(5));
		System.out.println();*/
		
			
		clickNextBtn.click();
		Thread.sleep(2000);
		
	} catch (Exception e) {
		System.out.println("Failed on Baisc Detailed Page :"+e.getMessage());
		tearDown();
	}
	
  //  wait.until(ExpectedConditions.visibilityOf(header));

		
   //==============  OTP Verify =================================================== //
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(otptake));
			
			String otpURL = null;
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

		} catch (Exception e) { 
			System.out.println("Otp screen failure " + e.getMessage());
			tearDown();
		}
	}

	
	private void tearDown() {
		// TODO Auto-generated method stub
		
	}


	public void check_Eligibility() throws Exception {
		
		 try {
				boolean isTheTextPresent4 = driver.getPageSource().contains(Conversion);
				 Assert.assertTrue(isTheTextPresent4, "Conversion Pixel is Not fired "+Conversion);
				
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
				 System.out.println("Pixel is fired");
			} catch (Exception e) {
				
				System.out.println("Pixel is not fire :"+e.getMessage());
			}
		
		
		
		
		try {
		
			WebElement day=driver.findElement(By.cssSelector("#li_birthdate"));
			Select dropdown11=new Select(day);
			dropdown11.selectByVisibleText("04");
			
			WebElement month=driver.findElement(By.cssSelector("#li_birthmonth"));
			Select mon=new Select(month);
			mon.selectByVisibleText("MAR - 03");
			
			WebElement year=driver.findElement(By.cssSelector("#li_birthyear"));
			Select yy=new Select(year);
			yy.selectByVisibleText("1986");
			
			gender.click();
					
			WebElement salry=driver.findElement(By.cssSelector("#li_salary_mode"));
			Select modeSal=new Select(salry);
			modeSal.selectByVisibleText("HDFC Bank");
			
			existingCard.click();
			Officepincode.sendKeys("110040");
			PanNo.sendKeys(Base.randommPAN());
			Submit.click();
			
			WebDriverWait wait = new WebDriverWait(driver, 70);
			wait.until(ExpectedConditions.visibilityOf(PanKarza));
			
			PanKarza.click();
			
			Thread.sleep(2000);
		} catch (Exception e) {
			
			System.out.println("Failure on eligibility form:"+e.getMessage());
		}
	
	}
	
	public void general_Information() throws Exception {
		
		try {
			

			//Marital Status
			MaritalStatus.click();
			
			WebElement quali=driver.findElement(By.cssSelector("#employmentSelect"));
			Select education=new Select(quali);
			education.selectByIndex(3);
			
			JavascriptExecutor js11 = (JavascriptExecutor) driver;
			 js11.executeScript("window.scrollBy(0,400)");
			
			//Present residential address//
			 houseNo.sendKeys("10");
			 street.sendKeys("Delhi");
			 ResArea.sendKeys("Delhi");
			Thread.sleep(2000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			 js1.executeScript("window.scrollBy(0,400)");
			 
			//Office address
			 OfficeNo.sendKeys("10");
			 Officestreet.sendKeys("Delhi");
			 OfficeArea.sendKeys("Delhi");
				
			 genricCLick.click();
		} catch (Exception e) {
			
			System.out.println("Failure on genral information form:"+e.getMessage());
		}
	
		
	}
	
	public void contact_Details() throws Exception {
		
		try {
			
					
			Office.click();
			landlineNo.sendKeys("27123468");
			fathersname.sendKeys("Father name");
			mothersname.sendKeys("Mother name");
			
			Employeetype.sendKeys("Accountant");
						
			Thread.sleep(1000);
		//	driver.findElement(By.cssSelector("#Accountant")).click();
			
		//	Select Employee =new Select(Employeetype);
		//	Employee.selectByIndex(1);
			
			Officeaddress.click();
			
			Currentadd.click();
			
			addproof.sendKeys("Passport");
			
			Nationality.click();
			CitirelativNOe.click();
			//Citirelative.click();
			
			
			finalSubmit.click();
			 Thread.sleep(2000);
				
				boolean isTheTextPresent4 = driver.getPageSource().contains(Conversion);
				 Assert.assertTrue(isTheTextPresent4, "Conversion Pixel is Not fired "+Conversion);
				
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
				 System.out.println("Contact details form submitted successfully");
				 
            } catch (Exception e) {
			
			System.out.println("Failure on contact details:"+e.getMessage());
			//tearDown();
		} 
	}
}
