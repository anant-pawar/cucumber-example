package com.bosch.mock;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Anant on 04-07-2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/mock" , glue = {"com.bosch.mock.steps"}, strict =  true)
public class CucumberTest {
}
