package selenium.features.app.main.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import selenium.features.app.main.base.MainBase;
import selenium.features.app.main.utility.BaseIn2;
import selenium.features.app.main.utility.ExcelUtilsApp;

public class TableTest extends MainBase implements BaseIn2{
	
	@Test
	public void test_table() throws Exception
	{
		String excel_file = ".\\src\\test\\resources\\testdata2.xlsx";
		launchBrowser();
		launchApp();
		int RowCount = driver.findElements(By.xpath("(//table/tbody)[1]/tr")).size();
		
		for (int i=1; i<=RowCount; i++)
		{
			String state = driver.findElement(By.xpath("(//table/tbody)[1]/tr["+i+"]/td[1]")).getText();
			String Capital = driver.findElement(By.xpath("(//table/tbody)[1]/tr["+i+"]/td[2]")).getText();
			String Language = driver.findElement(By.xpath("(//table/tbody)[1]/tr["+i+"]/td[3]")).getText();
			
			ExcelUtilsApp.setExceldata(excel_file, "StatesAndCapital", i, 0, state);
			ExcelUtilsApp.setExceldata(excel_file, "StatesAndCapital", i, 1, Capital);
			ExcelUtilsApp.setExceldata(excel_file, "StatesAndCapital", i, 2, Language);
		}
		
		closeBrowser();
		System.out.println("====Completed====");
	}

}
