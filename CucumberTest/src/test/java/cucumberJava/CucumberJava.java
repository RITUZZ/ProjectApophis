package cucumberJava; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When; 

public class CucumberJava { 
   int d = 0; 
	
   @Given("^I have open the browser$") 
   public void openBrowser() { 
      d = 3; 
   } 
	
   @When("^I open Facebook website$") 
   public void goToFacebook() { 
      d += 8; 
   } 
	
   @Then("^Login button should exits$") 
   public void loginButton() { 
      if(d==3) { 
         System.out.println("Test 1 Pass"); 
      } else { 
         System.out.println("Test 1 Fail"); 
      } 
   } 
}