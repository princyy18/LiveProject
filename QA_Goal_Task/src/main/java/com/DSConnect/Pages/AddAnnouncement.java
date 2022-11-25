package com.DSConnect.Pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AddAnnouncement {

	final WebDriver driver;
	
	//Constructor, as every page needs a Webdriver to find elements
	public AddAnnouncement(WebDriver driver){
			this.driver=driver;
		}
	
	@FindBy(how = How.XPATH,using="//div[contains(text(),'Settings')]")
	@CacheLookup
	WebElement settingsDropdown;
	
	@FindBy(how = How.XPATH,using="//a[normalize-space()='Announcement']")
	@CacheLookup
	WebElement selectAnnouncementMenu;
	
	@FindBy(how = How.XPATH,using="(//label[normalize-space()='None'])[1]")
	@CacheLookup
	WebElement noneBackground;
	
	@FindBy(how = How.XPATH,using="//button[@id='right-button']//img")
	@CacheLookup
	WebElement chooseBackground;
	
	@FindBy(how = How.XPATH,using="//button[@class='ButtonStyle']")
	@CacheLookup
	WebElement clickAddAnnouncementButton;
	
	@FindBy(how = How.XPATH,using="//input[@id='MediumText']")
	@CacheLookup
	WebElement mediumText;
	
	@FindBy(how = How.XPATH,using="//input[@id='BigText']")
	@CacheLookup
	WebElement bigText;
	
	@FindBy(how = How.XPATH,using="//input[@id='SmallText']")
	@CacheLookup
	WebElement smallText;
	
	@FindBy(how = How.XPATH,using="//input[@id='ButtonName']")
	@CacheLookup
	WebElement buttonText;
	
	@FindBy(how = How.XPATH,using="//button[@id='btnSaveLaunch']")
	@CacheLookup
	WebElement buttonSaveAndLaunch;
	
	@FindBy(how = How.XPATH,using="//input[@id='sStartDate']")
	@CacheLookup
	WebElement startDate;
	
	@FindBy(how = How.XPATH,using="//input[@id='sEndDate']")
	@CacheLookup
	WebElement endDate;
	
	@FindBy(how = How.XPATH,using="//span[@id='select2-Type-container']")
	@CacheLookup
	WebElement selectTypeDropdown;
	
	@FindBy(how = How.XPATH,using="//input[@aria-label='Search']")
	@CacheLookup
	WebElement searchTypeDropdown;
	
	@FindBy(how = How.XPATH,using="//label[@for='AnnualReviewImg4']")
	@CacheLookup
	WebElement selectIllustration;
	
	//Selecting Settings from dropdown
	public WebElement passDropDown()
	{
		return settingsDropdown;
	}
	//Selecting Announcement Menu from dropdown
	public WebElement passMenu()
	{
		return selectAnnouncementMenu;
	}
	
	//select the background dynamically in Add announcement Banner
	public void selectBackgroundDynamically() throws InterruptedException
	{
		
		Thread.sleep(2000);
		List<Integer> givenList = Arrays.asList(1,2,3,4);
		Random random = new Random();
	    int randomElement = givenList.get(random.nextInt(givenList.size()));
	   
//	    if(randomElement == 0)
//	    {
//	    	noneBackground.click();
//	    }
//	    else
	    
	    	driver.findElement(By.xpath("(//img[@alt='img'])["+randomElement+"]")).click();
	    	System.out.print(randomElement + "\n");
//	    else 
//	    {
//	    	
//	    	for(int i=1;i<=3;i++)
//	    	{
//	    		chooseBackground.click();
//	    		Thread.sleep(2000);
//	    	}
//	    	driver.findElement(By.xpath("(//li[@class='BackradioSelect'])["+randomElement+"]")).click();
//	    }
	    Thread.sleep(2000);
	}
	
	//get the current date
	public int getStartDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		int startDate=Integer.parseInt(dateFormat.format(date));
		return startDate;
	}
	
	//get the date after 2 days of current date
	public int getEndDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.DATE, 2);
	    int endDate=Integer.parseInt(dateFormat.format(cal.getTime())); 
	    return endDate;
	}	
	
	
	//Add new Announcement Banner 
	 public void AddNewAnnouncementForm(String MediumText,String SmallText,String BigText,String ButtonText,String TypeData,int StartDate,int EndDate) throws InterruptedException
	{
		clickAddAnnouncementButton.click();
		
		selectBackgroundDynamically();
		
		mediumText.sendKeys(MediumText);
		
		bigText.sendKeys(BigText);
	
		smallText.sendKeys(SmallText);
	
		buttonText.sendKeys(ButtonText);
		
		//scroll till the save  & launch button found
		
//      WebElement element = driver.findElement(By.xpath("//button[@id='btnSaveLaunch']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		Thread.sleep(500); 
		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",buttonSaveAndLaunch );
		Thread.sleep(500); 
		
		startDate.click();
		
		driver.findElement(By.xpath("//a[normalize-space()="+StartDate+"]")).click();
				
		endDate.click();
		
		driver.findElement(By.xpath("//a[normalize-space()="+EndDate+"]")).click();
		
		selectTypeDropdown.click();
		
		searchTypeDropdown.sendKeys(TypeData);
		searchTypeDropdown.sendKeys(Keys.ENTER);
		
	//	selectIllustration.click();
		
		buttonSaveAndLaunch.click();
	
	} 
	

}
