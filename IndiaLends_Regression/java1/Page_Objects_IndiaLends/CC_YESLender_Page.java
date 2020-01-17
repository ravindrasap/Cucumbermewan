package Page_Objects_IndiaLends;

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

public class CC_YESLender_Page extends Base {
	
    protected WebDriver driver;
    
 // =========================== Short Form Page Locators============================================= //

 	@FindBy(how = How.CSS, using = "#li_first_name")
 	private WebElement fullname;

 	@FindBy(how = How.CSS, using = "#li_email_id")
 	private WebElement email;

 	@FindBy(how = How.CSS, using = "#li_mobile_number")
 	private WebElement mobile;

 	@FindBy(how = How.CSS, using = "#li_res_pin")
 	private WebElement pincode;

 	@FindBy(how = How.CSS, using = "#li_emp_type")
 	private WebElement empType;

 	@FindBy(how = How.CSS, using = "#li_company_name")
 	private WebElement companyname;

 	@FindBy(how = How.CSS, using = "#li_monthly_salary")
 	private WebElement salary;

 	@FindBy(how = How.CSS, using = "#card_type")
 	private WebElement cardType;

 	@FindBy(how = How.CSS, using = "#li_submit")
 	private WebElement clickNextBtn;

   // =========================== Otp Screen & I-lite Locators========================================== //

 	@FindBy(how = How.XPATH, using = "//*[@id=\"txt_otp\"]")
 	private WebElement otptake;

 	@FindBy(how = How.XPATH, using = "//*[@id=\"btn_mobile_verify\"]")
 	private WebElement otpVerify;

 	@FindBy(how = How.CSS, using = "#control-indicator")
 	private WebElement terms;

 	// ============================= Check Eligibility===============================================//

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
 	
 	@FindBy(how = How.CSS, using = "#view_more_section > a")
 	private WebElement ViewMore;

 	@FindBy(how = How.CSS, using = "#btn_102")
 	private WebElement ClickCard;

 	@FindBy(how = How.CSS, using = "#married")
 	private WebElement MaritalStatus;

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

 	// ====================== Contact Details===========================================//
 	@FindBy(how = How.CSS, using = "#residenceSelect")
 	private WebElement ownership;

 	@FindBy(how = How.CSS, using = "#landine_number")
 	private WebElement landlineNo;

 	@FindBy(how = How.CSS, using = "#bankwise_controls_submit")
 	private WebElement FinalSubmit;
	
 
	public CC_YESLender_Page(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		
	}
	
	public void enterBasicdetailsToCheckLoanEligibility() throws Exception {

		/*driver.findElement(By.cssSelector(
				"#mainNav > div.container-fluid.md-pad10b.sm-pad0b > div.col-xs-12.col-sm-12.col-md-9.pad0 > div.collapse.navbar-collapse.navbar-ex1-collapse.pad10t.sm-pad0t.full-width > ul > li.dropdown > a"))
				.click();
		driver.findElement(By.cssSelector(
				"#mainNav > div.container-fluid.md-pad10b.sm-pad0b > div.col-xs-12.col-sm-12.col-md-9.pad0 > div.collapse.navbar-collapse.navbar-ex1-collapse.pad10t.sm-pad0t.full-width > ul > li.dropdown.open > ul > li:nth-child(1) > a"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#myNavbar > ul > li.dropdown.open > a")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#myNavbar > ul > li.dropdown.open > ul > li:nth-child(8) > a")).click();*/
		fullname.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "full_name"));
		// logger.log(LogStatus.INFO,"Enter first name : ");
		pincode.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "pincode"));
		empType.click();
		Select employeeTyp = new Select(empType);
		employeeTyp.selectByIndex(1);
        
		//driver.findElement(By.cssSelector("#is_itr_yes")).click();  //For SelfEmployed
		//driver.findElement(By.cssSelector("#is_itr_no")).click();   //For SelfEmployed
		
		companyname.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "company"));
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#a_loc1")).click();

		salary.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "salary"));
       // driver.findElement(By.cssSelector("#li_monthly_salary1")).sendKeys(Base.loadPropertiesFile("CC_Data.properties", "salary"));  //For selfemployed salary
		email.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "email"));
		 Thread.sleep(1000);
		mobile.sendKeys(mobileno);

		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("window.scrollBy(0,300)");
         Thread.sleep(1000);
		Select card = new Select(driver.findElement(By.cssSelector("#card_type")));
		card.selectByIndex(1);

		clickNextBtn.click();
		System.out.println("Succesfully submitted Shortform information ");
		Thread.sleep(5000);

		try {
			// OTP Verify

			String passwrd = Utility.Otp_Call.request_otp(otpURL, mobileno);
			System.out.println("OTP Is:" + passwrd);

			driver.findElement(By.cssSelector("#txt_otp0")).sendKeys(passwrd);
			driver.findElement(By.xpath("//*[@id=\"mobile_verification\"]/div[1]/div/div/div[2]/label/span")).click();
			driver.findElement(By.cssSelector("#btn_verifyMobile")).click();

			Thread.sleep(2000);
			System.out.println("Sucessfully submitted OTP");
		} catch (Exception e) {

			System.out.println("Otp screen failure " + e.getMessage());
		}

	}

	public void check_Eligibility() throws Exception {
		try {
		WebElement day = driver.findElement(By.cssSelector("#li_birthdate"));
		Select dropdown11 = new Select(day);
		dropdown11.selectByVisibleText("04");

		WebElement month = driver.findElement(By.cssSelector("#li_birthmonth"));
		Select mon = new Select(month);
		mon.selectByVisibleText("MAR - 03");

		WebElement year = driver.findElement(By.cssSelector("#li_birthyear"));
		Select yy = new Select(year);
		yy.selectByVisibleText("1996");

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

		System.out.println("Succesfully submitted PAN information ");
	}

	public void general_Information() throws Exception {

		MaritalStatus.click();
		// Qualification.click();
		WebElement edu = driver.findElement(By.cssSelector("#employmentSelect"));
		Select dropdown = new Select(edu);
		dropdown.selectByVisibleText("Post Graduate");

		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("window.scrollBy(0,400)");

		// Present residential address//
		houseNo.sendKeys("10");
		street.sendKeys("Delhi");
		ResArea.sendKeys("Delhi");
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,400)");

		// Office address
		OfficeNo.sendKeys("10");
		Officestreet.sendKeys("Delhi");
		OfficeArea.sendKeys("Delhi");

		genricCLick.click();

		System.out.println("Succesfully submitted general information ");

	}

	public void contact_Details() throws Exception {

		landlineNo.sendKeys("21343454");
		Thread.sleep(2000);
		
		Select owner=new Select(ownership);
		owner.selectByIndex(1);
		
		WebElement cibil=driver.findElement(By.cssSelector("#report_status"));
		Select cibilType=new Select(cibil);
		cibilType.selectByIndex(13);
		
		FinalSubmit.click();

		System.out.println("Final submit has done.");
	}

}
