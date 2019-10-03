package com.qsptechnologies.testing.launchingbrowsers;

public class ChromeDriver implements WebDriver {
	
	public void get(String url){
		System.out.println("Launching URL : "+url+ " in Chrome Bowser");
	}
	
	public void click(String xpath,String value){
		System.out.println("Clicking on element in Chrome Browser");
	}
	
	public void getTitle(){
		System.out.println("Getting The Page Title in Chrome Browser");
	}

	public static void main(String[] args) {
		

	}

	@Override
	public void getScreenShots() {
		System.out.println("Taking ScreenShots of Current Webpage");
		
	}

}
