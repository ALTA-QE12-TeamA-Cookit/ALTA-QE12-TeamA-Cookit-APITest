@Recipes
Feature: Recipes
  As a user i want to do something on recipes

#GET LIST RECIPES

  @Positive
  Scenario: Get list of recipes
    Given Get list of recipes
    When Send request get list of recipes
    Then Status code 200
    And Response body message should be "succesfully read list of recipes"
    And Validate JSON Schema "recipes/GetListOfRecipesSchema.json"

  @Positive
  Scenario: Get list of recipes with all query param
    Given Get list of recipes with query param "1" as page "1" as limit "695" as recipe_id "221" as user_id "Ayam bakar goreng edit" as recipe_name "Original" as type "OpenForSale" as status
    When Send request get list of recipes
    Then Status code 200
    And Response body message should be "succesfully read list of recipes"
    And Validate JSON Schema "recipes/GetListOfRecipesSchema.json"

  @Negative
  Scenario: Get list of recipes without token
    Given Get list of recipes without token
    When Send request get list of recipes
    Then Status code 200
    And Response body message should be "succesfully read list of recipes"
    And Validate JSON Schema "recipes/GetListOfRecipesSchema.json"



#GET DETAIL RECIPE

  @Positive
  Scenario: Get detail of recipes with recipe id
    Given Get detail of recipes with recipe id
    When Send request get detail recipe
    Then Status code 200
    And Response body message should be "succesfully read details of recipe"
    And Validate JSON Schema "recipes/GetDetailOfRecipeWithValidIdSchema.json"

  @Negative
  Scenario: Get detail of recipes with recipe_id isn't exists
    Given Get detail of recipes with recipe_id "84182375123"
    When Send request get detail recipe
    Then Status code 400
    And Response body message should be "record not found"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Get detail of recipes with recipe_id inputted by alphabet
    Given Get detail of recipes with recipe_id "asdahdsad"
    When Send request get detail recipe
    Then Status code 400
    And Response body message should be "invaild id param"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Get detail of recipes without token
    Given Get detail of recipes with recipe id
    When Send request get detail recipe
    Then Status code 200
    And Response body message should be "succesfully read details of recipe"
    And Validate JSON Schema "recipes/GetDetailOfRecipeWithValidIdSchema.json"