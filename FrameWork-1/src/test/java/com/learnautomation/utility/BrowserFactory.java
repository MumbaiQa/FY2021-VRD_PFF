package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver OpenURL(WebDriver driver, String BrowserName, String appURL) {
		
		if (BrowserName.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./Drivers_exe/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (BrowserName.equals("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "./Drivers_exe/geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		else if (BrowserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "./Drivers_exe/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		else {
		
			System.out.println("Please select right browser!");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
	
	public static void CloseURL(WebDriver driver) {
		//driver.quit();
		//driver.close();
		driver.quit();
		
	}

}
