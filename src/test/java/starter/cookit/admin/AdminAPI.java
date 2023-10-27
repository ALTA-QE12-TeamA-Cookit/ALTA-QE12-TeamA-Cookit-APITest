package starter.cookit.admin;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.cookit.auth.LoginAPI;
import starter.utils.Constant;

public class AdminAPI {

    public static String GET_VERIFY_USER = Constant.BASE_URL + "/users/listverify";

    public static String PUT_UPDATE_USER_ROLE = Constant.BASE_URL + "/users/approval/{id}";

//    GET ALL LIST USERS VERIFY
    @Step("Get all list users verify")
    public static void setGetAllUsersVerify() {
        String ADMIN_TOKEN = LoginAPI.getAdminToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + ADMIN_TOKEN)
                .contentType(ContentType.JSON);
    }
}
