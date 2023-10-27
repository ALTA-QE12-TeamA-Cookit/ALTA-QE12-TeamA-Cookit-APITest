package starter.cookit.admin;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.cookit.auth.LoginAPI;
import starter.cookit.users.UsersAPI;
import starter.utils.Constant;

import java.io.File;

public class AdminAPI {

    public static String GET_LIST_VERIFY_USER = Constant.BASE_URL + "/users/listverify";

    public static String PUT_UPDATE_USER_ROLE = Constant.BASE_URL + "/users/approval/{id}";

//    GET ALL LIST USERS VERIFY
    @Step("Get all list users verify")
    public static void setGetAllUsersVerify() {
        String ADMIN_TOKEN = LoginAPI.getAdminToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + ADMIN_TOKEN)
                .contentType(ContentType.JSON);
    }

    @Step("Update user role with valid user_id and valid reqBody")
    public static void setPutUpdateUserRole(File json) {
        String ADMIN_TOKEN = LoginAPI.getAdminToken();
        String USER_REQ_VERIFY_ID = UsersAPI.setGetUserIdByAdmin();
        SerenityRest.given()
                .header("Authorization", "Bearer " + ADMIN_TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("id", USER_REQ_VERIFY_ID)
                .body(json);
    }

    @Step("Update user role with exceed user_id and valid reqBody")
    public static void setUpdateRoleExceedID(String userID, File json) {
        String ADMIN_TOKEN = LoginAPI.getAdminToken();SerenityRest.given()
                .header("Authorization", "Bearer " + ADMIN_TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("id", userID)
                .body(json);
    }

    @Step("Update users role for verify user with valid user_id and invalid body")
    public static void setUpdateRoleInvalidReqBody(File json) {
        String ADMIN_TOKEN = LoginAPI.getAdminToken();
        String USER_REQ_VERIFY_ID = UsersAPI.setGetUserIdByAdmin();
        SerenityRest.given()
                .header("Authorization", "Bearer " + ADMIN_TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("id", USER_REQ_VERIFY_ID)
                .body(json);
    }
}
