package MavenProjects.Logics.and.ObjectCalls;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class container{
	
	
	WebDriver driver = WebDriverManager.chromedriver().create();
	//String Username,Password,mediumText,smallText,bigText,buttonText;

	//open the chrome browser
	public void openBrowser(String url)
	{		
		//Maximize Window
		driver.manage().window().maximize();
		
		//Opening URL into Web Browser
		driver.get(url);
	}
	
	//fill data function it will have all the local data
	/*public void filldata()
	{
		this.Username = "lokeshs@gain-insights.com";
		this.Password = "Frua@sLRKJ^87#";
		
		this.mediumText = "Your Annual Review is";
		this.smallText =  "Live Now";
		this.bigText = "Please fill up your review form";
		this.buttonText = "Click here";
	}*/
	
	//Login into DSConnect Website
	public void login(String Username , String Password)
	{
		//Sending Data to Username Field
		driver.findElement(By.xpath("//input[@id='emailID']")).sendKeys(Username);
		
		//Sending Data to Password Field
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
		
		//clicking on signin button
		driver.findElement(By.cssSelector("input[value='Sign In']")).click();
	}
	public void HandleAlert() throws InterruptedException
	{
//		
//		WebDriverWait wait = new WebDriverWait(driver,5);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='popup']")));
		
		driver.findElement(By.xpath("//button[@class='cancelBtn']")).click();
	}
	//open the dropdown and select announcement from dropdown
	public void openDropdownAndSelect() throws InterruptedException
	{
		//click on settings in order to open dropdown
		driver.findElement(By.xpath("//div[contains(text(),'Settings')]")).click();
		Thread.sleep(3000);
//		WebDriverWait wait = new WebDriverWait(driver,5);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Settings')]")));
		
		driver.findElement(By.xpath("//a[normalize-space()='Announcement']")).click();
		
	}
	
	//select the background dynamically in Add announcement Banner
	public void selectBackgroundDynamically() throws InterruptedException
	{
		//Selecting Background Dynamically
		Thread.sleep(2000);
		//Taking Random Number from Array List
		List<Integer> givenList = Arrays.asList(0,1,2,3,4,5,6);
		Random random = new Random();
	    int randomElement = givenList.get(random.nextInt(givenList.size()));
	   
	    //clicking on the random variable
	    if(randomElement == 0)
	    {
	    	driver.findElement(By.xpath("(//label[normalize-space()='None'])[1]")).click();
	    }
	    else if(randomElement == 1 || randomElement == 2)
	    {
	    	driver.findElement(By.xpath("(//li[@class='BackradioSelect'])["+randomElement+"]")).click();
	    }
	    else 
	    {
	    	
	    	//Clicking on the Right Arrow 3 times in order to choose background
	    	for(int i=1;i<=3;i++)
	    	{
	    		driver.findElement(By.xpath("//button[@id='right-button']//img")).click();
	    		Thread.sleep(2000);
	    	}
	    	driver.findElement(By.xpath("(//li[@class='BackradioSelect'])["+randomElement+"]")).click();
	    }
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
		 //click on add announcement button
		driver.findElement(By.xpath("//button[@class='ButtonStyle']")).click();
		
		//calling function in order to select background dynamically
		selectBackgroundDynamically();
		
		//sending data to Medium Text Field
		driver.findElement(By.xpath("//input[@id='MediumText']")).sendKeys(MediumText);
		
		//Sending Data to Big Text Field
		driver.findElement(By.xpath("//input[@id='BigText']")).sendKeys(BigText);
	
		//Sending Data to Small Text Field
		driver.findElement(By.xpath("//input[@id='SmallText']")).sendKeys(SmallText);
	
		//Sending Data to Button Text Field
		driver.findElement(By.xpath("//input[@id='ButtonName']")).sendKeys(ButtonText);
	
		//scroll till the save  & launch button found
        WebElement element = driver.findElement(By.xpath("//button[@id='btnSaveLaunch']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		
		//selecting start date
		driver.findElement(By.xpath("//input[@id='sStartDate']")).click();
		
		//wait to open date picker
//		WebDriverWait wait222 = new WebDriverWait(driver,5);
//		wait222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='sStartDate']")));
		driver.findElement(By.xpath("//a[normalize-space()="+StartDate+"]")).click();
				
		//selecting end date
		driver.findElement(By.xpath("//input[@id='sEndDate']")).click();
		
		//wait to open date picker
//		WebDriverWait wait2222 = new WebDriverWait(driver,5);
//		wait2222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='sEndDate']")));
		driver.findElement(By.xpath("//a[normalize-space()="+EndDate+"]")).click();
		
		//type drop down
		driver.findElement(By.xpath("//span[@id='select2-Type-container']")).click();
		
		//wait to open drop down
//		WebDriverWait wait22222 = new WebDriverWait(driver,5);
//		wait22222.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='select2-Type-container']")));
		
		//select skills from drop down and press enter from keyboard
		driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys(TypeData);
		driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys(Keys.ENTER);
		
		//selecting illustration image
		driver.findElement(By.xpath("//label[@for='AnnualReviewImg4']")).click();
		
		//click on save & launch button
		driver.findElement(By.xpath("//button[@id='btnSaveLaunch']")).click();
	
		Thread.sleep(2000);
		
	} 
	

	
}
