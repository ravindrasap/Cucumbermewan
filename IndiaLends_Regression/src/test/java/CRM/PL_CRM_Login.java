package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utility.Base;
//import Utility.SendMail;
//import Utility.SendmailCRMITC;

public class PL_CRM_Login {

	WebDriver driver;
	//String p2URL = "";

	//@Test
	public void verifyLogin(String encrypt) throws Exception {
	String	p2URL = "https://crm.indialends.com/admin/nbfc_customer_contact_v2.aspx?admin_id="+encrypt;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravindrakumar\\eclipse-workspace\\IndiaLends_Regression\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.navigate().to("https://crm.indialends.com/login.aspx");

		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("#txt_emailid")).sendKeys(Base.loadPropertiesFile("crm_PL_data.properties", "email"));
		driver.findElement(By.cssSelector("#txt_password")).sendKeys(Base.loadPropertiesFile("crm_PL_data.properties", "password"));
		driver.findElement(By.cssSelector("#btn_login")).click();

		Thread.sleep(3000);

		String expected = "My Profile";

		try {
			if (expected.equals(driver.findElement(By.cssSelector("body > div.pos_relative.clearfix.container12 > div > div.col-lg-10.col-xs-12 > div > div > div.panel-heading > h3")).getText())) {

				System.out.println("PASS");
			} else {

				System.out.println("Unable to login in live CRM");
				// SendMail.sendmail("Unable to login in live CRM");
			}
		} catch (Exception e) {

			System.out.println("Unable to login in live CRM Exception :" + e.getMessage());
			// SendMail.sendmail("Unable to login in live CRM Exception :"+e.getMessage());
		}

