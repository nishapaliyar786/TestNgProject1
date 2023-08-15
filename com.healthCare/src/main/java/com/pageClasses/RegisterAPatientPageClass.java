package com.pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ExcelReadClass;
import com.utilities.ExplicitWaitClass;
import com.utilities.GeneralUtilities;

public class RegisterAPatientPageClass {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWaitClass el = new ExplicitWaitClass();
	
	public RegisterAPatientPageClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='givenName']")
	WebElement name;
	
	@FindBy(xpath =  "//input[@name='familyName']")
	WebElement familyName;
	
	@FindBy (id = "next-button")
	WebElement nextButton;
	
	@FindBy(id = "gender-field")
	WebElement gender;
	
	@FindBy(id = "birthdateDay-field")
	WebElement dobDay;
	
	@FindBy(id = "birthdateMonth-field")
	WebElement dobMonth;
	
	@FindBy(id = "birthdateYear-field")
	WebElement dobYear;
	
	@FindBy(id = "address1")
	WebElement address1;
	
	@FindBy (id = "address2")
	WebElement address2;
	
	@FindBy(name ="phoneNumber")
	WebElement phoneNumber;
	
	@FindBy(id="relationship_type")
	WebElement relationshipType;
	
	@FindBy(xpath  = "(//input[@type='text'])[15]")
	WebElement relationPerson;
	
	@FindBy(id = "submit")
	WebElement submit;
	
	@FindBy(xpath = "//*[@class='PersonName-givenName']")
	WebElement displayName;
	
	@FindBy(xpath = "//div[contains(text(),'Delete Patient')]")
	WebElement deletePatient;
	
	@FindBy(xpath = "//input[@id='delete-reason']")
	WebElement reason;
	
	@FindBy(xpath = "(//button[@class='confirm right'])[6]")
	WebElement confirm;
	
	@FindBy(xpath  = "//i[@class='icon-home small']")
	WebElement home;
	
	@FindBy(xpath = "//div[contains(text(),'Start Visit')]")
	WebElement startVisit;
	
	@FindBy(id = "start-visit-with-visittype-confirm")
	WebElement startVistConfirm;
	
	public void enterFullName(String gname, String fname) {
		gl.typeToanElement(name, gname);
		gl.typeToanElement(familyName, fname);
		gl.clickOnElement(nextButton);
	}
	
	public void patientsGender(String gender1)
	{
		gl.selectByVisibleTextDropDownList(gender, gender1);
		gl.clickOnElement(nextButton);
	}
	
	public void birthDate(String day, String month, String year)
	{
		gl.typeToanElement(dobDay, day);
		gl.selectByVisibleTextDropDownList(dobMonth, month);
		gl.typeToanElement(dobYear, year);
		gl.clickOnElement(nextButton);
	}
	
	public void enterAddress(String add1, String add2)
	{
		gl.typeToanElement(address1, add1);
		gl.typeToanElement(address2, add2);
		gl.clickOnElement(nextButton);
	}
	
	public void phoneNumber(String pNumber)
	{
		gl.typeToanElement(phoneNumber, pNumber);
		gl.clickOnElement(nextButton);
	}
	
	public void relationShipType(String relation,String relPerson)
	{
		gl.selectByValueDropDownList(relationshipType, relation);
		gl.typeToanElement(relationPerson, relPerson);
		gl.clickOnElement(nextButton);
	}
	
	public void submitRegistration()
	{
		gl.clickOnElement(submit);
	}
	
	public String personNameText()
	{
		return gl.getTextOfAnElement(displayName);
	}
	
	public String readStringData(int a, int b) throws IOException
	{
		return ExcelReadClass.getStringData(a, b);
	}
	
	public String readIntegerData(int a, int b) throws IOException
	{
		return ExcelReadClass.getIntergerData(a, b);
	}
	
	public void clickOnDeletePatient()
	{
		gl.clickOnElement(deletePatient);
	}
	
	public void deleteReason(String rea)
	{
		gl.typeToanElement(reason, rea);
		gl.clickOnElement(confirm);
	}
	
	public void clickHomeButton()
	{
		el.presenceOfElementToBeClickable(driver, home);
		gl.clickUsingJS(driver, home);
	}
	
	public void clickStartVisit()
	{
		el.presenceOfElementToBeSelected(driver, startVisit);
		gl.clickOnElement(startVisit);
	}
	
	public void clickStartVisitConfirm()
	{
		gl.clickOnElement(startVistConfirm);
	}
	
	public void clickNextButton()
	{
		gl.clickOnElement(nextButton);
	}

}
