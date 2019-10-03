package com.qsptechnologies.testing.lecture8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_xpath_Assignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.wikipedia.org/");
		
		//Ending With Dynamic Value
		driver.findElement(By.xpath("//input[starts-with(@id,'search')]")).sendKeys("Prashant");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[starts-with(@id,'search')]")).clear();
		
//		//Starting With Dynamic Value
//		driver.findElement(By.xpath("//input[ends-with(@id,'Input')]")).sendKeys("Gugale");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[ends-with(@id,'Input')]")).clear();
		
		//Starting And Ending with dynamic value then use contains
		driver.findElement(By.xpath("//input[contains(@id,'rch')]")).sendKeys("Abhijit");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@id,'rch')]")).clear();
		
		//Moving Forward
		List<WebElement> drop = driver.findElements(By.xpath("//select[@id='searchLanguage']/option"));
		for (WebElement x : drop) {
			System.out.println(x.getText());
			System.out.println("**********");
		}
		
		//Moving backward
		driver.findElement(By.xpath("//select[@id='searchLanguage']/../../../input")).sendKeys("Vaibhav");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='searchLanguage']/../../../input")).clear();
		
		//following siblings
		String s = driver.findElement(By.xpath("//select[@id='searchLanguage']/option[5]/following-sibling::option[1]")).getText();
		System.out.println("Value Selected by using Following Siblings Method"+s);
		
		//preceding siblings
		//syntax : XPATH //select[@id='searchLanguage']/option[5]/preceding-sibling::option[1]
		
		//Go To The Parent Window Directly
		//Syntax : XPATH //option[@value='de']/parent::*
		
		//Search Text on WebPage
		//syntax XPATH : //*[contains(text(),'English')] 
		
		Thread.sleep(5000);
		driver.quit();
	}

}
