package com.healthCare.executepageclasses;

import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageClasses.FindAPatientPageClass;
import com.pageClasses.HomePageClass;
import com.pageClasses.LoginPageClass;
import com.pageClasses.RegisterAPatientPageClass;

public class RegisterAPatientTestClass extends BaseClass{
	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatientPageClass rp;
	FindAPatientPageClass fp;
  @Test(dataProviderClass = DataProviderClass1.class,dataProvider = "login")
  public void verifyToRegisterAPatient(String uname, String password) throws IOException {
	  lp = new LoginPageClass(driver);
	  lp.loginAsRegistrationDesk(uname, password);
	  hp = new HomePageClass(driver);
	  hp.clickOnRegisterAPatient();
	  
	  rp = new RegisterAPatientPageClass(driver);
      rp.enterFullName(rp.readStringData(5, 2), rp.readStringData(6, 2));
	  
	  rp.patientsGender(rp.readStringData(7, 1));
	  
	  rp.birthDate(rp.readIntegerData(8, 1), rp.readStringData(9, 1), rp.readIntegerData(10, 1));
	  
	  rp.enterAddress(rp.readStringData(11, 1), rp.readStringData(12, 1));
	  
	  rp.phoneNumber(rp.readIntegerData(13, 1));
	  
	  rp.relationShipType(rp.readStringData(14, 1), rp.readStringData(15, 1));
	  rp.submitRegistration();
	  
	  String actualResult = rp.personNameText();
	  String expectedResult = rp.readStringData(5, 2);
	  Assert.assertEquals(actualResult, expectedResult);
	  
  } 
  
  @Test(dataProviderClass = DataProviderClass1.class,dataProvider = "login")
  public void verifyToDeleteAPatient(String uname, String password) throws IOException {
	  lp = new LoginPageClass(driver);
	  lp.loginAsRegistrationDesk(uname, password);
	  hp = new HomePageClass(driver);
	  hp.clickOnRegisterAPatient();
	  
	  rp = new RegisterAPatientPageClass(driver);
	  String gName=rp.readStringData(5, 1);
	  String fName = rp.readStringData(6, 1);
      rp.enterFullName(gName,fName );
	  
	  rp.patientsGender(rp.readStringData(7, 1));
	  
	  rp.birthDate(rp.readIntegerData(8, 1), rp.readStringData(9, 1), rp.readIntegerData(10, 1));
	  
	  rp.enterAddress(rp.readStringData(11, 1), rp.readStringData(12, 1));
	  
	  rp.phoneNumber(rp.readIntegerData(13, 1));
	  
	  rp.relationShipType(rp.readStringData(14, 1), rp.readStringData(15, 1));
	  rp.submitRegistration();
	  
	  rp.clickOnDeletePatient();
	  rp.deleteReason("No");
	  
	  fp = new FindAPatientPageClass(driver);
	   Boolean actualResult =  fp.isPatientNameIsDisplayed(gName.concat(fName));
	   assertFalse(actualResult);

  }
  
}
