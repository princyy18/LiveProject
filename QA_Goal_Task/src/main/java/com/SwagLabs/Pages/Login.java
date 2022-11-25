package com.SwagLabs.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
final WebDriver driver;
	
	//Constructor, as every page needs a Webdriver to find elements
	public Login(WebDriver driver){
			this.driver=driver;
		}
		
	//Locating the username text box
		
		

	@FindBy(how = How.XPATH,using="//input[@id='userName']")
	WebElement username;
	
	//Locating the password text box
	@FindBy(id="password")
	WebElement pswd;
	
	//Locating Login Button
	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(id="submit")
	WebElement logout;
	
	//Method that performs login action using the web elements
	public void LogIn_Action(String uName, String pwd) throws InterruptedException{
		
	 username.sendKeys(uName);
		pswd.sendKeys(pwd);
		loginBtn.click();
		Thread.sleep(4000);
		logout.click();
		
	}
}
