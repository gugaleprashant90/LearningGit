package com.qsptechnologies.testing.externalfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropertiesFile {

	public static void main(String[] args) throws IOException {
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream("C:\\EclipseData\\Automation_Testing\\src\\com\\qsptechnologies\\testing\\externalfiles\\config.properties");
		config.load(fis);
		
		Properties OR = new Properties();
		FileInputStream fis1 = new FileInputStream("C:\\EclipseData\\Automation_Testing\\src\\com\\qsptechnologies\\testing\\externalfiles\\OR.properties");
		OR.load(fis1);
		
		System.out.println("Application URL : "+config.getProperty("Application_URL"));
		System.out.println("Browser Name : "+config.getProperty("Browser"));
		System.out.println("Browser Name : "+config.getProperty("emailId"));
		System.out.println("******* Config file Load Successfully ********");
		
		System.out.println("Xpath of Email input Field : "+OR.getProperty("Xemail"));
		System.out.println("Xpath of Next Btn : "+OR.getProperty("Xnext"));
		System.out.println("******* OR File Load Successfully ********");
		
	}

}
