package starter.cookit.comments;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.cookit.auth.LoginAPI;
import starter.cookit.recipes.RecipesAPI;
import starter.utils.Constant;

import java.io.File;

public class CommentsAPI {

    public static String GET_LIST_COMMENTS = Constant.BASE_URL + "/recipes/{recipe_id}/comments";

    public static String UPDATE_COMMENT_WITH_COMMENT_ID = Constant.BASE_URL + "/recipes/{recipe_id}/comments/{comment_id}";

//    Get comment ID
    @Step("Get comment ID")
    public static String getFirstCommentID() {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        return SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .when().get(CommentsAPI.GET_LIST_COMMENTS)
                .then().extract().response().jsonPath().getString("data[0].id");
    }

//    Get list comments in recipe
    @Step("Get list comments in recipe with recipe_id")
    public static void setGetListCommentsWithRecipeID() {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID);
    }

//   Get list comments in recipe exceed ID
    @Step("Get list comments in recipe with exceed recipe_id")
    public static void setGetListCommentsWithExceedRecipeID(String recipeID) {
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
            .header("Authorization", "Bearer " + TOKEN)
            .contentType(ContentType.JSON)
            .pathParam("recipe_id", recipeID);
    }

    @Step("Create comments in recipe with all valid param")
    public static void createCommentWithAllValidParam(File imageFile) {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("recipe_id", RECIPE_ID)
                .multiPart("comment", "ini enak lhooo")
                .multiPart("image", imageFile);
    }

    @Step("Create comments with exceed recipe ID")
    public static void createCommentWithExceedRecipeID(String recipeID) {
        String TOKEN = LoginAPI.getUserToken();
        File images = new File(Constant.IMAGE_DATA + "salad.jpg");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("recipe_id", recipeID)
                .multiPart("comment", "ini enak lhooo")
                .multiPart("image", images);
    }

//    Update comments with recipe and comment id
    @Step("Update comment with all valid param")
    public static void updateCommentWithAllValidParam() {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        String COMMENT_ID = CommentsAPI.getFirstCommentID();
        File images = new File(Constant.IMAGE_DATA + "salad.jpg");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("comment_id", COMMENT_ID)
                .pathParam("recipe_id", RECIPE_ID)
                .multiPart("comment", "ini enak lhooo")
                .multiPart("image", images);
    }

//    Update comment whit exceed recipe id
    @Step("Update comment with all valid param")
    public static void updateCommentWithExceedRecipeID(String recipeID) {
        String TOKEN = LoginAPI.getUserToken();
        String COMMENT_ID = CommentsAPI.getFirstCommentID();
        File images = new File(Constant.IMAGE_DATA + "salad.jpg");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("comment_id", COMMENT_ID)
                .pathParam("recipe_id", recipeID)
                .multiPart("comment", "ini enak lhooo")
                .multiPart("image", images);
    }

    @Step("Update comment with exceed comment ID")
    public static void updateCommentWithExceedCommentID(String commentID) {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        File images = new File(Constant.IMAGE_DATA + "salad.jpg");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("comment_id", commentID)
                .pathParam("recipe_id", RECIPE_ID)
                .multiPart("comment", "ini enak lhooo")
                .multiPart("image", images);
    }
}
