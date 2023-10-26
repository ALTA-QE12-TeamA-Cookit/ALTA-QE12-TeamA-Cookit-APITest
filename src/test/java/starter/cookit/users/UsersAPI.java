package starter.cookit.users;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.cookit.auth.LoginAPI;
import starter.utils.Constant;

public class UsersAPI {
    public static String GET_USERS_BY_ID = Constant.BASE_URL + "/users/{id}";

    @Step("Get user by user id")
    public static void setGetUserById(int id){
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("id", id);
    }
}
