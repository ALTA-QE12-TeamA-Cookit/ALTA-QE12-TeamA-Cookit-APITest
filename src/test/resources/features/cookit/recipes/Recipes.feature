@Recipes
Feature: Recipes
  As a user i want to do something on recipes

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

  @Positive
  Scenario: Get detail of recipes with recipe id
    Given Get detail of recipes with recipe id
    When Send request get detail recipe
    Then Status code 200
    And Response body message should be "succesfully read details of recipe"
    And Validate JSON Schema "recipes/GetDetailOfRecipeWithValidIdSchema.json"