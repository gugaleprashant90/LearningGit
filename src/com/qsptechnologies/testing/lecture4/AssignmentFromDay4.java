package com.qsptechnologies.testing.lecture4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentFromDay4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://freecrm.com/");
		Thread.sleep(5000);

		driver.findElement(By.linkText("Sign Up")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("gugaleprashant90@gmail.com");

		driver.findElement(By.xpath("//*[@id='country']")).click();
		driver.findElement(By.xpath("//*[@id='country']/div[2]/div[103]")).click();

		driver.findElement(By.id("phone_number")).sendKeys("9890871005");
		driver.findElement(By.id("terms")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@class='recaptcha-checkbox-border']")).click();
		driver.findElement(By.xpath("//*[@class='ui fluid large blue submit button']")).click();

		Thread.sleep(2000);
		driver.close();
	}

}
