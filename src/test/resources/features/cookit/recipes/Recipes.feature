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
  Scenario: Get detail of recipes with recipe id
    Given Get detail of recipes with recipe id
    When Send request get detail recipe
    Then Status code 200
    And Response body message should be "succesfully read details of recipe"
    And Validate JSON Schema "recipes/GetDetailOfRecipeWithValidIdSchema.json"