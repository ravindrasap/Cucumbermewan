package CRM;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Utility.Base;

public class CRMDetails_Page extends Base {

	protected WebDriver driver;

	@Test
	public void CRMS_Loginpage(String mobileno) throws Exception  {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//driver//"+"chromedriver.exe");
		driver=new ChromeDriver();

		driver.get("https://crm.indialends.com/login.aspx");
				driver.manage().window().maximize();
;

		driver.findElement(By.cssSelector("#txt_emailid")).sendKeys("surenderkumar@indialends.com");
		driver.findElement(By.cssSelector("#txt_password")).sendKeys("test");
		driver.findElement(By.cssSelector("#btn_login")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#navbar > ul > li:nth-child(2) > a")).click();

		driver.findElement(By.cssSelector("#navbar > ul > li.dropdown.open > ul > li:nth-child(2)")).click();

		Thread.sleep(4000);

		// search the lead and compete the lead

		Thread.sleep(1000);

		/// search the lead with Mobile number

		Select filter = new Select(driver.findElement(By.cssSelector("#ddl_filter")));
		filter.selectByIndex(1);

		driver.findElement(By.cssSelector("#txt_keyword")).sendKeys(mobileno);

		driver.findElement(By.cssSelector("#btn_search")).click();

		///////////////////////////////////////////// Open the lead /////////

		driver.findElement(
				By.cssSelector("#dv_application_list > div > table > tbody > tr:nth-child(1) > td:nth-child(3) > a"))
				.click();

		ArrayList<String> tabs21 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs21.get(1));

		Thread.sleep(2000);
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("window.scrollBy(0,400)");

		///////////// click incomplete button //////////////////////////

		driver.findElement(By.cssSelector(
				"#dv_cc_details > div.row > div > div > div > div > div > table > tbody > tr.bg-grey-lighter.font13 > td:nth-child(8) > button"))
				.click();
		Thread.sleep(6000);
		// Enter the user details ////////////////////

		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total size of frame:" + size);

		for (int i = 0; i <= size; i++) {

			driver.switchTo().frame(0);
			Thread.sleep(6000);
			driver.findElement(By.cssSelector("#li_first_name")).clear();
			// fname.clear();
			driver.findElement(By.cssSelector("#li_first_name")).sendKeys("Test");

			driver.findElement(By.cssSelector("#li_first_name")).clear();
			// fname.clear();
			driver.findElement(By.cssSelector("#li_first_name")).sendKeys("test1");

			/////////// select the DOB //////////////////////

			WebElement day = driver.findElement(By.cssSelector("#li_birthdate"));
			Select dropdown11 = new Select(day);
			dropdown11.selectByVisibleText("04");

			Thread.sleep(1000);
			WebElement month = driver.findElement(By.cssSelector("#li_birthmonth"));
			Select mon = new Select(month);
			mon.selectByVisibleText("MAR");

			WebElement year = driver.findElement(By.cssSelector("#li_birthyear"));
			Select yy = new Select(year);
			yy.selectByVisibleText("1986");

			driver.findElement(By.xpath("//*[@id=\"div_gender\"]/label/span[1]")).click();

			WebElement edu = driver.findElement(By.cssSelector("#li_edu_qualification"));
			Select dropdown = new Select(edu);
			// dropdown.selectByVisibleText("Post Graduate");
			dropdown.selectByIndex(1);

			/////// PAN ////////////

			//PanNo.sendKeys(Base.randommPAN());
            
			driver.findElement(By.cssSelector("#div_marriage > label > span.rd-chk-color.lh-35.font18")).click();

			JavascriptExecutor js111 = (JavascriptExecutor) driver;
			js111.executeScript("window.scrollBy(0,400)");

			////////// present office address ////////////////
			driver.findElement(By.cssSelector("#li_off_pin")).sendKeys("122001");

			////////// Present residential address////////////////
			// houseNo.sendKeys("10");
			driver.findElement(By.cssSelector("#li_res_house_no")).sendKeys("10");
			driver.findElement(By.cssSelector("#li_res_street")).sendKeys("Delhi");
			driver.findElement(By.cssSelector("#li_res_landmark")).sendKeys("Delhi");
			driver.findElement(By.cssSelector("#li_res_area")).sendKeys("Saket");

			Thread.sleep(2000);
			JavascriptExecutor js1111 = (JavascriptExecutor) driver;
			js1111.executeScript("window.scrollBy(0,400)");

			// Office address
			driver.findElement(By.cssSelector("#li_off_house_no")).sendKeys("Sector18");
			driver.findElement(By.cssSelector("#li_off_street")).sendKeys("Sector18");
			driver.findElement(By.cssSelector("#li_off_landmark")).sendKeys("Gurgaon");
			driver.findElement(By.cssSelector("#li_off_area")).sendKeys("Gurgaon");

			driver.findElement(By.xpath("//*[@id=\"step_two_flow\"]/div[2]/div/div[15]/div/div[4]/div/label/span[1]"))
					.click();

			Thread.sleep(2000);
			JavascriptExecutor js11111 = (JavascriptExecutor) driver;
			js11111.executeScript("window.scrollBy(0,400)");

			driver.findElement(By.xpath("//*[@id=\"div_sbi_relationship\"]/div/div[4]/div/label/span[1]")).click();

			driver.findElement(By.cssSelector("#li_designation")).sendKeys("Software Tester");
			driver.findElement(By.cssSelector("#li_second_submit")).click();

			// *[@id="div_gender"]/label/span[1]

			Thread.sleep(10000);
			String congt = driver.findElement(
					By.cssSelector("#page-top > div.thankyou-header-top-bg.container-fluid > div > div > div > h3"))
					.getText();

			String[] arrOfStr = congt.split("!", 2);

			for (String a : arrOfStr)
				System.out.println(a);

			if (arrOfStr.equals("Congratulations")) {
				System.out.println(" Congratulations Lead is created sucessfully ");
			}
			Thread.sleep(3000);

		}

	
		}

}
