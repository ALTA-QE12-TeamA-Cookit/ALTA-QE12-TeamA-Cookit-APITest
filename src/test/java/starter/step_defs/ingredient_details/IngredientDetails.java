package starter.step_defs.ingredient_details;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.ingredient_details.IngredientDetailsAPI;
import starter.utils.Constant;

import java.io.File;

public class IngredientDetails {
//    Create ingredient details with all valid param and body
    @Given("Create ingredient detail with valid recipe_id, valid ingredient_id and valid {string}")
    public void createIngredientDetailWithValidRecipe_idValidIngredient_idAndValid(String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        IngredientDetailsAPI.setInsertNewRecipesIngredientDetails(json);
    }

    @When("Send create ingredient detail with valid recipe_id and ingredient_id")
    public void sendCreateIngredientDetailWithValidRecipe_idValidIngredient_idAndValidBody() {
        SerenityRest.when().post(IngredientDetailsAPI.CREATE_INGREDIENT_DETAILS);
    }

//    Create ingredient details with exceed recipe ID and body
    @Given("Create ingredient detail with exceed {string}, valid ingredient_id and valid {string}")
    public void createIngredientDetailWithExceedValidIngredient_idAndValid(String recipeID, String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        IngredientDetailsAPI.setInsertNewRecipesIngredientDetailsExceedRecipeID(recipeID, json);
    }

//    Create ingredient details with exceed ingredient ID and body
    @Given("Create ingredient detail with valid recipe_id, exceed {string} and valid {string}")
    public void createIngredientDetailWithValidRecipe_idExceedAndValid(String ingredientID, String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        IngredientDetailsAPI.setInsertNewRecipesIngredientDetailsExceedIngredientID(ingredientID, json);
    }

//        Create ingredient details with blank body
    @Given("Create ingredient detail with valid recipe_id, valid ingredient_id and blank {string}")
    public void createIngredientDetailWithValidRecipe_idValidIngredient_idAndBlank(String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        IngredientDetailsAPI.setInsertNewRecipesIngredientDetails(json);
    }

//      Create ingredient details with ingredient details ID all valid param and body
    @Given("Update ingredient detail with valid recipe_id, valid ingredient_detail_id and valid {string}")
    public void updateIngredientDetailWithValidRecipe_idValidIngredient_detail_idAndValid(String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        IngredientDetailsAPI.setUpdateRecipesIngredientDetailsAllValidParam(json);
    }

    @When("Send update ingredient detail with valid recipe_id and valid ingredient_detail_id")
    public void sendUpdateIngredientDetailWithValidRecipe_idAndValidIngredient_detail_id() {
        SerenityRest.when().put(IngredientDetailsAPI.UPDATE_INGREDIENT_DETAIL_WHIT_ID);
    }
}
