package com.qsptechnologies.testing.lecture4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@title='Sign in']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Text Of Alert : "+alert.getText());
		alert.accept();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
