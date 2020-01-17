package Page_Object_cross_sell;

import java.nio.CharBuffer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



import Utility.Base;

public class CC_SBI_Crosssell_Page extends Base{
	
protected WebDriver driver;
	
	String Conversion = "803650867";
	String Conversion2 = "955414164";
	String gtag = "AW-955414164";
	String RemarketingTag1 = "803650867";
	String RemarketingTag2 = "803650924";
	String RemarketingTag3 = "955414164";
	String Google_Analytics = "UA-58036769-1";
	
	//=========================== Short Form Page Locators =============================================================== //
	
// click the credit card link 
	

	@FindBy(how=How.XPATH, using= "//*[@id=\"mainNav\"]/div[6]/div[1]/div[2]/ul/li[2]/a")
	private WebElement clickCClink;
	
	
// select the SBI link
	
	@FindBy(how=How.XPATH, using= "//*[@id=\"mainNav\"]/div[6]/div[1]/div[2]/ul/li[2]/ul/li[2]/a")
	private WebElement clickSBIClink;
	
/*	@FindBy(how = How.CSS, using = "#li_name")
	private WebElement fname;
*/
	//*[@id="li_first_name"]
	@FindBy(how = How.XPATH, using = "//*[@id='li_first_name']")
	private WebElement fname;
	
	@FindBy(how = How.CSS, using = "#li_res_pin")
	private WebElement pincode;
	@FindBy(how = How.CSS, using = "#li_emp_type")
	private WebElement empType;

	@FindBy(how = How.CSS, using = "#li_company_name")
	private WebElement companyname;

	@FindBy(how = How.CSS, using = "#li_monthly_salary")
	private WebElement salary;

	@FindBy(how = How.CSS, using = "#li_email_id")
	private WebElement email;

	@FindBy(how = How.CSS, using = "#li_mobile_number")
	private WebElement mobile;

	@FindBy(how = How.CSS, using = "#li_submit")
	private WebElement clickNextBtn;

	//===============   New User journey ==============================


		@FindBy(how=How.CSS, using="#btnnoscreen")
		private WebElement Getstatrtbtn;

		//#li_mobile_number
		@FindBy(how=How.CSS, using="#btnSendOTP")
		private WebElement OTPbtn;

		@FindBy(how=How.CSS, using="#btnproceeduj")
		private WebElement Proccedbtn;

		
		@FindBy(how=How.CSS, using="#li_name")
		private WebElement Ufname;


		@FindBy(how=How.CSS, using="#li_email_id")
		private WebElement UEmail;


		
	// ============================= Check Eligibility 	// =======================================//

	@FindBy(how = How.CSS, using = "#male")
	private WebElement gender;

	@FindBy(how = How.CSS, using = "#radio-8")
	private WebElement existingCard;

	@FindBy(how = How.CSS, using = "#li_off_pin")
	private WebElement Officepincode;

	@FindBy(how = How.CSS, using = "#li_pan_number")
	private WebElement PanNo;

	@FindBy(how = How.CSS, using = "#li_submit_pan_details")
	private WebElement Submit;

	// @FindBy(how=How.XPATH, using="//*[@id=\"dv_karza_buttons\"]/div[1]/span")
	@FindBy(how = How.CSS, using = "#dv_karza_buttons > div.col-sm-5.col-xs-5.pad0.pad20t > span")
	private WebElement PanKarza;

	// ============= General Information =========================================
	// //
	@FindBy(how = How.CSS, using = "#view_more_section > a")
	private WebElement ViewMore;

	@FindBy(how = How.CSS, using = "#btn_102")
	private WebElement ClickCard;

	@FindBy(how = How.CSS, using = "#div_married > label:nth-child(2)")
	private WebElement MaritalStatus;

	@FindBy(how=How.CSS, using="#li_submit")
	private WebElement SFsubmit;
	
	/*@FindBy(how=How.CSS, using="#btnSendOTP")
	private WebElement OTPbtn;*/

	// Present residential address//

	@FindBy(how = How.CSS, using = "#li_res_house_no")
	private WebElement houseNo;

	@FindBy(how = How.CSS, using = "#li_res_street")
	private WebElement street;

