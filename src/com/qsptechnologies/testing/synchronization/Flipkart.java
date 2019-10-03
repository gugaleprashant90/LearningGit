package com.qsptechnologies.testing.synchronization;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		Wait<WebDriver> wait =  new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class).withMessage("Error");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='_2AkmmA _29YdH8']"))).click();
		
		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//*[@class='_114Zhd']/li[4]"))).perform();
		
		action.moveToElement(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='_114Zhd']/li[4]")))).perform();
		
		driver.quit();	
	}

}
