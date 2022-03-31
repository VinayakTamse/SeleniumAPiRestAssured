package selenium.features.app.main.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUtils {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fileInput = new FileInputStream(".\\src\\test\\resources\\testdata1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = workbook.getSheet("data1");
		Iterator<Row> rowItr = sheet.rowIterator();
		while(rowItr.hasNext())
		{
			XSSFRow row = (XSSFRow)rowItr.next();
			Iterator<Cell> cellItr = row.cellIterator();
			
			while(cellItr.hasNext())
			{
				XSSFCell celldata = (XSSFCell)cellItr.next();
				switch (celldata.getCellType())
				{
				case STRING:
					System.out.print(celldata.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(celldata.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(celldata.getBooleanCellValue());
					break;
				}
				System.out.print("   |   ");
				
			}
			System.out.println("");
		}
		
		workbook.close();
		fileInput.close();
		
	}

}
