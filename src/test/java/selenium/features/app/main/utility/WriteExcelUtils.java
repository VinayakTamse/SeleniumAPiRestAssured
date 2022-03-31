package selenium.features.app.main.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelUtils {
	
	public static void main(String[] args) throws IOException {
		String filepath = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata2.xlsx";
		File f = new File(filepath);
		
		
		FileInputStream fileOut = new FileInputStream(f);
		Object [][] data = new Object [][] {
			{"EmpId", "EmpName", "Salary"},
			{101, "Kajal", 34000}
		};
		//XSSFWorkbook workbook = new XSSFWorkbook();
		Workbook workbook = WorkbookFactory.create(fileOut);
		Sheet sheet = workbook.createSheet("data3");
		fileOut.close();
		int row = data.length;
		int col = data[0].length;
		
		for (int i=0; i<row; i++)
		{
			Row rows = sheet.createRow(i);
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
		
		FileOutputStream wr = new FileOutputStream(f);
		
		workbook.write(wr);
		fileOut.close();
		System.out.println("Completed");
	}

}
