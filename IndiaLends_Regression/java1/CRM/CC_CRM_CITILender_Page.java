	package CRM;
	
	import java.nio.CharBuffer;
	import java.util.ArrayList;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	
	import Utility.Base;
	
	public class CC_CRM_CITILender_Page extends Base {
	
	protected WebDriver driver;
		
		String mobileno = Base.randomMobile();
		String data = mobileno;
		@FindBy(how = How.XPATH, using = "//li[@class='dropdown']")
		private WebElement clickCClink;
	
		@FindBy(how = How.XPATH, using = "//*[@id=\"mainNav\"]/div[6]/div[1]/div[2]/ul/li[2]/ul/li[5]/a")
		private WebElement clickCITIlender;
		// =============== New User journey ==============================
	
		@FindBy(how = How.CSS, using = "#btnnoscreen")
		private WebElement Getstatrtbtn;
	
		// #li_mobile_number
		@FindBy(how = How.CSS, using = "#btnSendOTP")
		private WebElement OTPbtn;
	
		@FindBy(how = How.CSS, using = "#btnproceeduj")
		private WebElement Proccedbtn;
	
		@FindBy(how = How.CSS, using = "#li_submit")
		private WebElement SFsubmit;
	
		@FindBy(how = How.CSS, using = "#li_name")
		private WebElement Ufname;
	
		@FindBy(how = How.CSS, using = "#li_email_id")
		private WebElement UEmail;
	
		// =========================== Short Form Page Locators 	// =============================================================== //
	
		@FindBy(how = How.CSS, using = "#li_first_name")
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
	
		@FindBy(how = How.CSS, using = "#dv_karza_buttons > div.col-sm-5.col-xs-5.pad0.pad20t > span")
		private WebElement PanKarza;
	
		// ============= General Information =========================================
		// //
		@FindBy(how = How.CSS, using = "#view_more_section > a")
		private WebElement ViewMore;
	
		@FindBy(how = How.CSS, using = "#btn_102")
		private WebElement ClickCard;
	
		@FindBy(how = How.CSS, using = "#married")
		private WebElement MaritalStatus;
	
		
	
		// ======================= CRM login ==============
	
		@FindBy(how = How.CSS, using = "#txt_emailid")
		private WebElement CRMUserlogin;
	
		@FindBy(how = How.CSS, using = "#txt_password")
		private WebElement CRMPasslogin;
	
		@FindBy(how = How.CSS, using = "#btn_login")
		private WebElement LoginSubmit;
	
		@FindBy(how = How.CSS, using = ("#navbar > ul > li:nth-child(1)"))
		private WebElement Creditcardlink;
	
		@FindBy(how = How.CSS, using = ("#navbar > ul > li:nth-child(1) > a"))
		private WebElement Creditcard;
	
		@FindBy(how = How.XPATH, using = ("#dv_application_list > div > table > tbody > tr:nth-child(1) > td:nth-child(3) > a"))
		private WebElement Openlead;
	
		
		@FindBy(how = How.XPATH, using = ("#btn_add_card"))
		private WebElement AddCard;
	
		@FindBy(how = How.CSS, using = ("#ddl_eligible_bank_0"))
		private WebElement addcomp;
	
		@FindBy(how = How.XPATH, using = ("//*[@id=\"ddl_eligible_card_0\"]"))
		private WebElement addcard;
	
		@FindBy(how = How.XPATH, using = ("//*[@id=\"status3\"]/form/div[4]/div[2]/button[1]"))
		private WebElement submitcard;
	
		public CC_CRM_CITILender_Page(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
	
		// ========== Verify Basic Details Page Header 	// =================================//
		public void enterBasicdetailsToCheckLoanEligibility() throws Exception {
	
			clickCClink.click();
			clickCITIlender.click();
			
			try {	
		
		driver.findElement(By.cssSelector("#li_first_name")).sendKeys("Test User");
		driver.findElement(By.cssSelector("#li_res_pin")).sendKeys("110020");
		
		Select dropdown=new Select(driver.findElement(By.cssSelector("#li_emp_type")));
		dropdown.selectByVisibleText("Salaried");
		
		driver.findElement(By.cssSelector("#li_company_name")).sendKeys("IBM");
		Thread.sleep(8000);
		driver.findElement(By.cssSelector("#a_loc1")).click();
		driver.findElement(By.cssSelector("#li_monthly_salary")).sendKeys("65000");
		driver.findElement(By.cssSelector("#li_email_id")).sendKeys("test@test.com");
		driver.findElement(By.cssSelector("#li_mobile_number")).sendKeys(mobileno);
		
		Select cardType=new Select(driver.findElement(By.cssSelector("#card_type")));
		cardType.selectByIndex(1);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#li_submit")).click();
			
		Thread.sleep(6000);
		Mobileotp();
		Thread.sleep(4000);
	
		CRM_Login(mobileno);
		
		
	}
	
	catch (Exception e1) {
		e1.printStackTrace();
		System.out.println("Failed on Baisc Detailed Page :" + e1.getMessage());
	}
	}
		
		public String CRM_Login(String mobileno) throws InterruptedException {
	
			System.out.println(mobileno);
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//driver//" + "chromedriver.exe");
			driver.get("https://crmcc.indialends.com/login.aspx");
	
			Thread.sleep(1000);
			driver.manage().window().maximize();
	
			WebDriverWait wait = new WebDriverWait(driver, 2000);
			CRMUserlogin.sendKeys(Base.loadPropertiesFile("CRMLogin.properties", "user"));
			CRMPasslogin.sendKeys(Base.loadPropertiesFile("CRMLogin.properties", "pass"));
			driver.findElement(By.cssSelector("#btn_login")).click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("#navbar > ul > li:nth-child(2) > a")).click();
			driver.findElement(By.cssSelector("#navbar > ul > li.dropdown.open > ul > li:nth-child(2) > a")).click();
			Thread.sleep(3000);
			
			Select filter=new Select(driver.findElement(By.cssSelector("#ddl_filter")));
			filter.selectByIndex(1);
			
			driver.findElement(By.cssSelector("#txt_keyword")).sendKeys(mobileno);
			driver.findElement(By.cssSelector("#btn_search")).click();
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,400)");
			
			driver.findElement(By.cssSelector("#dv_application_list > div > table > tbody > tr.bg-grey-lighter.font13 > td:nth-child(3) > a")).click();
			
			Thread.sleep(3000);
			
			ArrayList<String> tabs11 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs11.get(1));

			Thread.sleep(2000);
			JavascriptExecutor js11 = (JavascriptExecutor) driver;
			js11.executeScript("window.scrollBy(0,400)");
			
			driver.findElement(By.xpath("//*[@id=\"dv_cc_details\"]/div[1]/div/div/div/div/div/table/tbody/tr[1]/td[8]/button")).click();
			
			Thread.sleep(2000);
			
			int size=driver.findElements(By.tagName("iframe")).size();
			
		//	for(int i=0;i<=size;i++) {
				
				driver.switchTo().frame(0);
				Thread.sleep(3000);
				
				Select dd=new Select(driver.findElement(By.cssSelector("#li_birthdate")));
				dd.selectByValue("10");
		
				Select mm=new Select(driver.findElement(By.cssSelector("#li_birthmonth")));
				mm.selectByValue("05");
			
				Select yr=new Select(driver.findElement(By.cssSelector("#li_birthyear")));
				yr.selectByValue("1980");
				
				driver.findElement(By.cssSelector("#div_gender > label > span.rd-chk-color.lh-35.font18 > i")).click();
				
				Select edu=new Select(driver.findElement(By.cssSelector("#li_edu_qualification")));
				edu.selectByIndex(3);
				
				driver.findElement(By.cssSelector("#div_marriage > label > span.rd-chk-color.lh-35.font18 > i")).click();
				driver.findElement(By.cssSelector("#li_pan_number")).clear();
				driver.findElement(By.cssSelector("#li_pan_number")).sendKeys(Base.randommPAN());
				
				//Present Residential Address
				driver.findElement(By.cssSelector("#li_res_house_no")).sendKeys("10");
				driver.findElement(By.cssSelector("#li_res_street")).sendKeys("Delhi");
				driver.findElement(By.cssSelector("#li_res_landmark")).sendKeys("Landmark");
				driver.findElement(By.cssSelector("#li_res_area")).sendKeys("Locality");
				
				//Proof of Address
				Select addr=new Select(driver.findElement(By.cssSelector("#li_add_proof")));
				addr.selectByIndex(2);
				
				//Present Office Address
				driver.findElement(By.cssSelector("#li_off_pin")).sendKeys("110020");
				driver.findElement(By.cssSelector("#li_off_house_no")).sendKeys("20");
				driver.findElement(By.cssSelector("#li_off_street")).sendKeys("Delhi");
				driver.findElement(By.cssSelector("#li_off_landmark")).sendKeys("Delhi");
				driver.findElement(By.cssSelector("#li_off_area")).sendKeys("locality");
				
				//Additional Information
				driver.findElement(By.xpath("//*[@id=\"step_two_flow\"]/div[2]/div/div[19]/div/div[4]/div/label/span[1]/i")).click();
				driver.findElement(By.cssSelector("#li_father_name")).sendKeys("Father Name");
				driver.findElement(By.cssSelector("#li_mother_name")).sendKeys("Mother Name");
				driver.findElement(By.cssSelector("#li_res_phone")).sendKeys("20134512");
				driver.findElement(By.cssSelector("#li_off_phone")).sendKeys("29876032");
				
				Select desg=new Select(driver.findElement(By.cssSelector("#li_designation")));
				desg.selectByIndex(3);
				
				driver.findElement(By.xpath("//*[@id=\"step_two_flow\"]/div[2]/div/div[29]/div/div[4]/div/label/span[1]/i")).click();
				
				Select nat=new Select(driver.findElement(By.cssSelector("#li_nationality")));
				nat.selectByIndex(1);
				
				driver.findElement(By.cssSelector("#li_second_submit")).click();
				
				String msg=driver.findElement(By.cssSelector("#page-top > div.thankyou-header-top-bg.container-fluid > div > div > div > h3")).getText();
				System.out.println(msg);
				
				if(msg.contains("Thank You. Your application for Citi Bank Credit card has been successfully submitted."))
				{
					System.out.println("All details successfully saved");
				}else {
					System.out.println("Details is not saved");
				}
				Thread.sleep(3000);
				driver.close();
				driver.quit();
	//	}
	
			return mobileno;
		}
	
	
		public void Mobileotp() throws Exception {

			try {
				// OTP Verify
				// 6123000106
				System.out.println(mobileno);
				String passwrd = Utility.Otp_Call.request_otp(otpURL, mobileno);
				System.out.println("OTP Is:" + passwrd);

				String string = String.valueOf(passwrd);
				char[] ch = string.toCharArray();
				System.out.println(ch[3]);

				driver.findElement(By.cssSelector("#txt_otp0")).sendKeys(CharBuffer.wrap(new char[] { ch[0] }));
				driver.findElement(By.cssSelector("#txt_otp1")).sendKeys(CharBuffer.wrap(new char[] { ch[1] }));
				driver.findElement(By.cssSelector("#txt_otp2")).sendKeys(CharBuffer.wrap(new char[] { ch[2] }));
				driver.findElement(By.cssSelector("#txt_otp3")).sendKeys(CharBuffer.wrap(new char[] { ch[3] }));
				driver.findElement(By.cssSelector("#txt_otp4")).sendKeys(CharBuffer.wrap(new char[] { ch[4] }));
				driver.findElement(By.cssSelector("#txt_otp5")).sendKeys(CharBuffer.wrap(new char[] { ch[5] }));
				driver.findElement(By.cssSelector("#mobile_verification > div.modal-dialog.mobile-modal-dialog > div > div > div.pad20b.pad10t.pad10l.pad10r > label > span")).click();
				driver.findElement(By.cssSelector("#btn_verifyMobile")).click();

				Thread.sleep(2000);
				System.out.println("Sucessfully submitted OTP");

			} catch (Exception e) {

				System.out.println("Otp screen failure " + e.getMessage());
			}
		}
	}
