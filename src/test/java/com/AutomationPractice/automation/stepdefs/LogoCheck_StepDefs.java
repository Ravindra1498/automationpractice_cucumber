package com.AutomationPractice.automation.stepdefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AutomationPractice.automation.context.TestContext;
import com.AutomationPractice.automation.pagepbjects.CmnPageObject;
import com.AutomationPractice.automation.pagepbjects.SearchPageObjects;
import com.AutomationPractice.automation.pagepbjects.SocialMediaObjects;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoCheck_StepDefs {
	
	private static final Logger logger = LogManager.getLogger(LogoCheck_StepDefs.class);

	WebDriver driver;
	TestContext testContext;
	WebDriverWait wait;
	String url = "http://automationpractice.com/";
	Scenario scn;
	
	//Declaration
		CmnPageObject cmnPageObject;
		SearchPageObjects searchPageObjects;
		SocialMediaObjects socialMediaObjects;
		
	
	
	public LogoCheck_StepDefs(TestContext testContext){
		this.testContext = testContext;
		driver = testContext.getDriver();
		wait = testContext.getWebDriverWait();
		scn = testContext.getScenario();
		
		cmnPageObject = new CmnPageObject(driver);
	}
	

//	@Given("User navigated to the home page of the application url")
//	public void user_navigated_to_the_home_page_of_the_application_url()
//	{
//		driver.get(url);
//		scn.log("Browser navigated to the URL" + url);
//		
//	}

	@Then("Application logo is displayed")
	public void Application_logo_is_displayed()
	{
		cmnPageObject.validateLogo();
		logger.info("Logo Is displayed Successfully");
	}
	
	@When("User is on application landing page")
	public void user_is_on_application_landing_page() {
	    
	}
	
	@Then("Application logo height is {string}")
	public void application_logo_height_is(String ActualHeight) {
	   cmnPageObject.validateLogoHeight(ActualHeight);
	   logger.info("Logo Height match Actual Height is : "+ ActualHeight);
	   
	}
	@Then("Application logo width is {string}")
	public void application_logo_width_is(String ActualWidth) {
	   cmnPageObject.validateLogoWidth(ActualWidth);
	   logger.info("Logo Width match Actual Height is : "+ ActualWidth);
	   
	}
}
