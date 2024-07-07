package com.asset.demo.cucumberglue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CucumberSteps extends SpringIntegrationTest {

    ResponseEntity<String> latestResponse;

    @When("the client calls endpoint {string}")
    public void the_client_issues_GET_version(String arg0) throws Throwable {
        latestResponse = new RestTemplate().exchange("http://localhost:5000" + arg0, HttpMethod.GET, null,
                String.class);
    }

    @Then("the client receives status code of {int}")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        assertThat("status code is : " + statusCode, latestResponse.getStatusCodeValue() == statusCode);
    }

    @And("the client receives string of {string}")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }
}