	@FindBy(how = How.CSS, using = "#li_res_area")
	private WebElement ResArea;

	// Office address

	@FindBy(how = How.CSS, using = "#li_off_house_no")
	private WebElement OfficeNo;

	@FindBy(how = How.CSS, using = "#li_off_street")
	private WebElement Officestreet;

	@FindBy(how = How.CSS, using = "#li_off_area")
	private WebElement OfficeArea;

	@FindBy(how = How.CSS, using = "#generic_details_step1")
	private WebElement genricCLick;

	// ====================== Contact Details 	// =====================================//
	@FindBy(how = How.CSS, using = "#sbi_relation_no")
	private WebElement RelationNo;

	@FindBy(how = How.CSS, using = "#li_designation")
	private WebElement designation;

	@FindBy(how = How.CSS, using = "#bankwise_controls_submit")
	private WebElement FinalSubmit;
	
	
	//=================  Contact Details ========================
	
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
	
		
	public CC_SBI_Crosssell_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	// ========== Verify Basic Details Page Header =================================//
	public void enterBasicdetailsToCCEligibility() throws Exception 
	{

		clickCClink.click();
		clickSBIClink.click();
		//analyticsGA();
		 Thread.sleep(2000);	
		
		 try
			{
		    	 
			boolean TextPresentNoIndex=driver.getPageSource().contains("nofollow, noindex");
			Assert.assertFalse(TextPresentNoIndex,"NO index is present in pagesource");
			fname.clear();
			fname.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "full_name"));
			pincode.sendKeys("110030");
			empType.click();
			Select employeeTyp=new Select(empType);
			employeeTyp.selectByIndex(1);
			
