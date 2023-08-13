package com.pageClasses;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GeneralUtilities;

public class CaptureVitalsPageClass {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	
	public CaptureVitalsPageClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@id,'referenceapplication.realTime.vitals')]")
	WebElement captureVitals;
	
	@FindBy(xpath = "//input[@id='w8']")
	WebElement height;
	
	@FindBy(xpath = "//input[@id='w10']")
	WebElement weight;
	
	@FindBy(xpath = "//input[@id='w12']")
	WebElement temperature;
	
	@FindBy(xpath = "//input[@id='w14']")
	WebElement pulse;
	
	@FindBy(xpath = "//input[@id='w16']")
	WebElement respiratoryRate;
	
	@FindBy(xpath = "//input[@id='w18']")
	WebElement bloodPressureHigh;
	
	@FindBy(xpath = "//input[@id='w20']")
	WebElement bloodPressureLow;
	
	@FindBy(xpath = "//input[@id='w22']")
	WebElement pulseOxiMeter;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath = "//span[text()='show details']")
	WebElement showVitalDetails;
	
	@FindBy(xpath = "//*[text()='163.0 cm']")
	WebElement heightText;
	
	@FindBy(xpath = "//*[text()='55.0 kg']")
	WebElement weightText;
	
	@FindBy(xpath = "//*[text()='40.0 DEG C']")
	WebElement temperatureText;
	
	@FindBy(xpath = "//*[text()='40 beats/min']")
	WebElement pulseText;
	
	@FindBy(xpath = "//*[text()='60']")
	WebElement repositoryRateText;
	
	@FindBy(xpath = "//*[text()='170 mmHg']")
	WebElement systolicBloodPressureText;
	
	@FindBy(xpath = "//*[text()='80 mmHg']")
	WebElement diastolicBloodPressureText;
	
	@FindBy(xpath = "//*[text()='70 %']")
	WebElement arterialBloodOxygenText;
	
	
	
	public void clickCaptureVitals()
	{
		gl.clickOnElement(captureVitals);
	}
	
	public void typeHeight(String height1)
	{
		gl.typeToanElement(height, height1);
	}
	
	public void typeWeight(String weight1)
	{
		gl.typeToanElement(weight, weight1);
	}
	
	public void typeTemperature(String temperature1)
	{
		gl.typeToanElement(temperature, temperature1);
	}
	
	public void typePulse(String pulse1)
	{
		gl.typeToanElement(pulse, pulse1);
	}
	
	public void typeRespiratoryRate(String respiratoryRate1)
	{
		gl.typeToanElement(respiratoryRate, respiratoryRate1);
	}
	
	public void typeBloodPressure(String highBloodPressure1, String lowBloodPressure1)
	{
		gl.typeToanElement(bloodPressureHigh, highBloodPressure1);
		gl.typeToanElement(bloodPressureLow, lowBloodPressure1);
	}
	
	public void typePulseOxiMeter(String pulseOximeter1)
	{
		gl.typeToanElement(pulseOxiMeter, pulseOximeter1);
	}
	
	public void clickSubmitButton()
	{
		gl.clickOnElement(submit);
	}
	public void clickShowVitalDetails()
	{
		gl.clickOnElement(showVitalDetails);
	}
	
	public String getTextHeight()
	{
		return gl.getTextOfAnElement(heightText);
	}
	
	public String getWeightText()
	{
		return gl.getTextOfAnElement(weightText);
	}
	
	public String getTemperatureText()
	{
		return gl.getTextOfAnElement(temperatureText);
	}

	public String getPulseText()
	{
		return gl.getTextOfAnElement(pulseText);
	}
	
	public String getRepiratoryRateText()
	{
		return gl.getTextOfAnElement(repositoryRateText);
	}
	
	public String getSystolicBloodPressureText()
	{
		return gl.getTextOfAnElement(systolicBloodPressureText);
	}
	
	public String getDiastolicBloodPressureText()
	{
		return gl.getTextOfAnElement(diastolicBloodPressureText);
	}
	public String getPulseOxiMeterText()
	{
		return gl.getTextOfAnElement(arterialBloodOxygenText);
	}
		
		
	

}
