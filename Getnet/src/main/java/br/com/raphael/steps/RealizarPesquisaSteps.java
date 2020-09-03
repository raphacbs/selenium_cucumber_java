package br.com.raphael.steps;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;

import br.com.raphael.factories.WebDriverChrome;
import br.com.raphael.pages.HomePage;
import br.com.raphael.util.Constants;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RealizarPesquisaSteps {
	
	private HomePage homePage = new HomePage(WebDriverChrome.instance());
	
	@Given("^Acessar o site$")
	public void acessar_o_site() throws Exception {
		WebDriverChrome.instance().navigate().to(Constants.URL_HOME_PAGE);
	}

	@Given("^No campo de busca\\(LUPA\\), pesquisar por \"([^\"]*)\"$")
	public void no_campo_de_busca_LUPA_pesquisar_por_superget(String searchedText) throws Exception {
		homePage.waitLoadPage();
		homePage.searchLupa().click();
		homePage.searchField().sendKeys(searchedText);
		homePage.searchBtn().click();
	}

	@When("^No resultado da busca, clicar no link \"([^\"]*)\"$")
	public void no_resultado_da_busca_clicar_no_link(String expectedText) throws Exception {
		boolean found = false;
		boolean continueSearch = true;

		
		do {		
			homePage.waitLoadPage();
			List<WebElement> items = homePage.getSearchItems();
			WebElement link = items.stream().filter(item -> item.getText().equals(expectedText)).findFirst().orElse(null);
			
			if(link != null) {
				link.click();
				found = true;
				continueSearch = false;
				homePage.waitLoadPage();
			}else {
				List<WebElement> pageLinks = homePage.getSearchPagesLinks();
				int currentPage = homePage.getCurrentPage() + 1;
				WebElement pageLink = pageLinks.stream().filter(page -> page.getText().equals(currentPage+"")).findFirst().orElse(null);
				
				if(pageLink != null) 
					pageLink.click();
				else
					continueSearch = false;
			}
		} while (continueSearch);
		
		assertTrue("O valor '"+expectedText+"' não foi localizado.", found);
	}

	@Then("^Verificar se a modal foi aberta com a mensagem \"([^\"]*)\"$")
	public void verificar_se_a_modal_foi_aberta_com_a_mensagem(String expectedText) throws Exception {
		String modalTitle =  homePage.searchItemModalTitle().getText();

		
		assertEquals(expectedText, modalTitle);
	}
	
	@After
	public void closeBrowser() {
		WebDriverChrome.instance().close();
	}

}
