package com.qsptechnologies.testing.lecture7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderByUsingActionsClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.trivago.in/?aDateRange%5Barr%5D=2019-09-12&aDateRange%5Bdep%5D=2019-09-18&aPriceRange%5Bfrom%5D=0&aPriceRange%5Bto%5D=4436&iRoomType=7&aRooms%5B0%5D%5Badults%5D=2&cpt2=73918%2F200&iViewType=0&bIsSeoPage=0&sortingId=1&slideoutsPageItemId=&iGeoDistanceLimit=20000&address=&addressGeoCode=&offset=0&ra=");
		WebElement slider = driver.findElement(By.xpath("//*[@role='slider']"));
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 200, 0).perform();
		
		Thread.sleep(3000);
		action.dragAndDropBy(slider, -100, 0).perform();
		
		Thread.sleep(5000);
		//driver.quit();
	}

}
