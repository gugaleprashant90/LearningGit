package com.qsptechnologies.testing.synchronization;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class FluentWaitExample {
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
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(ElementNotInteractableException.class)
				.ignoring(NoSuchElementException.class)
				.withMessage("Element Not Found");
		
		System.out.println("Driver Switched To Frame");		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='vizury-notification-template']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='div-close']"))).click();
		
		System.out.println("Driver Switched To MainWindow");
		driver.switchTo().defaultContent();
		//driver.findElement(By.xpath("//a[@title='Login']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Login']"))).click();
		
		System.out.println("Driver Switch To First Window");
		FluentWaitExample.getWindows(1);
		//driver.findElement(By.xpath("//input[@id='User_Id']")).sendKeys("Prashant");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='User_Id']"))).sendKeys("Prashant");
		
		System.out.println("Driver Switch To MainWindow");
		FluentWaitExample.getWindows(0);
		//driver.findElement(By.xpath("//a[@title='NRI Banking']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='NRI Banking']"))).click();
		
		System.out.println("Driver Switch To Second");
		FluentWaitExample.getWindows(2);
		//driver.findElement(By.xpath("//a[@title='Login'][1]")).click();	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Login'][1]"))).click();
		
		System.out.println("Driver Switch To Third Window");
		FluentWaitExample.getWindows(3);
//		driver.findElement(By.xpath("//input[@id='User_Id']")).sendKeys("WeDoneCode");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='User_Id']"))).sendKeys("WeDoneCode");
		
		driver.quit();
		System.out.println("Driver Closed Successfully");
		
	}

}
