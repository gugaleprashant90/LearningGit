package com.qsptechnologies.testing.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleMenus {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://jqueryui.com/menu/");
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='ui-id-9']"))).perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='ui-id-10']"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ui-id-12']")).click();
		
		Thread.sleep(3000);
		driver.quit();
	}

}
