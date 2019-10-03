package com.qsptechnologies.testing.lecture8;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CityBank_MultipleTab_Handle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.online.citibank.co.in/");
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='vizury-notification-template']")));
		driver.findElement(By.xpath("//*[@id='div-close']")).click();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[@title='Login']")).click();
		
		Set<String> windowIDS = driver.getWindowHandles();
		Iterator<String> itr = windowIDS.iterator();
		String main_window = itr.next();
		System.out.println("ID of First Window : "+main_window);
		String second_Window = itr.next();
		System.out.println("ID of Second Window : "+second_Window);
		
		driver.switchTo().window(second_Window);	
		driver.findElement(By.xpath("//input[@id='User_Id']")).sendKeys("Prashant");
		
		driver.switchTo().window(main_window);
		driver.findElement(By.xpath("//a[@title='NRI Banking']")).click();
		
		windowIDS = driver.getWindowHandles();
		itr = windowIDS.iterator();
		itr.next();
		itr.next();
		String th_window = itr.next();
		System.out.println("ID of 3rd Window : "+th_window);
		
		driver.switchTo().window(th_window);
		driver.findElement(By.xpath("//a[@title='Login'][1]")).click();		
		
		windowIDS = driver.getWindowHandles();
		itr = windowIDS.iterator();
		itr.next();
		itr.next();
		itr.next();
		String four_window = itr.next();
		System.out.println("ID of 4th Window : "+four_window);
		
		driver.switchTo().window(four_window);
		
		driver.findElement(By.xpath("//input[@id='User_Id']")).sendKeys("WeDoneCode");
		Thread.sleep(5000);
		driver.quit();
	}

}
