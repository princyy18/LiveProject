package com.xlsxdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class getCellDataFromXlsx {

	public static void main(String[] args) throws IOException {
		
		//need Data formatter because Selenium is not able to get cell data directly in string format
		DataFormatter formatter = new DataFormatter();
		
		//to open a file
		File file = new File(System.getProperty("user.dir") + "//TestData//" + "Exceldata" + ".xlsx");
		
		//input stream to read file
		FileInputStream inputstream = new FileInputStream(file);
		
		//to reach to workbook
		XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		
		//to reach to sheet
		XSSFSheet sheet = wb.getSheet("LoginDetails");
		
		//to reach to row
		XSSFRow row = sheet.getRow(1);
		
		//to reach to cell
		XSSFCell cell = row.getCell(0);
		
		
		//String UserName = cell.getStringCellValue();
		
		//read UserName of row 1 cell 0 ----> first userName
		String Username = formatter.formatCellValue(cell);
		System.out.println("Username is "+Username);
		
		
		cell = row.getCell(1);
		//read userName of row 1 cell 0 ---> first password
		String Password = formatter.formatCellValue(cell);
		System.out.println("Password is "+Password);
	}

}
