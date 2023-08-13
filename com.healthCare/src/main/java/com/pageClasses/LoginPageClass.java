package com.pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GeneralUtilities;

public class LoginPageClass 
{
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	
	public LoginPageClass(WebDriver driver)//this driver is the testclass driver
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath = "//li[text()='Registration Desk']")
	WebElement registrationDesk;
	
	@FindBy(id = "loginButton")
	WebElement login;
	
	@FindBy(id = "error-message")
	WebElement errorMsg;
	
	//write actions
	//Action method for login
	public void loginAsRegistrationDesk(String uname,String pass)
	{
		//four test steps
		gl.typeToanElement(userName, uname);
		gl.typeToanElement(password, pass);
		gl.clickOnElement(registrationDesk);
		gl.clickOnElement(login); 
	}
	
	public String getErrorMessage()
	{
		return gl.getTextOfAnElement(errorMsg);
	}
	
	public String getUrlOfLoginPage()
	{
		return gl.getPageCurrentUrl(driver);
	}
	
   
}
