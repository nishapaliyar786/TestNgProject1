package com.pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GeneralUtilities;

public class FindAPatientPageClass {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	
	public FindAPatientPageClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath  = "//table[@id='patient-search-results-table']//tr")
	List<WebElement> row;
	
	@FindBy(xpath  = "//table[@id='patient-search-results-table']//th")
	List<WebElement> col;
	
	public Boolean isPatientNameIsDisplayed(String name)
	{
		int rowCount = row.size();   
		int colCount = col.size();	
		System.out.println(rowCount+"  "+colCount);   
		
		boolean flag = false;  
		
		for(int row = 1;row<rowCount;row++) {
			for(int col = 1;col<colCount;col++) {
				
				String actValue = driver.findElement(By.xpath("//table[@id='patient-search-results-table']//tr["+row+"]//td["+col+"]")).getText();
				if (actValue.equalsIgnoreCase(name)) {
					
					flag = true;  
					System.out.println(row+" : "+col); 
					break;
					
				}
			}
		}
		if (flag) {  
			return true;
		}
		return flag;
		
	
	}
}
