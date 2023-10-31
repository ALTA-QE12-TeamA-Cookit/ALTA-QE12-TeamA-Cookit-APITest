package starter.cookit.ingredient_details;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.cookit.auth.LoginAPI;
import starter.cookit.ingredients.IngredientsAPI;
import starter.cookit.recipes.RecipesAPI;
import starter.utils.Constant;

import java.io.File;

public class IngredientDetailsAPI {

    public static String CREATE_INGREDIENT_DETAILS = Constant.BASE_URL + "/recipes/{recipe_id}/ingredients/{ingredient_id}/ingredientDetails";

    public static String UPDATE_INGREDIENT_DETAIL_WHIT_ID = Constant.BASE_URL + "/recipes/{recipe_id}/ingredients/ingredientDetails/{ingredient_detail_id}";

//  Create
    @Step("Insert new recipes ingredient detail with valid recipes_id, ingredient_id and valid req body")
    public static void setInsertNewRecipesIngredientDetails(File json) {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String RECIPE_ID = GENERAL.getString("data.id");
        String INGREDIENT_ID = GENERAL.getString("data.ingredients[0].id");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("ingredient_id", INGREDIENT_ID)
                .body(json);
    }

    @Step("Insert new recipes ingredient detail with valid recipes_id, ingredient_id and valid req body")
    public static void setInsertNewRecipesIngredientDetailsExceedRecipeID(String recipeID, File json) {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String INGREDIENT_ID = GENERAL.getString("data.ingredients[0].id");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", recipeID)
                .pathParam("ingredient_id", INGREDIENT_ID)
                .body(json);
    }

    @Step("Insert new recipes ingredient detail with valid recipes_id, exceed ingredient_id and valid req body")
    public static void setInsertNewRecipesIngredientDetailsExceedIngredientID(String ingredientID, File json) {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String RECIPE_ID = GENERAL.getString("data.id");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("ingredient_id", ingredientID)
                .body(json);
    }

//    Update
    @Step("Update recipes ingredient detail with valid recipes_id, ingredient_detail_id and valid req body")
    public static void setUpdateRecipesIngredientDetailsAllValidParam(File json) {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String RECIPE_ID = GENERAL.getString("data.id");
        String INGREDIENT_DETAIL_ID = GENERAL.getString("data.ingredients[0].ingredient_details[0].id");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("ingredient_detail_id", INGREDIENT_DETAIL_ID)
                .body(json);
    }

    @Step("Update recipes ingredient detail with exceed recipes_id, ingredient_detail_id and valid req body")
    public static void setUpdateRecipesIngredientDetailsExceedRecipeID(String recipeID, File json) {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String INGREDIENT_DETAIL_ID = GENERAL.getString("data.ingredients[0].ingredient_details[0].id");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", recipeID)
                .pathParam("ingredient_detail_id", INGREDIENT_DETAIL_ID)
                .body(json);
    }

    @Step("Update recipes ingredient detail with valid recipes_id, exceed ingredient_detail_id and valid req body")
    public static void setUpdateRecipesIngredientDetailsExceedIngredientDetailID(String ingredientDetailID, File json) {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String RECIPE_ID = GENERAL.getString("data.id");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("ingredient_detail_id", ingredientDetailID)
                .body(json);
    }

    //    Delete
    @Step("Delete recipes ingredient detail with valid recipes_id and ingredient_detail_id")
    public static void setDeleteRecipesIngredientDetailsAllValidParam() {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String RECIPE_ID = GENERAL.getString("data.id");
        String INGREDIENT_DETAIL_ID = GENERAL.getString("data.ingredients[0].ingredient_details[0].id");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("ingredient_detail_id", INGREDIENT_DETAIL_ID);
    }

    @Step("Delete recipes ingredient detail with exceed recipes_id and valid ingredient_detail_id")
    public static void setDeleteRecipesIngredientDetailsExceedRecipeID(String recipeID) {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String INGREDIENT_DETAIL_ID = GENERAL.getString("data.ingredients[0].ingredient_details[0].id");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", recipeID)
                .pathParam("ingredient_detail_id", INGREDIENT_DETAIL_ID);
    }

    @Step("Delete recipes ingredient detail with valid recipes_id and exceed ingredient_detail_id")
    public static void setDeleteRecipesIngredientDetailsExceedIngredientDetailID(String ingredientDetailID) {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String RECIPE_ID = GENERAL.getString("data.id");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("ingredient_detail_id", ingredientDetailID);
    }

    @Step("Delete recipes ingredient detail with all aphabet param ID")
    public static void setDeleteRecipesIngredientDetailsAlphabetParamID(String recipeID, String ingredientDetailID) {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", recipeID)
                .pathParam("ingredient_detail_id", ingredientDetailID);
    }
}