		driver.get(p2URL);
		Thread.sleep(3000);
		
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,400)");
		
	//	driver.findElement(By.cssSelector("#anc_edit_application")).click();
		driver.findElement(By.xpath("//*[@id=\"p_edit_application\"]/a")).click();
		Thread.sleep(4000);
		
		int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Size is:"+size);
	    for(int i=0; i<=size; i++){
		driver.switchTo().frame(1);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#loanAmt")).clear();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#loanAmt")).sendKeys(Base.loadPropertiesFile("crm_PL_data.properties", "loanamount"));
		driver.findElement(By.cssSelector("#loanTenure")).sendKeys(Base.loadPropertiesFile("crm_PL_data.properties", "tenure"));
		
		driver.findElement(By.cssSelector("#form1 > div:nth-child(21) > div.col-md-6.col-lg-6.md-pad0l.md-pad0.md-marg5 > div > div.btn-group.bootstrap-select.show-tick.form-control.radius-none.dropdown > div > button")).click();
		driver.findElement(By.cssSelector("#form1 > div:nth-child(21) > div.col-md-6.col-lg-6.md-pad0l.md-pad0.md-marg5 > div > div.btn-group.bootstrap-select.show-tick.form-control.radius-none.dropdown > div > div > ul > li:nth-child(3) > a")).click();
	   
		
	
		JavascriptExecutor js31 = (JavascriptExecutor) driver;
		js31.executeScript("window.scrollBy(0,600)");
		
		driver.findElement(By.cssSelector("#form1 > div:nth-child(23) > div.col-md-6.col-lg-6.pad0l.md-pad0 > div > div:nth-child(3) > div > button")).click();
		driver.findElement(By.cssSelector("#form1 > div:nth-child(23) > div.col-md-6.col-lg-6.pad0l.md-pad0 > div > div:nth-child(3) > div > div > ul > li:nth-child(4) > a")).click();
		
		driver.findElement(By.cssSelector("#form1 > div:nth-child(23) > div.col-md-6.col-lg-6.pad0l.md-pad0 > div > div:nth-child(4) > div > button")).click();
		driver.findElement(By.cssSelector("#form1 > div:nth-child(23) > div.col-md-6.col-lg-6.pad0l.md-pad0 > div > div:nth-child(4) > div > div > ul > li:nth-child(4) > a")).click();
		
		driver.findElement(By.cssSelector("#form1 > div:nth-child(23) > div.col-md-6.col-lg-6.pad0l.md-pad0 > div > div:nth-child(5) > div > button")).click();
		driver.findElement(By.cssSelector("#form1 > div:nth-child(23) > div.col-md-6.col-lg-6.pad0l.md-pad0 > div > div:nth-child(5) > div > div > ul > li:nth-child(9) > a")).click();
		
		driver.findElement(By.cssSelector("#div_gender > label > span > span")).click();
		driver.findElement(By.cssSelector("#div_marriage")).click();
		
		driver.findElement(By.cssSelector("#form1 > div:nth-child(23) > div:nth-child(13) > div > div.btn-group.bootstrap-select.show-tick.form-control.radius-none.dropdown > div > button")).click();
		driver.findElement(By.cssSelector("#form1 > div:nth-child(23) > div:nth-child(13) > div > div.btn-group.bootstrap-select.show-tick.form-control.radius-none.dropdown > div > div > ul > li:nth-child(4) > a")).click();
		
		JavascriptExecutor js6 = (JavascriptExecutor) driver;
		js6.executeScript("window.scrollBy(0,600)");
		
		driver.findElement(By.cssSelector("#div_payment > div > div.col-md-12.col-lg-12.pad0l.md-pad0r.hid-sm > div.col-md-6.col-lg-6.md-pad0.pad0l > div > div.btn-group.bootstrap-select.show-tick.form-control.radius-none > button")).click();
		driver.findElement(By.cssSelector("#div_payment > div > div.col-md-12.col-lg-12.pad0l.md-pad0r.hid-sm > div.col-md-6.col-lg-6.md-pad0.pad0l > div > div.btn-group.bootstrap-select.show-tick.form-control.radius-none.open > div > ul > li:nth-child(2) > a")).click();
		
		driver.findElement(By.cssSelector("#pincode")).sendKeys("110020");
		
		driver.findElement(By.cssSelector("#address")).sendKeys("Delhi");
		driver.findElement(By.cssSelector("#locality")).sendKeys("Delhi");
		
		JavascriptExecutor js7 = (JavascriptExecutor) driver;
		js7.executeScript("window.scrollBy(0,600)");
		
		driver.findElement(By.cssSelector("#form1 > div:nth-child(29) > div:nth-child(15) > div > div.btn-group.bootstrap-select.show-tick.form-control.radius-none > button")).click();
		driver.findElement(By.cssSelector("#form1 > div:nth-child(29) > div:nth-child(15) > div > div.btn-group.bootstrap-select.show-tick.form-control.radius-none.open > div > ul > li:nth-child(2) > a")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("#yearsAddress")).sendKeys("05");
		driver.findElement(By.cssSelector("#monthAddress")).sendKeys("02");
		
		Thread.sleep(1000);
		
	/*	driver.findElement(By.cssSelector("#companyName")).sendKeys("IBM");
		Thread.sleep(4000);
		WebElement textbox = driver.findElement(By.cssSelector("#companyName"));
		textbox.sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		*/
		driver.findElement(By.cssSelector("#currentExpYrs")).sendKeys("05");
		driver.findElement(By.cssSelector("#currentExpMonth")).sendKeys("03");
		
		
		
		driver.findElement(By.cssSelector("#totalExpYrs")).sendKeys("06");
		driver.findElement(By.cssSelector("#totalExpMonth")).sendKeys("04");
		
		driver.findElement(By.cssSelector("#officePincode")).sendKeys("110020");
		
		driver.findElement(By.cssSelector("#offAddress")).sendKeys("delhi");
		driver.findElement(By.cssSelector("#offLocality")).sendKeys("Delhi");
		
		driver.findElement(By.cssSelector("#panNo")).sendKeys(Base.loadPropertiesFile("crm_PL_data.properties", "panNO"));
		
		JavascriptExecutor js8 = (JavascriptExecutor) driver;
		js8.executeScript("window.scrollBy(0,400)");
		
		driver.findElement(By.cssSelector("#form1 > div:nth-child(35) > div.col-md-6.col-lg-6.pad0l.md-pad0r > div > div.btn-group.bootstrap-select.show-tick.form-control.radius-none > button")).click();
		driver.findElement(By.cssSelector("#form1 > div:nth-child(35) > div.col-md-6.col-lg-6.pad0l.md-pad0r > div > div.btn-group.bootstrap-select.show-tick.form-control.radius-none.open > div > ul > li:nth-child(2) > a")).click();
		
		driver.findElement(By.cssSelector("#li_submit")).click();
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		String pancard=driver.findElement(By.cssSelector("#td_pan_id")).getText();
		
		if(pancard.contains(Base.loadPropertiesFile("crm_PL_data.properties", "panNO"))) {
			
			System.out.println("Data save successfully in CRM");
			//SendmailCRMITC.sendmail("I2C lead data are saving in Live CRM in PL.");
			driver.close();
		}else {
			System.out.println("I2C lead data are not saving in Live CRM");
			//SendmailCRMITC.sendmail("I2C lead data are not saving in Live CRM in PL.");
		}
		
	    }
		
	}
}

