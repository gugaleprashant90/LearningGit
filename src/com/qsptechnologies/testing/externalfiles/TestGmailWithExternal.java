package com.qsptechnologies.testing.externalfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestGmailWithExternal {
	static WebDriver driver;
	

	public static void main(String[] args) throws IOException, InterruptedException {
		Properties config = new Properties();
//		FileInputStream fis =  new FileInputStream("C:\\EclipseData\\Automation_Testing\\src\\com\\qsptechnologies\\testing\\externalfiles\\config.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\qsptechnologies\\testing\\externalfiles\\config.properties");
		config.load(fis);
		
		Properties OR = new Properties();
		FileInputStream fis1 =  new FileInputStream("C:\\EclipseData\\Automation_Testing\\src\\com\\qsptechnologies\\testing\\externalfiles\\OR.properties");
		OR.load(fis1);
		
		String browser = config.getProperty("Browser");
		if(browser.equalsIgnoreCase("Chrome")){
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("IE")){
			driver = new InternetExplorerDriver();
		}
		System.out.println("Browser Launched Successfully ...");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.get(config.getProperty("Application_URL"));
		System.out.println("Application URL is : "+config.getProperty("Application_URL"));
		
		driver.findElement(By.xpath(OR.getProperty("Xemail"))).sendKeys(config.getProperty("emailId"));
		System.out.println("Entered Email id is : "+config.getProperty("emailId"));
		driver.findElement(By.xpath(OR.getProperty("Xnext"))).click();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
