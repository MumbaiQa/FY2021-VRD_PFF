package com.learnautomation.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_SelectADMAgentIDPage {
	
	WebDriver driver;
	
	public POM_SelectADMAgentIDPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
				
	}
	
	@FindBy (xpath = "//div[@class=' css-1d99uvj']") WebElement drpSelectAgentType;
	
	
	public void setAgentType(String getAgentType) {
		
	}
	

}
