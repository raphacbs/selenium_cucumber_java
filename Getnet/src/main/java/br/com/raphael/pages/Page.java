package br.com.raphael.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	public WebDriver webDriver;
	
	public Page(WebDriver webDriver ) {
		this.webDriver = webDriver;
	}
	
	public void waitLoadPage() throws InterruptedException {

		 ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };
	        WebDriverWait wait = new WebDriverWait(this.webDriver, 30);
	        wait.until(pageLoadCondition);
	}
}
