package com.AutomationPractice.automation.stepdefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AutomationPractice.automation.context.TestContext;
import com.AutomationPractice.automation.pagepbjects.CmnPageObject;
import com.AutomationPractice.automation.pagepbjects.SearchPageObjects;
import com.AutomationPractice.automation.pagepbjects.SocialMediaObjects;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HealthCheck_StepDefs {
	
	private static final Logger logger = LogManager.getLogger(HealthCheck_StepDefs.class);
	
	WebDriver driver;
	TestContext testContext;
	WebDriverWait wait;
	String url = "http://automationpractice.com/";
	Scenario scn;
	
	//Declaration
		CmnPageObject cmnPageObject;
		SearchPageObjects searchPageObjects;
		SocialMediaObjects socialMediaObjects;
		
		public HealthCheck_StepDefs(TestContext testContext){
			this.testContext = testContext;
			driver = testContext.getDriver();
			wait = testContext.getWebDriverWait();
			scn = testContext.getScenario();
			
			cmnPageObject = new CmnPageObject(driver);
			searchPageObjects = new SearchPageObjects(driver);
			socialMediaObjects = new SocialMediaObjects(driver);
		}
		
//		@Given("User navigated to the home page of the application url")
//		public void user_navigated_to_the_home_page_of_the_application_url()
//		{
//			driver.get(url);
//			scn.log("Browser navigated to the URL" + url);
//			
//		}
		
		@Then("Match the url")
		public void match_the_url()
		{
			String expectedUrl = "http://automationpractice.com/index.php";
			Assert.assertEquals("not match url",expectedUrl,driver.getCurrentUrl());
			logger.info("Page url Matech" + expectedUrl);
		}
		
		
		@Then("Application title is {string}")
		public void application_title_is(String expectedTitle) {
		   
			String expected = "My Store";
			cmnPageObject.validatePageTitleMatch(expected);
			logger.info("Title is Validate Successfully");
			
		}



		
		@When("Search box is displayed")
		public void search_box_is_displayed() {
		    cmnPageObject.searchBoxIsDisplayed();
		}
		
		@And("User search for {string}")
		public void user_search_for(String text) {
		    
			cmnPageObject.SearchTextBox(text);
		}
		
		@Then("Search box shows result containing {string}  product is {int}")
		public void search_box_shows_result_containing_as_product_is(String text, int ContainDressProduct) {
		    
			searchPageObjects.searchProductResult(text, ContainDressProduct);
		}

		
}
