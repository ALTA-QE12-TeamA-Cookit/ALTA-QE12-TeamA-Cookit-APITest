package starter.cookit.transactions;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.cookit.auth.LoginAPI;
import starter.utils.Constant;

import java.io.File;

public class TransactionsAPI {

    public static String GET_USER_LIST_TRANSACTIONS = Constant.BASE_URL + "/users/transactions";

    public static String POST_CREATE_USER_TRANSACTION = Constant.BASE_URL + "/users/transactions";

    public static String UPDATE_USER_TRANSACTIONS = Constant.BASE_URL + "/users/transactions/{transactions_id}/status";

    @Step("Get list user's transactions")
    public static void GetListUsersTransactions(){
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON);
    }

    @Step("Post new transactions")
    public static void setPostNewTransactions(File json){
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update user transactions")
    public static void setUpdateUserTransactions(String transactions_id){
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("transactions_id", transactions_id);
    }
}
