package com.healthCare.executepageclasses;

import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageClasses.ActiveVisitPageClass;
import com.pageClasses.FindAPatientPageClass;
import com.pageClasses.HomePageClass;
import com.pageClasses.LoginPageClass;
import com.pageClasses.RegisterAPatientPageClass;

public class ActiveVisitTestClass extends BaseClass{
	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatientPageClass rp;
	FindAPatientPageClass fp;
	ActiveVisitPageClass ap;
  @Test(dataProviderClass = DataProviderClass1.class,dataProvider = "login")
  public void verifyThePatientIsNotDisplayedInActiveVisitsWhenVisitNotStarted(String uname, String password) throws IOException {
	  lp = new LoginPageClass(driver);
	  lp.loginAsRegistrationDesk(uname, password);
	  hp = new HomePageClass(driver);
	  hp.clickOnRegisterAPatient();
	  
	  rp = new RegisterAPatientPageClass(driver);
	  String gName=rp.readStringData(5, 3);
	  String fName = rp.readStringData(6, 3);
      rp.enterFullName(gName,fName );
	  
	  rp.patientsGender(rp.readStringData(7, 1));
	  
	  rp.birthDate(rp.readIntegerData(8, 1), rp.readStringData(9, 1), rp.readIntegerData(10, 1));
	  
	  rp.enterAddress(rp.readStringData(11, 1), rp.readStringData(12, 1));
	  
	  rp.phoneNumber(rp.readIntegerData(13, 1));
	  
	  rp.relationShipType(rp.readStringData(14, 1), rp.readStringData(15, 1));
	  rp.submitRegistration();
	  
	  rp.clickHomeButton();
	  hp.clickOnActiveVisits();
	  
	  ap = new ActiveVisitPageClass(driver);
	  Boolean actualOutcome = ap.isPatientNameIsDisplayed(gName.concat(fName));
	  assertFalse(actualOutcome);
  }
  @Test(dataProviderClass = DataProviderClass1.class,dataProvider = "login")
	public void verifyThePatientIsInActiveVisitsWhenVisitStarts(String uname, String password) throws IOException
	{
	  lp = new LoginPageClass(driver);
	  lp.loginAsRegistrationDesk(uname, password);
	  hp = new HomePageClass(driver);
	  hp.clickOnRegisterAPatient();
	  
	  rp = new RegisterAPatientPageClass(driver);
	  String gName=rp.readStringData(5, 3);
	  String fName = rp.readStringData(6, 3);
      rp.enterFullName(gName,fName );
	  
	  rp.patientsGender(rp.readStringData(7, 1));
	  
	  rp.birthDate(rp.readIntegerData(8, 1), rp.readStringData(9, 1), rp.readIntegerData(10, 1));
	  
	  rp.enterAddress(rp.readStringData(11, 1), rp.readStringData(12, 1));
	  
	  rp.phoneNumber(rp.readIntegerData(13, 1));
	  
	  rp.relationShipType(rp.readStringData(14, 1), rp.readStringData(15, 1));
	  rp.submitRegistration();
	  
	  rp.clickStartVisit();
	  rp.clickStartVisitConfirm();
	  
	  ap = new ActiveVisitPageClass(driver);
	  rp.clickHomeButton();
	  rp.clickHomeButton();
	  hp.clickOnActiveVisits();
	  Boolean result = ap.isPatientNameIsDisplayed(fName.concat(gName));
	  Assert.assertTrue(result);
	  
	  
		
	}
}
