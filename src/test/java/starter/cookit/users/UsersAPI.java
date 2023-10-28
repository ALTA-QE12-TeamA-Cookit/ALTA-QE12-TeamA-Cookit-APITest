package starter.cookit.users;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.cookit.auth.LoginAPI;
import starter.utils.Constant;

import java.io.File;

public class UsersAPI {

    public static String GET_USERS = Constant.BASE_URL + "/users";

    public static String GET_USER_BY_USERNAME = Constant.BASE_URL + "/users/search";

    public static String PUT_USER_PASSWORD = Constant.BASE_URL + "/users/password";

    public static String GET_USERS_BY_ID = Constant.BASE_URL + "/users/{id}";

    public static String GET_LIST_USER_FOLLOWERS = Constant.BASE_URL + "/users/follower";

    public static String GET_LIST_USER_FOLLOWING = Constant.BASE_URL + "/users/following";

    public static String POST_REQUEST_UPGRADE_ACCOUNT = Constant.BASE_URL + "/users/upgrade";

    @Step("Get users")
    public static void getUsers(){
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON);

    }

    @Step("Update user profile")
    public static void setUpdateUsers(File json) {
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Search user by username")
    public static void setGetUserByUsername(String username){
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer" + TOKEN)
                .contentType(ContentType.JSON)
                .queryParam("q", username);
    }


    @Step("Edit user password")
    public static void setEditUserPassword(File json){
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer" + TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get user by user id")
    public static void setGetUserById(String id){
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("id", id);
    }

    @Step("Get user by user id without token")
    public static void setGetUsersByIdWithoutToken(String id){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .pathParam("id", id);
    }

    @Step("Get list of user followers")
    public static void setGetListOfUserFollowers(){
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON);
    }

    @Step("Get list of user followers without token")
    public static void setGetListOfUserFollowersWithoutToken(){
        SerenityRest.given()
                .contentType(ContentType.JSON);
    }

    @Step("Get list of user following")
    public static void setGetListOfUserFollowing(){
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON);
    }

    @Step("Get list of user following without token")
    public static void setGetListOfUserFollowingWithoutToken(){
        SerenityRest.given()
                .contentType(ContentType.JSON);
    }

    @Step("Post request upgrade account to admin")
    public static void setPostRequestUpgradeAccountToAdmin(){
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON);
    }
}
