package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signIn  = By.xpath("//*[@class='pull-right']/ul/li[4]/a");
	By secTitle = By.xpath("//*[@class='text-center']/h2");
	By navBar = By.xpath("//*[@class='nav navbar-nav navbar-right']");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
	}



	public WebElement clicksignIn() {
		// TODO Auto-generated method stub
		return driver.findElement(signIn);
	}
	
	
	public WebElement getTitle() {
		// TODO Auto-generated method stub
		return driver.findElement(secTitle);
	}
	
	public WebElement getNavBar() {
		// TODO Auto-generated method stub
		return driver.findElement(navBar);
	}
	

}
