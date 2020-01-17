
import java.nio.CharBuffer;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utility.Base;

public class HDFCCreditCard {
	public static WebDriver driver;
	String mobileno=Base.randomMobile();
//UAT	
	//String otpURL="http://uat.indialends.com/internal/a/get_otp_mail_verify_api.ashx?mobileno=";
	
// Live	
	
	String otpURL="https://v.indialends.com/test/get_otp_user_registration_encrypt.ashx?type=json&mobileno=";
	
	String salary="47000";
	String pincode="110020";
	String company="I";
	
	String loanamount="65000";
	String DOB_year="1988";
		
	String Pan_NO="ABCPD1234E";
		
	
	
	
	@BeforeClass
	public void set_UP()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ravindrakumar\\eclipse-workspace\\IndiaLends_Sanity\\driver\\chromedriver.exe");
		System.out.println("launching chrome browser");
	
		driver = new ChromeDriver();
		driver.navigate().to("https://indialends.com/credit-cards/");
	//	driver.navigate().to("https://staging.indialends.com/credit-cards/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.manage().window().maximize();
}
	@Test(priority=0)
	public void verify_PL_Form() throws Exception {
		
		//Basic Details
		driver.findElement(By.cssSelector("#li_first_name")).sendKeys("MUKUT MEENA");	
		driver.findElement(By.cssSelector("#li_res_pin")).sendKeys(pincode);
		
		WebElement empType=driver.findElement(By.cssSelector("#li_emp_type"));
		Select dropdown=new Select(empType);
		dropdown.selectByVisibleText("Salaried");
		Thread.sleep(3000);
				
		 
		driver.findElement(By.cssSelector("#li_company_name")).sendKeys(company);
        Thread.sleep(6000);
        driver.findElement(By.cssSelector("#a_loc1")).click();
		driver.findElement(By.cssSelector("#li_monthly_salary")).sendKeys(salary);
		driver.findElement(By.cssSelector("#li_email_id")).sendKeys("Testuser@gmail.com");
		driver.findElement(By.cssSelector("#li_mobile_number")).sendKeys(mobileno);
		System.out.println(mobileno);
		driver.findElement(By.cssSelector("#li_submit")).click();
		
		Thread.sleep(4000);
		
	}
	@Test(priority=1)
	public void verify_OTP() throws Exception {
		
		//OTP Verify
		
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
		//driver.findElement(By.cssSelector("#mobile_verification > div > div > div > a")).click();
		
		driver.findElement(By.xpath("//span[@class='checkmark']")).click();
		
		driver.findElement(By.cssSelector("#mobile_verification > div > div > div > a")).click();
		
		Thread.sleep(3000);
		System.out.println("Sucessfully submitted OTP");
		
		
	}

	@Test(priority=2)
	public void check_Eligibility() throws Exception {
		
		WebElement day=driver.findElement(By.cssSelector("#li_birthdate"));
		Select dropdown11=new Select(day);
		dropdown11.selectByVisibleText("02");
		
		WebElement month=driver.findElement(By.cssSelector("#li_birthmonth"));
		Select mon=new Select(month);
		mon.selectByVisibleText("FEB - 02");
		
		WebElement year=driver.findElement(By.cssSelector("#li_birthyear"));
		Select yy=new Select(year);
		yy.selectByVisibleText("1990");
		
		driver.findElement(By.cssSelector("#female")).click();
				
		WebElement salry=driver.findElement(By.cssSelector("#li_salary_mode"));
		Select modeSal=new Select(salry);
		modeSal.selectByVisibleText("HDFC Bank");
		
		driver.findElement(By.cssSelector("#radio-8")).click();
		driver.findElement(By.cssSelector("#li_off_pin")).sendKeys("110030");
		driver.findElement(By.cssSelector("#li_pan_number")).sendKeys("HDFPC1981C");
		
		driver.findElement(By.cssSelector("#li_submit_pan_details")).click();
		
		driver.findElement(By.cssSelector("#dv_karza_buttons > div.col-sm-6.text-center.pad10.pad15t > span")).click();
		Thread.sleep(2000);
	
	}
	@Test(priority=3)
	public void general_Information() throws Exception {
		
		driver.findElement(By.cssSelector("#view_more_section > a")).click();
		Thread.sleep(2000);
				
		 List<WebElement> offer = driver.findElements(By.tagName("h5"));
	        System.out.println("Total offer size is: "+offer.size());

	        for(int i=0; i<offer.size();i++){
	            //Thread.sleep(200);
	            System.out.println(i+ "."+offer.get(i).getText());
	        }
	        Thread.sleep(3000);
	        driver.findElement(By.cssSelector("#btn_805")).click();
	/*	driver.findElement(By.cssSelector("#priority_cards > div:nth-child(1) > div.panel-body > div.col-md-8.pad0 > div.col-xs-5.col-sm-6.pad0l.text-right.pad10t.md-pad20t.btn-section > span")).click();
		
		*/
		//Marital Status
	        driver.findElement(By.cssSelector("#married")).click();
		driver.findElement(By.cssSelector("#pg")).click();
		
		//Office address
		//driver.findElement(By.cssSelector("#li_off_door_no")).sendKeys("10");
	//	driver.findElement(By.cssSelector("#li_off_street")).sendKeys("Delhi");
	//	driver.findElement(By.cssSelector("#li_off_area")).sendKeys("Delhi");
	//	driver.findElement(By.cssSelector("#generic_details_step1")).click();
	    
		//Present residential address//
		driver.findElement(By.cssSelector("#li_res_house_no")).sendKeys("10");
		driver.findElement(By.cssSelector("#li_res_street")).sendKeys("Delhi");
		
		driver.findElement(By.cssSelector("#li_res_area")).sendKeys("Delhi ");
		Thread.sleep(2000);
		
	
		//Present office address
		driver.findElement(By.cssSelector("#li_off_house_no")).sendKeys("10");
		driver.findElement(By.cssSelector("#li_off_street")).sendKeys("Delhi");
		driver.findElement(By.cssSelector("#li_off_area")).sendKeys("Delhi");
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		 js1.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.cssSelector("#generic_details_step1")).click();
		
		
	}
	
	@Test(priority=4)
	public void contact_Details() {
		driver.findElement(By.cssSelector("#li_office")).click();
	//	driver.findElement(By.cssSelector("#landine_code")).sendKeys("011");
		driver.findElement(By.cssSelector("#landine_number")).sendKeys("26826826");
		driver.findElement(By.cssSelector("#salary_slip_yes")).click();
		driver.findElement(By.cssSelector("#bankwise_controls_submit")).click();
	}
	
	
	@AfterClass
	public void tear_down() {
		
	//driver.quit();
	}
	
}
