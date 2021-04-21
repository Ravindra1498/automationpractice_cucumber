package com.AutomationPractice.automation.stepdefs;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AutomationPractice.automation.context.TestContext;
import com.AutomationPractice.automation.pagepbjects.CmnPageObject;
import com.AutomationPractice.automation.pagepbjects.SearchPageObjects;
import com.AutomationPractice.automation.pagepbjects.SocialMediaObjects;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class StepDefs_Hooks {

	private static final Logger logger = LogManager.getLogger(Thread.getAllStackTraces().getClass().getName());
	TestContext testContext;
	Scenario scn;
	int implicitWait_timeout_in_sec = 20;
	int pageLoad_timeout_in_sec = 20;
	int setScript_timeout_in_sec = 20;
	int webDriver_wait_timeout_sec = 20;
	
	//Declaration
		CmnPageObject cmnPageObject;
		SearchPageObjects searchPageObjects;
		SocialMediaObjects socialMediaObjects;
	
	
	public StepDefs_Hooks(TestContext testContext)
	{
		this.testContext = testContext;
	}
	
	@Before
	public void setup(Scenario scn)
	{
		this.scn = scn;
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicitWait_timeout_in_sec, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageLoad_timeout_in_sec, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(setScript_timeout_in_sec, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, webDriver_wait_timeout_sec);
		
		testContext.setDriver(driver);
		testContext.setWebDriverWait(wait);
		testContext.setScenario(scn);
		scn.log("Browser Invoked");
		logger.info("Browser Invoked");
		
		cmnPageObject = new CmnPageObject(driver);
		searchPageObjects = new SearchPageObjects(driver);
		socialMediaObjects = new SocialMediaObjects(driver);
		
		
	}
	
	@After(order=1)
	public void cleanUp()
	{
		testContext.getDriver().quit();
		scn.log("Browser Closed");
		logger.info("Browser closed");
	}
	
	@After(order=2)
	public void takeScreenShot(Scenario s)
	{
		if(s.isFailed())
		{
			TakesScreenshot scrnShot = (TakesScreenshot)testContext.getDriver();
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.log("Step is failed");
			scn.attach(data, "image/png", "Failed Step Name: " + s.getName());
		}
		else
		{
			scn.log("Test case is passed, no screen shot captured");
		}
	}
}
