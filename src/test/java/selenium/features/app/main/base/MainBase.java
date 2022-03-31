package selenium.features.app.main.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import selenium.features.app.main.utility.BrowserFactory;

public class MainBase {
	
	public static WebDriver driver;
	private final String propertiesfile =".\\src\\main\\resources\\app.properties";
	public static FileInputStream file;
	public static Properties props;
	private String browsername;
	static MainBase main;
	
	
	public MainBase()
	{
		try {
			file = new FileInputStream(propertiesfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		props = new Properties();
		try {
			props.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setBrowserType(String browsername)
	{
		this.browsername = browsername;
	}
	
	public String getBrowsername() {
		return browsername;
	}
	
	public static void launchBrowser() throws Exception
	{
		main = new MainBase();
		main.setBrowserType(props.getProperty("Browser"));
		driver = new BrowserFactory().BrowserType(main.getBrowsername());
	}
	
	public static void launchApp()
	{
		driver.get(props.getProperty("Url"));
	}
	
	public static void closeBrowser()
	{
		driver.quit();
	}

	
	

}
