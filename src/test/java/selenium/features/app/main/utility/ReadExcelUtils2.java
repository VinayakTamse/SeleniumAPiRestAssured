package selenium.features.app.main.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUtils2 {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fileInput = new FileInputStream(".\\src\\test\\resources\\testdata1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = workbook.getSheet("data1");
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		
		for (Row rows : sheet)
		{
			for (Cell cells : rows)
			{
				System.out.println(cells.toString());
			}
		}
		
		System.out.println("===================>");
		
		
	}

}
