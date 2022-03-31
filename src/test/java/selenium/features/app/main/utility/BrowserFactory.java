package selenium.features.app.main.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	final String chromedriverpath = ".\\src\\main\\resources\\drivers\\chromedriver.exe";
	final String firefoxdriverpath = ".\\src\\main\\resources\\drivers\\geckodriver.exe";
	final String edgedriverpath = ".\\src\\main\\resources\\drivers\\msedgedriver.exe";
	WebDriver driver;
	
	public WebDriver BrowserType(String browsername) throws Exception
	{
		switch (browsername)
		{
		case "Chrome":
		case "chrome":
			System.setProperty("webdriver.chrome.driver", chromedriverpath);
			driver = new ChromeDriver();
			break;
		case "Firefox":
		case "firefox":
			System.setProperty("webdriver.gecko.driver", firefoxdriverpath);
			driver = new FirefoxDriver();
			break;
		case "Edge":
		case "edge":
			System.setProperty("webdriver.edge.driver", edgedriverpath);
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid Browser Type");
			throw new Exception("Invalid Browser Type Please Choose Either Chrome, Firefox or Edge");
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	

}
