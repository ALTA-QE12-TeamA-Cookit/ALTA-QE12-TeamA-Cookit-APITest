package starter.cookit.steps;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.cookit.auth.LoginAPI;
import starter.cookit.recipes.RecipesAPI;
import starter.utils.Constant;

import java.io.File;

public class StepsAPI {

    public static String POST_CREATE_STEPS = Constant.BASE_URL + "/recipes/{recipe_id}/steps";

    public static String DELETE_ALL_STEPS = Constant.BASE_URL + "/recipes/{recipe_id}/steps";

    public static String PUT_UPDATE_STEPS = Constant.BASE_URL + "/recipes/{recipe_id}/steps/{step_id}";

    public static String DELETE_STEPS_SPECIFICALLY = Constant.BASE_URL + "/recipes/{recipe_id}/steps/{step_id}";

    @Step("Create new steps from recipe page")
    public static void createNewSteps(File json) {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .body(json);
    }

    @Step("Create new steps with id input manually")
    public static void createNewStepsWithIdInputManually(String recipe_id, File json) {
        String TOKEN = LoginAPI.getUserToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", recipe_id)
                .body(json);
    }

    @Step("Update recipe steps")
    public static void updateRecipeSteps(File json){
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String RECIPE_ID = GENERAL.getString("data.id");
        String STEP_ID = GENERAL.getString("data.steps[0].id");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("step_id", STEP_ID)
                .body(json);
    }

    @Step("Update steps with id input manually")
    public static void updateStepsWithStepIdInputManually(String step_id, File json) {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("step_id", step_id)
                .body(json);
    }

    @Step("Delete recipe steps specifically")
    public static void deleteRecipeStepsSpecifically(){
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String RECIPE_ID = GENERAL.getString("data.id");
        String STEP_ID = GENERAL.getString("data.steps[0].id");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("step_id", STEP_ID);
    }

    @Step("Delete steps specifically with id input manually")
    public static void deleteStepsWithStepIdInputManuallySpecifically(String step_id) {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("step_id", step_id);
    }

    @Step("Delete steps specifically without token")
    public static void deleteStepsSpecificallyWithoutToken() {
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String RECIPE_ID = GENERAL.getString("data.id");
        String STEP_ID = GENERAL.getString("data.steps[0].id");

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("step_id", STEP_ID);
    }

    @Step("Delete recipe steps")
    public static void deleteRecipeSteps(){
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID);
    }

    @Step("Delete recipe steps without token")
    public static void deleteRecipeStepsWithoutToken(){
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID);
    }

    @Step("Delete recipe steps with recipe id set manually")
    public static void deleteRecipeStepsWithRecipeIdSetManually(String recipe_id){
        String TOKEN = LoginAPI.getUserToken();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", recipe_id);
    }

}
