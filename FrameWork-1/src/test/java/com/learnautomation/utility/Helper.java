package com.learnautomation.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {


	public static String getScreenShot(WebDriver driver) {
		
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotPath = System.getProperty("user.dir")+"/Screenshots/ProjectName_"+getCurrentDataTime()+".png";
		
		try {
			
			FileHandler.copy(src, new File(ScreenshotPath));
			System.out.println("Screenshots Captured");
			
			
		} catch (Exception e) {
			System.out.println("Unabaled to Capture Screenshots - "+e.getMessage());
		}
		return ScreenshotPath;
		
	}
	
	public static String getCurrentDataTime() {
		
		DateFormat customeFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customeFormat.format(currentDate);
		
	}


}
