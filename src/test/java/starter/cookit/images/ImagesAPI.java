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

    public static String UPDATE_IMAGE_BY_IMAGE_ID = Constant.BASE_URL + "/recipes/{recipe_id}/images/{image_id}";

//    Post Image
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

//    Delete image by recipe ID
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

//    Update image by recipe ID and image ID
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

    @Step("User update image by recipe id isn't available")
    public static void updateImageWithInvalidRecipesID(String recipeID) {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String IMAGE_ID = GENERAL.getString("data.images[0].id");
        File images = new File(Constant.IMAGE_DATA + "cake.jpg");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("recipe_id", recipeID)
                .pathParam("image_id", IMAGE_ID)
                .multiPart("image", images);
    }

    @Step("User update image by image id isn't available")
    public static void updateImageWithInvalidImageID(String imageID) {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        File images = new File(Constant.IMAGE_DATA + "cake.jpg");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("image_id", imageID)
                .multiPart("image", images);
    }

    @Step("User update ingredient without key image")
    public static void userUpdateIngredientWithoutKeyImage() {
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

    @Step("User update ingredient without token")
    public static void userUpdateIngredientWithoutToken(File imageFile) {
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String IMAGE_ID = GENERAL.getString("data.images[0].id");

        SerenityRest.given()
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("image_id", IMAGE_ID)
                .multiPart("image", imageFile);
    }

//    Delete image by recipe ID and image ID
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
    @Step("User delete image with unavailable image_id")
    public static void userDeleteImageRecipeWithUnavailImageID(String imageID) {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("image_id", imageID)
                .contentType(ContentType.JSON);
    }

    @Step("User delete image without token")
    public static void userDeleteImageRecipeWithoutToken() {
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String IMAGE_ID = GENERAL.getString("data.images[0].id");

        SerenityRest.given()
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("image_id", IMAGE_ID)
                .contentType(ContentType.JSON);
    }

}
