import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPrograms1 {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\testing\\chromedriver.exe");
		WebDriver  driver = new ChromeDriver();
//		ChromeDriver  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Gugale Prashant");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[1]/div[3]/center/input[1]")).click();
		
		System.out.println("Title : "+driver.getTitle());
		Thread.sleep(2000);
		driver.close();

	}
}
