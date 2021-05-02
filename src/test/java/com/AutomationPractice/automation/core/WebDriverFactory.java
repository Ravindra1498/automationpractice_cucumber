package com.AutomationPractice.automation.core;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
	private static WebDriver driver=null;
	
	public static WebDriver getWebDriverForBrowser(String browser) throws Exception 
	{
		switch(browser.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();
			logger.info("Chrome Browser invoked");
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			logger.info("Forefox Browser inviked");
			break;
			
		case "headless":
			ChromeOptions option =  new ChromeOptions();
			option.addArguments("headless");
			option.addArguments("window-size=1200x600");
			driver = new ChromeDriver(option);
			logger.info("Headless Chrome Browser invoked");
			break;
		default:
			logger.fatal("No such browser is implemented. browser name sent: "+ browser);
			throw new Exception("No such browser is implemented.Browser name sent: " + browser);
			
		}
		 driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        logger.info("Driver maximized and implicit time out set to 20 seconds");
	        return driver;
	
	}
    public static String getBrowserName(){
        String browserDefault = "chrome"; //Set by default
        String browserSentFromCmd = System.getProperty("browser");

        if (browserSentFromCmd==null){
            return browserDefault;
        }else{
            return browserSentFromCmd;
        }
    }
}
