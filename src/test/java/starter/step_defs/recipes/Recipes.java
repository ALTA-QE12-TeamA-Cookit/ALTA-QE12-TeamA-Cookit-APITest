package starter.step_defs.recipes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.auth.LoginAPI;
import starter.cookit.recipes.RecipesAPI;

public class Recipes {

//GET LIST OF RECIPES

    @Given("Get list of recipes")
    public void getListOfRecipes() {
        RecipesAPI.setGetListOfRecipes();
    }

    @When("Send request get list of recipes")
    public void sendRequestGetListOfRecipes() {
        SerenityRest.when().get(RecipesAPI.GET_LIST_RECIPES);
    }

//GET DETAIL OF RECIPE

    @Given("Get detail of recipes with recipe id")
    public void getDetailOfRecipesWithRecipeId() {
        RecipesAPI.getRecipeDetailWithId();
    }

    @When("Send request get detail recipe")
    public void sendRequestGetDetailRecipe() {
        SerenityRest.when().get(RecipesAPI.GET_RECIPE_DETAIL);
    }

// GET LIST OF RECIPE WITH QUERY

    @Given("Get list of recipes with query param {string} as page {string} as limit {string} as recipe_id {string} as user_id {string} as recipe_name {string} as type {string} as status")
    public void getListOfRecipesWithQueryParamAsPageAsLimitAsRecipe_idAsUser_idAsRecipe_nameAsTypeAsStatus(String page, String limit, String recipe_id, String user_id, String recipe_name, String type, String status) {
        RecipesAPI.getLIstOfRecipeWithQueryParam(page, limit, recipe_id, user_id, recipe_name, type, status);
    }

// GET LIST OF RECIPE WITHOUT TOKEN
    @Given("Get list of recipes without token")
    public void getListOfRecipesWithoutToken() {
        RecipesAPI.getListOfRecipeWithoutToken();
    }
}