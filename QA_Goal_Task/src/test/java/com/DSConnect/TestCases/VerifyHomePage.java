package com.DSConnect.TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.DSConnect.Pages.Home;
import com.DSConnect.Pages.LoginDSConnect;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyHomePage {

	@Test
	public void CheckValidHomePage() throws InterruptedException, IOException
	{
		//load the file and read the data from file
		Properties pro = new Properties();
		FileInputStream io = new FileInputStream("/Users/princy.anghan/Documents/Selenium/testData.properties");
		pro.load(io);
		
		
		WebDriver driver =  WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get(pro.getProperty("URL"));
		
		
		LoginDSConnect login = PageFactory.initElements(driver, LoginDSConnect.class);
		Home homePage = PageFactory.initElements(driver, Home.class);
		
		login.LogIn_Action(pro.getProperty("Username"), pro.getProperty("Password"));
		
		Thread.sleep(1000);
		System.out.println("Login Successfully");
		
		homePage.HandleAlert();
				
		homePage.openDropdownAndSelect(homePage.passDropDown(),homePage.passMenu());
		driver.quit();
		
	}
	
}
