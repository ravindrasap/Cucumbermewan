package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utility.Base;

public class Genric_I2C {
	WebDriver driver;
	String mobileno=Base.randomMobile();
	String otpURL = "http://v.indialends.com/test/get_otp_user_registration_encrypt.ashx?type=json&mobileno=";
	@Test
	public void verify_genric_SF() throws Exception {
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://indialends.com/credit-card");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#btnnoscreen")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#li_mobile_number")).sendKeys(mobileno);
		driver.findElement(By.cssSelector("#btnSendOTP")).click();
		
		Thread.sleep(6000);
		String passwrd = Utility.Otp_Call.request_otp(otpURL, mobileno);
		System.out.println("Mobile no is:" + mobileno);
		System.out.println("OTP is:" + passwrd);
		
		driver.findElement(By.cssSelector("#txt_otp0")).sendKeys(passwrd);
		driver.findElement(By.cssSelector("#mobile_verification > div.modal-dialog.mobile-modal-dialog > div > div > div.pad20b.pad10t.pad10l.pad10r > label > span")).click();
		driver.findElement(By.cssSelector("#btn_verifyMobile")).click();
         
		WebDriverWait wait = new WebDriverWait(driver, 50);
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
		
		driver.findElement(By.cssSelector("#li_company_name")).sendKeys("IBM");
		Thread.sleep(8000);
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
		driver.findElement(By.cssSelector("#li_pan_number")).sendKeys(Base.randommPAN());
		driver.findElement(By.cssSelector("#li_submit_pan_details")).click();
		
		Thread.sleep(6000);
		
		driver.findElement(By.cssSelector("#dv_karza_buttons > div.col-sm-5.col-xs-5.pad0.pad20t > span")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#btn_102")).click();
		
		CC_Genric_CRM launchCRM=new CC_Genric_CRM();
		launchCRM.verify_crm_I2C(mobileno);
		
		
	
	}

}
