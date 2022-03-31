package selenium.features.app.main.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelUtils2 {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fileInput = new FileInputStream(".\\src\\test\\resources\\testdata1.xlsx");
		
		Workbook workbook = WorkbookFactory.create(fileInput);
		
		Sheet sheet = workbook.getSheetAt(0);
		
		int lastRow = sheet.getLastRowNum();
		
		fileInput.close();
		
		Object [][] data = new Object[][] {
			{5, "Vinod", 23000},
			{6, "Arjun", 77000},
			{7, "Ramesh", 55000}
		};
		
		int row = data.length;
		int col = data[0].length;
		
		for (int i=0; i<row; i++)
		{
			Row rows = sheet.createRow(++lastRow);
			
			for (int j=0; j<col; j++)
			{
					Cell cell = rows.createCell(j);
					Object value = data[i][j];
					if (value instanceof String)
					{
						cell.setCellValue((String)value);
					}
					if (value instanceof Integer)
					{
						cell.setCellValue((Integer)value);
					}
					if (value instanceof Boolean)
					{
						cell.setCellValue((Boolean)value);
					}
			}
		}
		
		FileOutputStream fileOut = new FileOutputStream(".\\src\\test\\resources\\testdata1.xlsx");
		workbook.write(fileOut);
		fileOut.close();
		System.out.println("Updated");
		
	}

}
