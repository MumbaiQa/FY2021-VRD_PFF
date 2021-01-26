package com.learnautomation.testcases;

import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.POM_LoginPage;


public class LoginTestCases extends BaseClass {

	@Test (priority=1)
	public void LoginTestFunction() throws InterruptedException {
		
		logger=report.createTest("VRD Login PageCode");
		
		String getUserID = xl.getCellData("Login", 0, 1);
		String getPassword = xl.getCellData("Login", 1, 1);
		logger.info("Read Valus form Excel File");
		
		POM_LoginPage login = new POM_LoginPage(driver);
		logger.info("Object Created for Login Page");
		login.pageLogin(getUserID, getPassword);
		logger.pass("Login Sucessfully to application");
		
		}
		
	@Test (priority=2)
	public void testLoggerFunctionality() {
		logger=report.createTest("Logger Functionality");
		System.out.println("test Logger Functionality");
		logger.fail("test Logger Functionality intionally failed");
	}
}
