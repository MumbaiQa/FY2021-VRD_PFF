package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_LoginPage {
	
	WebDriver driver;
	
	public POM_LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy (xpath="//input[@id='userId']") WebElement txtUserId;
	@FindBy (xpath="//input[@id='password']") WebElement txtPassword;
	@FindBy (xpath="//button[@class='GlhKQAgw2R-AmI_l5FN08 butn-primary']") WebElement btnLogin;
	//
	
	public void pageLogin(String AppUserId, String AppUserPass) throws InterruptedException {
		txtUserId.sendKeys(AppUserId);
		txtPassword.sendKeys(AppUserPass);
		btnLogin.click();
	}
}
