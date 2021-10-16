package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\eclipseworkspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
	    prop.load(fis);
	    String browserName = prop.getProperty("browser");
	    System.out.println(browserName);
	    if(browserName.equalsIgnoreCase("Chrome"))
	    {
	    	System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    }
	    
	    if(browserName.equalsIgnoreCase("firefox"))
	    {
	        System.setProperty("webdriver.gecko.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
	        driver = new FirefoxDriver();
	    }
	    
	    if(browserName.equalsIgnoreCase("IE"))
	    {
	    	System.setProperty("webdriver.ie.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
	    	driver=new InternetExplorerDriver();
	    }
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    return driver;
	    
	    
	}
	
	public void getScreenShotPath(String testCaseName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		
	}
}
