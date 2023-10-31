package starter.cookit.auth;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constant;

import java.io.File;

public class RegisterAPI {
    public static String POST_REGISTER = Constant.BASE_URL + "/register";

    @Step("Register user with all field is valid")
    public static void setPostRegister(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
