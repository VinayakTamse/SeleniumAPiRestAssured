package selenium.features.app.main.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelUtils3 {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		Object [][] data = new Object[][] {
			{1, "Vinod", 23000},
			{2, "Arjun", 77000},
			{3, "Ramesh", 55000}
		};
		FileInputStream fileIn = new FileInputStream(".\\src\\test\\resources\\testdata1.xlsx");
		XSSFWorkbook workbook =  new XSSFWorkbook(fileIn);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowNum = sheet.getPhysicalNumberOfRows();
		fileIn.close();
		int row = data.length;
		int col = data[0].length;
		
		for (Object [] r : data)
		{
			XSSFRow ro = sheet.createRow(rowNum++);
			
			int cellCount=0;
			
			for (Object c : r)
			{
				XSSFCell co = ro.createCell(cellCount++);
				if (c instanceof String)
				{
					co.setCellValue((String)c);
				}
				if (c instanceof Integer)
				{
					co.setCellValue((Integer)c);
				}
				if (c instanceof Boolean)
				{
					co.setCellValue((Boolean)c);
				}
				
			}
		}
		
	
		
		FileOutputStream fileOut = new FileOutputStream(".\\src\\test\\resources\\testdata1.xlsx");
		
		workbook.write(fileOut);
		fileOut.close();
		System.out.println("Completed");
	
	
	}

}
