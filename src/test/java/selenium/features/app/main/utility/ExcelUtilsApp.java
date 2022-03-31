package selenium.features.app.main.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsApp {
	
	static FileInputStream fi;
	static FileOutputStream fo;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	
	public static void setExceldata(String filename, String SheetName, int rowmun, int colnum, String data) throws IOException
	{
		File file = new File(filename);
		if (! file.exists())
		{
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(filename);
			workbook.write(fo);
		}
		
		fi = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fi);
		
		if (workbook.getSheetIndex(SheetName)==-1)
		{
			sheet = workbook.createSheet(SheetName);
		}
		sheet = workbook.getSheet(SheetName);
		
		if (sheet.getRow(rowmun)==null)
		{
			row = sheet.createRow(rowmun);
		}
		row = sheet.getRow(rowmun);
		
		cell = row.createCell(colnum);
		
		cell.setCellValue(data);
		fo = new FileOutputStream(filename);
		workbook.write(fo);
		
		workbook.close();
		fi.close();
		fo.close();
	}

}
