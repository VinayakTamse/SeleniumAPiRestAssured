package selenium.features.app.main.utility;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

public class Libs {
	
	public WebElement fluentWait(WebDriver driver, String locator)
	{
		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(45))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		Function<WebDriver, WebElement> func = d ->  d.findElement(By.xpath(locator));
		
		//return fluent.until(d -> func.apply(d));
		return fluent.until(func);
	}
	
	public void highlightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].style.border='2px solid black';", element);
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px dashed black; background-color: yellow");
	}
	
	public void clickOnWebelement(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		highlightElement(driver, element);
		actions.click(element).perform();
	}
	
	public void enterText(WebDriver driver, WebElement element, String Value)
	{
		Actions actions = new Actions(driver);
		highlightElement(driver, element);
		actions.sendKeys(element, Value).perform();
	}

}
