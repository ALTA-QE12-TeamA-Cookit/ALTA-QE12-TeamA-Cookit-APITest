package starter.step_defs.auth;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.cookit.auth.LoginAPI;
import starter.utils.Constant;


import java.io.File;

public class Login {
    @Given("Login user with {string} as request body")
    public void loginUserWithAsRequestBody(String reqBodyPath) {
        File json = new File(Constant.REQ_BODY + reqBodyPath);
        LoginAPI.setPostLogin(json);
    }

    @When("Send request login user")
    public void sendRequestLoginUser() {
        SerenityRest.when().post(LoginAPI.POST_LOGIN);
    }
}
