package starter.step_defs.users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.users.UsersAPI;
import starter.utils.Constant;

import java.io.File;

public class Users {

//GET USERS

    @Given("Get users current profile")
    public void getUsersCurrentProfile() {UsersAPI.getUsers();
    }
    @When("Send request get users current profile")
    public void sendRequestGetUsersCurrentProfile() {SerenityRest.when().get(UsersAPI.GET_USERS);
    }

//UPDATE USERS PROFILE

    @Given("Edit current users profile with valid {string}")
    public void editCurrentUsersProfileWithValid(String pathFile) {
        File json = new File(Constant.REQ_BODY + pathFile);
        UsersAPI.setUpdateUsers(json);
    }

    @When("Send request edit current users profile")
    public void sendRequestEditCurrentUsersProfile() {
        SerenityRest.when()
                .put(UsersAPI.GET_USERS);
    }

//SEARCH USER BY USERNAME
    @Given("search user by {string}")
    public void searchUserBy(String username) {
        UsersAPI.setGetUserByUsername(username);
    }

    @When("Send request search by username")
    public void sendRequestSearchByUsername() {
        SerenityRest.when().get(UsersAPI.GET_USER_BY_USERNAME);
    }

//EDIT USER PASSWORD
    @Given("edit user password with valid {string}")
    public void editUserPasswordWithValid(String jsonFile) {
        File json = new File(Constant.REQ_BODY+jsonFile);
        UsersAPI.setEditUserPassword(json);
    }

    @When("Send request edit password users")
    public void sendRequestEditPasswordUsers() {
        SerenityRest.when().put(UsersAPI.PUT_USER_PASSWORD);
    }


    @Then("Status code should be {string}")
    public void statusCodeShouldBe(String statCode) {
        SerenityRest.then().statusCode(Integer.parseInt(statCode));
    }

//DELETE USER ACCOUNT
    @When("Send request delete account")
    public void sendRequestDeleteAccount() {
        SerenityRest.when().delete(UsersAPI.GET_USERS);
    }

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
