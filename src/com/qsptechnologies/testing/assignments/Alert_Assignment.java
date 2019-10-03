package com.qsptechnologies.testing.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_Assignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@class='panel panel-primary'][1]/div/button")).click();
		Thread.sleep(2000);
		Alert alt = driver.switchTo().alert();
		System.out.println("Text From Alert : "+alt.getText());
		alt.accept();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@class='panel panel-primary'][2]/div/button")).click();
		Thread.sleep(2000);
		System.out.println("Text From Alert : "+alt.getText());
		alt.dismiss();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@class='panel panel-primary'][3]/div/button")).click();
		Thread.sleep(2000);
		System.out.println("Text From Alert : "+alt.getText());
		alt.sendKeys("Prashant");
		Thread.sleep(3000);
		//alt.accept();
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
