package starter.cookit.recipes;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.cookit.auth.LoginAPI;
import starter.utils.Constant;

public class RecipesAPI {
    public static String GET_LIST_RECIPES = Constant.BASE_URL + "/recipes";

    public static String GET_RECIPE_DETAIL = Constant.BASE_URL + "/recipes/{recipe_id}/detail";

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

    @Step("Get recipe detail with id")
    public static void getRecipeDetailWithId(){
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID);
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
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        SerenityRest.given()
                .contentType(ContentType.JSON);
    }

}
