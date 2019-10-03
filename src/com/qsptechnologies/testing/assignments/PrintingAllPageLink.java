package com.qsptechnologies.testing.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintingAllPageLink {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.wikipedia.org");
		Thread.sleep(3000);
		
		List<WebElement> pagelinks = driver.findElements(By.tagName("a"));
		System.out.println("Number Of Link Of Page is : "+pagelinks.size());
		
		for (WebElement li : pagelinks) {
			System.out.println("Text : "+li.getText());
			System.out.println("Link : "+li.getAttribute("href"));
			System.out.println("************************");
		}
		driver.quit();
	}

}
