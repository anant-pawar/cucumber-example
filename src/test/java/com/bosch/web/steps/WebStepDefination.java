package com.bosch.web.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Anant on 04-07-2017.
 */
public class WebStepDefination {

    private WebDriver webDriver;

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.gecko.driver", "D:\\gecko\\geckodriver.exe");

        webDriver =  new FirefoxDriver();
    }

    @Given("^a user navigates to \"([^\"]*)\"$")
    public void a_user_navigates_to(String url) throws Throwable {
        webDriver.get(url);
    }

    @When("^he types \"([^\"]*)\" and hit search$")
    public void he_types_and_hit_search(String searchString) throws Throwable {
        webDriver.findElement(By.id("lst-ib")).sendKeys(searchString);
    }

    @Then("^he should get result$")
    public void he_should_get_result() throws Throwable {
        webDriver.findElement(By.name("btnG")).submit();
    }
}
