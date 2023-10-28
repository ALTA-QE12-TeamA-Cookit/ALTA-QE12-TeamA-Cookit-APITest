package starter.step_defs.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.steps.StepsAPI;
import starter.utils.Constant;

import java.io.File;

public class Steps {
    @Given("Create new steps with recipe id and {string} as request body")
    public void createNewStepsWithIdAndAsRequestBody(String pathFile) {
        File json = new File(Constant.REQ_BODY + pathFile);
        StepsAPI.createNewSteps(json);
    }

    @When("Send request post create new steps")
    public void sendRequestPostCreateNewSteps() {
        SerenityRest.when().post(StepsAPI.POST_CREATE_STEPS);
    }

    @Given("Create new steps with {string} as recipe id and {string} as request body")
    public void createNewStepsWithAsRecipeIdAndAsRequestBody(String recipe_id, String pathFile) {
        File json = new File(Constant.REQ_BODY + pathFile);
        StepsAPI.createNewStepsWithIdInputManually(recipe_id, json);
    }

    @Given("Update steps with recipe id and step id and {string} as request body")
    public void updateStepsWithRecipeIdAndStepIdAndAsRequestBody(String pathFile) {
        File json = new File(Constant.REQ_BODY + pathFile);
        StepsAPI.updateRecipeSteps(json);
    }

    @When("Send request put update steps")
    public void sendRequestPutUpdateSteps() {
        SerenityRest.when().put(StepsAPI.PUT_UPDATE_STEPS);
    }

    @Given("Update steps with recipe id and {string} as step id and {string} as request body")
    public void updateStepsWithRecipeIdAndAsStepIdAndAsRequestBody(String step_id, String pathFile) {
        File json = new File(Constant.REQ_BODY + pathFile);
        StepsAPI.updateStepsWithStepIdInputManually(step_id, json);
    }

    @Given("Delete steps with recipe id and step id")
    public void deleteStepsWithRecipeIdAndStepId() {
        StepsAPI.deleteRecipeStepsSpecifically();
    }

    @When("Send request delete steps specifically")
    public void sendRequestDeleteStepsSpecifically() {
        SerenityRest.when().delete(StepsAPI.DELETE_STEPS_SPECIFICALLY);
    }

    @Given("Delete steps with recipe id and step id without token")
    public void deleteStepsWithRecipeIdAndStepIdWithoutToken() {
        StepsAPI.deleteStepsSpecificallyWithoutToken();
    }

    @Given("Delete steps with recipe id and {string} as step id")
    public void deleteStepsWithRecipeIdAndAsStepId(String step_id) {
        StepsAPI.deleteStepsWithStepIdInputManuallySpecifically(step_id);
    }

    @Given("Delete steps with recipe id")
    public void deleteStepsWithRecipeId() {
        StepsAPI.deleteRecipeSteps();
    }

    @When("Send request delete steps")
    public void sendRequestDeleteSteps() {
        SerenityRest.when().delete(StepsAPI.DELETE_ALL_STEPS);
    }

    @Given("Delete steps with recipe id without token")
    public void deleteStepsWithRecipeIdWithoutToken() {
        StepsAPI.deleteRecipeStepsWithoutToken();
    }

    @Given("Delete steps with recipe id {string} as recipe_id")
    public void deleteStepsWithRecipeIdAsRecipe_id(String recipe_id) {
        StepsAPI.deleteRecipeStepsWithRecipeIdSetManually(recipe_id);
    }
}
