

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utility.Base;

public class PL_Regression_Validation {
	public static WebDriver driver;
	String mobileno = Base.randomMobile();
	// String mobileno="6123000493";
	String otpURL = "https://uatweb.indialends.com/internal/a/get_otp_mail_verify_api.ashx?mobileno= ";
	String salary = "65000";
	String pincode = "110020";
	String company = "IBM";
	String[] arr = { "test", "test@", "@test", "@test.", "test@test.", "Test@gmail.c","Test@gmail.com"};
	String[] pin = { "11", "1100", "110020" };
	
	
	@FindBy(how=How.CSS, using="#mobile")
	private WebElement mobile;
	
	@FindBy(how=How.CSS, using="#otp_countdown")
	private WebElement Otptimmer;
	
	@FindBy(how=How.CSS, using="#div_resend > span.font15.text-orange.font-weight700 > a")
	private WebElement OTpresend;
	
	@FindBy(how=How.CSS, using="#div_resend > span.font13.font-weight500.marg0.text-orange.font-weight700.pad15l > a")
	private WebElement GetOTPthroughcall;
	
	@FindBy(how=How.CSS, using="#edit_no")
	private WebElement Editno;
		
	@FindBy(how=How.CSS, using="#li_submit")
	private WebElement clickNextBtn;
	

	@BeforeClass
	public void set_UP() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravindrakumar\\eclipse-workspace\\IndiaLends_Sanity\\driver\\chromedriver.exe");
		System.out.println("launching chrome browser");

		driver = new ChromeDriver();
		driver.navigate().to("https:/indialends.com/personal-loan");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void verify_PL_Form() throws Exception {

		try {

			// First name Blank validation check
			driver.findElement(By.cssSelector("#li_submit")).click();

			String msg = driver.findElement(By.cssSelector("#h_ctr1")).getText();

			if (msg.equals("Please enter your Name")) {
				System.out.println("Error displayed: First name Should not take blank value.");
			} else {
				System.out.println("Name field Error is not triggered");
			}
			Thread.sleep(1000);
			// First name one alphabet validation check
			driver.findElement(By.cssSelector("#li_display_name")).sendKeys("A");

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,400)");

			driver.findElement(By.cssSelector("#li_submit")).click();

			String msg1 = driver.findElement(By.cssSelector("#h_ctr18")).getText();

			if (msg1.equals("Please enter your full Name")) {
				System.out.println("Error displayed: First name Should not take 1 alphabet.");
			} else {
				System.out.println("Name field Error is not triggered");
			}
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("#li_display_name")).clear();
			// driver.findElement(By.cssSelector("#li_display_name")).sendKeys("Test User");

			// Full name length Max Length verify
			WebElement fullName = driver.findElement(By.cssSelector("#li_display_name"));
			fullName.clear();
			String maxLengthDefined = fullName.getAttribute("maxlength");

			if (maxLengthDefined.equals("50")) {

				System.out.println("Full Name Max character limit is set as expected.");
			}

			else {
				System.out.println("Full Name No limit is set.");

			}

			driver.findElement(By.cssSelector("#li_display_name")).sendKeys("Test User");

			// Email address Max Length
			WebElement email = driver.findElement(By.cssSelector("#email"));
			email.clear();
			String maxLengthEmail = email.getAttribute("maxlength");

			if (maxLengthEmail.equals("50")) {

				System.out.println("Email Max character limit is set as expected.");
			}

			else {
				System.out.println("Email No limit is set.");

			}

			// email address validation check

			Thread.sleep(1000);
			boolean notvalidemail = false;
			for (int i = 0; i < arr.length; i++) {
				driver.findElement(By.cssSelector("#email")).clear();
				driver.findElement(By.cssSelector("#email")).sendKeys(arr[i]);
				driver.findElement(By.cssSelector("#li_submit")).click();

				if (driver.findElement(By.cssSelector("#h_ctr2")).isDisplayed()) {
					notvalidemail = true;
					System.out.println("Error displayed:Please enter a valid  email address");
				} else {
					notvalidemail = false;

					break;
				}

				Thread.sleep(2000);
			}

