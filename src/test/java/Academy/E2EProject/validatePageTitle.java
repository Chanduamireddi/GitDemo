package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import resources.Base;

public class validatePageTitle extends Base{
	
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	public WebDriver driver;
	
	@BeforeTest
	public void initializeBrowser() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is Initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page Successfully"); 
	}

	
	@Test
	public void valSectitle() throws IOException, InterruptedException
	{
		
		LandingPage lp = new LandingPage(driver);
		
		String setitle = lp.getTitle().getText();
		
		Assert.assertEquals(setitle, "FEATURED COURSES");
		
		log.info("Successfully Title validated");
			
		//driver.quit();
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
