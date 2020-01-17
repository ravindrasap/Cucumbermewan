package CRM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Utility.Base;

public class CC_CRM_Login  {
	
	WebDriver driver;
	//String mobileno="5393709364";
	@Test
	public void verify_login(String mobileno) throws Exception {
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://crm.indialends.com");
		driver.findElement(By.cssSelector("#txt_emailid")).sendKeys("surenderkumar@indialends.com");
		driver.findElement(By.cssSelector("#txt_password")).sendKeys("test");
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
		
		for(int i=0;i<=size;i++) {
			
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
		}
		
		
	}

}
