package starter.step_defs.carts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.carts.CartsAPI;
import starter.utils.Constant;

import java.io.File;

public class Carts {

//    Create
    @Given("create new user cart with valid {string}")
    public void createNewUserCartWithValid(String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        CartsAPI.createPostCarts(json);
    }

    @When("Send create new user cart")
    public void sendCreateNewUserCart() {
        SerenityRest.when().post(CartsAPI.CREATE_NEW_CARTS);
    }

    @Given("create new user cart with invalid reBody {string}")
    public void createNewUserCartWithInvalidReBody(String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        CartsAPI.createPostCarts(json);
    }

    @Given("create new user cart with empty key {string}")
    public void createNewUserCartWithEmptyKey(String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        CartsAPI.createPostCarts(json);
    }

    @Given("create new user cart with invalid {string}")
    public void createNewUserCartWithInvalid(String jsonFile) {
        File json = new File(Constant.REQ_BODY + jsonFile);
        CartsAPI.createPostCarts(json);
    }


//  Get list carts
    @Given("Get list cart")
    public void getListCart() {
        CartsAPI.getListUsersCarts();
    }

    @When("Send request get list cart")
    public void sendRequestGetListCart() {
        SerenityRest.when().get(CartsAPI.CREATE_NEW_CARTS);
    }

    @Given("Get list cart with page param path {string}")
    public void getListCartWithInvalidPath(String pageParam) {
        CartsAPI.getListUsersCartsExceedPathParam(pageParam);
    }

    @Given("Get single cart with exceed limit param {string}")
    public void getSingleCartWithExceedLimitParam(String limitParam) {
        CartsAPI.getListUsersCartsExceedLimitPathParam(limitParam);
    }


    @Given("Update user's cart with {int} as param and {string} as reqBody")
    public void updateUserSCart(int cart_id, String jsonFile) {
        File json = new File (Constant.REQ_BODY + jsonFile);
        CartsAPI.updateUserCart(cart_id, json);
    }
    @When("Send update user's cart")
    public void sendUpdateUserSCart() {
        SerenityRest.when().put(CartsAPI.UPDATE_CART_USER);
    }


    @Given("Delete users cart valid param {string}")
    public void deleteUsersCartValidParam(String cart_id) {
        CartsAPI.deleteUserCart(cart_id);
    }

    @When("Send Delete users cart with valid param")
    public void sendDeleteUsersCartWithValidParam() {
        SerenityRest.when().delete(CartsAPI.UPDATE_CART_USER);
    }
}
