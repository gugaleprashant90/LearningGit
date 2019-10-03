package com.qsptechnologies.testing.lecture4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintingModuleData {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		System.out.println("URL : https://www.wikipedia.org/ Has been Open");
		Thread.sleep(2000);
		
//		printing All Module
		List<WebElement> modulelink = driver.findElements(By.xpath("//*[@class='other-projects']/div/a"));
		for (WebElement x : modulelink) {
			
			System.out.println("Link : "+ x.getAttribute("href"));
			System.out.println("Text : "+x.getText());
			System.out.println("************************");
		}
		
		driver.quit();
	}

}
