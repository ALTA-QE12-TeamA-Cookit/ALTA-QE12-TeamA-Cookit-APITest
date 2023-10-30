@Steps
Feature: Steps
  As a user i want to do something on this endpoint

#CREATE NEW RECIPE

  @Positive
  Scenario: Create new recipe steps with valid id and valid body
    Given Create new steps with recipe id and "steps/CreateNewRecipeStepsWithValidIdAndValidBody.json" as request body
    When Send request post create new steps
    Then Status code 201
    And Response body message should be "succesfully insert recipe's step"
    And Validate JSON Schema "steps/CreateNewRecipeStepsWithValidIdAndValidBodySchema.json"

  Scenario: Create new recipe steps with valid id and valid body
    Given Create new steps with recipe id and "steps/CreateNewRecipeStepsWithValidIdAndValidBody.json" as request body
    When Send request post create new steps
    Then Status code 201
    And Response body message should be "succesfully insert recipe's step"
    And Validate JSON Schema "steps/CreateNewRecipeStepsWithValidIdAndValidBodySchema.json"

  @Negative
  Scenario: Create new recipe steps with id isn't exists and valid body
    Given Create new steps with "893469123" as recipe id and "steps/CreateNewRecipeStepsWithValidIdAndValidBody.json" as request body
    When Send request post create new steps
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"

#UPDATE RECIPE

  @Positive
  Scenario: Update recipe steps with valid body and valid recipe_id and valid step_id
    Given Update steps with recipe id and step id and "steps/UpdateRecipeStepsWithValidIdAndValidBody.json" as request body
    When Send request put update steps
    Then Status code 200
    And Response body message should be "succesfully update recipe's step"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update recipe steps with valid body and valid recipe_id and step_id isn't exists
    Given Update steps with recipe id and "12452324" as step id and "steps/UpdateRecipeStepsWithValidIdAndValidBody.json" as request body
    When Send request put update steps
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update recipe steps with valid body and recipe id inputted by alphabet
    Given Update steps with recipe id and "asdjkhsakdj" as step id and "steps/UpdateRecipeStepsWithValidIdAndValidBody.json" as request body
    When Send request put update steps
    Then Status code 400
    And Response body message should be "invaild id param"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update recipe steps with empty string body and valid id
    Given Update steps with recipe id and step id and "steps/UpdateRecipeStepsWithEmptyStringBodyAndValidId.json" as request body
    When Send request put update steps
    Then Status code 400
    And Response body message should be "invalid input"
    And Validate JSON Schema "MessageSchema.json"

#DELETE STEP SPECIFICALLY

  @Positive
  Scenario: Delete specific recipe steps with valid recipe id and valid step id
    Given Delete steps with recipe id and step id
    When Send request delete steps specifically
    Then Status code 200
    And Response body message should be "succesfully delete recipe's step"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete specific recipe steps with valid recipe id and valid step id without token
    Given Delete steps with recipe id and step id without token
    When Send request delete steps specifically
    Then Status code 401
    And Response body message should be "missing or malformed jwt"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete recipe steps with valid body and valid recipe_id and step id isn't exists
    Given Delete steps with recipe id and "12452324" as step id
    When Send request delete steps specifically
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete recipe steps with valid body and valid recipe_id and step id inputted by alphabet
    Given Delete steps with recipe id and "asdkjhf" as step id
    When Send request delete steps specifically
    Then Status code 400
    And Response body message should be "invaild id param"
    And Validate JSON Schema "MessageSchema.json"

#DELETE ALL STEP

  @Positive
  Scenario: Delete recipe steps with valid recipe id
    Given Delete steps with recipe id
    When Send request delete steps
    Then Status code 200
    And Response body message should be "succesfully delete recipe's step"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete recipe steps without token
    Given Delete steps with recipe id without token
    When Send request delete steps
    Then Status code 401
    And Response body message should be "missing or malformed jwt"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete recipe steps with recipe_id isn't exists
    Given Delete steps with recipe id "1289361251" as recipe_id
    When Send request delete steps
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete recipe steps with recipe_id inputted by alphabet
    Given Delete steps with recipe id "asdgsda" as recipe_id
    When Send request delete steps
    Then Status code 400
    And Response body message should be "invaild id param"
    And Validate JSON Schema "MessageSchema.json"