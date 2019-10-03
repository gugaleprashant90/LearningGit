package com.qsptechnologies.testing.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickingOnCheckbox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@class='display'][1]/input[1]")).click();
//		driver.findElement(By.xpath("//*[@class='display'][1]/*[@value='soccer']")).click();
		
		Thread.sleep(4000);
		driver.quit();
	}

}
