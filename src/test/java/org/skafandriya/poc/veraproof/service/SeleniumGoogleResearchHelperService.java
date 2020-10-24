package org.skafandriya.poc.veraproof.service;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.skafandriya.poc.veraproof.configuration.TestApplicationProperties;
import org.skafandriya.poc.veraproof.utility.SeleniumWebDriverUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;


@Service
public class SeleniumGoogleResearchHelperService {

    private WebDriver driver;

    @Autowired
    private TestApplicationProperties testApplicationProperties;

    public void initializeDriverIfNull() {
        this.driver = SeleniumWebDriverUtility.getFirefoxWebDriver();
    }

    public void navigateToGooglePage() throws InterruptedException {
        // navigate to google search page :
        this.driver.navigate().to(this.testApplicationProperties.getGoogleSearchUrl());
        // wait 1s :
        TimeUnit.SECONDS.sleep(1);
    }

    public void searchTextInGooglePage(String text) throws InterruptedException {
        // tap text in search text zone :
        this.driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys(text);
        // find search btn and click into it :
        AtomicBoolean isToContinue = new AtomicBoolean(true);
        this.driver.findElements(By.cssSelector("input.gNO89b"))
                .stream().takeWhile(btn -> isToContinue.get())
                .forEach(btn -> {
                    try {
                        btn.click();
                        isToContinue.set(false);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                });
        // wait 1s :
        TimeUnit.SECONDS.sleep(1);
    }

    public boolean findIsFirstResultContainsOneOfKeywordsInText(String text) {
        var firstResultText = this.driver.findElements(By.cssSelector("h3 span")).get(0).getText();
        for(String keyword: text.split(" ")) {
            if (keyword.length() > 2 && firstResultText.toUpperCase().contains(keyword.toUpperCase())) {
                System.err.println("THE KEYWORD FOUND : " + keyword);
                return true;
            }
        }
        return false;
    }

    public void quitbrowserWebDriver() {
        this.driver.quit();
    }

}
