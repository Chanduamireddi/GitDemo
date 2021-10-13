package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.Loginpage;
import resources.Base;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinition extends Base {

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	
    	driver = initializeDriver();
    }

    
    @When("^User login with (.+) and (.+)$")
    public void user_login_with_and(String username, String password) throws Throwable {
        
		Loginpage lop = new Loginpage(driver);
		
		lop.enterUsername().sendKeys(username);
		
		lop.enterPassword().sendKeys(password);
				
		lop.clickLogin().click();
		
    }

    @Then("^User lands on landing page$")
    public void user_lands_on_landing_page() throws Throwable {
    	
    	System.out.println("User landed on landing page");
	System.out.println("User landed on landing page2");
        
    }

    @And("^Navigate to \"([^\"]*)\"$")
    public void navigate_to_something(String strArg1) throws Throwable {
       
    	driver.get(strArg1);
    	
    }

    @And("^Click on login link on home page and navigate to login page$")
    public void click_on_login_link_on_home_page_and_navigate_to_login_page() throws Throwable {
        
		LandingPage lp = new LandingPage(driver);
		
		lp.clicksignIn().click(); 
    	
    }
    
    @And("^Close the Browser$")
    public void close_the_browser() throws Throwable {
        
    	driver.quit();
    }

}
