package com.qsptechnologies.testing.getwindowhandles;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CityBank_Code2 {
	static WebDriver driver;
	public static void getWindows(int num){
		String winID = null;
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();
		
		for(int i=0;i<=num;i++){
			winID = itr.next();
		}
		driver.switchTo().window(winID);	
	}

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.online.citibank.co.in/");
		Thread.sleep(3000);
		System.out.println("Driver Switched To Frame");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='vizury-notification-template']")));
		driver.findElement(By.xpath("//*[@id='div-close']")).click();
		
		System.out.println("Driver Switched To MainWindow");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[@title='Login']")).click();
		
		System.out.println("Driver Switch To First Window");
		CityBank_Code2.getWindows(1);
		driver.findElement(By.xpath("//input[@id='User_Id']")).sendKeys("Prashant");
		
		System.out.println("Driver Switch To MainWindow");
		CityBank_Code2.getWindows(0);
		driver.findElement(By.xpath("//a[@title='NRI Banking']")).click();
		
		System.out.println("Driver Switch To Second");
		CityBank_Code2.getWindows(2);
		driver.findElement(By.xpath("//a[@title='Login'][1]")).click();		
		
		System.out.println("Driver Switch To Third Window");
		CityBank_Code2.getWindows(3);
		driver.findElement(By.xpath("//input[@id='User_Id']")).sendKeys("WeDoneCode");
		
		
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Driver Closed Successfully");
	}

}
