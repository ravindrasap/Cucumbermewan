package Ameyo;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

public class Scrrenshot {

    @Test

    public void TakeScreenShot() throws Exception{

    	ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver ;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//driver//"+"chromedriver.exe");
		driver = new ChromeDriver(options);

         driver.get("https://indialends.com/");

        //Call take screenshot function

        Scrrenshot.takeSnapShot(driver, "D:\\Screenshot\\test.png") ;     

    }

    
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

         TakesScreenshot scrShot =((TakesScreenshot)webdriver);

           File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

           File DestFile=new File(fileWithPath);

           FileUtils.copyFile(SrcFile, DestFile);

    }

}