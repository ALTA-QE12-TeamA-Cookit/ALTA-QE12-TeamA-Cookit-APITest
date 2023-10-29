package starter.cookit.carts;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.cookit.auth.LoginAPI;
import starter.utils.Constant;

import java.io.File;

public class CartsAPI {

    public static String CREATE_NEW_CARTS = Constant.BASE_URL + "/users/carts";

    @Step("Create new carts")
    public static void createPostCarts(File json) {
        String TOKEN = LoginAPI.getUserToken();

        SerenityRest.given()
                            .header("Authorization", "Bearer " + TOKEN)
                            .contentType(ContentType.JSON)
                            .body(json);
    }

    @Step("Get list new create")
    public static void getListUsersCarts() {
        String TOKEN = LoginAPI.getUserToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON);
    }

    @Step("Get list exceed page path param")
    public static void getListUsersCartsExceedPathParam(String pageParam) {
        String TOKEN = LoginAPI.getUserToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .queryParam("page", pageParam)
                .contentType(ContentType.JSON);
    }

    @Step("Get list exceed limit path param")
    public static void getListUsersCartsExceedLimitPathParam(String limitParam) {
        String TOKEN = LoginAPI.getUserToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .queryParam("limit", limitParam)
                .contentType(ContentType.JSON);
    }
}
