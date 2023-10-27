package starter.step_defs.recipes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.auth.LoginAPI;
import starter.cookit.recipes.RecipesAPI;
import starter.utils.Constant;

import java.io.File;

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

// CREATE NEW RECIPES

    @Given("Create new recipes with {string} as req body")
    public void createNewRecipesWithAsReqBody(String pathFile) {
        File json = new File(Constant.REQ_BODY + pathFile);
        RecipesAPI.postCreateNewRecipe(json);
    }

    @When("Send request create new recipes")
    public void sendRequestCreateNewRecipes() {
        SerenityRest.when().post(RecipesAPI.POST_CREATE_RECIPE);
    }

// UPDATE USER'S RECIPES

    @Given("Update recipes with {string} as req body")
    public void updateRecipesWithAsReqBody(String pathFile) {
        File json = new File(Constant.REQ_BODY + pathFile);
        RecipesAPI.putUpdateUsersRecipes(json);
    }

    @When("Send request update users recipes")
    public void sendRequestUpdateUsersRecipes() {
        SerenityRest.when().put(RecipesAPI.PUT_UPDATE_USERS_RECIPES);
    }

    @Given("Update recipes with {string} as req body and {string}")
    public void updateRecipesWithAsReqBodyAnd(String pathFile, String recipe_id) {
        File json = new File(Constant.REQ_BODY + pathFile);
        RecipesAPI.putUpdateUsersRecipesWithIdInputManually(json, recipe_id);
    }

//DELETE USERS RECIPE

    @Given("Delete users recipe with id")
    public void deleteUsersRecipeWithId() {
        RecipesAPI.deleteUsersRecipeWithId();
    }

    @When("Send request delete users recipes")
    public void sendRequestDeleteUsersRecipes() {
        SerenityRest.when().delete(RecipesAPI.DELETE_USERS_RECIPES);
    }

    @Given("Delete users recipe with {string} as id")
    public void deleteUsersRecipeWithAsId(String recipe_id) {
        RecipesAPI.deleteusersRecipeWithIdSetManually(recipe_id);
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

    @Given("Get detail of recipes with recipe_id {string}")
    public void getDetailOfRecipesWithRecipe_idIsnTExists(String recipe_id) {
        RecipesAPI.getRecipeDetailWithIdIsNotExists(recipe_id);
    }


// GET RECIPE TIMELINE

    @Given("Get list of recipes timeline")
    public void getListOfRecipesTimeline() {
        RecipesAPI.getListUsersRecipeTimeline();
    }

    @When("Send request get list of recipes timeline")
    public void sendRequestGetListOfRecipesTimeline() {
        SerenityRest.when().get(RecipesAPI.GET_RECIPES_TIMELINE);
    }

    @Given("Get list of recipes timeline with {string} as page {string} as limit")
    public void getListOfRecipesTimelineWithAsPageAsLimit(String page, String limit) {
        RecipesAPI.getListUsersRecipeTimelineWithQueryParam(page, limit);
    }

    @Given("Get list of recipes timeline without token")
    public void getListOfRecipesTimelineWithoutToken() {
        RecipesAPI.getListUsersRecipeTimelineWithoutToken();
    }

    @Given("Get list users recipe trending")
    public void getListUsersRecipeTrending() {
        RecipesAPI.getListUsersRecipeTrending();
    }

    @When("Send request get list users trending")
    public void sendRequestGetListUsersTrending() {
        SerenityRest.when().get(RecipesAPI.GET_RECIPE_TRENDING);
    }

    @Given("Get list of recipes trending with {string} as page {string} as limit")
    public void getListOfRecipesTrendingWithAsPageAsLimit(String page, String limit) {
        RecipesAPI.getListUsersRecipeTrendingWithQueryParam(page, limit);
    }

    @Given("Get list of recipes trending without token")
    public void getListOfRecipesTrendingWithoutToken() {
        RecipesAPI.getListUsersRecipeTrendingWithoutToken();
    }
}