package CRM;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Utility.Base;

public class CC_Genric_CRM {
	WebDriver driver;
	//String mobileno="5307565661";
	@Test
	public void verify_crm_I2C(String mobileno) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Driver\\chromedriver.exe");
        driver=new ChromeDriver();
		
		driver.get("https://crm.indialends.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#txt_emailid")).sendKeys("surenderkumar@indialends.com");
		driver.findElement(By.cssSelector("#txt_password")).sendKeys("test");
		driver.findElement(By.cssSelector("#btn_login")).click();
		
		Thread.sleep(4000);
		
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
			card.selectByValue("101");
			
			driver.findElement(By.cssSelector("#li_res_house_no")).sendKeys("House no");
			driver.findElement(By.cssSelector("#li_res_street")).sendKeys("Street name");
			driver.findElement(By.cssSelector("#li_res_landmark")).sendKeys("Landmark");
			driver.findElement(By.cssSelector("#li_res_area")).sendKeys("Locality");
			
			/*Select addr=new Select(driver.findElement(By.cssSelector("#li_add_proof")));
			addr.selectByIndex(3);
			
			Select id=new Select(driver.findElement(By.cssSelector("#li_id_proof")));
			id.selectByIndex(2);
			*/
			driver.findElement(By.cssSelector("#li_off_pin")).sendKeys("110020");
			driver.findElement(By.cssSelector("#li_off_house_no")).sendKeys("Office No");
			driver.findElement(By.cssSelector("#li_off_street")).sendKeys("Office Street name");
			driver.findElement(By.cssSelector("#li_off_landmark")).sendKeys("Office Landmark");
			driver.findElement(By.cssSelector("#li_off_area")).sendKeys("Office locality");
			
			JavascriptExecutor js1=(JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,400)");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"step_two_flow\"]/div[2]/div/div[15]/div/div[4]/div/label/span[1]/i")).click();
					
			driver.findElement(By.cssSelector("#div_sbi_relationship > div > div:nth-child(4) > div > label > span.rd-chk-color.lh-35.font18")).click();
			driver.findElement(By.cssSelector("#li_designation")).sendKeys("Tester");
			
			driver.findElement(By.cssSelector("#li_second_submit")).click();
			Thread.sleep(4000);
			
			String msg=driver.findElement(By.cssSelector("#page-top > div.thankyou-header-top-bg.container-fluid > div > div > div > h3")).getText();
			System.out.println(msg);
			
			if(msg.contains("Thank you for applying for an SBI Credit Card with IndiaLends"))
			{
				System.out.println("All details successfully saved");
			}else {
				System.out.println("Details is not saved");
			}
		
		}
	}

}
