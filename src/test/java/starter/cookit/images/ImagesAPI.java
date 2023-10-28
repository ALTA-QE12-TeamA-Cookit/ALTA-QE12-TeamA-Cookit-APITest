package starter.cookit.images;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.cookit.auth.LoginAPI;
import starter.cookit.recipes.RecipesAPI;
import starter.utils.Constant;

import java.io.File;

public class ImagesAPI {

    public static String POST_IMAGES = Constant.BASE_URL + "/recipes/{recipe_id}/images";

    @Step("User upload image with valid recipe_id")
    public static void setInsertNewImageWithValidId(File imageFile) {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("recipe_id", RECIPE_ID)
                .multiPart("image", imageFile);
    }

    @Step("User upload image with recipe_id isn't exist")
    public static void setInsertImageWithRecipeIDInstExist(String recipeID) {
        String TOKEN = LoginAPI.getUserToken();
        File images = new File(Constant.IMAGE_DATA + "cake.jpg");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("recipe_id", recipeID)
                .multiPart("image", images);
    }

    @Step("User upload image without token")
    public static void setInsertImageWithoutToken() {
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        File images = new File(Constant.IMAGE_DATA + "cake.jpg");
        SerenityRest.given()
                .pathParam("recipe_id", RECIPE_ID)
                .multiPart("image", images);
    }

    @Step("User delete image with valid recipe_id")
    public static void userDeleteImageRecipeWithValidRecipeID() {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("recipe_id", RECIPE_ID)
                .contentType(ContentType.JSON);
    }

    @Step("User delete image with isnt avail recipe_id")
    public static void userDeleteImageRecipeWithInvalidRecipeID(String recipeID) {
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("recipe_id", recipeID)
                .contentType(ContentType.JSON);
    }

    @Step("User update ingredient with valid all ID param")
    public static void userUpdateIngredientWithAllValidParam(File imageFile) {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String IMAGE_ID = GENERAL.getString("data.images[0].id");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("image_id", IMAGE_ID)
                .multiPart("image", imageFile);
    }

    @Step("User delete image with valid all ID param")
    public static void userDeleteImageRecipeWithValidParam() {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String IMAGE_ID = GENERAL.getString("data.images[0].id");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("image_id", IMAGE_ID)
                .contentType(ContentType.JSON);
    }
}
