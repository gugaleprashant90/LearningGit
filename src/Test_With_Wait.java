import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test_With_Wait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@class='login']")).click();
		
		driver.findElement(By.id("email_create")).sendKeys("qsptechnologies31@gmail.com");
		driver.findElement(By.xpath("//*[@class='btn btn-default button button-medium exclusive']")).click();
		
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Prashant");
		driver.findElement(By.id("customer_lastname")).sendKeys("Gugale");
		driver.findElement(By.id("passwd")).sendKeys("Prashant123");
		
		WebElement day =  driver.findElement(By.id("days"));
		Select s = new Select(day);
		s.selectByValue("5");
		
		WebElement mon =  driver.findElement(By.id("months"));
		Select s1 = new Select(mon);
		s1.selectByValue("4");
		
		WebElement year =  driver.findElement(By.id("years"));
		Select s2 = new Select(year);
		s2.selectByValue("1996");
		
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		
		driver.findElement(By.id("company")).sendKeys("QSPTECHNOLOGIES");
		driver.findElement(By.id("address1")).sendKeys("Shrigonda");
		driver.findElement(By.id("address2")).sendKeys("Near ADCC Bank");
		
		driver.findElement(By.id("city")).sendKeys("Adhalgaon");
		
		WebElement state =  driver.findElement(By.id("id_state"));
		Select s3 = new Select(state);
		s3.selectByValue("5");
		
		driver.findElement(By.id("postcode")).sendKeys("94203");
		
		driver.findElement(By.id("other")).sendKeys("Software Engineer");
		
		driver.findElement(By.id("phone_mobile")).sendKeys("9890111213");
		
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("Testing");
		
		driver.findElement(By.id("submitAccount")).click();
		
		
		driver.quit();

	}

}
