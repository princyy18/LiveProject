package com.DSConnect.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginDSConnect {

	
final WebDriver driver;
	
	//Constructor, as every page needs a Webdriver to find elements
	public LoginDSConnect(WebDriver driver){
			this.driver=driver;
		}
	
	
	//Locating elements
	@FindBy(how = How.XPATH,using="//input[@id='emailID']")
	@CacheLookup
	WebElement username;
	
	@FindBy(how = How.XPATH,using="//input[@id='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(how = How.XPATH,using="//input[@value='Sign In']")
	@CacheLookup
	WebElement signin;
	
	
	
	
	public void LogIn_Action(String uName, String pwd) throws InterruptedException{
		
		username.sendKeys("lokeshs@gain-insights.com");
		password.sendKeys("Frua@sLRKJ^87#");
		signin.click();
		Thread.sleep(2000);
			
	}
}
