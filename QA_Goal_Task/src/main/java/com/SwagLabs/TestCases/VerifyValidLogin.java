package com.SwagLabs.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.SwagLabs.Pages.Login;

import io.github.bonigarcia.wdm.WebDriverManager;



public class VerifyValidLogin {
	

	@Test
	public void checkValidUser() throws InterruptedException
	{
		WebDriver driver =  WebDriverManager.chromedriver().create();
		driver.get("https://demoqa.com/login");
		
		Login loginPg = PageFactory.initElements(driver, Login.class);
		
		loginPg.LogIn_Action("princyyy", "Simform@123");

	}
	

}
