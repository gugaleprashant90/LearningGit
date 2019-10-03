package com.qsptechnologies.testing.lecture8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class SpinnerKeyboardUsingActionClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/spinner/");
		driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
		Thread.sleep(3000);
		Actions action = new Actions(driver);
//		action.sendKeys(Keys.ARROW_DOWN).perform();
				
		action.sendKeys(Keys.chord(Keys.CONTROL+"a")).build().perform();
		action.sendKeys(Keys.chord(Keys.CONTROL+"c")).build().perform();
		
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='spinner']")).click();
		action.sendKeys(Keys.chord(Keys.CONTROL+"v")).build().perform();		
		
		Thread.sleep(5000);
		driver.quit();
		

	}

}
