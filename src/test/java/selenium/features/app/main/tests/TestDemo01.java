package selenium.features.app.main.tests;

import org.testng.annotations.Test;

import selenium.features.app.main.base.MainBase;
import selenium.features.app.main.utility.BaseIn2;
import selenium.features.app.main.utility.Libs;

public class TestDemo01 extends MainBase implements BaseIn2{
	
	@Test
	public void test_app01() throws Exception
	{
		launchBrowser();
		launchApp();
		Thread.sleep(5000);
		Libs lib = new Libs();
		lib.enterText(driver, lib.fluentWait(driver, usernameXpath), "Admin");
		lib.enterText(driver, lib.fluentWait(driver, userpasswordXpath), "admin123");
		lib.clickOnWebelement(driver, lib.fluentWait(driver, loginButtonXpath));
		
		Thread.sleep(5000);
		closeBrowser();
	}

}
