package starter.step_defs.transaction_details;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.transaction_details.TransactionsDetailsAPI;

public class TransactionsDetails {

    @Given("Get transactions detail with param {string}")
    public void getSingleTransactionsDetailWithValid(String transactions_details_id) {
        TransactionsDetailsAPI.GetListUsersTransactionsDetails(transactions_details_id);
    }

    @When("Send request get transactions detail")
    public void sendRequestGetTransactionsDetailWithValidParam() {
        SerenityRest.when().get(TransactionsDetailsAPI.GET_USER_TRANSACTIONS_DETAILS);
    }


}
