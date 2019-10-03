package com.qsptechnologies.testing.lecture4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCheckbox {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		System.out.println("URL : http://www.tizag.com/htmlT/htmlcheckboxes.php open in Chromebrowser");
		
		System.out.println("Clicking on All Check box");
		Thread.sleep(2000);
		List<WebElement> check = driver.findElements(By.xpath("//input[@name='sports']"));
		for(WebElement x : check){
			x.click();
		}
		Thread.sleep(5000);
		System.out.println("Clicking on only First Block");
		List<WebElement> block =  driver.findElements(By.xpath("//div[@class='display'][1]/input"));
		for(WebElement y : block){
			y.click();
		}
		Thread.sleep(10000);
		driver.close();
		
		
	}

}
