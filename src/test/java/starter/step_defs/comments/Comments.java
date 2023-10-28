package starter.step_defs.comments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.comments.CommentsAPI;
import starter.utils.Constant;

import java.io.File;

public class Comments {

//    Get list comments in recipe
    @Given("List recipe comments with valid recipe_id")
    public void listRecipeCommentsWithValidRecipe_id() {
        CommentsAPI.setGetListCommentsWithRecipeID();
    }

    @When("Send list recipe comments with recipe_id")
    public void sendListRecipeCommentsWithValidRecipe_id() {
        SerenityRest.when().get(CommentsAPI.GET_LIST_COMMENTS);
    }

    //    Get list comments in recipe with exceed ID
    @Given("List recipe comments with exceed {string}")
    public void listRecipeCommentsWithExceed(String recipeID) {
        CommentsAPI.setGetListCommentsWithExceedRecipeID(recipeID);
    }

    //    Create comments in recipe with all param valid
    @Given("Create comments with valid recipe_id and valid reqBody {string}")
    public void createCommentsWithValidRecipe_idAndValidReqBody(String imageFile) {
        File images = new File(Constant.IMAGE_DATA + imageFile);
        CommentsAPI.createCommentWithAllValidParam(images);
    }

    @When("Send create comments with recipe_id")
    public void sendCreateCommentsWithValidRecipe_idAndValidRequestBody() {
        SerenityRest.when().post(CommentsAPI.GET_LIST_COMMENTS);
    }
//  Create comment with exceed ID
    @Given("Create comments with exceed {string} and valid reqBody")
    public void createCommentsWithExceedAndValidReqBody(String recipeID) {
        CommentsAPI.createCommentWithExceedRecipeID(recipeID);
    }

//    Update comment with recipe ID and commend ID
    @Given("Update comments with valid recipe_id, comment_id and valid reqBody")
    public void updateCommentsWithValidRecipe_idComment_idAndValidReqBody() {
        CommentsAPI.updateCommentWithAllValidParam();
    }

    @When("Send update comments with recipe and comment id")
    public void sendUpdateCommentsWithValidRecipe_idComment_idAndValidRequestBody() {
        SerenityRest.when().put(CommentsAPI.UPDATE_COMMENT_WITH_COMMENT_ID);
    }

//    Update comment with exceed recipe ID
    @Given("Update comment in exceed {string}, valid comment_id and valid reqBody")
    public void updateCommentInExceedValidComment_idAndValidReqBody(String recipeID) {
        CommentsAPI.updateCommentWithExceedRecipeID(recipeID);
    }

//    Update comment with exceed comment ID
    @Given("Update comment in valid recipe_id, exceed {string} and valid reqBody")
    public void updateCommentInValidRecipe_idExceedAndValidReqBody(String commentID) {
        CommentsAPI.updateCommentWithExceedCommentID(commentID);
    }

//    Update comment with alphabet comment ID
    @Given("Update recipe comment with valid recipe_id and {string} inputted by alphabet")
    public void updateRecipeCommentWithValidRecipe_idAndInputtedByAlphabet(String commentID) {
        CommentsAPI.updateCommentWithExceedCommentID(commentID);
    }
}
