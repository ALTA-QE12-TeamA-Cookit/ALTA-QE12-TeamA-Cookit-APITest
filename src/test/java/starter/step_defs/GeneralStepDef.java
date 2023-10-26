package starter.step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.Constant;

import java.io.File;

public class GeneralStepDef {
    @Then("Status code {int}")
    public void statusCode(int status) {
        SerenityRest.then().statusCode(status);
    }

    @And("Response body message should be {string}")
    public void responseBodyMessageShouldBe(String message) {
        SerenityRest.then()
                .body("message", Matchers.equalTo(message));
    }

    @And("Validate JSON Schema {string}")
    public void validateJSONSchema(String schemaPath) {
        File json = new File(Constant.JSON_SCHEMA+schemaPath);
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
