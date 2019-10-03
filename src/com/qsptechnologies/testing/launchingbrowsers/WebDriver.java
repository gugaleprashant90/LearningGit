package com.qsptechnologies.testing.launchingbrowsers;

public interface WebDriver {
	
	public void get(String url);
	
	public void click(String xpath,String value);
	
	public void getTitle();
	
	public void getScreenShots();

}
