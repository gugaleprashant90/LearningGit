package com.qsptechnologies.testing.lecture4;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchingIntenetExplorer {
	static WebDriver driver;
	public static void SwitchToWindow(int index){
		String winID = null;
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();
		
		for (int i = 0; i <= index; i++) {
			winID = itr.next();
		}
		driver.switchTo().window(winID);
	}

	public static void main(String[] args) throws InterruptedException {
		
	driver =  new InternetExplorerDriver();
	driver.manage().window().maximize();
	System.out.println("Opening Chrome Browser");
	driver.get("https://gmail.com");
	System.out.println("Title of page : "+driver.getTitle());
	driver.findElement(By.linkText("Sign in")).click();
	
	LaunchingIntenetExplorer.SwitchToWindow(1);
	
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("gugaleprashant90@gmail.com");
	Thread.sleep(2000);
	driver.findElement(By.linkText("Next")).click();
	System.out.println("Title of page : "+driver.getTitle());
	Thread.sleep(3000);
	driver.close();
	}

}
