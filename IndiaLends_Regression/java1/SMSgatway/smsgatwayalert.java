package SMSgatway;

import java.io.IOException;
import java.net.URL;

import org.apache.http.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class smsgatwayalert {
	
	WebDriver driver;
	@Test
	
	
	public void verify_SMS_certificate() throws ParseException, IOException	{
		
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
			 +"//driver//"+"chromedriver.exe");
		
	
		driver = new ChromeDriver();
		driver.navigate().to("https://www.smsgatewayhub.com/api/mt/GetBalance?APIKey=cpnYV2cSoUyvGdjKFa63dg");
		
		driver.manage().window().maximize();
		System.out.println("================Verify SMS Count ===========================");
		String ele=driver.findElement(By.cssSelector("body")).getText();
		
		int lengtht= ele.length();
		//System.out.println(lengtht);
	   SendmailSMS.sendmail(ele);
		
			
			   Pattern p = Pattern.compile("\\d+");
		        Matcher m = p.matcher(ele);
		        
										        
		        while(m.find()) {
		        	String test =m.group(0);
		        	
		        	 if (test.compareTo("Balance") == 0) {
		        	
		        	
		       //     System.out.println(m.group());
		        	}
		        }
		       
		        driver.quit();
		}
	}

