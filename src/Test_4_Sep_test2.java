import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class Test_4_Sep_test2 {
	
	static WebDriver driver;
	public static void getWindows(int num){
		String winID = null;
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();
		
		for(int i=0;i<=num;i++){
			winID = itr.next();
		}
		driver.switchTo().window(winID);	
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Properties config = new Properties();
		FileInputStream file1 = new FileInputStream("C:\\EclipseData\\Automation_Testing\\src\\config.properties");
		config.load(file1);
		
		Properties or = new Properties();
		FileInputStream file2 = new FileInputStream("C:\\EclipseData\\Automation_Testing\\src\\or.properties");
		or.load(file2);
		
		if(config.getProperty("Browser").equalsIgnoreCase("Chrome")){
			driver = new ChromeDriver();
			System.out.println("ChromeBrowser Launched Successfully");
		}
		else if(config.getProperty("Browser").equalsIgnoreCase("IE")){
			driver = new InternetExplorerDriver();
			System.out.println("InternetExplorerDriver Launched Successfully");
		}
		driver.manage().window().maximize();
		driver.get(config.getProperty("Application_URL"));
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement bill = driver.findElement(By.xpath(or.getProperty("xbillpay")));
		action.moveToElement(bill).perform();
		
		
		driver.findElement(By.xpath(or.getProperty("xsubbill"))).click();

		Test_4_Sep_test2.getWindows(1);
		driver.findElement(By.xpath(or.getProperty("xFlogin"))).click();
		driver.findElement(By.xpath(or.getProperty("xSlogin"))).click();
		
		driver.findElement(By.xpath(or.getProperty("xusername"))).sendKeys(config.getProperty("sendusername"));
		driver.findElement(By.xpath(or.getProperty("xpass"))).sendKeys(config.getProperty("sendpass"));
		
		driver.findElement(By.xpath(or.getProperty("xbtnlogin"))).click();

		driver.quit();
	}

}
