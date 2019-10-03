package com.qsptechnologies.testing.hidingWindows;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;

public class LetsHandle {
	public static void getWindows(WebDriver driver,int num){
		String winID = null;
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();
		
		for(int i=0;i<=num;i++){
			winID = itr.next();
		}
		driver.switchTo().window(winID);	
	}
	public static void main(String[] args) {
		

	}

}
