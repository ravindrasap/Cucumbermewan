import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class loginPay {

	private static TimeUnit thread;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//driver//"+"chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		
		
		//WebDriver driver = new FirefoxDriver();
	//  Wait For Page To Load
	// Put a Implicit wait, this means that any search for elements on the page
	//could take the time the implicit wait is set for before throwing exception 
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	// Navigate to URL
	driver.get("https://paytm.com/");
	// Maximize the window.
	driver.manage().window().maximize();
	
	//wait (10);
	driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div[4]/div")).click();
	driver.findElement(By.cssSelector("#app > div > div.R-WO > div._3AxU > div._3huM > div._1Vt1 > div")).click();
	

	driver.findElement(By.cssSelector("input_0")).sendKeys("ravinderkumar71@gmail.com	");
	// Enter Password
	driver.findElement(By.cssSelector("#input_1")).sendKeys("YOUR PASSWORD");
	// Wait For Page To Load
	driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
	// Click on 'Sign In' button
	driver.findElement(By.cssSelector("#loginForm > div > md-content > button > img")).click();
	
	
	
	//Click on Compose Mail.
	//driver.findElement(By.xpath("//div[@class='z0']/div")).click();
	// Click on the image icon present in the top right navigational Bar
	//driver.findElement(By.xpath("//div[@class='gb_1 gb_3a gb_nc gb_e']/div/a")).click();
	//Click on 'Logout' Button
	driver.findElement(By.xpath("#loginForm > div > md-content > button > img")).click();
	//Close the browser.
	driver.close();
	}
		

	}


