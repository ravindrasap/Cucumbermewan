	package Page_Object_cross_sell;
	
	import java.nio.CharBuffer;
	
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
	
	public class CC_HDFC_Crosssell_Page {
		
		
		//================ verify the tag and google analytics  =============================
		
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
		
		//============ click CC HDFC link =====================
		
		@FindBy(how=How.XPATH, using= "//*[@id=\"mainNav\"]/div[6]/div[1]/div[2]/ul/li[2]/ul/li[7]/a")
		private WebElement clickHDFClender;	
			
			
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
		
		@FindBy(how=How.CSS, using="#li_email_id")
		private WebElement email;
		
		@FindBy(how=How.CSS, using="#li_mobile_number")
		private WebElement mobile;
		
		@FindBy(how=How.CSS, using="#li_submit")
		private WebElement clickNextBtn;
	
		/*@FindBy(how=How.CSS, using="#a_loc1")
		private WebElement employment;*/
			
		
		//=========================== Basic Details Page Locators End =============================================================== //
		
		//=========================== Otp Screen  =============================================================== //
		
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
	//	@FindBy(how=How.CSS, using="#li_office")
		@FindBy(how=How.XPATH,using ="//*[@id=\"div_generic_details_step3\"]/div[1]/div[3]/div[2]/div/div[2]/div/label[1]")
		private WebElement Office;
		
		@FindBy(how=How.CSS, using="#landine_number")
		private WebElement landlineNo;
		
		@FindBy(how=How.CSS, using="#bankwise_controls_submit")
		private WebElement finalSubmit;
		
	   
		String mobileno = Base.randomMobile();
		
		public CC_HDFC_Crosssell_Page(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		// ========== Verify Basic Details Page Header =================================//
		public void enterBasicdetailsToCheckLoanEligibility() 
		{
	
		try {
			
			clickCClink.click();
			clickHDFClender.click();
			
			 Thread.sleep(2000);
				
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
				
				fname.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "full_name"));
				//logger.log(LogStatus.INFO,"Enter first name : ");
				pincode.sendKeys("110030");
				empType.click();
				Select employeeTyp=new Select(empType);
				employeeTyp.selectByIndex(1);
				
				companyname.sendKeys("GOOGLE INDIA");
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("#a_loc1")).click();
				
				salary.sendKeys("50000");
				email.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "email"));
				
				JavascriptExecutor js = (JavascriptExecutor) driver;  
				js.executeScript("window.scrollBy(0,100)");
				Thread.sleep(1000);
				mobile.sendKeys(mobileno);
				System.out.println(mobileno);
			
				Thread.sleep(2000);
				WebElement card=driver.findElement(By.cssSelector("#card_type"));
				Select cardType=new Select(card);
				cardType.selectByIndex(1);
				
				clickNextBtn.click();
				
				Thread.sleep(4000);
				
		} catch (Exception e1) {
			
			    System.out.println("Failed on Baisc Detailed Page :"+e1.getMessage());
		}
			
	   //==============  OTP Verify =================================================== //
			
		try {
			       Thread.sleep(3000);
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
					driver.findElement(By.cssSelector("#mobile_verification > div.modal-dialog.mobile-modal-dialog > div > div > div.pad20b.pad10t.pad10l.pad10r > label > span")).click();
					driver.findElement(By.cssSelector("#btn_verifyMobile")).click();
					
					
					Thread.sleep(3000);
					System.out.println("Sucessfully submitted OTP");
		} catch (Exception e) {
			
			System.out.println("Otp screen failure "+e.getMessage());
		}
			
		}	
		
		
		public void check_Eligibility() throws Exception {
			
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
				Thread.sleep(2000);
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
				 street.sendKeys("saket");
				 ResArea.sendKeys("Delhi");
				Thread.sleep(2000);
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				 js1.executeScript("window.scrollBy(0,400)");
				 
				//Office address
				 OfficeNo.sendKeys("101");
				 Officestreet.sendKeys("Sector 18");
				 OfficeArea.sendKeys("Gurgaon");
					
				 genricCLick.click();
			} catch (Exception e) {
				
				System.out.println("Failure on genral information form:"+e.getMessage());
			}
		
			
		}
		
		public void contact_Details() throws Exception {
			
			try {
				
				Thread.sleep(1000);		
				Office.click();
				landlineNo.sendKeys("27123468");
				
				driver.findElement(By.cssSelector("#salary_slip_yes")).click();
				
				finalSubmit.click();
				Thread.sleep(2000);
				driver.close();
				
			} catch (Exception e) {
				
				System.out.println("Failure on contact details:"+e.getMessage());
			} 
		}
		
		
		
		public void CC_contact_Aditionaletails() throws Exception {
			
              try {
				
				/*Thread.sleep(1000);		
				Office.click();
				landlineNo.sendKeys("27123468");
				
				driver.findElement(By.cssSelector("#salary_slip_yes")).click();
				*/
				finalSubmit.click();
				Thread.sleep(2000);
				driver.close();
				
			} catch (Exception e) {
				
				System.out.println("Failure on contact details:"+e.getMessage());
			} 
			
				
		}
	}
		