			companyname.sendKeys("GOOGLE INDIA");			
			Thread.sleep(1000);
			salary.sendKeys("60000");
			email.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "email"));
			Thread.sleep(1000);
			mobile.sendKeys(mobileno);
			System.out.println(mobileno);
			// card selection 
			WebElement card=driver.findElement(By.cssSelector("#card_type"));
			Select cardType=new Select(card);
			cardType.selectByIndex(1);
			clickNextBtn.click();
			Thread.sleep(8000);
			//SFsubmit.click();
			  Mobileotp();
			Thread.sleep(4000);			
			
		    }				
			catch (Exception ee) {
				}
  			
		}	
			
		public void check_CCEligibility() throws Exception {
			
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
				Thread.sleep(2000);
				WebDriverWait wait = new WebDriverWait(driver, 70);
				wait.until(ExpectedConditions.visibilityOf(PanKarza));
				
				PanKarza.click();
				System.out.println("PanKarza popup clicked");
				Thread.sleep(2000);
			} catch (Exception e) {
				
				System.out.println("Failure on eligibility form:"+e.getMessage());
				//tearDown();
			}
				
		}
		
		public void general_CCInformation() throws Exception {
			
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
				 Thread.sleep(5000);
			} catch (Exception e) {
				
				System.out.println("Failure on genral information form:"+e.getMessage());
			}
				
		    }
		
	      public void contact_CCDetails() throws Exception {
			
			try {		
				Office.click();
				Thread.sleep(1000);
				landlineNo.sendKeys("27123468");
			
				driver.findElement(By.cssSelector("#div_sbi_relationship > label:nth-child(2)")).click();
				   	
			   	WebElement relationshipwithSBI=driver.findElement(By.cssSelector("#li_sbi_relation_type"));
				Select Account=new Select(relationshipwithSBI);
				Account.selectByIndex(1);
			   	
			   	driver.findElement(By.cssSelector("#account")).sendKeys("4534635575464767");
			   	JavascriptExecutor js1 = (JavascriptExecutor) driver;
				 js1.executeScript("window.scrollBy(0,400)");
			   	
				driver.findElement(By.cssSelector("#li_designation")).sendKeys("SOFTWARE CONSULTANT");
				Thread.sleep(1000);	
				driver.findElement(By.cssSelector("#bankwise_controls_submit")).click();

				Thread.sleep(10000);
			 //  driver.close();		
				
			} catch (Exception e) {
				
				System.out.println("Failure on contact details:"+e.getMessage());
			} 
		}
	              
	      
	      public void contact_CCADDetails() throws Exception {
				
				try {		
					
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("window.scrollBy(0,400)");
					
				
				Thread.sleep(3000);
							 
			    driver.findElement(By.xpath("//*[@id=\"myCarouselMobile\"]/ol/li[1]")).click();
				String cardname = driver.findElement(By.xpath("//*[@id=\"myCarouselMobile\"]/div[1]/div[1]/div/div[2]/div[1]/div[2]/h5")).getText();
				if (cardname == "HDFC Bank Regalia First Credit Card") {
				   System.out.println("Bank name is:"+cardname);
				   driver.findElement(By.cssSelector("#btn_810")).click();
				} 
				if (cardname == "American Express SmartEarn™ Credit Card"){
					 System.out.println("Bank name is:"+cardname);
					 driver.findElement(By.cssSelector("#btn_310")).click();	
					
				}else if(cardname =="ICICI Bank Platinum Chip Credit Card") {
					 System.out.println("Bank name is:"+cardname);
					 driver.findElement(By.cssSelector("#btn_710")).click();	
				}else {
					System.out.println("Bank name is:"+cardname);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id=\"myCarouselMobile\"]/ol/li[1]")).click();
					String cardname1 = driver.findElement(By.xpath("//*[@id=\"myCarouselMobile\"]/div[1]/div[1]/div/div[2]/div[1]/div[2]/h5")).getText();
					System.out.println("Bank name is:"+cardname1);
					driver.findElement(By.xpath("//button[contains(.,'Apply Now')]")).click();
				}
				  
				
				Thread.sleep(3000);					
				Office.click();
				Thread.sleep(1000);
				landlineNo.sendKeys("27123468");
				
				driver.findElement(By.xpath("//*[@id=\"div_salary_slip\"]/label[2]")).click();
				
				driver.findElement(By.cssSelector("#bankwise_controls_submit")).click();
				
				Thread.sleep(8000);
							
			//	driver.close();		
					
				} catch (Exception e) {
					
					System.out.println("Failure on contact details:"+e.getMessage());
				} 
			}
		              
	   
		public void Mobileotp() throws Exception {
			 
		     try {
		 		//OTP Verify
		 		
		    	 String otpURL = "http://v.indialends.com/test/get_otp_user_registration_encrypt.ashx?type=json&mobileno=";
						String passwrd = Utility.Otp_Call.request_otp(otpURL, mobileno);
		 				System.out.println("OTP Is:"+passwrd);
		 				
		 				String string=String.valueOf(passwrd);
		 				char[] ch=string.toCharArray();
		 				System.out.println(ch[3]);
		 				
		 			    driver.findElement(By.cssSelector("#txt_otp0")).sendKeys(CharBuffer.wrap(new char[]{ch[0]}));
		 				driver.findElement(By.cssSelector("#txt_otp1")).sendKeys(CharBuffer.wrap(new char[]{ch[1]}));
		 				driver.findElement(By.cssSelector("#txt_otp2")).sendKeys(CharBuffer.wrap(new char[]{ch[2]}));
		 				driver.findElement(By.cssSelector("#txt_otp3")).sendKeys(CharBuffer.wrap(new char[]{ch[3]}));
		 				driver.findElement(By.cssSelector("#txt_otp4")).sendKeys(CharBuffer.wrap(new char[]{ch[4]}));
		 				driver.findElement(By.cssSelector("#txt_otp5")).sendKeys(CharBuffer.wrap(new char[]{ch[5]}));
		 			//	driver.findElement(By.cssSelector("#mobile_verification > div.modal-dialog.mobile-modal-dialog > div > div > div.clearfix > div.pad20b.pad10t.pad10l.pad10r > label > span")).click();
		 				driver.findElement(By.cssSelector("#mobile_verification > div.modal-dialog.mobile-modal-dialog > div > div > div.pad20b.pad10t.pad10l.pad10r > label > span")).click();
		 				driver.findElement(By.cssSelector("#btn_verifyMobile")).click();
		 				Thread.sleep(2000);
		 				System.out.println("Sucessfully submitted OTP");
		 				
		 	} catch (Exception e) {
		 		
		 		System.out.println("Otp screen failure "+e.getMessage());
		 	}
		}
		
		
		
	}

