package com.healthCare.executepageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageClasses.HomePageClass;
import com.pageClasses.LoginPageClass;



public class LoginPageTestClass extends BaseClass{
	
	LoginPageClass lp;
	HomePageClass hp;
	
  @Test(dataProviderClass = DataProviderClass1.class,dataProvider = "login")
  public void verifySuccessfulLogin(String uname, String password) {
	  lp = new LoginPageClass(driver);
	  lp.loginAsRegistrationDesk(uname,password);
	  
	  hp = new HomePageClass(driver);
	  String actualResult = hp.getTextofWelcomeMessage();
	  String expectedResult = "Logged in as Super User (admin) at Registration Desk.";
	  Assert.assertEquals(actualResult, expectedResult,"actual and exxpected are not same");
  }
  
  @Test(dataProviderClass = DataProviderClass1.class,dataProvider = "dp")
  public void verifyUnsuccessfulLogin(String uname,String password1)
  {
	  lp = new LoginPageClass(driver);
	  lp.loginAsRegistrationDesk(uname, password1);

	  String actualResult = lp.getErrorMessage();
	  String expectedResult = "Invalid username/password. Please try again.";
	  Assert.assertEquals(actualResult, expectedResult);
  }
  
  @Test
	public void verifyTheCorrectSiteIsLoadedWhileHittingTheURL()
	{
		lp = new LoginPageClass(driver);
		String actualResult = lp.getUrlOfLoginPage();
		String expectedResult = "https://demo.openmrs.org/openmrs/login.htm";
		
		Assert.assertEquals(actualResult, expectedResult);
	}
}
