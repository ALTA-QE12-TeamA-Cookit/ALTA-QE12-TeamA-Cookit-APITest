package starter.step_defs.ingredients;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.ingredients.IngredientsAPI;
import starter.utils.Constant;

import java.io.File;

public class Ingredients {

//    Create new ingredients with valid id and valid req body
    @Given("Create ingredient with valid recipe_id and valid {string}")
    public void createIngredientWithValidRecipe_idAndValid(String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        IngredientsAPI.setInsertNewRecipesIngredient(json);
    }

    @When("Send create ingredient with valid recipe_id and valid body")
    public void sendCreateIngredientWithValidRecipe_idAndValidBody() {
        SerenityRest.when().post(IngredientsAPI.CREATE_NEW_INGREDIENT);
    }

//    Create new ingredients with valid id and invalid req body
    @Given("Create ingredient with valid recipe_id and invalid {string}")
    public void createIngredientWithValidRecipe_idAndInvalid(String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        IngredientsAPI.setInsertNewRecipesIngredient(json);
    }

    @When("Send create ingredient with valid recipe_id and invalid body")
    public void sendCreateIngredientWithValidRecipe_idAndInvalidBody() {
        SerenityRest.when().post(IngredientsAPI.CREATE_NEW_INGREDIENT);
    }

//    Delete ingredient with valid recipe_id
    @Given("Delete ingredient with valid recipe_id")
    public void deleteIngredientWithValidRecipe_id() {
        IngredientsAPI.setDeleteIngredientWithValidRecipeId();
    }

    @When("Send delete ingredient with valid recipe_id")
    public void sendDeleteIngredientWithValidRecipe_id() {
        SerenityRest.when().delete(IngredientsAPI.CREATE_NEW_INGREDIENT);
    }

//    Delete ingredient with exceed recipe_id
    @Given("Delete ingredient with exceed {string}")
    public void deleteIngredientWithExceed(String recipeID) {
        IngredientsAPI.setDeleteIngredientExceedId(recipeID);
    }

    @When("Send delete ingredient with exceed recipe_id")
    public void sendDeleteIngredientWithExceedRecipe_id() {
        SerenityRest.when().delete(IngredientsAPI.CREATE_NEW_INGREDIENT);
    }

    //    Update ingredient with valid recipe_id, valid ingredient_id and valid body
    @Given("Update ingredient with valid recipe_id, valid ingredient_id and valid {string}")
    public void updateIngredientWithValidValidAndValid(String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        IngredientsAPI.setUpdateIngredientAllValid(json);
    }

    @When("Send update ingredient with valid recipe_id, valid ingredient_id and valid body")
    public void sendUpdateIngredientWithValidRecipe_idValidIngredient_idAndValidBody() {
        SerenityRest.when().put(IngredientsAPI.UPDATE_RECIPES_INGREDIENT);
    }

//    Update ingredient with exceed recipe_id, valid ingredient_id and valid body
    @Given("Update ingredients with exceed recipe_id {string} valid req body {string}")
    public void updateIngredientsWithExceedRecipe_idValidReqBody(String recipeID, String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        IngredientsAPI.setUpdateIngredientExceedIngredientID(recipeID, json);
    }

    @When("Send update ingredient with exceed recipe_id, valid ingredient_id and valid body")
    public void sendUpdateIngredientWithExceedRecipe_idValidIngredient_idAndValidBody() {
        SerenityRest.when().put(IngredientsAPI.UPDATE_RECIPES_INGREDIENT);
    }

//    Update ingredient with valid recipe_id, exceed ingredient_id and valid body

    @Given("Update ingredient with valid recipe_id, exceed ingredient_id {string} and valid {string}")
    public void updateIngredientWithValidRecipe_idExceedAndValid(String ingredientID, String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        IngredientsAPI.setUpdateIngredientExceedIngredientID(ingredientID, json);
    }

    @When("Send update ingredient with valid recipe_id, exceed ingredient_id and valid body")
    public void sendUpdateIngredientWithValidRecipe_idExceedIngredient_idAndValidBody() {
        SerenityRest.when().put(IngredientsAPI.UPDATE_RECIPES_INGREDIENT);
    }

//      Update ingredient with blank body
    @Given("Update ingredient with valid recipe_id, valid ingredient_id and blank {string}")
    public void updateIngredientWithValidRecipe_idValidIngredient_idAndBlank(String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        IngredientsAPI.setUpdateIngredientAllValid(json);
    }

    @When("Send update ingredient with valid recipe_id, valid ingredient_id and blank body")
    public void sendUpdateIngredientWithValidRecipe_idValidIngredient_idAndBlankBody() {
        SerenityRest.when().put(IngredientsAPI.UPDATE_RECIPES_INGREDIENT);
    }

//    Delete ingredient with valid recipe_id and valid ingredient_id
    @Given("Delete ingredient with valid recipe_id and valid ingredient_id")
    public void deleteIngredientWithValidRecipe_idAndValidIngredient_id() {
        IngredientsAPI.setDeleteIngredientWithAllValidParam();
    }

    @When("Send delete ingredient with valid recipe_id and valid ingredient_id")
    public void sendDeleteIngredientWithValidRecipe_idAndValidIngredient_id() {
        SerenityRest.when().delete(IngredientsAPI.UPDATE_RECIPES_INGREDIENT);
    }
}
