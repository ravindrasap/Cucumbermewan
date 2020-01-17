package TestScript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.Base;

public class Verify_CR_Values  {
	
WebDriver driver;
protected String otpURL="http://v.indialends.com/test/get_otp_user_registration_encrypt.ashx?type=json&mobileno=";
//protected String otpURL="https://uatweb.indialends.com/internal/a/get_otp_mail_verify_api.ashx?mobileno=";
	String mobileno=Base.randomMobile();
	String email=Base.randomEmail();
	String panNo=Base.randommPAN();
	String name="Test User";
	String date="20";
	String month="04";
	String year="1980";
	String gtag="AW-955414164";
	String RemarketingTag1="803650867";
	String RemarketingTag2="803650924";
	String RemarketingTag3="955414164";
	String Google_Analytics="UA-58036769-1";
	
	@Test
	public void verify_Credit_Report() throws Exception {
		
		 System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Driver\\chromedriver.exe");

		  driver = new ChromeDriver();
		  
		  
		  driver.get("https://indialends.com/credit-application");
		  driver.manage().window().maximize();
	
		  driver.findElement(By.cssSelector("#li_first_name")).clear();	 
		  driver.findElement(By.cssSelector("#li_first_name")).sendKeys(name);
		  driver.findElement(By.cssSelector("#li_email_id")).clear();	 
		  driver.findElement(By.cssSelector("#li_email_id")).sendKeys(email);
		  driver.findElement(By.cssSelector("#li_gender_male")).click();
		  
		  Select DD=new Select(driver.findElement(By.cssSelector("#li_birthdate")));
		  DD.selectByValue(date);
		  
		  Select MM=new Select(driver.findElement(By.cssSelector("#li_birthmonth")));
		  MM.selectByValue(month);
		  
		  Select YY=new Select(driver.findElement(By.cssSelector("#li_birthyear")));
		  YY.selectByValue(year);
		  
		  driver.findElement(By.cssSelector("#li_res_pin")).sendKeys("110020");
		  Thread.sleep(2000);
		  
		  Select emp=new Select(driver.findElement(By.cssSelector("#li_emp_type")));
		  emp.selectByIndex(1);
		  
		  driver.findElement(By.cssSelector("#li_monthly_salary")).sendKeys("45000");
		  driver.findElement(By.cssSelector("#li_mobile_number")).clear();
		  driver.findElement(By.cssSelector("#li_mobile_number")).sendKeys(mobileno);
		  driver.findElement(By.cssSelector("#li_pan_number")).clear();
		  driver.findElement(By.cssSelector("#li_pan_number")).sendKeys(panNo);
		  driver.findElement(By.cssSelector("#li_submit_one")).click();
		  Thread.sleep(6000);
		  
		    String passwrd = Utility.Otp_Call.request_otp(otpURL, mobileno);
		    System.out.println("Mobile no is:" + mobileno);
			driver.findElement(By.cssSelector("#txt_otp0")).sendKeys(passwrd);
			driver.findElement(By.cssSelector("#mobile_verification > div > div > div > div.pad20b.pad10t.pad10l.pad10r > label > span")).click();
			driver.findElement(By.cssSelector("#btn_verify_mobile")).click();
		  
             Thread.sleep(2000);
             
             Verify_CR_DB_Values launchDb=new Verify_CR_DB_Values();
             launchDb.fetchDbValue(mobileno);
			
		  }
	}



