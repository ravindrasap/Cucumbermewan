package Ameyo;

import java.awt.AWTException;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.SendmailSSL;

public class Ameyo_login {

	public static void main(String[] args) throws InterruptedException, AWTException, FileNotFoundException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//driver//"+"chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://ameyo.indialends.com:8443/app/");
		// UAT URL https://ameyoccuat.indialends.com:8443/app/
	
		Thread.sleep(1000);
		driver.manage().window().maximize();
		// WebDriverWait wait = new WebDriverWait(driver, 5000);
		 
		 driver.findElement(By.cssSelector("#gwt-uid-1")).sendKeys("surenderkumar@indialends.com");
		 
      
         driver.findElement(By.cssSelector("#gwt-uid-2")).sendKeys("test");
         
		 driver.findElement(By.xpath("//*[@id=\"ameyo-body\"]/div[3]/div/div[1]/div/div/div[2]/div/div[1]/div/div[2]/div/div[1]/div/div[2]/form/div[7]/div/button")).click(); 
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@id=\"automationButton1\"]")).click();
		
		  driver.findElement(By.cssSelector("#ameyo-body > div:nth-child(11) > div > div.s12.m12.l12.col > div > div > div:nth-child(2) > div > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(1) > div > div:nth-child(2) > form > div:nth-child(7) > div > button")).click();
		//   String nameok = driver.findElement(By.cssSelector("#ameyo-body > div:nth-child(11) > div > div.s12.m12.l12.col > div > div > div:nth-child(2) > div > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(1) > div > div:nth-child(2) > form > div:nth-child(7) > div > button")).getText();
		  // System.out.println(nameok);
			//Thread.sleep(3000);
						driver.findElement(By.cssSelector("#automationButton1")).click();
		  Thread.sleep(10000);
		
		//String expected = "Home";
		String expected = "Campaign Selection";
	
			
		}

}


