package com.qsptechnologies.testing.lecture8;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollOpeationsUsingKeyboard {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/");
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.PAGE_UP).perform();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='s']")).click();
		//action.contextClick().perform();
		
		String data = "Prashant";
		StringSelection selection = new StringSelection(data);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
		Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_V);
		
		ro.keyRelease(KeyEvent.VK_CONTROL);
		ro.keyRelease(KeyEvent.VK_V);
		//action.sendKeys(Keys.chord(Keys.CONTROL,"v"));
		
		Thread.sleep(5000);
		driver.quit();
	}
}
