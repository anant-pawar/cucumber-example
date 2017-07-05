package com.bosch.api.steps;

import com.bosch.helper.JsonHelper;
import com.bosch.model.User;
import com.bosch.repository.UserRepository;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Anant on 04-07-2017.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
public class StepDefination {
    private ResponseEntity responseEntity = null;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    UserRepository userRepository;

    @After("@cleanRepository")
    public void afterTest(){
        userRepository.deleteAll();
    }

    @When("^we create user with is as \"([^\"]*)\" name as \"([^\"]*)\" age as (\\d+) and mobile as \"([^\"]*)\" by calling api \"([^\"]*)\"$")
    public void we_create_user_with_is_as_name_as_age_as_and_mobile_as_by_calling_api(String id, String name, int age, String mobile, String uri) throws Throwable {
       responseEntity = testRestTemplate.postForEntity(uri, new User(id, name, age, mobile), Object.class);
    }

    @Then("^(?:we|i) get response status as \"([^\"]*)\"$")
    public void we_get_response_status_as(String message) throws Throwable {
        Assert.assertEquals(message.toUpperCase(), responseEntity.getStatusCode().getReasonPhrase());
    }

    @Given("^an? user with id as \"([^\"]*)\" name as \"([^\"]*)\" age as (\\d+) and mobile as \"([^\"]*)\"$")
    public void a_user_with_is_as_name_as_age_as_and_mobile_as(String id, String name, int age, String mobile) throws Throwable {
        userRepository.save(new User(id, name, age, mobile));
    }

    @When("^i get user by calling \"([^\"]*)\" api with (?:id|name|mobile) \"([^\"]*)\"$")
    public void i_get_user_by_calling_api_with_id(String uri, String id) throws Throwable {
        responseEntity = testRestTemplate.getForEntity(uri + "/" + id, Object.class);
    }

    @Then("^response message as$")
    public void response_message_as(String resultJson) throws Throwable {
        Assert.assertTrue(JsonHelper.compareJson(resultJson, JsonHelper.getJsonString(responseEntity.getBody())));
    }

}
