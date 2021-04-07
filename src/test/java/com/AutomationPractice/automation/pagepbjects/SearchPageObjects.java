package com.AutomationPractice.automation.pagepbjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class SearchPageObjects {
	
	 private static final Logger logger = LogManager.getLogger(SearchPageObjects.class);
	 WebDriver driver;
	 
	 private By SearchProductList = By.xpath("//div[@class='ac_results']/ul/li");
	 
	 public SearchPageObjects(WebDriver driver)
	 {
		 this.driver = driver;
	 }
	 
	 public void searchProductResult(String text, int ContainDressProduct)
	 {
		 int TotalProductContainDress = 0;
		 List<WebElement> ListOfProduct = driver.findElements(SearchProductList);
		 WebDriverWait webDriverWait = new WebDriverWait(driver,20);
		 webDriverWait.until(ExpectedConditions.visibilityOfAllElements(ListOfProduct));
		 logger.info("Number of product search :" + ListOfProduct.size());
		 
		 for(int i=0; i<ListOfProduct.size(); i++)
		 {
			 if(ListOfProduct.get(i).getText().contains(text))
			 {
				 logger.info("Total Product contains Dress :" + ListOfProduct.get(i).getText());
				TotalProductContainDress++;
			 }
			 
		 }
		 logger.info("Total Product contains Dress count:"+ TotalProductContainDress);
		 Assert.assertEquals("Product Count not match",ContainDressProduct,TotalProductContainDress);
		 
	 }
	 
	 
}
