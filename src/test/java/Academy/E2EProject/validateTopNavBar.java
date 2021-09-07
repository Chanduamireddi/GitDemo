package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base; 

public class validateTopNavBar extends Base{
	
	public WebDriver driver;
	
	private static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initializeBrowser() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url")); 
	}
	
	@Test
	public void valTopNavBar() throws IOException, InterruptedException
	{		
		LandingPage lp = new LandingPage(driver);
		
		lp.getNavBar().isDisplayed();
		
		Assert.assertTrue(lp.getNavBar().isDisplayed()); 
		
		log.info("Navigation bar is displayed");
		
	}
	
	
	@AfterTest
	public void teardown() {
		driver.quit(); 
	}
}
