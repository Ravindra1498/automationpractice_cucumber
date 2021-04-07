package com.AutomationPractice.automation.pagepbjects;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CmnPageObject {
	
	private static final Logger logger = LogManager.getLogger(CmnPageObject.class);
	WebDriver driver;
	
	private By Home_page_log = By.xpath("//img[@class='logo img-responsive']");
	private By search_text_box = By.id("search_query_top");
	
	
	
	public CmnPageObject(WebDriver driver)
	{
		this.driver =driver;
	}
	
	
	public void validatePageTitleMatch(String expectedTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		Boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("Title validation",true,b);
		logger.info("Page title matched: " + expectedTitle);
		
	}
	
	public void validateLogo()
	{
		boolean b = driver.findElement(Home_page_log).isDisplayed();
		Assert.assertEquals("Navigation link logo",true,b);
	}
	
	public void validateLogoHeight(String height)
	{
		String LogoHeight = driver.findElement(Home_page_log).getAttribute("height");
		Assert.assertEquals("Height not match",LogoHeight,height);
		logger.info("Logo Height Match");
		
	}
	public void validateLogoWidth(String width)
	{
		String LogoWidth = driver.findElement(Home_page_log).getAttribute("width");
		Assert.assertEquals("Width not match",LogoWidth,width);
		logger.info("Logo width Match");
		
	}
	
	public void SearchTextBox(String text)
	{
		WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
		WebElement searchBoxElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(search_text_box));
		searchBoxElement.sendKeys(text);
		logger.info("Value entered in search box : " + text);
	}
	
	public void searchBoxIsDisplayed()
	 {
		 boolean searchBox = driver.findElement(search_text_box).isDisplayed();
		 Assert.assertEquals("Search Box Not Display",true,searchBox);
		 logger.info("Search Box is Displayed");
	 }
	
	
	
}
