package starter.step_defs.recipes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
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
}
