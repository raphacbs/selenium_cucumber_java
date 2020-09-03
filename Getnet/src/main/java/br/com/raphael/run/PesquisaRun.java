package br.com.raphael.run;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/main/resources/features"}
		,glue = {"br.com.raphael.steps"}
		,tags = {"@Realizarpesquisa"}
)
public class PesquisaRun {

}
