package starter.cookit.auth;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Test;
import starter.utils.Constant;

import java.io.File;

public class LoginAPI {

    public static String POST_LOGIN = Constant.BASE_URL + "/login";

    @Step("Get user token")
    public static String getUserToken(){
        File json = new File(Constant.REQ_BODY+"auth/LoginUserWithRegisteredAccountAndAllFieldIsValid.json");
        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .when().post(POST_LOGIN)
                .then().extract().response().jsonPath().getString("data.token");
    }

    @Step("Login")
    public static void setPostLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get admin token")
    public static String getAdminToken() {
        File json = new File(Constant.REQ_BODY+"admin/LoginAdmin.json");
        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json).when().post(POST_LOGIN)
                .then().extract().response().jsonPath().getString("data.token");
    }

}
