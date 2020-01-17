import org.openqa.selenium.WebDriver;
import java.nio.CharBuffer;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utility.Base;
import junit.framework.Assert;

public class Web {
	public static WebDriver driver;
	
	
	@BeforeClass
	public void set_UP()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravindrakumar\\eclipse-workspace\\driver\\chromedriver.exe");
		System.out.println("launching chrome browser");
	
		driver = new ChromeDriver();
	
		driver.navigate().to("http://demo.nopcommerce.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.manage().window().maximize();
}
	
	@Test(priority=0)
	public void Select_Product_Form() throws Exception {
		
		 driver.findElement(By.id("small-searchterms")).sendKeys("Computer");
		 
		 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS); 
		 
		 driver.findElement(By.cssSelector("#small-search-box-form > input.button-1.search-box-button")).click();
		 
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,700)");
		 
		 
		 driver.findElement(By.linkText("ADD TO CART")).click();
		 
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		
		 // select HDD
		 driver.findElement(By.id("product_attribute_3_6")).click();
		 
		 //add to cart
		 driver.findElement(By.id("add-to-cart-button-1")).click();
		 // page scroll up
		 js.executeScript("window.scrollBy(0,0)");
		 
		 driver.findElement(By.cssSelector("#topcartlink > a > span.cart-label")).click();
		 
		 js.executeScript("window.scrollBy(0,700)");
		 
		  driver.findElement(By.xpath("//*[@id=\"termsofservice\"]")).click();
		 
		  driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
		 
		  Thread.sleep(3000);
		 
		  
		  // register the user
		  
		//  @Test(priority=1)
			//public void verify_register() throws Exception {
			
		  
		  driver.findElement(By.linkText("button-1 register-button")).click();
		 
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"gender-male\"]")).click();
		  
		  driver.findElement(By.cssSelector("#FirstName")).sendKeys("Test");
		  driver.findElement(By.cssSelector("#LastName")).sendKeys("Kumar");
		  
		  
		  // DOB
		  
		  WebElement day=driver.findElement(By.cssSelector("#DateOfBirthDay"));
			Select dropdown11=new Select(day);
			dropdown11.selectByVisibleText("02");
			
			WebElement month=driver.findElement(By.cssSelector("#DateOfBirthMonth"));
			Select mon=new Select(month);
			mon.selectByVisibleText("FEB - 02");
			
			WebElement year=driver.findElement(By.cssSelector("#DateOfBirthYear"));
			Select yy=new Select(year);
			yy.selectByVisibleText("1990");
			
			
			driver.findElement(By.cssSelector("#Email")).sendKeys("tets@gmail.com");
			
			
			js.executeScript("window.scrollBy(0,700)");
		 
		     driver.findElement(By.cssSelector("#Password")).sendKeys("test123");
		     driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("test123");
		     
		     driver.findElement(By.cssSelector("//*[@id=\"register-button\"]")).click();
		     Thread.sleep(1000);
		     
		     driver.findElement(By.linkText("register-continue")).click();
		     
		     js.executeScript("window.scrollBy(0,500)");
		     
		    // driver.findElement(By.cssSelector("#shopping-cart-form > div.cart-options > div.common-buttons > input.button-2.continue-shopping-button")).click();
		     
		     driver.findElement(By.xpath("//*[@id=\"termsofservice\"]")).click();
		     
		     driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
		     
		     
		     // select country
		     
		     WebElement county=driver.findElement(By.cssSelector("#BillingNewAddress_CountryId"));
				Select con=new Select(county);
				con.selectByVisibleText("india");
				driver.findElement(By.cssSelector("#BillingNewAddress_City")).sendKeys("Gurgaon");
				
				driver.findElement(By.cssSelector("#BillingNewAddress_Address1")).sendKeys("flat no 15 delhi");
		     driver.findElement(By.cssSelector("#BillingNewAddress_ZipPostalCode")).sendKeys("110033");
		    driver.findElement(By.cssSelector("#BillingNewAddress_PhoneNumber")).sendKeys("7345234517");
		    driver.findElement(By.cssSelector("#billing-buttons-container > input")).click();
		    
		    driver.findElement(By.cssSelector("#shipping-method-buttons-container > input")).click();
		   
		    // credit card
		    driver.findElement(By.cssSelector("#paymentmethod_1")).click();
		    
		    //Payment
		    driver.findElement(By.cssSelector("#payment-method-buttons-container > input")).click();
		    
		    
		     // card details
		    
		    driver.findElement(By.cssSelector("#CardholderName")).sendKeys("RAvindra");
		    
		    driver.findElement(By.cssSelector("#CardNumber")).sendKeys("4111111111111111");
		    
		    WebElement Month=driver.findElement(By.cssSelector("#ExpireMonth"));
			Select Mont=new Select(Month);
			Mont.selectByVisibleText("02");
			
			WebElement yeare=driver.findElement(By.cssSelector("#ExpireYear"));
			Select years=new Select(yeare);
			years.selectByVisibleText("2021");
			
			driver.findElement(By.cssSelector("#CardCode")).sendKeys("123");
			
			driver.findElement(By.cssSelector("#payment-info-buttons-container > input")).click();
			
			// conform order
			driver.findElement(By.cssSelector("#confirm-order-buttons-container > input")).click();
			
			
			// verify the order number
			
			
			WebElement order = driver.findElement(By.xpath("//div[@class='order-number']"));
			String order1 = order.toString();
			
			Assert.assertTrue("ORDER NUMBER", order1.contains(order1));
			System.out.println("Sucessfully order place ");
			
			 
		 
			}
}
