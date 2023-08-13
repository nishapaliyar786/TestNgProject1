package com.pageClasses;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GeneralUtilities;

public class HomePageClass {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	
	public HomePageClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h4[contains(text(),'Logged in as Super User')]   ")
	WebElement welcomeMessage;
	
	@FindBy(xpath = "//a[@class='btn btn-default btn-lg button app big align-self-center']")
	List<WebElement> allFiles;
	
	@FindBy(xpath = "//a[@href='/openmrs/coreapps/activeVisits.page?app=coreapps.activeVisits']")
	WebElement activeVisits;
	
	@FindBy(xpath = "//div[@class='logo']")
	WebElement logo;
	
	@FindBy(id = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
	WebElement findPatientRecord;
	
//	@FindBy(id = "referenceapplication-vitals-referenceapplication-vitals-extension")
//	WebElement captureVitals;
	
	//Action Methods
	public String getTextofWelcomeMessage()
	{
	  return gl.getTextOfAnElement(welcomeMessage);
	}
	
	public Boolean isAllTileDisplayed()
	{
		for (WebElement webElement : allFiles) {
			 gl.isDisplayedElement(webElement);
			 return true;
		}
		return false;
		
	}
	
	@FindBy(xpath = "//a[contains(@id,'referenceapplication-registrationapp-registerPatient-homepageL')]")
	WebElement registerAPatient;
	
	public void clickOnRegisterAPatient()
	{
		gl.clickOnElement(registerAPatient);
	}
	
	public void clickOnActiveVisits()
	{
		gl.clickOnElement(activeVisits);
	}
	
//	public void clickOnCaptureVitals()
//	{
//		gl.clickOnElement(captureVitals);
//	}
	
	public Boolean isLogoDisplayed()
	{
		return gl.isDisplayedElement(logo);
	}
	
	public void clickFindPatientRecord()
	{
		gl.clickOnElement(findPatientRecord);
	}

}
