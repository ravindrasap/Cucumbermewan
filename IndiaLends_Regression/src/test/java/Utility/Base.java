package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
	
	protected WebDriver driver;
	protected static Properties properties;
	protected String mobileno=Base.randomMobile();
	protected String email=Base.randommEmail();
	protected String pancard=Base.randommPAN();
	protected String otpURL="http://v.indialends.com/test/get_otp_user_registration_encrypt.ashx?type=json&mobileno=";
	//protected String otpURL="http://uatweb.indialends.com/internal/a/get_otp_mail_verify_api.ashx?mobileno=";
	
	public void initilizeDriver(String browser){
		
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//driver//"+"chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("enable-automation");
			//options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-extensions");
			options.addArguments("--dns-prefetch-disable");
			options.addArguments("--disable-gpu");
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver=new ChromeDriver(options);
			
			//driver=new ChromeDriver();
			
		} else if(browser.equalsIgnoreCase("firefox")){
			
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"//driver//"+"geckodriver.exe");
			driver=new FirefoxDriver();
		} else {
			
			driver=new InternetExplorerDriver();
		}
		
	}
	
	@BeforeTest(alwaysRun=true)
	public void startUp(){
		
		initilizeDriver("chrome");
		getURL();
		setWaitAndWindowMaximize();
		
	}
	
	public void getURL() {
		String URL = loadPropertiesFile("login.properties", "URL");
		System.out.println("URL Value is " + URL);
		driver.get(URL);
	}

	public static String loadPropertiesFile(String FileName, String Key) {
		String URL_Value = "";
		File file = new File(System.getProperty("user.dir")
				+ "//src//test//resources//Config_Data_Provider//" + FileName);
		try {
			FileInputStream fis = new FileInputStream(file);
			properties = new Properties();
			properties.load(fis);
			URL_Value = properties.getProperty(Key);
		} catch (Exception e) {

			System.out.println("Exception message is " + e.getMessage());
		}

		return URL_Value;
	}
	
/*	public static Object writePropertiesFile(String Key, String Value) {
		Object DATA_Value = "";
		File file = new File(System.getProperty("user.dir")
				+ "//src//test//resources//Config_Data_Provider//data.properties");
		try {
			
			FileOutputStream fileOut = new FileOutputStream(file);
			properties.store(fileOut, "Favorite Things");
			DATA_Value =properties.setProperty(Key, Value);
			fileOut.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return DATA_Value;

	}*/

	public void setWaitAndWindowMaximize() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest(alwaysRun=true)
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	 public static String randomEmail() {
	        return "random_" +/* UUID.randomUUID().toString() +*/ gen()+ "@gmail.com";
	    }
	    
	    private static int gen() {
	    	Random r = new Random( System.currentTimeMillis() );
	        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	    }
	    public static String randomMobile() {
			//System.out.println("random number generation"); 
		/*	Random obj= new Random(); 
			//create object for random class
			int rgen1= obj.nextInt(1000);//get random number with in the range of 0-1000 
			
			//int rgen1=obj.nextInt(10000000) % 10000;
			String cellnum = ("612340" + rgen1); 
			//System.out.println(cellnum);
*/			
			String numStart = "51";
	        String numRemainder;
	        String numComplete;
	        String sd3, sd4, sd5, sd6, sd7, sd8, sd9, sd10, sd11;
	 
	        Random rand = new Random();
	 
	      //  int d3 = rand.nextInt(10);
	        int d4 = rand.nextInt(10);
	        int d5 = rand.nextInt(10);
	        int d6 = rand.nextInt(10);
	        int d7 = rand.nextInt(10);
	        int d8 = rand.nextInt(10);
	        int d9 = rand.nextInt(10);
	        int d10 = rand.nextInt(10);
	        int d11 = rand.nextInt(10);
	 
	       // sd3 = Integer.toString(d3);
	        sd4 = Integer.toString(d4);
	        sd5 = Integer.toString(d5);
	        sd6 = Integer.toString(d6);
	        sd7 = Integer.toString(d7);
	        sd8 = Integer.toString(d8);
	        sd9 = Integer.toString(d9);
	        sd10 = Integer.toString(d10);
	        sd11 = Integer.toString(d11);
	 
	        numRemainder= ""+sd4+""+sd5+""+sd6+""+sd7+""+sd8+""
	                +sd9+""+sd10+""+sd11+"";
	 
	        numComplete = ""+numStart+""+numRemainder+"";
	 
	       // System.out.println(numComplete);
			
			return numComplete;
	    }
	    public static String randommEmail() {
	        return "random_" +/* UUID.randomUUID().toString() +*/ gen()+ "@gmail.com";
	    }
	    public static String randommPAN() {
	        return "BAAPQ" +/* UUID.randomUUID().toString() +*/ genn()+ "B";
	    }
	    
	    private static int genn() {
	    	Random r = new Random( System.currentTimeMillis() );
	        return ((1 + r.nextInt(2)) * 1000 + r.nextInt(1000));
	    }
}
