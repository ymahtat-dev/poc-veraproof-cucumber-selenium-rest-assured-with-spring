package org.skafandriya.poc.veraproof.stepdefs;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.skafandriya.poc.veraproof.configuration.TestApplicationProperties;
import org.skafandriya.poc.veraproof.service.RestAssuredHelperService;
import org.skafandriya.poc.veraproof.service.SeleniumGoogleResearchHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


@CucumberContextConfiguration
@ContextConfiguration(classes = {
        TestApplicationProperties.class,
        SeleniumGoogleResearchHelperService.class,
        RestAssuredHelperService.class
})
public class ApplicationContexteStepdefs {

    @Autowired
    private SeleniumGoogleResearchHelperService seleniumGoogleResearchHelperService;

    @Given("an application contexte")
    public void provideApplicationContexte() {
        // Given Spring Application Context for Cucumber StepDefs
        this.seleniumGoogleResearchHelperService.initializeDriverIfNull();
    }

    @Then("fermer le browser \\(Selenium) webdriver de l'Application Test")
    public void fermerLeBrowserSeleniumWebdriverDeLApplicationTest() {
        this.seleniumGoogleResearchHelperService.quitbrowserWebDriver();
    }

}
