package com.healthCare.executepageclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageClasses.FindAPatientPageClass;
import com.pageClasses.HomePageClass;
import com.pageClasses.LoginPageClass;
import com.pageClasses.RegisterAPatientPageClass;

public class FindAPatientPageTestClass extends BaseClass{

	LoginPageClass lp;
	HomePageClass hp;
	FindAPatientPageClass fp;
	RegisterAPatientPageClass rp;
	 
	@Test(dataProviderClass = DataProviderClass1.class,dataProvider = "login")
	public void verifyTheRegisteredPatientIsFoundOrNotInPatientRecordTable(String uname, String password) throws IOException
	{
		lp = new LoginPageClass(driver);
		  lp.loginAsRegistrationDesk(uname, password);
		  hp = new HomePageClass(driver);
		  
		  hp.clickFindPatientRecord();
		  rp = new RegisterAPatientPageClass(driver);
		  
		  String gName=rp.readStringData(5, 2);
		  String fName = rp.readStringData(6, 2);
		  fp = new FindAPatientPageClass(driver);
		  Boolean actualResult = fp.isPatientNameIsDisplayed(gName.concat(fName));
		  Assert.assertFalse(actualResult);
		  
		  
	}
}
