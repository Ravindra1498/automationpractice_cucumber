package com.AutomationPractice.automation.pagepbjects;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SocialMediaObjects {
	
	private static final Logger logger = LogManager.getLogger(SocialMediaObjects.class);
	WebDriver driver;
	
	private By FacbookIconLink = By.xpath("//li[@class='facebook']");
	private By TiwtterIconLink = By.xpath("//li[@class='twitter']");
	private By YoutubeIconLink = By.xpath("//li[@class='youtube']");
	
	private By FacebookAccountName = By.xpath("//h2//span[text()='Selenium Framework']");
	private By TiwtterAccountName = By.xpath("(//span[text()='Selenium Framework'])[2]");
	private By YoutubeAccountName = By.xpath("//div[@id='text-container']/yt-formatted-string[@id='text' and text()='Selenium Framework']");
	
	
	
	public SocialMediaObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void ClickOnFacebookIconLink()
	{
		driver.findElement(FacbookIconLink).click();
		logger.info("Click on Facebook Icon Link");
	}
	
	
	public void ClickOnTwitterIconLink()
	{
		driver.findElement(TiwtterIconLink).click();
		logger.info("Click on Tiwtter Icon Link");
	}
	public void ClickOnYoutubeIconLink()
	{
		driver.findElement(YoutubeIconLink).click();
		logger.info("Click on Youtube Icon Link");
	}
	
	public void newTabOpen()
	{
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it =windowHandles.iterator();
		
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		logger.info("Switched to the new window/tab");
		
	}
	public void validateFacebookAccountNameText(String FacebookAccount)
	{
		newTabOpen();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(FacebookAccountName));
		String FacebookExpectedAccountName = driver.findElement(FacebookAccountName).getText();
		System.out.println(FacebookExpectedAccountName);
		Assert.assertEquals("Account name not validate",FacebookExpectedAccountName,FacebookAccount);
		logger.info("Account name Validate Actual Account name is " +FacebookAccount);
		
	}
	public void validateTiwtterAccountNameText(String TiwtterAccount)
	{
		newTabOpen();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(TiwtterAccountName));
		String TiwtterExpectedAccountName = driver.findElement(TiwtterAccountName).getText();
		Assert.assertEquals("Account name not validate",TiwtterExpectedAccountName,TiwtterAccount);
		logger.info("Account name Validate Actual Account name is " +TiwtterAccount);
	}
	public void validateYoutubeAccountNameText(String YoutubeAccount)
	{
		newTabOpen();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(YoutubeAccountName));
		String YoutubeExpectedAccountName = driver.findElement(YoutubeAccountName).getText();
		Assert.assertEquals("Account name not validate",YoutubeExpectedAccountName,YoutubeAccount);
		logger.info("Account name Validate Actual Account name is " +YoutubeAccount);
	}
	


}
