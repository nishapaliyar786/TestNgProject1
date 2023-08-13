package com.utilities;

import java.sql.Driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	
	//method for click on an element
	public void clickOnElement(WebElement element)
	{
	 element.click();
	}
	
	public void clearElementContent(WebElement element)
	{
		element.clear();
	}
	
	public void typeToanElement(WebElement element, String text)
	{
		element.sendKeys(text);
	}
	
	public String getPageCurrentUrl(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	
	public Boolean isDisplayedElement(WebElement element)
	{
		return element.isDisplayed();
	}
	
	public String getTextOfAnElement(WebElement element)
	{
		return element.getText();
	}
	
	public String getAttributeOfAnElement(WebElement element , String attributeType)
	{
		return element.getAttribute(attributeType);
	}
	
	public void clickUsingJS(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Arguments[0].click;", element);
	}
	
	public void scrollToAnElementUsingJS(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Arguments[0].ScrollIntoView();", element);
	}
	
	public void selectByDropDownUsingIndex(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	//write balance 2 methods
	
	public void AlertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void AlertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void AlertGetText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	
	public void AlertSendKeys(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	public void clickAnElementByUsingSendKeys(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.sendKeys(element,Keys.ENTER).build().perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement element1, WebElement element2) 
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element1, element2).build().perform();
	}
	
	public String getTitleofUrl(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public void selectByVisibleTextDropDownList(WebElement element,String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void selectByValueDropDownList(WebElement element,String text)
	{
		Select select = new Select(element);
		select.selectByValue(text);
	}

}
