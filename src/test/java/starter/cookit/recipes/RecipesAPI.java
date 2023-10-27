package starter.cookit.recipes;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.cookit.auth.LoginAPI;
import starter.utils.Constant;

import java.io.File;

public class RecipesAPI {
    public static String GET_LIST_RECIPES = Constant.BASE_URL + "/recipes";

    public static String GET_RECIPE_DETAIL = Constant.BASE_URL + "/recipes/{recipe_id}/detail";

    public static String GET_RECIPES_TIMELINE = Constant.BASE_URL + "/users/recipes/timeline";

    public static String GET_RECIPE_TRENDING = Constant.BASE_URL + "/recipes/trending";

    public static String POST_CREATE_RECIPE = Constant.BASE_URL + "/recipes";

    public static String PUT_UPDATE_USERS_RECIPES = Constant.BASE_URL + "/recipes/{recipe_id}";

    @Step("Get first recipe id")
    public static String getFirstRecipeId(){
        String TOKEN = LoginAPI.getUserToken();
        return SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .queryParam("page", 1)
                .queryParam("limit", 1)
                .queryParam("status", "OpenForSale")
                .when().get(RecipesAPI.GET_LIST_RECIPES)
                .then().extract().response().jsonPath().getString("data[0].id");
    }

    @Step("Get steps in recipe detail")
    public static String getStepsInRecipeDetail(){
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();

        return SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .when().get(RecipesAPI.GET_LIST_RECIPES)
                .then().extract().response().jsonPath().getString("data.steps[0].id");
    }

    @Step("Get images in recipe detail")
    public static String getImagesInRecipeDetail(){
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();

        return SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .when().get(RecipesAPI.GET_LIST_RECIPES)
                .then().extract().response().jsonPath().getString("data.images[0].id");
    }

    @Step("Get ingredients in recipe detail")
    public static String getIngredientsInRecipeDetail(){
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();

        return SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .when().get(RecipesAPI.GET_LIST_RECIPES)
                .then().extract().response().jsonPath().getString("data.ingredients[0].id");
    }

    @Step("Get ingredient details in recipe detail")
    public static String getIngredientDetailsInRecipeDetail(){
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();

        return SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .when().get(RecipesAPI.GET_LIST_RECIPES)
                .then().extract().response().jsonPath().getString("data.ingredients[0].ingredient_details[0].id");
    }

    @Step("Get list of recipes")
    public static void setGetListOfRecipes(){
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON);
    }

    @Step("Get list of recipe with query param")
    public static void getLIstOfRecipeWithQueryParam(String page, String limit, String recipe_id, String user_id, String recipe_name, String type, String status){
        String TOKEN = LoginAPI.getUserToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .queryParam("page", page)
                .queryParam("limit", limit)
                .queryParam("id", recipe_id)
                .queryParam("user_id", user_id)
                .queryParam("name", recipe_name)
                .queryParam("type", type)
                .queryParam("status", status);
    }

    @Step("Get list of recipe without token")
    public static void getListOfRecipeWithoutToken(){
        SerenityRest.given()
                .contentType(ContentType.JSON);
    }

    @Step("Create new recipe")
    public static void postCreateNewRecipe(File json){
        String TOKEN = LoginAPI.getUserToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update user's recipes")
    public static void putUpdateUsersRecipes(File json){
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(json)
                .pathParam("recipe_id", RECIPE_ID);
    }

    @Step("Update user's recipes with id input manually")
    public static void putUpdateUsersRecipesWithIdInputManually(File json, String recipe_id){
        String TOKEN = LoginAPI.getUserToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(json)
                .pathParam("recipe_id", recipe_id);
    }

    @Step("Get recipe detail with id")
    public static void getRecipeDetailWithId(){
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID);
    }

    @Step("Get recipe detail with recipe_id isn't exists")
    public static void getRecipeDetailWithIdIsNotExists(String recipe_id){
        String TOKEN = LoginAPI.getUserToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", recipe_id);
    }

    @Step("Get list user's recipe timeline")
    public static void getListUsersRecipeTimeline(){
        String TOKEN = LoginAPI.getUserToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON);
    }

    @Step("Get list user's recipe timeline with query param")
    public static void getListUsersRecipeTimelineWithQueryParam(String page, String limit){
        String TOKEN = LoginAPI.getUserToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .queryParam("page", page)
                .queryParam("limit", limit);
    }

    @Step("Get list user's recipe timeline without token")
    public static void getListUsersRecipeTimelineWithoutToken(){
        SerenityRest.given()
                .contentType(ContentType.JSON);
    }

    @Step("Get list user's recipe trending")
    public static void getListUsersRecipeTrending(){
        String TOKEN = LoginAPI.getUserToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON);
    }

    @Step("Get list user's recipe trending with query param")
    public static void getListUsersRecipeTrendingWithQueryParam(String page, String limit){
        String TOKEN = LoginAPI.getUserToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .queryParam("page", page)
                .queryParam("limit", limit);
    }

    @Step("Get list user's recipe trending without token")
    public static void getListUsersRecipeTrendingWithoutToken(){
        SerenityRest.given()
                .contentType(ContentType.JSON);
    }
}
