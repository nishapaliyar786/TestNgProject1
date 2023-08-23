package com.healthCare.executepageclasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.utilities.ScreenshotClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;
	ScreenshotClass sc;

	public static Properties property;// Property is a class

	public static void readProperty() throws IOException {
		property = new Properties();
		FileInputStream f = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");// set property file path
		property.load(f);// load file

	}

	@Parameters("browser")
	@BeforeMethod(groups = {"launch"})
	public void beforeMethod(String browserValue) throws IOException {
		readProperty();
		if (browserValue.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browserValue.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod(groups = {"close"})
	public void afterMethod(ITestResult itr) throws IOException {

		if (itr.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenshotClass();
			sc.takeScreenshot(driver, itr.getName());
		}

		driver.quit();
	}
	
	@BeforeSuite(alwaysRun = true)//always run this code if test is fail or pass.
	//method for create report
	public void createExtendReport(final ITestContext testContext)
	{
	   extendReport.ExtentManager.createInstance().createTest(testContext.getName(),"message");	
	}

}
