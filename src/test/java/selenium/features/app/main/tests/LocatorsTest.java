package selenium.features.app.main.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import selenium.features.app.main.base.MainBase;

public class LocatorsTest extends MainBase  {
	
	
	@Test
	public void relativeElementTest() throws Exception
	{
		launchBrowser();
		launchApp();
		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
		Thread.sleep(3000);
		WebElement ele = driver.findElement(RelativeLocator.with(By.tagName("div")).below(loginBtn));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'border : 2px solid black;')", ele);
		Thread.sleep(1000);
		js.executeScript("arguments[0].style.backgroundr='linear-gradient(yellow, green)';", ele);
		Thread.sleep(5000);
		closeBrowser();
	}

}
