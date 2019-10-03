package com.qsptechnologies.testing.launchingbrowsers;

public class AppTesting {
		static WebDriver driver;
		
	public static void main(String[] args) {
		
		
		/*ChromeDriver driver =  new ChromeDriver();
		driver.get("www.google.com");
		driver.click("abcabc", "ab");
		driver.getTitle();
		
		InternetExplorerDriver driver2 =  new InternetExplorerDriver();
		driver2.get("www.google.com");
		driver2.click("abcabc", "ab");
		driver2.getTitle();*/
		
		String browser = "Chrome";
		
		if(browser.equalsIgnoreCase("Firefox")){
			
		}
		else if(browser.equalsIgnoreCase("Chrome")){
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("IE")){
			driver =  new InternetExplorerDriver();
		}
		driver.get("www.google.com");
		driver.click("abcabc", "ab");
		driver.getTitle();
	}

}
