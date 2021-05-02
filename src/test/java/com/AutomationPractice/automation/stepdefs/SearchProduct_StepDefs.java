package com.AutomationPractice.automation.stepdefs;

import java.util.List;
import java.util.Map;

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
import io.cucumber.java.en.When;

public class SearchProduct_StepDefs {
	
	private static final Logger logger = LogManager.getLogger(SearchProduct_StepDefs.class);
	
	WebDriver driver;
	TestContext testContext;
	WebDriverWait wait;
	String url = "http://automationpractice.com/";
	Scenario scn;
	
	CmnPageObject cmnPageObject;
	SearchPageObjects searchPageObjects;
	SocialMediaObjects socialMediaObjects;
	
	
	public SearchProduct_StepDefs(TestContext testContext)
	{
		this.testContext = testContext;
		driver = testContext.getDriver();
		wait = testContext.getWebDriverWait();
		scn  = testContext.getScenario();
		
		cmnPageObject = new CmnPageObject(driver);
		searchPageObjects = new SearchPageObjects(driver);
		socialMediaObjects = new SocialMediaObjects(driver);
	}
	
//	@Given("User navigated to the home page of the application url")
//	public void user_navigated_to_the_home_page_of_the_application_url()
//	{
//		driver.get(url);
//		scn.log("Browser navigated to the URL" + url);
//		
//	}
//	
	@When("User search following products and add into cart")
	public void user_search_following_products_and_add_into_cart(List<Map<String,String>> cartDataTable) throws InterruptedException {
		
		searchPageObjects.productsToAddInCart(cartDataTable);
		searchPageObjects.searchAndAddProduct(cartDataTable, 0);
		
	}
	

}
