package com.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitClass {
	
	public WebDriverWait wait;
	
	public void presenceOfElementLocatedWaitUsingXpath(WebDriver driver,String xPath)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
	}
	
	public void presenceOfElementLocatedWaitUsingId(WebDriver driver,String id)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	}
	
	public void presenceOfElementLocatedWaitUsingName(WebDriver driver,String name)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
	}
	
	public void presenceOfElementToBeClickable(WebDriver driver,WebElement element)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void presenceOfElementToBeSelected(WebDriver driver,WebElement element)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void presenceOfVisibilityOf(WebDriver driver,WebElement element)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void presenceOfElementAlertPresent(WebDriver driver,WebElement element)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void presenceOfElementToVisibilityOfElementLocatedId(WebDriver driver,String id)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	
	public void presenceOfElementToVisibilityOfElementLocatedXpath(WebDriver driver,String xpath)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	public void presenceOfElementToVisibilityOfElementLocated(WebDriver driver,String name)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
	}





}
