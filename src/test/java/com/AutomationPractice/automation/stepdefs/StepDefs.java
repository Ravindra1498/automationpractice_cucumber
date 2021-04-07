package com.AutomationPractice.automation.stepdefs;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.AutomationPractice.automation.pagepbjects.CmnPageObject;
import com.AutomationPractice.automation.pagepbjects.SearchPageObjects;
import com.AutomationPractice.automation.stepdefs.StepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefs {
	
	private static final Logger logger = LogManager.getLogger(StepDefs.class);
	
	WebDriver driver;
	String url = "http://automationpractice.com";
	int implicit_wait_timeout_in_sec = 20;
	Scenario scn;
	
	//Declaration
	CmnPageObject cmnPageObject;
	SearchPageObjects searchPageObjects;
	
	
	
	@Before
	public void setup(Scenario scn)
	{
		this.scn = scn;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
		logger.info("Browser invoked.");
		
		cmnPageObject = new CmnPageObject(driver);
		searchPageObjects = new SearchPageObjects(driver);
		
	}
	
	@After
	public void cleanUp()
	{
		driver.quit();
		scn.log("Browser Closed");
	}
	
	@Given("User navigated to the home page of the application url")
	public void user_navigated_to_the_home_page_of_the_application_url()
	{
		driver.get(url);
		scn.log("Browser navigated to the URL" + url);
		
	}
	
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
	
	@When("Search box is displayed")
	public void search_box_is_displayed() {
	    cmnPageObject.searchBoxIsDisplayed();
	}
	
	@And("User search for {string}")
	public void user_search_for(String text) {
	    
		cmnPageObject.SearchTextBox(text);
	}
	
	@Then("Search box shows result containing {string} as product is {int}")
	public void search_box_shows_result_containing_as_product_is(String text, int ContainDressProduct) {
	    
		searchPageObjects.searchProductResult(text, ContainDressProduct);
	}

	
	
	

	

}
