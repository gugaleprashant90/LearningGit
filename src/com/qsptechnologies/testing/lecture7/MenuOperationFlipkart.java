package com.qsptechnologies.testing.lecture7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MenuOperationFlipkart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);

		// To Handle Popup Signup Page
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();

		// Move toword menu and click on Submenu
		WebElement menu = driver.findElement(By.xpath("//*[@class='_1QZ6fC _3Lgyp8'][text()='Men']"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		driver.findElement(By.xpath("//*[@title='T-Shirts']")).click();

		WebElement menu1 = driver.findElement(By.xpath("//*[@class='_1QZ6fC _3Lgyp8'][text()='Men']"));
		action.moveToElement(menu1).perform();

		Thread.sleep(2000);
		// Printing All Data Of Sub-Menu
		for (int i = 1; i <= 5; i++) {
			System.out.println("\n\t .. Block "+i+" Section Links .. ");
			List<WebElement> all = driver.findElements(By.xpath("//*[@id='container']/div/div[2]/div/ul/li[3]/ul/li/ul/li[" + i + "]/ul/li/a"));

			// driver.findElements(By.xpath("//*[@id='container']/div/div[2]/div/ul/li[3]/ul/li/ul/li[1]/ul/li/a"));

			for (WebElement x : all) {
				System.out.println(x.getText());
				System.out.println("*****************");
			}
		}

		Thread.sleep(10000);
		driver.quit();

	}

}
