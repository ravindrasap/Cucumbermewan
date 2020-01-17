package Page_Objects_IndiaLends;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

 
public class Brockenlink {
	
	public static WebDriver driver;

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//driver//"+"chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("launching chrome browser");
		driver.manage().window().maximize();
		driver.get("http://indialends.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are:"+links.size());
		
		for( int i=0;i<links.size();i++) 
		{
			WebElement ele = links.get(i);
			
			String url = ele.getAttribute("href");
			verify_links(url);
		}
	}

	private static void verify_links(String linkurl) 
	{
		try 
		{
			URL url = new URL(linkurl);
			HttpURLConnection httpURLConnect =  (HttpURLConnection)url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			
			if (httpURLConnect.getResponseCode()==200)
			{
				System.out.println(linkurl+"Status"+httpURLConnect.getResponseMessage());
			}
			
			else if (httpURLConnect.getResponseCode()!=200)
			{
				System.out.println(linkurl+"Status"+httpURLConnect.getResponseMessage());
			}
			
		}
		
		catch(Exception ex)
		{
			
		}
	}
	
	
}
