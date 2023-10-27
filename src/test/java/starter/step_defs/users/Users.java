package starter.step_defs.users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.users.UsersAPI;

public class Users {

//GET USER WITH SPECIFIC ID

    @Given("Get user with specific id {string}")
    public void getUserWithSpecificId(String id) {
        UsersAPI.setGetUserById(id);
    }

    @When("Send request get specific users")
    public void sendRequestGetSpecificUsers() {
        SerenityRest.when().get(UsersAPI.GET_USERS_BY_ID);
    }

    @Given("Get user with specific id without token {string}")
    public void getUserWithSpecificIdWithoutToken(String id) {
        UsersAPI.setGetUsersByIdWithoutToken(id);
    }

//GET LIST USER FOLLOWERS

    @Given("Get list of user followers")
    public void getListOfUserFollowers() {
        UsersAPI.setGetListOfUserFollowers();
    }

    @When("Send request get list of user followers")
    public void sendRequestGetListOfUserFollowers() {
        SerenityRest.when().get(UsersAPI.GET_LIST_USER_FOLLOWERS);
    }

    @Given("Get list of user followers without token")
    public void getListOfUserFollowersWithoutToken() {
        UsersAPI.setGetListOfUserFollowersWithoutToken();
    }

//GET LIST USER FOLLOWING

    @Given("Get list of user following")
    public void getListOfUserFollowing() {
        UsersAPI.setGetListOfUserFollowing();
    }

    @When("Send request get list of user following")
    public void sendRequestGetListOfUserFollowing() {
        SerenityRest.when().get(UsersAPI.GET_LIST_USER_FOLLOWING);
    }

    @Given("Get list of user following without token")
    public void getListOfUserFollowingWithoutToken() {
        UsersAPI.setGetListOfUserFollowingWithoutToken();
    }

//POST REQUEST UPGRADE ACCOUNT TO ADMIN

    @Given("Request upgrade account to admin")
    public void requestUpgradeAccountToAdmin() {
        UsersAPI.setPostRequestUpgradeAccountToAdmin();
    }

    @When("Send request post upgrade account to admin")
    public void sendRequestPostUpgradeAccountToAdmin() {
        SerenityRest.when().post(UsersAPI.POST_REQUEST_UPGRADE_ACCOUNT);
    }
}
