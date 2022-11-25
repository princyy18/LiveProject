package com.TestRails.Page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
//import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addDuplicatePage {

	@Test
	public void doActions() throws AWTException
	{
		//Setup browser
		WebDriverManager.chromedriver().create();
		
		
		//Adding .crx file
		ChromeOptions chromeOptions = new ChromeOptions();
		String fileURL = System.getProperty("user.dir");
		chromeOptions.addExtensions(new File(fileURL + "/src/test/resources/extensions/Get CRX 1.40.0.0.crx"));
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.get("http://demo.simformsolutions.com/Login/Login");
		driver.manage().window().maximize();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_SHIFT);
		r.keyRelease(KeyEvent.VK_ALT);
		
		
		
	}
	

}
