package com.qsptechnologies.testing.assignments;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickingOnCheckboxes {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		Thread.sleep(3000);
		
//		Clicking on Block of checkboxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@class='display'][1]/input"));
		for (WebElement x : checkboxes) {

			System.out.println("Value Of Checkbox : " + x.getAttribute("value"));
			x.click();
			System.out.println("**************");
		}
		Thread.sleep(4000);
		driver.quit();
	}

}
