package starter.step_defs.images;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.images.ImagesAPI;
import starter.utils.Constant;

import java.io.File;

public class Images {

//    Insert image into recipe with valid id
    @Given("Insert image into recipe with {string} as file recipe_id as id")
    public void insertImageIntoRecipeWithAsFileRecipe_idAsId(String imageFile) {
        File images = new File(Constant.IMAGE_DATA + imageFile);
        ImagesAPI.setInsertNewImageWithValidId(images);
    }

    @When("Send request insert image into recipe")
    public void sendRequestInsertImageIntoRecipe() {
        SerenityRest.when().post(ImagesAPI.POST_IMAGES);
    }

//    Insert image into recipe with id isn't exists
    @Given("Insert image into recipe with image as file {string} as id")
    public void insertImageIntoRecipeWithAsFileAsId(String recipeID) {
        ImagesAPI.setInsertImageWithRecipeIDInstExist(recipeID);
    }

//    Insert image into recipe without token
    @Given("Insert image into recipe with image as file recipe_id as id without token")
    public void insertImageIntoRecipeWithImageAsFileRecipe_idAsIdWithoutToken() {
        ImagesAPI.setInsertImageWithoutToken();
    }

//    Delete recipe images with valid id
    @Given("Delete image into recipe with recipe_id as id")
    public void deleteImageIntoRecipeWithAsId() {
        ImagesAPI.userDeleteImageRecipeWithValidRecipeID();
    }

    @When("Send request delete image into recipe")
    public void sendRequestDeleteImageIntoRecipe() {
        SerenityRest.when().delete(ImagesAPI.POST_IMAGES);
    }

    //    Delete recipe images isn't available valid id
    @Given("Delete image into recipe with {string} as id")
    public void deleteImageIntoRecipeWithAsId(String recipeID) {
        ImagesAPI.userDeleteImageRecipeWithInvalidRecipeID(recipeID);
    }
}
