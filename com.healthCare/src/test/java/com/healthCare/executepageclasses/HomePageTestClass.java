package com.healthCare.executepageclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageClasses.HomePageClass;
import com.pageClasses.LoginPageClass;

public class HomePageTestClass extends BaseClass{
	
	LoginPageClass lp;
	HomePageClass hp;
	
  @Test(dataProviderClass = DataProviderClass1.class,dataProvider = "login")
  public void verifyAllTilesAreDisplayedInHomePage(String uname, String password) {
	  lp = new LoginPageClass(driver);
	  lp.loginAsRegistrationDesk(uname, password);
	  hp = new HomePageClass(driver);
	  
	  Boolean actualResult = hp.isAllTileDisplayed();
	  Assert.assertTrue(actualResult);	  
  }
  
  @Test(dataProviderClass = DataProviderClass1.class,dataProvider = "login")
	public void verifyTheLogoIsDisplayedOrNotInHomePage (String uname,String password) 
	{
		  lp = new LoginPageClass(driver);
		  lp.loginAsRegistrationDesk(uname, password);
		  hp = new HomePageClass(driver);
		  
		  Boolean actualResult = hp.isLogoDisplayed();
		  Assert.assertTrue(actualResult);
	}
}
