package org.skafandriya.poc.veraproof.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONException;
import org.skafandriya.poc.veraproof.model.dto.PostDto;
import org.skafandriya.poc.veraproof.service.RestAssuredHelperService;
import org.skafandriya.poc.veraproof.service.SeleniumGoogleResearchHelperService;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

public class SearchRandomPostInGoogleStepdefs {

    @Autowired
    private RestAssuredHelperService restAssuredHelperService;

    @Autowired
    private SeleniumGoogleResearchHelperService seleniumGoogleResearchHelperService;

    private PostDto randompostRecovredFromWebService;

    @Given("random post from JSONPlaceholder fake Online REST API")
    public void randomPostFromJSONPlaceholderFakeOnlineRESTAPI() throws JSONException {
        this.randompostRecovredFromWebService = this.restAssuredHelperService.getRandomPost();
    }

    @Given("navigate to google page")
    public void navigateToGooglePage() throws InterruptedException {
        this.seleniumGoogleResearchHelperService.navigateToGooglePage();
    }

    @When("research Title of random post in Google Search")
    public void researchTitleOfRandomPostInGoogleSearch() throws InterruptedException {
        this.seleniumGoogleResearchHelperService.searchTextInGooglePage(this.randompostRecovredFromWebService.getTitle());
    }

    @Then("verify is there key word of title in the first result")
    public void verifyIsThereKeyWordOfTitleInTheFirstResult() {
        assertTrue(this.seleniumGoogleResearchHelperService.findIsFirstResultContainsOneOfKeywordsInText(this.randompostRecovredFromWebService.getTitle()));
    }
}
