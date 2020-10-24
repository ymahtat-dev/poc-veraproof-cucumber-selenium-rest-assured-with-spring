package org.skafandriya.poc.veraproof.service;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;
import org.skafandriya.poc.veraproof.configuration.TestApplicationProperties;
import org.skafandriya.poc.veraproof.mapper.JsonPlaceholderPostsMapper;
import org.skafandriya.poc.veraproof.model.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RestAssuredHelperService {

    @Autowired
    TestApplicationProperties testApplicationProperties;

    private static PostDto randompostRecovredFromWebService;


    public PostDto getRandomPost() throws JSONException {
        if ( RestAssuredHelperService.randompostRecovredFromWebService == null) {
            var response = RestAssured.given().headers(
                    "Content-Type",
                    ContentType.JSON
            ).relaxedHTTPSValidation()
                    .when()
                    .get(this.testApplicationProperties.getJsonplaceholderPostsEndpoint() + '/' + this.getRandomNumberInRange(1, 100));
            RestAssuredHelperService.randompostRecovredFromWebService = JsonPlaceholderPostsMapper.getPostDtoFromJsonObject(
                    new JSONObject(response.getBody().asString())
            );
        }
        return  RestAssuredHelperService.randompostRecovredFromWebService;
    }

    private int getRandomNumberInRange(int min, int max) {
        return (int)(Math.random() * max + min);
    }

}
