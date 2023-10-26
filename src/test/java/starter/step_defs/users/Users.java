package starter.step_defs.users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.users.UsersAPI;

public class Users {



    @Given("Get user with specific id {int}")
    public void getUserWithSpecificId(int id) {
        UsersAPI.setGetUserById(id);
    }

    @When("Send request get specific users")
    public void sendRequestGetSpecificUsers() {
        SerenityRest.when().get(UsersAPI.GET_USERS_BY_ID);
    }
}
