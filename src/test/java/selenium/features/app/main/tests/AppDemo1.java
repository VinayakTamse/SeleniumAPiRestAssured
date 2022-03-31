package selenium.features.app.main.tests;

import org.openqa.selenium.By;

import selenium.features.app.main.base.MainBase;
import selenium.features.app.main.utility.BaseIn;
import selenium.features.app.main.utility.BaseIn2;
import selenium.features.app.main.utility.Title;
import selenium.features.app.main.utility.URL;

public class AppDemo1 extends MainBase implements BaseIn2 {
	
	public static void main(String[] args) throws Exception {
		
		launchBrowser();
		launchApp();
		//Get Title
		Title t = () -> driver.getTitle();
		URL u = () -> driver.getCurrentUrl();
		System.out.println(t.title());
		System.out.println(u.url());
		driver.findElement(By.xpath(usernameXpath)).sendKeys("Admin");
		driver.findElement(By.xpath(userpasswordXpath)).sendKeys("admin123");
		driver.findElement(By.xpath(loginButtonXpath)).click();
		BaseIn.justWait();
		closeBrowser();
		
	}

}
