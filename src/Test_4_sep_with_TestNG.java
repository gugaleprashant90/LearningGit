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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_4_sep_with_TestNG {
	static WebDriver driver;
	Properties config = new Properties();
	Properties or = new Properties();
	public static void getWindows(int num){
		String winID = null;
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();
		
		for(int i=0;i<=num;i++){
			winID = itr.next();
		}
		driver.switchTo().window(winID);	
	}
	
	@BeforeMethod
	public void launchBrowser() throws IOException{
		
		FileInputStream file1 = new FileInputStream("C:\\EclipseData\\Automation_Testing\\src\\config.properties");
		config.load(file1);
		
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
		driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
	}
	
	@Test
	public void sbiregistration(){
		driver.findElement(By.xpath(or.getProperty("xnewuser"))).click();
		System.out.println("click on button");
		
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		
		Test_4_sep_with_TestNG.getWindows(1);
				
		driver.findElement(By.xpath(or.getProperty("xNextButton"))).click();
		
		driver.findElement(By.xpath(or.getProperty("xAccountid"))).sendKeys(config.getProperty("sendAccnum"));
		driver.findElement(By.xpath(or.getProperty("xCIFnum"))).sendKeys(config.getProperty("sendCIF"));
		driver.findElement(By.xpath(or.getProperty("xbranchcode"))).sendKeys(config.getProperty("sendbranchcode"));
		
		WebElement con = driver.findElement(By.xpath(or.getProperty("xcountry")));
		Select sel = new Select(con);
		sel.selectByValue("91");
		
		driver.findElement(By.xpath(or.getProperty("xmobile"))).sendKeys(config.getProperty("sendMobile"));
		
		WebElement con1 = driver.findElement(By.xpath(or.getProperty("xfacility")));
		Select sel2 = new Select(con1);
		sel2.selectByValue("09");	
		driver.findElement(By.xpath(or.getProperty("xsubmit"))).click();	
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}

}
