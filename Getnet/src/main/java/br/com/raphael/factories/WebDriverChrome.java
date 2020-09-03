package br.com.raphael.factories;

import org.openqa.selenium.WebDriver;

import br.com.raphael.util.EnumBrowser;


public class WebDriverChrome {
	
	private static WebDriver driver = null;
	
	private WebDriverChrome() {
		
	}
	
	public static WebDriver instance() {
		if(driver == null || !isOpen()) {
			driver = WebDriverFactory.createWebDriver(EnumBrowser.CHROME);
		} 
		
		return driver;
	}
	
	public static boolean isOpen() {
	    try {
	        driver.getCurrentUrl();
	        return true;
	    } catch (Exception ex) {
	        return false;
	    }
	}
	

}
