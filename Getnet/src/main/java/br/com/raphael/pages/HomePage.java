package br.com.raphael.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.raphael.util.AWebElement;

public class HomePage extends Page{
	
//	private WebDriver webDriver;
	
	public AWebElement<WebDriver> teste;

	public HomePage(WebDriver webDriver) {
		super(webDriver);
		this.webDriver = webDriver;
	}
	
	public WebElement searchLupa() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable((By.id("search-trigger"))));
		return this.webDriver.findElement(By.id("search-trigger"));
	}
	
	public WebElement searchField() {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.visibilityOf(this.webDriver.findElement(By.id("global-search-input"))));
		return this.webDriver.findElement(By.id("global-search-input"));
	}
	
	public WebElement searchBtn() {
		return this.webDriver.findElement(By.className("c-search-box__button"));
	}
	
	public List<WebElement> getSearchItems(){
		WebElement webElement = this.webDriver.findElement(By.cssSelector(".c-search-page section"));
		List<WebElement> _temp = this.webDriver.findElements(By.cssSelector(".c-search-page a[class='c-search-page__link']"));
		return _temp;
	}
	
	public List<WebElement> getSearchPagesLinks(){
		return this.webDriver.findElements(By.cssSelector(".o-pagination a[class='page-numbers']"));
	}
	
	public int getCurrentPage() {
		WebElement span =	this.webDriver.findElement(By.cssSelector(".o-pagination span.page-numbers.current"));
		
		return Integer.parseInt(span.getText());
	}
	
	public WebElement searchItemModalTitle() {
		return this.webDriver.findElement(By.cssSelector("div.o-modal.is-modal-open > div > div.o-modal__title"));
	}
}
