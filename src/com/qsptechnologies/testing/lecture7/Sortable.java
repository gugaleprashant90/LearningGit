package com.qsptechnologies.testing.lecture7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/sortable/");
		Thread.sleep(2000);
		
		WebElement iframeid = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframeid);
		
		WebElement Item3ID = driver.findElement(By.xpath("//*[@class='ui-state-default ui-sortable-handle'][text()='Item 3']"));
		WebElement Item1ID = driver.findElement(By.xpath("//*[@class='ui-state-default ui-sortable-handle'][text()='Item 1']"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(Item3ID, Item1ID).perform();
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
