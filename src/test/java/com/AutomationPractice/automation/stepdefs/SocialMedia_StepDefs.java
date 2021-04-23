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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SocialMedia_StepDefs {
	
	private static final Logger logger = LogManager.getLogger(SocialMedia_StepDefs.class);
	
	WebDriver driver;
	TestContext testContext;
	WebDriverWait wait;
	String url = "http://automationpractice.com/";
	Scenario scn;
	
	//Declaration
	CmnPageObject cmnPageObject;
	SearchPageObjects searchPageObjects;
	SocialMediaObjects socialMediaObjects;

	public SocialMedia_StepDefs(TestContext testContext)
	{
		this.testContext = testContext;
		driver= testContext.getDriver();
		wait = testContext.getWebDriverWait();
		scn = testContext.getScenario();
		
		cmnPageObject = new CmnPageObject(driver);
		searchPageObjects = new SearchPageObjects(driver);
		socialMediaObjects = new SocialMediaObjects(driver);
		
	}
	
	@When("User clicks on  facebook link  of the bottom landing page and open new tab")
	public void user_clicks_on_facebook_link_of_the_bottom_landing_page_and_open_new_tab() {
	    
		socialMediaObjects.ClickOnFacebookIconLink();
	}
	
	@Then("User able to see facebook group with name {string}")
	public void user_able_to_see_facebook_group_with_name(String FacebookAccount) {
	   
		socialMediaObjects.validateTiwtterAccountNameText(FacebookAccount);
	}
	
	@When("User clicks on  twitter link  of the bottom landing page and open new tab")
	public void user_clicks_on_twitter_link_of_the_bottom_landing_page_and_open_new_tab() {
	    
		socialMediaObjects.ClickOnTwitterIconLink();
	}

	@Then("User able to see twitter group with name {string}")
	public void user_able_to_see_twitter_group_with_name(String TiwtteeAccount) {
	   
		socialMediaObjects.validateTiwtterAccountNameText(TiwtteeAccount);
	}
	
	@When("User clicks on  Youtube link  of the bottom landing page and open new tab")
	public void user_clicks_on_youtube_link_of_the_bottom_landing_page_and_open_new_tab() {
	    
		socialMediaObjects.ClickOnYoutubeIconLink();
	}
	@Then("User able to see Youtube group with name {string}")
	public void user_able_to_see_youtube_group_with_name(String YoutubeAccount) {
	    
		socialMediaObjects.validateYoutubeAccountNameText(YoutubeAccount);
		
	}
}
