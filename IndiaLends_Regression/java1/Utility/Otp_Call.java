package Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Otp_Call {
	
	public static WebDriver driver;
	
	public static String request_otp(final String API_Query , final String Mobile_no) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//driver//"+"chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.get(API_Query+Mobile_no);
		String message = driver.getPageSource();
		Thread.sleep(3000);
		driver.quit();
		final Pattern p = Pattern.compile("(\\d{6})");
		final Matcher m = p.matcher(message);
		
		if(m.find())
		{
			String otp = m.group(0);
			return otp;
		}
		
		else 
		{
			return "Null";
		}
	}

}
