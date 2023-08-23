package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotClass {
	
	public void takeScreenshot(WebDriver driver,String name) throws IOException//name is the name of each testcase
	{
		TakesScreenshot ts = (TakesScreenshot)driver;//capture screenshot
		File screenshotFile = ts.getScreenshotAs(OutputType.FILE);//capture screenshot
		
		String dest = System.getProperty("user.dir") + "//Test_Evidence";//create Test_Evidence is the folder in project
		File f1 = new File(dest);
		if (!f1.exists()) {
			f1.mkdirs();//create file 
		}
		
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//for time and date in file
		
		String destinationPath = System.getProperty("user.dir") + "//Test_Evidence//" + name + timeStamp + ".png";
		File finalDestination = new File(destinationPath);//set destinationPath as file
		FileHandler.copy(screenshotFile, finalDestination);//copy screenshot to a file
	}

}