			if (notvalidemail) {
				System.out.println("Email field error is not triggered");
			}

			// pincode Max Length
			WebElement pincode = driver.findElement(By.cssSelector("#pincode"));
			pincode.clear();
			String maxLengthpincode = pincode.getAttribute("maxlength");

			if (maxLengthpincode.equals("6")) {

				System.out.println("pincode Max character limit is set as expected.");
			}

			else {
				System.out.println("pincode No limit is set.");

			}
			// pincode validation check
			boolean notvalidpincode = false;
			for (int i = 0; i < pin.length; i++) {
				driver.findElement(By.cssSelector("#pincode")).clear();
				driver.findElement(By.cssSelector("#pincode")).sendKeys(pin[i]);
				driver.findElement(By.cssSelector("#li_submit")).click();

				if (driver.findElement(By.cssSelector("#h_ctr4")).isDisplayed()) {
					notvalidpincode=true;
					System.out.println("Error displayed:Please enter a valid Residence Pincode");
				} else {
					
					notvalidpincode=false;
					break;
				}

				Thread.sleep(2000);
			}
			
			if (notvalidpincode) {
				System.out.println("Pincode field error is not triggered");
			}

			// Employment validation check
			if (driver.findElement(By.cssSelector("#h_ctr_emp_status")).isDisplayed()) {
				System.out.println("Error displayed:Please select your Employment Type");

				driver.findElement(By.cssSelector("#employment")).click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("#salaried12")).click();

			} else {
				System.out.println("Employment field Error is not triggered");
			}
			Thread.sleep(1000);

			// Company Max Length
			WebElement Company = driver.findElement(By.cssSelector("#companyName"));
			Company.clear();
			String maxLengthCompany = Company.getAttribute("maxlength");

			if (maxLengthCompany.equals("75")) {

				System.out.println("Company Max character limit is set as expected.");
			}

			else {
				System.out.println("Company No limit is set.");

			}

			driver.findElement(By.cssSelector("#li_submit")).click();

			// Company validation check
			if (driver.findElement(By.cssSelector("#h_ctr5")).isDisplayed()) {
				System.out.println("Error displayed:Please enter a valid Company Name");
				driver.findElement(By.cssSelector("#companyName")).sendKeys(company);

				Thread.sleep(6000);
				driver.findElement(By.cssSelector("#a_loc1")).click();
				Thread.sleep(8000);

			} else {
				System.out.println("Company field Error is not triggered");

			}
			Thread.sleep(1000);

			// Company Max Length
			WebElement Salary = driver.findElement(By.cssSelector("#monthlyIncome"));
			Salary.clear();
			String maxLengthSalary = Salary.getAttribute("maxlength");

			if (maxLengthSalary.equals("6")) {

				System.out.println("Salary Max character limit is set as expected.");
			}

			else {
				System.out.println("Salary No limit is set.");

			}
			driver.findElement(By.cssSelector("#li_submit")).click();

			// Salary validation check

			if (driver.findElement(By.cssSelector("#h_ctr6")).isDisplayed()) {
				System.out.println("Error displayed:Minimum salary of Rs 10,000 is required");

			} else {
				System.out.println("Salary field Error is not triggered");
			}

			driver.findElement(By.cssSelector("#monthlyIncome")).sendKeys("9999");
			driver.findElement(By.cssSelector("#li_submit")).click();

			if (driver.findElement(By.cssSelector("#h_ctr6")).isDisplayed()) {
				System.out.println("Error displayed:Minimum salary of Rs 10,000 is required");
				driver.findElement(By.cssSelector("#monthlyIncome")).clear();
				driver.findElement(By.cssSelector("#monthlyIncome")).sendKeys("65000");
				driver.findElement(By.cssSelector("#li_submit")).click();
			} else {
				System.out.println("Salary field Error is not triggered");
			}

			// mobile Max Length
			WebElement mobile = driver.findElement(By.cssSelector("#mobile"));
			mobile.clear();
			String maxLengthmobile = mobile.getAttribute("maxlength");

			if (maxLengthmobile.equals("10")) {

				System.out.println("mobile Max character limit is set as expected.");
			}

			else {
				System.out.println("mobile No limit is set.");

			}
			// Mobile no Validation check
			if (driver.findElement(By.cssSelector("#h_ctr3_mobile")).isDisplayed()) {
				System.out.println("Error displayed:Please enter your mobile number");
				driver.findElement(By.cssSelector("#mobile")).sendKeys("65");
			} else {
				System.out.println("mobile field Error is not triggered");
			}

			if (driver.findElement(By.cssSelector("#h_ctr3_mobile")).isDisplayed()) {
				System.out.println("Error displayed:Please enter your mobile number");
				driver.findElement(By.cssSelector("#mobile")).clear();
				driver.findElement(By.cssSelector("#mobile")).sendKeys("6312786120");
				driver.findElement(By.cssSelector("#li_submit")).click();
			} else {
				System.out.println("Salary field Error is not triggered");
			}
			Thread.sleep(1000);

			Thread.sleep(4000);
		} catch (Exception e) {

			System.out.println("Exception occur in first form " + e.getMessage());
		}

	}

	@Test(priority = 1 )//enabled = false
	public void verify_OTP() throws Exception {

		// OTP Verify

		try {
			
			
			String Timer =driver.findElement(By.cssSelector("#otp_countdown")).getText();
			 if (Timer.isEmpty())
			 {
				 System.out.println("Timmer is not coming ");
			 
			 } else {
				
				 System.out.println("Timmer is coming ");
				 
			 }
			 String OTpresend =driver.findElement(By.cssSelector("#div_resend > span.font15.text-orange.font-weight700 > a")).getText();
		
					 
			 String GetOTPthroughcall =driver.findElement(By.cssSelector("#div_resend > span.font13.font-weight500.marg0.text-orange.font-weight700.pad15l > a")).getText();
			//	@FindBy(how=How.CSS, using="#div_resend > span.font13.font-weight500.marg0.text-orange.font-weight700.pad15l > a")
			//	private WebElement GetOTPthroughcall;
				
			
			// WebDriverWait wait = new WebDriverWait(driver, 90);
			 Thread.sleep(9000);
		//	 wait.until(ExpectedConditions.visibilityOf(OTpresend));		 
			// String ResendOTP = OTpresend.getText();
			 //Thread.sleep(9000);	 
			 //String GetOTPcall = GetOTPthroughcall.getText();
			 
			 if (OTpresend.contains("Resend OTP"))
			 {
				 System.out.println("Resend OTP is coming ");
			 }else
			 {
				 System.out.println("Resend OTP is not coming ");
			 }
				 				 
				 if (GetOTPthroughcall.contains("Get OTP through Call"))
				 {
					 System.out.println("GetOTPcall OTP is coming "); 
				 }
					 
				 Thread.sleep(4000);  
			// Verify the edit number  
				 
//					@FindBy(how=How.CSS, using="#edit_no")
					//	private WebElement Editno;
			 //	  Editno.click();
			 	 driver.findElement(By.cssSelector("#edit_no")).click();
			  // open sort form and enter the mobile number
			 	 
			 	 Thread.sleep(4000);
			  mobile.clear();
			  
			 // Thread.sleep(2000);
			  
			  mobile.sendKeys(mobileno);
			  clickNextBtn.click();
			  			  
			// Again click the sumbit button 
			
			 	 
			String passwrd = Utility.Otp_Call.request_otp(otpURL, mobileno);
			System.out.println("OTP Is:" + passwrd);
			driver.findElement(By.xpath("//*[@id=\"txt_otp\"]")).sendKeys(passwrd);

			driver.findElement(By.xpath("//*[@id=\"btn_mobile_verify\"]")).click();

			Thread.sleep(2000);
			System.out.println("Sucessfully submitted OTP");
		} catch (Exception e) {

			System.out.println("Otp screen failure " + e.getMessage());
		}

		}

	
	// ============ Verify the OTP ========================
	
//	driver.manage().timeouts().implicitlyWait(8000,TimeUnit.SECONDS) ;
	
		 
		 
	@AfterClass
	public void tear_down() {

		// driver.quit();
	}

	
	
	
}
