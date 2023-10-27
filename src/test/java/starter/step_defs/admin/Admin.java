package starter.step_defs.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.admin.AdminAPI;
import starter.utils.Constant;

import java.io.File;

public class Admin {

    @Given("List request verify users")
    public void listRequestVerifyUsers() {
        AdminAPI.setGetAllUsersVerify();
    }
    @When("Send request list request verify users")
    public void sendRequestListRequestVerifyUsers() {
        SerenityRest.when().get(AdminAPI.GET_VERIFY_USER);
    }

}
