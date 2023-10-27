package starter.step_defs.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.admin.AdminAPI;
import starter.utils.Constant;

import java.io.File;

public class Admin {

//    Get list user req verify
    @Given("List request verify users")
    public void listRequestVerifyUsers() {
        AdminAPI.setGetAllUsersVerify();
    }
    @When("Send request list request verify users")
    public void sendRequestListRequestVerifyUsers() {
        SerenityRest.when().get(AdminAPI.GET_LIST_VERIFY_USER);
    }

//    Put update user role with valid id and valid req body
    @Given("Update users role for verify user with valid user_id and valid body {string}")
    public void updateUsersRoleForVerifyUserWithValidUser_idAndValidBody(String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        AdminAPI.setPutUpdateUserRole(json);
    }

    @When("Send request update users role for verify user with valid user_id and valid body")
    public void sendRequestUpdateUsersRoleForVerifyUserWithValidUser_idAndValidBody() {
        SerenityRest.when().put(AdminAPI.PUT_UPDATE_USER_ROLE);
    }

//    update user role with exceed ID and valid req boy
    @Given("Update users role for verify user with exceed {string} and valid body {string}")
    public void updateUsersRoleForVerifyUserWithExceedAndValidBody(String userID, String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        AdminAPI.setUpdateRoleExceedID(userID, json);
    }

    @When("Send request update users role for verify user with exceed user_id and valid valid body")
    public void sendRequestUpdateUsersRoleForVerifyUserWithExceedUser_idAndValidValidBody() {
        SerenityRest.when().put(AdminAPI.PUT_UPDATE_USER_ROLE);
    }

//    update user role with valid user_id and invalid req boy
    @Given("Update users role for verify user with valid user_id and invalid body {string}")
    public void updateUsersRoleForVerifyUserWithValidUser_idAndInvalidBody(String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        AdminAPI.setUpdateRoleInvalidReqBody(json);
    }

    @When("Send request update users role for verify user with valid user_id and invalid body")
    public void sendRequestUpdateUsersRoleForVerifyUserWithValidUser_idAndInvalidBody() {
        SerenityRest.when().put(AdminAPI.PUT_UPDATE_USER_ROLE);
    }

    @Given("Update users role for verify user with alphabet {string} and invalid body {string}")
    public void updateUsersRoleForVerifyUserWithAlphabetAndInvalidBody(String userID, String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        AdminAPI.setUpdateRoleExceedID(userID, json);
    }

    @When("Send request update users role for verify user with alphabet user_id and invalid body")
    public void sendRequestUpdateUsersRoleForVerifyUserWithAlphabetUser_idAndInvalidBody() {
        SerenityRest.when().put(AdminAPI.PUT_UPDATE_USER_ROLE);
    }
}
