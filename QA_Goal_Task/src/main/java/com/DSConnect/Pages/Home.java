package com.DSConnect.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class Home {
final WebDriver driver;
	
	//Constructor, as every page needs a Webdriver to find elements
	public Home(WebDriver driver){
			this.driver=driver;
		}
	
	
	@FindBy(how = How.XPATH,using="//button[@class='cancelBtn']")
	@CacheLookup
	WebElement alertCancel;
	
	@FindBy(how = How.XPATH,using="//div[contains(@class,'dsai-heading-8 ml-20')][normalize-space()='Passport']")
	@CacheLookup
	WebElement passportDropdown;
	
	@FindBy(how = How.XPATH,using="//a[normalize-space()='Passport Template']")
	@CacheLookup
	WebElement selectPassportTMenu;
	
	
	
	public WebElement passDropDown()
	{
		return passportDropdown;
	}
	//Selecting Announcement Menu from dropdown ---> Temporaray to verify Home Page
	public WebElement passMenu()
	{
		
		return selectPassportTMenu;
	}
	
	public void HandleAlert() {
		
		alertCancel.click();
			
	}
	
	public void openDropdownAndSelect(WebElement selectDropDown, WebElement selectMenu) throws InterruptedException
	{
		
		selectDropDown.click();
		Thread.sleep(2000);
		selectMenu.click();
//		Assert.assertEquals("Passport Template", selectMenu.getText());
	}
}
