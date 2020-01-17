package fabricAlert.java;

import java.awt.AWTException;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class fabricalertAnroid {

	@Test
	public static void main(String[] args) throws InterruptedException, AWTException, FileNotFoundException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//driver//"+"chromedriver.exe");
		driver=new ChromeDriver();
	//	driver.get("https://console.firebase.google.com/?pli=1");
		
		driver.get("https://console.firebase.google.com/project/indialends-aff8b/crashlytics/app/android:com.indialends.android/issues?state=open&time=last-hour&type=crash");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("ravindrakumar@indialends.com");
		
		//driver.findElement(By.cssSelector("#view_container > div > div > div.pwWryf.bxPAYd > div > div.WEQkZc > div > form > span > section > div > div > div.d2CFce.cDSmF > div")).sendKeys("ravindrakumar@indialends.com");
		
		driver.findElement(By.cssSelector("#identifierNext > span > span")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/form/input[1]")).sendKeys("ravindrakumar@indialends.com");
		driver.findElement(By.xpath("/html/body/div[3]/form/input[2]")).sendKeys("India@123456734");
		//India@1234567
		driver.findElement(By.xpath("/html/body/div[3]/form/input[3]")).click();
		
	
		String crshcount = driver.findElement(By.xpath("//*[@id=\"main\"]/ng-transclude/div/div/div/c9s-issues/c9s-issues-index/div/div/div/c9s-issues-metrics/div/mat-card[2]/div[2]/div/fire-stat[1]/div/div[2]/div[1]")).getText();
		 
		String usrcrsh = driver.findElement(By.xpath("//*[@id=\"main\"]/ng-transclude/div/div/div/c9s-issues/c9s-issues-index/div/div/div/c9s-issues-metrics/div/mat-card[2]/div[2]/div/fire-stat[2]/div/div[2]/div[1]/span")).getText();
	   
	    	
	    	 if (crshcount.length()>0) {
	    		 System.out.println("Number of crash count:" + crshcount);
	    	 }
	    		 else {
	    			
	    			 System.out.println("Number of crash is zero");
	    		 }
	    		
	    
	}
}
