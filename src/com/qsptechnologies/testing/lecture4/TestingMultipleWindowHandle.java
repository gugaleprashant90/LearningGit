package com.qsptechnologies.testing.lecture4;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingMultipleWindowHandle {
	static WebDriver driver;
	
//	This Method is Used To Handle Multiple Windows
	public static void SwitchToWindow(int index){
		String winID = null;
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();
		
		for (int i = 0; i <= index; i++) {
			winID = itr.next();
		}
		driver.switchTo().window(winID);
	}

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://demo.automationtesting.in/Windows.html");
		Thread.sleep(3000);
		System.out.println("Title of Main Window : "+driver.getTitle());
		driver.findElement(By.xpath("//*[@id='Tabbed']/a/button")).click();
		
//		Code To Handle The Newly Opened Window
		/*Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();
		String mainwindow = itr.next();
		String childwindow = itr.next();
		driver.switchTo().window(childwindow);*/
		
//		Calling Sati method With classname
		TestingMultipleWindowHandle.SwitchToWindow(1);
		System.out.println("Title of Newly Open Tab : "+driver.getTitle());
		
		Thread.sleep(2000);
//		driver.switchTo().window(mainwindow);
		TestingMultipleWindowHandle.SwitchToWindow(0);
		System.out.println("Title of Main Window : "+driver.getTitle());
		Thread.sleep(3000);
		driver.quit();
	}

}
