package com.AutomationPractice.automation.context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class TestContext {
	
	WebDriver driver;
	WebDriverWait wait;
	Scenario scn;
	
	public Scenario getScenario()
	{
		return scn;
	}
	
	public void setScenario(Scenario scn)
	{
		this.scn = scn;
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	public void setDriver(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebDriverWait getWebDriverWait()
	{
		return wait;
	}
	public void setWebDriverWait(WebDriverWait wait)
	{
		this.wait = wait;
	}
	

}
