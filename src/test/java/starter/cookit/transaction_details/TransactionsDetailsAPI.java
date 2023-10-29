package starter.cookit.transaction_details;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.cookit.auth.LoginAPI;
import starter.utils.Constant;

public class TransactionsDetailsAPI {

    public static String GET_USER_TRANSACTIONS_DETAILS = Constant.BASE_URL + "/users/transactions/transaction_detail/{transaction_detail_id}";


    @Step("Get list user's transactions details")
    public static void GetListUsersTransactionsDetails(String id){
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("transaction_detail_id", id);

    }

}
