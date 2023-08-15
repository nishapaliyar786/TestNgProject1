package com.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitClass 
{
	Wait<WebDriver> wait ;
	public void presenceOfElementToBeClickable(WebDriver driver,WebElement element)
	{
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10)) 
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);//only throw exception after completing the 10 second
				  wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void presenceOfElementLocateWaitUsingXpath(WebDriver driver,String xPath)
	{
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10)) 
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);//only throw exception after completing the 10 second
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
	}
	
	public void presenceOfElementLocateWaitUsingId(WebDriver driver,String id)
	{
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10)) 
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);//only throw exception after completing the 10 second
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(id)));
	}
	
	public void presenceOfElementLocateWaitUsingName(WebDriver driver,String name)
	{
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10)) 
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);//only throw exception after completing the 10 second
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(name)));
	}
	
	public void presenceOfElementToBeSelected(WebDriver driver,WebElement element)
	{
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10)) 
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);//only throw exception after completing the 10 second
				  wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
   
}
