package org.skafandriya.poc.veraproof.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"org.skafandriya.poc.veraproof.stepdefs"},
        plugin = {"pretty", "json:target/json/cucumber.json"}
)
public class CucumberRunnerListnerTest {
}
