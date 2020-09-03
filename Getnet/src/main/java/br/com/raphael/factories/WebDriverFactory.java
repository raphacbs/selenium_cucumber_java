package br.com.raphael.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Resources;

import br.com.raphael.util.EnumBrowser;

public class WebDriverFactory {
	
	
	protected static WebDriver createWebDriver(EnumBrowser browser) {
		
		switch (browser) {
		
		case CHROME:
			System.setProperty("webdriver.chrome.driver", Resources.getResource("drivers/chromedriver.exe").getPath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			WebDriver webDriver = new ChromeDriver(options);
			return webDriver;

		default:
			break;
		}
		
		return null;
	}
}
