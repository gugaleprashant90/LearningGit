package com.qsptechnologies.testing.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintingWikipediaModule {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		System.out.println("URL : https://www.wikipedia.org/ Has been Open");
		Thread.sleep(2000);
		
		// printing 1nd All Module
		List<WebElement> firstmodule = driver.findElements(By.xpath("//div[@class='central-featured']/div/a"));
		System.out.println("\n\t.. First Module .. \nNumber of Link in First Section :  "+firstmodule.size());
		for (int i = 0; i < firstmodule.size(); i++) {
			System.out.println("Link Name : "+firstmodule.get(i).getText());
			System.out.println("Link : "+firstmodule.get(i).getAttribute("href"));
			System.out.println("**************************");
			
		}
		
		// printing 2nd All Module
		List<WebElement> secondmodule = driver.findElements(By.xpath("//*[@class='other-projects']/div/a"));
		System.out.println("\n\t.. Second Module .. \nNumber of Link in First Section :  "+secondmodule.size());
		for (WebElement x : secondmodule) {

			System.out.println("Link : " + x.getAttribute("href"));
			System.out.println("Text : " + x.getText());
			System.out.println("************************");
		}

		driver.quit();

	}

}
