package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {
	
	public WebDriver driver;
	
	By username  = By.xpath("//*[@id='user_email']");
	By password = By.xpath("//*[@id='user_password']");
	By login = By.xpath("//*[@value='Log In']");
	
	
	
	public Loginpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
	}



	public WebElement enterUsername() {
		// TODO Auto-generated method stub
		return driver.findElement(username);
	}
	
	public WebElement enterPassword() {
		// TODO Auto-generated method stub
		return driver.findElement(password);
	}
	
	public WebElement clickLogin() {
		// TODO Auto-generated method stub
		return driver.findElement(login);
	}
	
	

}
