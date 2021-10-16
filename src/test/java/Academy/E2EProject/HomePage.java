package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.Loginpage;
import resources.Base;

public class HomePage extends Base{ 
	
	private static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initializeBrow() throws IOException 
	{
		driver = initializeDriver();
	}
		
	@Test(dataProvider="getData")
	public void basePageNav(String username, String password, String text) throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		
		LandingPage lp = new LandingPage(driver);
		
		lp.clicksignIn().click(); 
		
		Loginpage lop = new Loginpage(driver);
		
		lop.enterUsername().sendKeys(username);
		
		lop.enterPassword().sendKeys(password);
		
		log.info(text);
		
		lop.clickLogin().click();
		
		System.out.println("Git Demo Test");
		System.out.println("Git Demo Test2");
		System.out.println("Git Demo Test3");
		System.out.println("Git Demo Test4");
		System.out.println("Git Demo Test5");
		System.out.println("Git Demo Test6");

		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object data[][] = new Object[2][3];
		
		data[0][0] = "nonrestricteduser@qa.com";
		data[0][1] = "1234567";
		data[0][2] = "Restricted user";
		
		data[1][0] = "restricteduser@qa.com";
		data[1][1] = "3456789";
		data[1][2] = "Non Restricted user";
		
		return data;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
