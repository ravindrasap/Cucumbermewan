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
import org.testng.Assert;
import Utility.Base;

public class CC_CRM_ICICILender_Page  extends Base{
protected WebDriver driver;
	
	String mobileno = Base.randomMobile();
	// String mobileno = "6123000111";
	String data = mobileno;
	@FindBy(how = How.XPATH, using = "//li[@class='dropdown']")
	private WebElement clickCClink;

	@FindBy(how = How.XPATH, using = "//*[@id=\"mainNav\"]/div[6]/div[1]/div[2]/ul/li[2]/ul/li[6]/a")
	private WebElement clickICICIlender;
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

	
	// =======================================================

	public CC_CRM_ICICILender_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ========== Verify Basic Details Page Header 	// =================================//
	public void enterBasicdetailsToCheckLoanEligibility() throws Exception {

		clickCClink.click();
		clickICICIlender.click();
		
		try {

				fname.clear();
				fname.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "full_name"));
				pincode.sendKeys("110030");
				empType.click();
				Select employeeTyp = new Select(empType);
				employeeTyp.selectByIndex(1);

				companyname.sendKeys("GOOGLE INDIA");
				
				salary.sendKeys("50000");
				Thread.sleep(1000);
				email.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "email"));
				Thread.sleep(1000);
				// String mobile=mobileNo;
				mobile.sendKeys(mobileno);

				// card selection
				WebElement card = driver.findElement(By.cssSelector("#card_type"));
				Select cardType = new Select(card);
				cardType.selectByIndex(1);

				clickNextBtn.click();
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
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#navbar > ul > li:nth-child(2) > a")).click();
		driver.findElement(By.cssSelector("#navbar > ul > li.dropdown.open > ul > li:nth-child(2) > a")).click();
		
		Select filter=new Select(driver.findElement(By.cssSelector("#ddl_filter")));
		filter.selectByIndex(1);
		
		driver.findElement(By.cssSelector("#txt_keyword")).sendKeys(mobileno);
		driver.findElement(By.cssSelector("#btn_search")).click();
		
		driver.findElement(By.cssSelector("#dv_application_list > div > table > tbody > tr.bg-grey-lighter.font13 > td:nth-child(3) > a")).click();
		
		Thread.sleep(3000);
		
		ArrayList<String> tab=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
		
		Thread.sleep(1000);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		
		driver.findElement(By.xpath("//*[@id=\"dv_cc_details\"]/div[1]/div/div/div/div/div/table/tbody/tr[1]/td[8]/button")).click();
		
		Thread.sleep(2000);
		
		int size=driver.findElements(By.tagName("frame")).size();
		//System.out.println("Size of frame is:"+size);
		
		for(int i=0;i<=size;i++) {
			
			driver.switchTo().frame(0);
			
			Select dd=new Select(driver.findElement(By.cssSelector("#li_birthdate")));
			dd.selectByValue("10");
			
			Select mm=new Select(driver.findElement(By.cssSelector("#li_birthmonth")));
			mm.selectByIndex(5);
			
			Select yr=new Select(driver.findElement(By.cssSelector("#li_birthyear")));
			yr.selectByValue("1986");
			
			driver.findElement(By.cssSelector("#div_gender > label > span.rd-chk-color.lh-35.font18")).click();
			
			Select edu=new Select(driver.findElement(By.cssSelector("#li_edu_qualification")));
			edu.selectByIndex(3);
			
			driver.findElement(By.cssSelector("#div_marriage > label > span.rd-chk-color.lh-35.font18 > i")).click();
			driver.findElement(By.cssSelector("#li_pan_number")).sendKeys(Base.randommPAN());
			
			Select empType=new Select(driver.findElement(By.cssSelector("#li_emp_type")));
			empType.selectByIndex(1);
			
			Select card=new Select(driver.findElement(By.xpath("//*[@id=\"li_card_type\"]")));
			card.selectByValue("701");
			
			driver.findElement(By.cssSelector("#li_res_house_no")).sendKeys("House no");
			driver.findElement(By.cssSelector("#li_res_street")).sendKeys("Street name");
			driver.findElement(By.cssSelector("#li_res_landmark")).sendKeys("Landmark");
			driver.findElement(By.cssSelector("#li_res_area")).sendKeys("Locality");
			
			Select addr=new Select(driver.findElement(By.cssSelector("#li_add_proof")));
			addr.selectByIndex(3);
			
			Select id=new Select(driver.findElement(By.cssSelector("#li_id_proof")));
			id.selectByIndex(2);
			
			driver.findElement(By.cssSelector("#li_off_pin")).sendKeys("110020");
			driver.findElement(By.cssSelector("#li_off_house_no")).sendKeys("Office No");
			driver.findElement(By.cssSelector("#li_off_street")).sendKeys("Office Street name");
			driver.findElement(By.cssSelector("#li_off_landmark")).sendKeys("Office Landmark");
			driver.findElement(By.cssSelector("#li_off_area")).sendKeys("Office locality");
			
			JavascriptExecutor js1=(JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,400)");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"step_two_flow\"]/div[2]/div/div[17]/div/div[4]/div/label/span[1]/i")).click();
			
			Select relation=new Select(driver.findElement(By.cssSelector("#li_relation_type")));
			relation.selectByIndex(1);
			
			Select salaryMode=new Select(driver.findElement(By.cssSelector("#li_salary_mode")));
			salaryMode.selectByIndex(1);
			
			driver.findElement(By.cssSelector("#li_res_phone")).sendKeys("23123456");
			driver.findElement(By.cssSelector("#li_off_phone")).sendKeys("73212342");
			driver.findElement(By.xpath("//*[@id=\"dv_3_salary_slip\"]/div/div[4]/div/label/span[1]/i")).click();
			driver.findElement(By.cssSelector("#li_second_submit")).click();
			
			Thread.sleep(2000);
			
			Select card1=new Select(driver.findElement(By.xpath("//*[@id=\"li_card_type\"]")));
			card1.selectByValue("701");
			
			JavascriptExecutor js2=(JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,400)");
			
			driver.findElement(By.cssSelector("#li_second_submit")).click();
			Thread.sleep(4000);
			
			String msg=driver.findElement(By.cssSelector("#page-top > div.thankyou-header-top-bg.container-fluid > div > div > div > h3")).getText();
			System.out.println(msg);
			
			if(msg.contains("Thank You. Your application for ICICI Bank Credit card has been successfully submitted."))
			{
				System.out.println("All details successfully saved");
			}else {
				System.out.println("Details is not saved");
			}
			Thread.sleep(3000);
			driver.close();
			driver.quit();
	}

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
