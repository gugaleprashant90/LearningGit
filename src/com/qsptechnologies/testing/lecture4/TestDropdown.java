package com.qsptechnologies.testing.lecture4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		System.out.println("URL : https://www.wikipedia.org/ Has been Open");
		Thread.sleep(2000);
		driver.findElement(By.id("searchInput")).sendKeys("Automation Testing");
		WebElement drop = driver.findElement(By.xpath("//*[@id='searchLanguage']"));
		
		Select s = new Select(drop);
		s.selectByValue("hi");
		
		Thread.sleep(2000);
//		Printing With Another Method
		List<WebElement> op = s.getOptions();
		for (WebElement ap : op) {
			System.out.println(ap.getAttribute("value"));
			System.out.println(ap.getText());
			System.out.println("*******************************");
		}
		
		driver.findElement(By.xpath("//*[@id='search-form']/fieldset/button/i")).click();
		System.out.println("Title of Page : "+driver.getTitle());
		Thread.sleep(3000);
		System.out.println("*******************************");
		driver.navigate().back();	
		
//		Printing All List From DropDown 
		List<WebElement> list =  driver.findElements(By.xpath("//*[@id='searchLanguage']"));
		for (WebElement x : list) {
			System.out.println(x.getAttribute("value"));
			System.out.println(x.getText());
			System.out.println("*****************************");
		}
		
		
		Thread.sleep(3000);
		System.out.println("******************************");
		List<WebElement> list2 = driver.findElements(By.xpath("//*[@id='www-wikipedia-org']/div[6]/div[3]"));
		for (WebElement y : list2) {
			System.out.println(y.getAttribute("href"));
			System.out.println(y.getText());
			System.out.println("*********************");
		}
		
		driver.close();
	}

}
