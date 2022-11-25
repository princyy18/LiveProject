package com.DSConnect.TestCases;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.DSConnect.Pages.AddAnnouncement;
import com.DSConnect.Pages.Home;
import com.DSConnect.Pages.LoginDSConnect;


import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyAddAnnouncement {
	
	@Test
	public void CheckValidAnnouncementBanner() throws InterruptedException, IOException
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
		AddAnnouncement addBanner = PageFactory.initElements(driver, com.DSConnect.Pages.AddAnnouncement.class);
		
		login.LogIn_Action(pro.getProperty("Username"), pro.getProperty("Password"));
		
		homePage.HandleAlert();
		
		homePage.openDropdownAndSelect(addBanner.passDropDown() ,addBanner.passMenu());
		
		addBanner.AddNewAnnouncementForm(pro.getProperty("MediumText"),pro.getProperty("SmallText"),pro.getProperty("BigText"),pro.getProperty("ButtonText"),pro.getProperty("TyepData"),addBanner.getStartDate(),addBanner.getEndDate());

	}
}
