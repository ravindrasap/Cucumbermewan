package Page_Object_DB;

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

import TestScript.Verify_CC_SBI_lender_DB_Values;
import Utility.Base;

public class CC_SBI_LenderPage extends Base {

	protected WebDriver driver;
	static String mob=Base.randomMobile();
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

	@FindBy(how = How.CSS, using = "#radio-7")
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
	@FindBy(how = How.CSS, using = "#sbi_relation_no")
	private WebElement RelationNo;

	@FindBy(how = How.CSS, using = "#li_designation")
	private WebElement designation;

	@FindBy(how = How.CSS, using = "#bankwise_controls_submit")
	private WebElement FinalSubmit;

	public CC_SBI_LenderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterBasicdetailsToCheckLoanEligibility() throws Exception {

		driver.findElement(By.cssSelector(
				"#mainNav > div.container-fluid.md-pad10b.sm-pad0b > div.col-xs-12.col-sm-12.col-md-9.pad0 > div.collapse.navbar-collapse.navbar-ex1-collapse.pad10t.sm-pad0t.full-width > ul > li.dropdown > a"))
				.click();
		driver.findElement(By.cssSelector(
				"#mainNav > div.container-fluid.md-pad10b.sm-pad0b > div.col-xs-12.col-sm-12.col-md-9.pad0 > div.collapse.navbar-collapse.navbar-ex1-collapse.pad10t.sm-pad0t.full-width > ul > li.dropdown.open > ul > li:nth-child(2) > a"))
				.click();
		fullname.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "full_name"));
		// logger.log(LogStatus.INFO,"Enter first name : ");
		pincode.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "pincode"));
		empType.click();
		Select employeeTyp = new Select(empType);
		employeeTyp.selectByIndex(1);

		companyname.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "company"));
		Thread.sleep(8000);
		driver.findElement(By.cssSelector("#a_loc1")).click();

		salary.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "salary"));

		email.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "email"));
		mobile.sendKeys(mob);

		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("window.scrollBy(0,400)");

		Select card = new Select(driver.findElement(By.cssSelector("#card_type")));
		card.selectByIndex(2);

		clickNextBtn.click();
		System.out.println("Succesfully submitted Shortform information ");
		Thread.sleep(5000);

		try {
			// OTP Verify

			String passwrd = Utility.Otp_Call.request_otp(otpURL, mob);
			System.out.println("Mobile No is:"+mob);
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

		WebElement day = driver.findElement(By.cssSelector("#li_birthdate"));
		Select dropdown11 = new Select(day);
		dropdown11.selectByVisibleText(Base.loadPropertiesFile("CC_Data.properties", "DOB_DD"));

		WebElement month = driver.findElement(By.cssSelector("#li_birthmonth"));
		Select mon = new Select(month);
		mon.selectByValue(Base.loadPropertiesFile("CC_Data.properties", "DOB_MN"));

		WebElement year = driver.findElement(By.cssSelector("#li_birthyear"));
		Select yy = new Select(year);
		yy.selectByVisibleText(Base.loadPropertiesFile("CC_Data.properties", "DOB_Year"));

		gender.click();

		WebElement salry = driver.findElement(By.cssSelector("#li_salary_mode"));
		Select modeSal = new Select(salry);
		modeSal.selectByVisibleText("HDFC Bank");

		existingCard.click();
		driver.findElement(By.cssSelector("#bank_select > div > button")).click();
		driver.findElement(By.cssSelector("#bank_select > div > div > ul > li:nth-child(1)")).click();
		existingCard.click();
		driver.findElement(By.cssSelector("#cr_limit")).sendKeys(Base.loadPropertiesFile("CC_Data.properties","creditLimit"));
		
		Officepincode.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "offPincode"));
		PanNo.sendKeys(Base.randommPAN());
		Submit.click();

		WebDriverWait wait = new WebDriverWait(driver, 50);
		@SuppressWarnings("unused")
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(PanKarza));
		PanKarza.click();

		Thread.sleep(2000);

		System.out.println("Succesfully submitted PAN information ");
	}

	public void general_Information() throws Exception {

		MaritalStatus.click();
		// Qualification.click();
		WebElement edu = driver.findElement(By.cssSelector("#employmentSelect"));
		Select dropdown = new Select(edu);
		dropdown.selectByVisibleText(Base.loadPropertiesFile("CC_Data.properties","Education"));

		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("window.scrollBy(0,400)");

		// Present residential address//
		houseNo.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "houseNo"));
		street.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "street"));
		ResArea.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "ResArea"));
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,400)");

		// Office address
		OfficeNo.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "OfficeNo"));
		Officestreet.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "offStreet"));
		OfficeArea.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "offArea"));

		genricCLick.click();
        Thread.sleep(2000);
		System.out.println("Succesfully submitted general information ");

	}

	public void contact_Details() throws Exception {
		
		driver.findElement(By.cssSelector("#li_office")).click();
		driver.findElement(By.cssSelector("#landine_number")).sendKeys(Base.loadPropertiesFile("CC_Data.properties", "off_LandlineNo"));
        
		driver.findElement(By.cssSelector("#sbi_relation_yes")).click();
		
		Select relSbi=new Select(driver.findElement(By.cssSelector("#li_sbi_relation_type")));
		relSbi.selectByVisibleText(Base.loadPropertiesFile("CC_Data.properties","Relation_type"));
		
		driver.findElement(By.cssSelector("#account")).sendKeys(Base.loadPropertiesFile("CC_Data.properties", "Relation_ac"));
		designation.sendKeys(Base.loadPropertiesFile("CC_Data.properties","designation"));
		Thread.sleep(2000);
		designation.click();
		FinalSubmit.click();
		System.out.println("Final submit has done.");
		
		Thread.sleep(8000);
		
		Verify_CC_SBI_lender_DB_Values ccSbi=new Verify_CC_SBI_lender_DB_Values();
		ccSbi.fetchCCDBvalues(mob);
	}
}
