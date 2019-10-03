package com.qsptechnologies.testing.launchingbrowsers;

public class InternetExplorerDriver implements WebDriver {
	
	public void get(String url){
		System.out.println("Launching URL : "+url+ " in InternetExplorerDriver Bowser");
	}
	
	public void click(String xpath,String value){
		System.out.println("Clicking on element in InternetExplorerDriver Browser");
	}
	
	public void getTitle(){
		System.out.println("Getting The Page Title in InternetExplorerDriver Browser");
	}

	public static void main(String[] args) {
		

	}

	@Override
	public void getScreenShots() {
		System.out.println("Taking ScreenShots of Current Webpage");
		
	}

}
