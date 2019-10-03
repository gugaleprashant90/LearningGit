package com.qsptechnologies.testing.hidingWindows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CityBank_Code3 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.online.citibank.co.in/");
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='vizury-notification-template']")));
		System.out.println("Driver Switched To Frame");
		driver.findElement(By.xpath("//*[@id='div-close']")).click();
		
		driver.switchTo().defaultContent();
		System.out.println("Driver Switched To MainWindow");
		driver.findElement(By.xpath("//a[@title='Login']")).click();
		
		LetsHandle.getWindows(driver,1);
		System.out.println("Driver Switch To First Window");
		driver.findElement(By.xpath("//input[@id='User_Id']")).sendKeys("Prashant");
		
		LetsHandle.getWindows(driver,0);
		System.out.println("Driver Switch To MainWindow");
		driver.findElement(By.xpath("//a[@title='NRI Banking']")).click();
		
		LetsHandle.getWindows(driver,2);
		Thread.sleep(3000);
		System.out.println("Driver Switch To Second");
		driver.findElement(By.xpath("//a[@title='Login'][1]")).click();		
		
		LetsHandle.getWindows(driver,3);
		System.out.println("Driver Switch To Third Window");
		driver.findElement(By.xpath("//input[@id='User_Id']")).sendKeys("WeDoneCode");
		
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Driver Closed Successfully");
	}

}
