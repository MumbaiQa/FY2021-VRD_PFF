package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.commons.exec.ExecuteException;

public class ConfigDataProvider {

	
	Properties pro;
	
	public ConfigDataProvider() {
		
		File src = new File("./Config/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Not Able to load config file ="+e.getMessage());
		}
	}
	
	public String getConfigData(String getData) {
		
		return pro.getProperty(getData);
		
	}
}
