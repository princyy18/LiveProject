package com.xlsxdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getAllColumnData {

	public static void main(String[] args) throws IOException {
		//need Data formatter because Selenium is not able to get cell data directly in string format
		DataFormatter formatter = new DataFormatter();
				
		File file = new File(System.getProperty("user.dir")+"//TestData//"+"Exceldata"+".xlsx");
		FileInputStream inputstream = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = wb.getSheet("LoginDetails");
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(1);
		
		for(int i=0;i<=row.getLastCellNum();i++)
		{
			cell = row.getCell(i);
			String Column_Name = formatter.formatCellValue(cell);
			System.out.println(Column_Name);
		}
	}

}
