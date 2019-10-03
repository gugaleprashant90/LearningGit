package com.qsptechnologies.testing.lecture7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropByUsingActionClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(2000);
		
		//Switch to iFrame
		WebElement iframeid = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframeid);
		//Source
		WebElement draggable = driver.findElement(By.xpath("//*[@id='draggable']"));
		//Destination
		WebElement droppable = driver.findElement(By.xpath("//*[@id='droppable']"));

		
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, droppable).perform();

		Thread.sleep(5000);
		driver.quit();
	}

}
