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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Base;

public class CC_CRM_SBIGeneric_Page extends Base {

   protected WebDriver driver;
	
	String mobileno = Base.randomMobile();
	// String mobileno = "6123000111";
	String data = mobileno;
	@FindBy(how = How.XPATH, using = "//li[@class='dropdown']")
	private WebElement clickCClink;

	@FindBy(how = How.XPATH, using = "//*[@id=\"mainNav\"]/div[6]/div[1]/div[2]/ul/li[2]/ul/li[1]/a")
	private WebElement clicGenericflow;
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

	@FindBy(how=How.CSS, using="#dv_karza_buttons > div.col-sm-5.col-xs-5.pad0.pad20t > span")
	//@FindBy(how=How.CSS, using="#dv_karza_buttons > div.col-sm-6.text-center.pad10.pad15t > span")
	private WebElement PanKarza;
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

		@FindBy(how = How.CSS, using = "#li_pan_number")
		private WebElement PanNo;

		// =======================================================

		public CC_CRM_SBIGeneric_Page(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	
	
	public void enterBasicdetailsToCheckLoanEligibility() {
		// TODO Auto-generated method stub
		clickCClink.click();
		clicGenericflow.click();
		
		try {

			driver.findElement(By.cssSelector("#btnnoscreen")).click();
			mobile.sendKeys(mobileno);
			driver.findElement(By.cssSelector("#btnSendOTP")).click();
			Thread.sleep(8000);
			Mobileotp();
			Thread.sleep(4000);
			WebDriverWait wait = new WebDriverWait(driver, 500);
			@SuppressWarnings("unused")
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#li_name")));
			
			driver.findElement(By.cssSelector("#li_name")).clear();
			driver.findElement(By.cssSelector("#li_name")).sendKeys("Test User");
			driver.findElement(By.cssSelector("#li_email_id")).clear();
			driver.findElement(By.cssSelector("#li_email_id")).sendKeys("test644@gmail.com");
			driver.findElement(By.cssSelector("#btnproceeduj")).click();
			driver.findElement(By.cssSelector("#li_res_pin")).clear();
			driver.findElement(By.cssSelector("#li_res_pin")).sendKeys("110020");
			Select empType=new Select(driver.findElement(By.cssSelector("#li_emp_type")));
			empType.selectByIndex(1);
			
			driver.findElement(By.cssSelector("#li_company_name")).sendKeys("GOOGLE INDIA");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("#a_loc1")).click();
			driver.findElement(By.cssSelector("#li_monthly_salary")).sendKeys("65000");
			driver.findElement(By.cssSelector("#li_submit")).click();
			Thread.sleep(7000);
			
			Select dd=new Select(driver.findElement(By.cssSelector("#li_birthdate")));
			dd.selectByIndex(1);
			
			Select mm=new Select(driver.findElement(By.cssSelector("#li_birthmonth")));
			mm.selectByIndex(3);
			
			Select yr=new Select(driver.findElement(By.cssSelector("#li_birthyear")));
			yr.selectByValue("1986");
			
			driver.findElement(By.cssSelector("#male")).click();
			
			Select salaryMode=new Select(driver.findElement(By.cssSelector("#li_salary_mode")));
			salaryMode.selectByValue("9");
			
			driver.findElement(By.cssSelector("#radio-8")).click();
			driver.findElement(By.cssSelector("#li_off_pin")).sendKeys("110020");
			//driver.findElement(By.cssSelector("#li_pan_number")).sendKeys(Base.randommPAN());
		//	driver.findElement(By.cssSelector("#li_submit_pan_details")).click();
			
			Thread.sleep(6000);
			PanNo.sendKeys(Base.randommPAN());
			driver.findElement(By.cssSelector("#li_submit_pan_details")).click();
			
			WebDriverWait wait1 = new WebDriverWait(driver, 10000);
			wait1.until(ExpectedConditions.visibilityOf(PanKarza));
			Thread.sleep(10000);
			PanKarza.click();
			Thread.sleep(4000);
				
			Thread.sleep(3000);
			
			driver.findElement(By.cssSelector("#btn_102")).click();
			Thread.sleep(6000);
				CRM_Login(mobileno);

			}

			catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("Failed on Baisc Detailed Page :" + e1.getMessage());
			}
		}
	//}

	// =======================================================================================================
	public String CRM_Login(String mobileno) throws InterruptedException {

		System.out.println(mobileno);
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//driver//" + "chromedriver.exe");
		driver.get("https://crmcc.indialends.com/login.aspx");

		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		CRMUserlogin.sendKeys(Base.loadPropertiesFile("CRMLogin.properties", "user"));
		CRMPasslogin.sendKeys(Base.loadPropertiesFile("CRMLogin.properties", "pass"));
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		
		driver.findElement(By.cssSelector("#btn_login")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#navbar > ul > li:nth-child(2) > a")).click();

		driver.findElement(By.cssSelector("#navbar > ul > li.dropdown.open > ul > li:nth-child(2)")).click();

		Thread.sleep(4000);

		// search the lead and compete the lead

		Thread.sleep(1000);

		/// search the lead with Mobile number

		Select filter = new Select(driver.findElement(By.cssSelector("#ddl_filter")));
		filter.selectByIndex(1);

		driver.findElement(By.cssSelector("#txt_keyword")).sendKeys(mobileno);

		driver.findElement(By.cssSelector("#btn_search")).click();

		///////////////////////////////////////////// Open the lead /////////

		driver.findElement(By.cssSelector("#dv_application_list > div > table > tbody > tr:nth-child(1) > td:nth-child(3) > a")).click();

		ArrayList<String> tabs21 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs21.get(1));

		Thread.sleep(2000);
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("window.scrollBy(0,400)");

		///////////// click incomplete button //////////////////////////

		driver.findElement(By.xpath("//*[@id=\"dv_cc_details\"]/div[1]/div/div/div/div/div/table/tbody/tr[1]/td[8]/button")).click();
		Thread.sleep(6000);
		// Enter the user details ////////////////////

		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total size of frame:" + size);

		//for (int i = 0; i <= size; i++) {

			driver.switchTo().frame(0);
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("#li_first_name")).clear();
			// fname.clear();
			driver.findElement(By.cssSelector("#li_first_name")).sendKeys("Test");

			driver.findElement(By.cssSelector("#li_first_name")).clear();
			// fname.clear();
			driver.findElement(By.cssSelector("#li_first_name")).sendKeys("test1");

			/////////// select the DOB //////////////////////

			WebElement day = driver.findElement(By.cssSelector("#li_birthdate"));
			Select dropdown11 = new Select(day);
			dropdown11.selectByVisibleText("04");

			Thread.sleep(1000);
			WebElement month = driver.findElement(By.cssSelector("#li_birthmonth"));
			Select mon = new Select(month);
			mon.selectByVisibleText("MAR");

			WebElement year = driver.findElement(By.cssSelector("#li_birthyear"));
			Select yy = new Select(year);
			yy.selectByVisibleText("1986");

			driver.findElement(By.xpath("//*[@id=\"div_gender\"]/label/span[1]")).click();

			WebElement edu = driver.findElement(By.cssSelector("#li_edu_qualification"));
			Select dropdown = new Select(edu);
			dropdown.selectByIndex(1);

			driver.findElement(By.cssSelector("#div_marriage > label > span.rd-chk-color.lh-35.font18")).click();
			
			/////// PAN ////////////

			PanNo.sendKeys(Base.randommPAN());
			
			JavascriptExecutor js111 = (JavascriptExecutor) driver;
			js111.executeScript("window.scrollBy(0,400)");

			
			//////////// Select Card Type //////////////////////
			
						
			WebElement card = driver.findElement(By.cssSelector("#li_card_type"));
			Select cardtypes = new Select(card);
		    cardtypes.selectByIndex(1);
			
			
			////////// present office address ////////////////
	
			// Present residential address///////
			
			// houseNo.sendKeys("10");
			driver.findElement(By.cssSelector("#li_res_house_no")).sendKeys("10");
			driver.findElement(By.cssSelector("#li_res_street")).sendKeys("Delhi");
			driver.findElement(By.cssSelector("#li_res_landmark")).sendKeys("Delhi");
			driver.findElement(By.cssSelector("#li_res_area")).sendKeys("Saket");

			Thread.sleep(2000);
			JavascriptExecutor js1111 = (JavascriptExecutor) driver;
			js1111.executeScript("window.scrollBy(0,400)");

			// Office address
		
			driver.findElement(By.cssSelector("#li_off_pin")).sendKeys("122001");
			driver.findElement(By.cssSelector("#li_off_house_no")).sendKeys("Sector18");
			driver.findElement(By.cssSelector("#li_off_street")).sendKeys("Sector18");
			driver.findElement(By.cssSelector("#li_off_landmark")).sendKeys("Gurgaon");
			driver.findElement(By.cssSelector("#li_off_area")).sendKeys("Gurgaon");

			driver.findElement(By.xpath("//*[@id=\"step_two_flow\"]/div[2]/div/div[15]/div/div[4]/div/label/span[1]")).click();
			
			Thread.sleep(2000);
			JavascriptExecutor js11111 = (JavascriptExecutor) driver;
			js11111.executeScript("window.scrollBy(0,400)");
			
			driver.findElement(By.xpath("//*[@id=\"div_sbi_relationship\"]/div/div[4]/div/label/span[1]")).click();
			
			driver.findElement(By.cssSelector("#li_off_phone")).sendKeys("9560229");
			
		
			
			driver.findElement(By.cssSelector("#li_designation")).sendKeys("SOFTWARE ANALYST");
			driver.findElement(By.cssSelector("#li_second_submit")).click();

			// *[@id="div_gender"]/label/span[1]

			Thread.sleep(10000);
			String congt = driver.findElement(By.cssSelector("#page-top > div.thankyou-header-top-bg.container-fluid > div > div > div > h3")).getText();

			String[] arrOfStr = congt.split("!", 2);

			for (String a : arrOfStr)
				System.out.println(a);

			if (arrOfStr.equals("Congratulations")) {
				System.out.println(" Congratulations Lead is created sucessfully ");
			}
			Thread.sleep(3000);
		//	driver.close();
			//driver.quit();
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
