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

//  Update image by all valid param ID
    @Given("Update image into recipe with {string} as file recipe_id as recipe_id image_id as image_id")
    public void updateImageIntoRecipeWithAsFileRecipe_idAsRecipe_idImage_idAsImage_id(String imageFile) {
        File images = new File(Constant.IMAGE_DATA + imageFile);
        ImagesAPI.userUpdateIngredientWithAllValidParam(images);
    }

    @When("Send request update image into recipe")
    public void sendRequestUpdateImageIntoRecipe() {
        SerenityRest.when().put(ImagesAPI.UPDATE_IMAGE_BY_IMAGE_ID);
    }

    //  Update image recipe ID isn't available
    @Given("Update image into recipe with image as file recipe_id as recipe_id {string} as image_id")
    public void updateImageIntoRecipeWithImageAsFileRecipe_idAsRecipe_idAsImage_id(String recipeID) {
        ImagesAPI.updateImageWithInvalidRecipesID(recipeID);
    }

    //  Update image without key image or blank body req
    @Given("Update image into recipe without key image as file recipe_id as recipe_id image_id as image_id")
    public void updateImageIntoRecipeWithoutKeyImageAsFileRecipe_idAsRecipe_idImage_idAsImage_id() {
        ImagesAPI.userUpdateIngredientWithoutKeyImage();
    }

    @Given("Update image into recipe without image as file recipe_id as recipe_id image_id as image_id")
    public void updateImageIntoRecipeWithoutImageAsFileRecipe_idAsRecipe_idImage_idAsImage_id() {
        ImagesAPI.userUpdateIngredientWithoutKeyImage();
    }

//     Update image without token
    @Given("Update image into recipe with {string} as file recipe_id as recipe_id image_id as image_id without token")
    public void updateImageIntoRecipeWithAsFileRecipe_idAsRecipe_idImage_idAsImage_idWithoutToken(String imageFile) {
        File images = new File(Constant.IMAGE_DATA + imageFile);
        ImagesAPI.userUpdateIngredientWithoutToken(images);
    }

    //     Delete image with all valid param
    @Given("Delete specific image into recipe with recipe_id as recipe_id and image_id as image_id")
    public void deleteSpecificImageIntoRecipeWithAsRecipe_idAsImage_id() {
        ImagesAPI.userDeleteImageRecipeWithValidParam();
    }

    @When("Send request delete specific image into recipe")
    public void sendRequestDeleteSpecificImageIntoRecipe() {
        SerenityRest.when().delete(ImagesAPI.UPDATE_IMAGE_BY_IMAGE_ID);
    }

//     Delete image with image ID not available
    @Given("Delete specific image into recipe with recipe_id as recipe_id {string} as image_id")
    public void deleteSpecificImageIntoRecipeWithRecipe_idAsRecipe_idAsImage_id(String imageID) {
        ImagesAPI.userDeleteImageRecipeWithUnavailImageID(imageID);
    }

//     Delete image without token
    @Given("Delete specific image into recipe with recipe_id as recipe_id image_id as image_id without token")
    public void deleteSpecificImageIntoRecipeWithRecipe_idAsRecipe_idImage_idAsImage_idWithoutToken() {
        ImagesAPI.userDeleteImageRecipeWithoutToken();
    }
}
