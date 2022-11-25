package com.xlsxdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dynamicLoginTestScript {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/");
		
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
		String Result = null;
		
		for(int i=1;i<sheet.getLastRowNum();i++)
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
			//click on login button
			driver.findElement(By.xpath("//a[@class='ico-login']")).click();
			
			//send username and password from Excel sheet
			driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Password);
			
			//click on login
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
			
			//try if login sucess
			try
			{
				//logout is display on screen ?
				Boolean isSucess = driver.findElement(By.xpath("//a[@class='ico-logout']")).isDisplayed();
				//if sucess pass true in result
				if(isSucess == true)
				{
					Result = "PASS";
					cell = row.createCell(2);
					formatter.formatCellValue(cell);
					cell.setCellValue(Result);
				}
				System.out.println("Username = " + username + " and " + " Password = " + Password +" || Login Success "+ " --->"+ Result);
				//click on logout 
				driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
			}
			//handle exception if login fail
			catch(Exception e)
			{
				//Error is display on screen ?
				Boolean isError = driver.findElement(By.xpath("//*[text()='The credentials provided are incorrect']")).isDisplayed();
				//if error pass false in result
				if(isError == true)
				{
					Result = "FAIL";
					cell = row.createCell(2);
					formatter.formatCellValue(cell);
					cell.setCellValue(Result);
				}
				System.out.println("Username = " + username + " and " + " Password = " + Password +" || Login Fail "+ " --->"+ Result);
				//click on login again
				driver.findElement(By.xpath("//a[@class='ico-login']")).click();
			}
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		fos.close();
			
		}
		
		
	}

}

