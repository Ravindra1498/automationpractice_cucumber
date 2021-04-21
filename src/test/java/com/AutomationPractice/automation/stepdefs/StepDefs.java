package com.AutomationPractice.automation.stepdefs;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.AutomationPractice.automation.pagepbjects.CmnPageObject;
import com.AutomationPractice.automation.pagepbjects.SearchPageObjects;
import com.AutomationPractice.automation.pagepbjects.SocialMediaObjects;
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
	SocialMediaObjects socialMediaObjects;
	
	
	
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
		socialMediaObjects = new SocialMediaObjects(driver);
		
	}
	
	@After(order=1)
	public void cleanUp()
	{
		driver.quit();
		scn.log("Browser Closed");
	}
	
	@After(order=2)
	public void takeSceenShot(Scenario s)
	{
		if(scn.isFailed())
		{
			TakesScreenshot srcShot = (TakesScreenshot)driver;
			byte[] data = srcShot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png","Failed Step Name : "+ s.getName());
		}
		else
		{
			scn.log("Test case is passed, no screen shot captured");
		}
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

	@When("User clicks on  facebook link  of the bottom landing page and open new tab")
	public void user_clicks_on_facebook_link_of_the_bottom_landing_page_and_open_new_tab() {
	   
		socialMediaObjects.ClickOnFacebookIconLink();
		socialMediaObjects.newTabOpen();
	}
	@Then("User able to see facebook group with name {string}")
	public void user_able_to_see_facebook_group_with_name(String FacebookAccount) {
	    socialMediaObjects.validateFacebookAccountNameText(FacebookAccount);
	}
	
//	@When("User clicks on  twitter link  of the bottom landing page and open new tab")
//	public void user_clicks_on_twitter_link_of_the_bottom_landing_page_and_open_new_tab() {
//	    
//		socialMediaObjects.ClickOnTwitterIconLink();
//	}
//
//	@Then("User able to see twitter group with name {string}")
//	public void user_able_to_see_twitter_group_with_name(String TiwtteeAccount) {
//	   
//		socialMediaObjects.validateTiwtterAccountNameText(TiwtteeAccount);
//	}
	
//	@When("User clicks on  Youtube link  of the bottom landing page and open new tab")
//	public void user_clicks_on_youtube_link_of_the_bottom_landing_page_and_open_new_tab() {
//	    
//		socialMediaObjects.ClickOnYoutubeIconLink();
//	}
//	@Then("User able to see Youtube group with name {string}")
//	public void user_able_to_see_youtube_group_with_name(String YoutubeAccount) {
//	    
//		socialMediaObjects.validateYoutubeAccountNameText(YoutubeAccount);
//		
//	}

	

	

}
