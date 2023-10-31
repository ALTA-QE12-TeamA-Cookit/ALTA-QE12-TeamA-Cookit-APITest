package starter.cookit.followers;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.cookit.auth.LoginAPI;
import starter.utils.Constant;

public class FollowersAPI {

    public static String POST_FOLLOW = Constant.BASE_URL + "/users/follow/{id}";

    public static String DELETE_UNFOLLOW = Constant.BASE_URL + "/users/unfollow/{id}";

    @Step("Following & Unfollowing users by id")
    public static void setFollowingUsersById(String id){
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("id", id);
    }
}
