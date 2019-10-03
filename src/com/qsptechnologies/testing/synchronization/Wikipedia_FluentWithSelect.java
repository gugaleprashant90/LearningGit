package com.qsptechnologies.testing.synchronization;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class Wikipedia_FluentWithSelect {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org");
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class).ignoring(ElementNotInteractableException.class).withMessage("ERROR");
		//driver.findElement(By.xpath("//select[@id='searchLanguage']"));
		Select sel = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='searchLanguage']"))));
		sel.selectByValue("es");
		
		driver.quit();
	}

}
