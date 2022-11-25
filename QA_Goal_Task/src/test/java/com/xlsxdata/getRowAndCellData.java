package com.xlsxdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getRowAndCellData {

	public static void main(String[] args) throws IOException {
		
		//need Data formatter because Selenium is not able to get cell data directly in string format
				DataFormatter formatter = new DataFormatter();
						
				File file = new File(System.getProperty("user.dir")+"//TestData//"+"Exceldata"+".xlsx");
				FileInputStream inputstream = new FileInputStream(file);
				
				XSSFWorkbook wb = new XSSFWorkbook(inputstream);
				XSSFSheet sheet = wb.getSheet("LoginDetails");
				XSSFRow row = null;
				XSSFCell cell = null;
				String username = null;
				String Password = null;
				
				for(int i=1;i<=sheet.getLastRowNum();i++)
				{
					row = sheet.getRow(i);
					
					for(int j=0;j<row.getLastCellNum();j++)
					{
						cell = row.getCell(j);
						if(j == 0)
						{
							username = formatter.formatCellValue(cell);
							
						}
						else
						{
							Password = formatter.formatCellValue(cell);
							
						}
						
					}
					System.out.println("Username is = "+username);
					System.out.println("Password is = "+Password);
					System.out.println();
				}
				
				
	}

}
