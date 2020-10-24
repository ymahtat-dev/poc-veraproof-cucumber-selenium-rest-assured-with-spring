package org.skafandriya.poc.veraproof.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:application-test.properties")
@Component
public class TestApplicationProperties {

    @Value("${test.webservice.jsonplaceholder.posts.endpoint}")
    private String jsonplaceholderPostsEndpoint;

    @Value("${test.google.search.url}")
    private String googleSearchUrl;

    public String getJsonplaceholderPostsEndpoint() {
        return jsonplaceholderPostsEndpoint;
    }

    public String getGoogleSearchUrl() {
        return googleSearchUrl;
    }

}
