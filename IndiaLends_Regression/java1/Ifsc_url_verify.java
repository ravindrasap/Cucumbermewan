

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ifsc_url_verify {

	public static WebDriver driver;
	int BankSize;
	int StateSize;
	int DistrictSize;
	Select selectBank, selectState, selectDistrict, selectBranch;

	@Test
	public void set_UP() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//driver//"+"chromedriver.exe");
		System.out.println("launching chrome browser");

		driver = new ChromeDriver();
		driver.navigate().to("https://indialendsifsc.azurewebsites.net/IFSC/d ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		attachbank();
		attachstate();
		attachdistric();
		attachbranch();

		for (int b = 101; b < BankSize; b++) {
			attachbank();
			selectBank.selectByIndex(b);
			Thread.sleep(3000);
			String url = driver.getCurrentUrl();
			System.out.println("Current URL are:"+url);
			attachstate();
			for (int s = 1; s < StateSize; s++) {
				attachstate();
				selectState.selectByIndex(s);
				Thread.sleep(3000);
				String url1 = driver.getCurrentUrl();
				System.out.println("Current URL are:"+url1);
				attachdistric();

				for (int d = 1; d < DistrictSize; d++) {
					attachdistric();
					selectDistrict.selectByIndex(d);
					Thread.sleep(3000);
					String url2 = driver.getCurrentUrl();
					System.out.println("Current URL are:"+url2);
					attachbranch();
					
					for (int br = 1; br < Branchsize; br++) {
						attachbranch();
						selectBranch.selectByIndex(br);
						Thread.sleep(2000);
						String url3 = driver.getCurrentUrl();
						System.out.println("Current URL are:"+url3);
					}
				}
			}

		}

		String url = driver.getCurrentUrl();
		System.out.println("Current URL is:" + url);

		Assert.assertEquals(
				"https://indialendsifsc.azurewebsites.net/IFSC/d/abhyudaya-cooperative-bank-limited-gujarat-ahmedabad-ghatlodiya",
				url);

	}

	private void attachbank() {
		try {
			WebElement bank = driver.findElement(By.cssSelector("#ddlBank"));
			selectBank = new Select(bank);
			java.util.List<WebElement> options = selectBank.getOptions();
			BankSize = options.size();
			//System.out.println("Total no. of bank are : " + BankSize);

			// selectBank.selectByIndex(1);
		} catch (Exception e) {
			
			System.out.println("Exception message"+e.getMessage());
		}
	}

	private void attachstate() {
		try {
			WebElement state = driver.findElement(By.cssSelector("#ddlState"));
			selectState = new Select(state);
			java.util.List<WebElement> options2 = selectState.getOptions();
			StateSize = options2.size();
		//	System.out.println("Total no. of state are : " + StateSize);

		} catch (Exception e) {
			
			System.out.println("Exception message"+e.getMessage());
		}
	}

	private void attachdistric() {
		try {
			WebElement district = driver.findElement(By.cssSelector("#ddlDistrict"));
			selectDistrict = new Select(district);
			java.util.List<WebElement> options3 = selectDistrict.getOptions();
			DistrictSize = options3.size();
		//	System.out.println("Total no. of district are : " + DistrictSize);

		} catch (Exception e) {
			
			System.out.println("Exception message"+e.getMessage());
		}
	}

	private void attachbranch() {
		//
		try {
			WebElement branch = driver.findElement(By.cssSelector("#ddlBranch"));
			selectBranch = new Select(branch);
			java.util.List<WebElement> options4 = selectBranch.getOptions();
			Branchsize = options4.size();
			//System.out.println("Total no. of branch are : " + Branchsize);

		} catch (Exception e) {
			
			System.out.println("Exception message"+e.getMessage());
			
		}
	}

	int Branchsize;
}
