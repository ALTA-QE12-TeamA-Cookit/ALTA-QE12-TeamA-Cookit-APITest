package starter.step_defs.auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.auth.LoginAPI;
import starter.cookit.auth.RegisterAPI;
import starter.utils.Constant;

import java.io.File;

public class Register {
    @Given("Register user with {string} as request body")
    public void registerUserWithAsRequestBody(String pathFile) {
        File json = new File(Constant.REQ_BODY + pathFile);
        RegisterAPI.setPostRegister(json);
    }

    @When("Send request register user")
    public void sendRequestRegisterUser() {
        SerenityRest.when().post(RegisterAPI.POST_REGISTER);
    }
}
