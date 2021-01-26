package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.Helper;
import com.learnautomation.utility.Xls_Reader;

public class BaseClass{

	public WebDriver driver;
	public ConfigDataProvider config;
	public Xls_Reader xl;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() {
		
		config = new ConfigDataProvider();
		xl=new Xls_Reader("./TestData/TestData.xlsx");
		
		ExtentHtmlReporter extent  = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ProjectName_"+Helper.getCurrentDataTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("BeforSuite: All declaration run sucessfully", true);
	}
	
	@BeforeClass
	public void startUp() {
		
		Reporter.log("BeforClass: Setup process started ", true);
		String appURL = config.getConfigData("uatURL");
		Reporter.log("BeforClass: Get URL from config file ", true);
		driver = BrowserFactory.OpenURL(driver, "Chrome", appURL);
		Reporter.log("BeforClass: Open Expected browser and ready to execute test cases ", true);
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.CloseURL(driver);
		Reporter.log("AfterClass: All Execuation done scussfuly and Browser closed", true);
	}
	
	@AfterMethod
	public void tearDownMethodSS(ITestResult result) throws IOException {
		
		
		Reporter.log("BeforMethod: ScreenShot will take if TC failed ", true);
		if (result.getStatus()==ITestResult.FAILURE) {
			logger.fail("Test Case Failed - ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenShot(driver)).build());
			
			Reporter.log("BeforMethod: TC failed and ScreenShot save sucessfully", true);
		}
		
		/*else if (result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Case Passed - ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenShot(driver)).build());
		} */
		
		/*else if (result.getStatus()==ITestResult.SKIP) {
			logger.skip("Test Case Skip - ",MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenShot(driver)).build());
		}*/
		report.flush();
		
	}

}
