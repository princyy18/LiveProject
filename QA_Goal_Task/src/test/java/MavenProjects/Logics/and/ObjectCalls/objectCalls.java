package MavenProjects.Logics.and.ObjectCalls;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;


public class objectCalls {

	@Test
	public void browser() throws InterruptedException, IOException
	{
		//load the file and read the data from file
		Properties pro = new Properties();
		FileInputStream io = new FileInputStream("/Users/princy.anghan/Documents/Selenium/testData.properties");
		pro.load(io);
		
		//creating object of Container function class in order to access the Properties of class
		container user1 = new container();
		
		//passing parameter directly reading from file
		//calling open browser function
		user1.openBrowser(pro.getProperty("URL"));
		
		
		//calling login function
		user1.login(pro.getProperty("Username"),pro.getProperty("Password"));
		
		user1.HandleAlert();
		//calling open Drop down and select function
		user1.openDropdownAndSelect();
		
		//calling Add Announcement Form function
		user1.AddNewAnnouncementForm(pro.getProperty("MediumText"),pro.getProperty("SmallText"),pro.getProperty("BigText"),pro.getProperty("ButtonText"),pro.getProperty("TyepData"),user1.getStartDate(),user1.getEndDate());
		
	}
}
