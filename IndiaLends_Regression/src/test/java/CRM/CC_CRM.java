package CRM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CC_CRM {

	private static final boolean String = false;
  @Test
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
				
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//driver//"+"chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://crm.indialends.com/login.aspx");
		
		
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		//System.out.println(loginname);
		
		 WebDriverWait wait = new WebDriverWait(driver, 5000);
		//	wait.until(ExpectedConditions.visibilityOf(CRMUserlogin));
		//	CRMUserlogin.clear();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#txt_emailid")).sendKeys("surenderkumar@indialends.com"); 
			driver.findElement(By.cssSelector("#txt_password")).sendKeys("test"); 
			driver.findElement(By.cssSelector("#btn_login")).click();
			
			Thread.sleep(2000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(0));

			
			driver.get("http://https//crm.indialends.com/admin/cc_crm_agent.aspx?phone=5123000931");
		
	//	CRMPasslogin.sendKeys("test");
		
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("#navbar > ul > li:nth-child(2) > a")).click();

			driver.findElement(By.cssSelector("#navbar > ul > li.dropdown.open > ul > li:nth-child(2)")).click();

			Thread.sleep(1000);
			/// search the lead with Mobile number

			Select filter = new Select(driver.findElement(By.cssSelector("#ddl_filter")));
			filter.selectByIndex(1);

			driver.findElement(By.cssSelector("#txt_keyword")).sendKeys("6123000106");

			driver.findElement(By.cssSelector("#btn_search")).click();
			
			//driver.get("https://crmccuat.indialends.com/admin/cc_my_customer.aspx");
			 
			driver.navigate().refresh();
			Thread.sleep(20000);

			driver.get("https://crmccuat.indialends.com/admin/cc_my_customer.aspx");
			 
			driver.navigate().refresh();
			Thread.sleep(20000);
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,400)");

			
			////////////////////////////////////////////////////

			// Open the lead
			driver.findElement(By.cssSelector("#dv_application_list > div > table > tbody > tr:nth-child(3) > td:nth-child(3) > a")).click();

					
		//	ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		//	driver.switchTo().window(tabs2.get(1));

			Thread.sleep(2000);
			JavascriptExecutor js11 = (JavascriptExecutor) driver;
			js11.executeScript("window.scrollBy(0,400)");

			// click incomplete button 
			
			driver.findElement(By.cssSelector("#dv_cc_details > div.row > div > div > div > div > div > table > tbody > tr.bg-grey-lighter.font13 > td:nth-child(8) > button")).click();
			Thread.sleep(6000);
			// Enter the user details ////////////////////
			
			int size=driver.findElements(By.tagName("iframe")).size();
			System.out.println("Total size of frame:"+size);
			
			for(int i=0;i<=size;i++) {
				
				driver.switchTo().frame(0);
				Thread.sleep(6000);
				driver.findElement(By.cssSelector("#li_first_name")).clear();
				//fname.clear();
				driver.findElement(By.cssSelector("#li_first_name")).sendKeys("Test");
			
			
			driver.findElement(By.cssSelector("#li_first_name")).clear();
			//fname.clear();
			driver.findElement(By.cssSelector("#li_first_name")).sendKeys("test1");
			
			driver.findElement(By.xpath("//*[@id=\"div_gender\"]/label/span[1]")).click();
			
			WebElement edu = driver.findElement(By.cssSelector("#li_edu_qualification"));
			Select dropdown = new Select(edu);
		//	dropdown.selectByVisibleText("Post Graduate");
			dropdown.selectByIndex(1);
			
			driver.findElement(By.cssSelector("#div_marriage > label > span.rd-chk-color.lh-35.font18")).click();
			
			
			JavascriptExecutor js111 = (JavascriptExecutor) driver;
			 js111.executeScript("window.scrollBy(0,400)");
			
			//Present residential address//
			// houseNo.sendKeys("10");
			 driver.findElement(By.cssSelector("#li_res_house_no")).sendKeys("10");
			 driver.findElement(By.cssSelector("#li_res_street")).sendKeys("Delhi");
			 driver.findElement(By.cssSelector("#li_res_landmark")).sendKeys("Delhi");
			 driver.findElement(By.cssSelector("#li_res_area")).sendKeys("Saket");
			 
			
			Thread.sleep(2000);
			JavascriptExecutor js1111 = (JavascriptExecutor) driver;
			 js1111.executeScript("window.scrollBy(0,400)");
			 
			//Office address
			 driver.findElement(By.cssSelector("#li_off_house_no")).sendKeys("Sector18");
			 driver.findElement(By.cssSelector("#li_off_street")).sendKeys("Sector18");
			 driver.findElement(By.cssSelector("#li_off_landmark")).sendKeys("Gurgaon");
			 driver.findElement(By.cssSelector("#li_off_area")).sendKeys("Gurgaon");
					 
			 
			driver.findElement(By.xpath("//*[@id=\"step_two_flow\"]/div[2]/div/div[15]/div/div[4]/div/label/span[1]")).click();
				
			Thread.sleep(2000);
			JavascriptExecutor js11111 = (JavascriptExecutor) driver;
			 js11111.executeScript("window.scrollBy(0,400)");
			 
			
			
			driver.findElement(By.xpath("//*[@id=\"div_sbi_relationship\"]/div/div[4]/div/label/span[1]")).click();
			
			
			
			driver.findElement(By.cssSelector("#li_designation")).sendKeys("Software Tester");
			driver.findElement(By.cssSelector("#li_second_submit")).click();
			
			
			
			//*[@id="div_gender"]/label/span[1]

			Thread.sleep(10000);
			String congt  = driver.findElement(By.cssSelector("#page-top > div.thankyou-header-top-bg.container-fluid > div > div > div > h3")).getText();
			
			String[] arrOfStr = congt.split("!", 2); 
			  
	        for (String a : arrOfStr) 
	            System.out.println(a); 
			
	        
	        
			if (arrOfStr.equals ("Congratulations")) {
				System.out.println(" Congratulations Lead is created sucessfully ");
			}
			
		//	return mobileNo;

			// driver.findElement(By.xpath("//*[@id=\"status3\"]/form/div[4]/div[2]/button[1]")).click();

			
			
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		/*	
			
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#navbar > ul > li:nth-child(1) > a")).click();
		
		driver.findElement(By.cssSelector("#navbar > ul > li.dropdown.open > ul > li > a")).click();
			

		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		 js11.executeScript("window.scrollBy(0,400)");
	
		 // Open the lead
		 driver.findElement(By.cssSelector("#dv_application_list > div > table > tbody > tr:nth-child(1) > td:nth-child(3) > a")).click();
		
		
/// switch the control one tab to aother tab.
		 
				 
		 ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs2.get(1));
		 
		 Thread.sleep(3000);
			JavascriptExecutor js11 = (JavascriptExecutor) driver;
			 js11.executeScript("window.scrollBy(0,400)");
			 
		 // Add card 
		 driver.findElement(By.cssSelector("#btn_add_card")).click();
		 
		 Select lendertype = new Select(driver.findElement(By.cssSelector("#ddl_eligible_bank_0")));
		 lendertype.selectByIndex(1);
		 Thread.sleep(3000);
		 Select cardname = new Select(driver.findElement(By.xpath("//*[@id=\"ddl_eligible_card_0\"]")));
		  cardname.selectByIndex(2);
		 
		  driver.findElement(By.xpath("//*[@id=\"status3\"]/form/div[4]/div[2]/button[1]")).click();
		  
		  //================ OTP Verification =====================
		  
		  
*/		  
		  
	}

}
	
