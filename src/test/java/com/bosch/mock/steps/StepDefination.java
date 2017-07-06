package com.bosch.mock.steps;

import com.bosch.model.User;
import com.bosch.repository.UserRepository;
import com.bosch.service.UserService;
import com.bosch.service.UserServiceImpl;
import com.bosch.transformers.UserTransformer;
import cucumber.api.Transform;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Anant on 06-07-2017.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
public class StepDefination {
    private UserService userService;
    private UserRepository userRepository;

    private User user = null;

    @Before
    public void beforeTest(){
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Given("^an user with id as \"([^\"]*)\" name as \"([^\"]*)\" age as (\\d+) and mobile as \"([^\"]*)\"$")
    public void an_user_with_id_as_name_as_age_as_and_mobile_as(String id, String name, int age, String mobile) throws Throwable {
        Mockito.when(userRepository.findOne(id)).thenReturn(new User(id,name,age,mobile));
    }

    @When("^i get user by id \"([^\"]*)\"$")
    public void i_get_user_by_id(String id) throws Throwable {
        user = userService.getUserById(id);
    }

    @Then("^i get response message as$")
    public void i_get_response_message_as(@Transform(UserTransformer.class) User expectedUser) throws Throwable {
        Assert.assertEquals(expectedUser.getMobile(), user.getMobile());
    }
}
