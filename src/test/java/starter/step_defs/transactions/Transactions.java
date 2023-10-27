package starter.step_defs.transactions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.cookit.transactions.TransactionsAPI;
import starter.utils.Constant;

import java.io.File;

public class Transactions {
    @Given("Get list user transactions")
    public void getListUserTransactions() {
        TransactionsAPI.GetListUsersTransactions();
    }

    @When("Send request get list user transactions")
    public void sendRequestGetListUserTransactions() {
        SerenityRest.when().get(TransactionsAPI.GET_USER_LIST_TRANSACTIONS);
    }

    @Given("Create user transactions with {string}")
    public void createUserTransactionsWith(String pathFile) {
        File json = new File(Constant.REQ_BODY + pathFile);
        TransactionsAPI.setPostNewTransactions(json);
    }

    @When("Send request post create user transactions")
    public void sendRequestPostCreateUserTransactions() {
        SerenityRest.when().post(TransactionsAPI.POST_CREATE_USER_TRANSACTION);
    }

    @Given("Update user transactions with {string} as transactions_id")
    public void updateUserTransactionsWith(String transactions_id) {
        TransactionsAPI.setUpdateUserTransactions(transactions_id);
    }

    @When("Send request update user transactions")
    public void sendRequestUpdateUserTransactions() {
        SerenityRest.when().put(TransactionsAPI.UPDATE_USER_TRANSACTIONS);
    }
}
