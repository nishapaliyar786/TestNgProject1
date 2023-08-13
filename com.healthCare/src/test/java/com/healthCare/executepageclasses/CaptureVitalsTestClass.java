package com.healthCare.executepageclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageClasses.CaptureVitalsPageClass;
import com.pageClasses.HomePageClass;
import com.pageClasses.LoginPageClass;
import com.pageClasses.RegisterAPatientPageClass;

public class CaptureVitalsTestClass extends BaseClass{
	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatientPageClass rp;
	CaptureVitalsPageClass cp;
	
	@Test
	public void verifyThePatientIsInActiveVisitsWhenVisitStarts()
	{
		
	}
  @Test

  public void verifyAllAddVitalDetailsOfRegisteredPatient(String uname,String password) throws IOException {
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
	  
	  cp = new CaptureVitalsPageClass(driver);
	  
	  cp.clickCaptureVitals();
	  
	  cp.typeHeight(rp.readIntegerData(17, 1));
	  
	  rp.clickNextButton();
	  
	  cp.typeWeight(rp.readIntegerData(18, 1));
	  rp.clickNextButton();
	  rp.clickNextButton();
	  
	  cp.typeTemperature(rp.readIntegerData(19, 1));
	  rp.clickNextButton();
	  
	  cp.typePulse(rp.readIntegerData(20, 1));
	  rp.clickNextButton();
	  
	  cp.typeRespiratoryRate(rp.readIntegerData(21, 1));
	  rp.clickNextButton();
	  
	  cp.typeBloodPressure(rp.readIntegerData(22, 1), rp.readIntegerData(23, 1));
	  rp.clickNextButton();
	  
	  cp.typePulseOxiMeter(rp.readIntegerData(24, 1));
	  rp.clickNextButton();
	  
	  cp.clickSubmitButton();
	  
	  cp.clickShowVitalDetails();
	  
	  String actualText = cp.getTextHeight().concat(cp.getWeightText().concat(cp.getTemperatureText().concat(cp.getPulseText().concat(cp.getRepiratoryRateText().concat(cp.getSystolicBloodPressureText().concat(cp.getDiastolicBloodPressureText().concat(cp.getPulseOxiMeterText())))))));
	  String expectedText = rp.readIntegerData(17, 1).concat(rp.readIntegerData(18, 1).concat(rp.readIntegerData(19, 1).concat(rp.readIntegerData(20, 1).concat(rp.readIntegerData(21, 1).concat(rp.readIntegerData(22, 1).concat(rp.readIntegerData(23, 1).concat(rp.readIntegerData(24, 1))))))));
	  
	  Assert.assertEquals(actualText, expectedText);
  }
}
