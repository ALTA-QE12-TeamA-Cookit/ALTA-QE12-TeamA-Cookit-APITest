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


#POST CREATE NEW RECIPES


  @Positive
  Scenario: Create new recipes with all field is valid
    Given Create new recipes with "recipes/CreateNewRecipesWithAllFieldIsValid.json" as req body
    When Send request create new recipes
    Then Status code 201
    And Response body message should be "succesfully insert user's recipe"
    And Validate JSON Schema "recipes/CreateNewRecipesWithAllFieldIsValidSchema.json"

  @Negative
  Scenario: Create new recipes without steps
    Given Create new recipes with "recipes/CreateNewRecipesWithoutSteps.json" as req body
    When Send request create new recipes
    Then Status code 400
    And Response body message should be "steps field is required"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Create new recipes without ingredients
    Given Create new recipes with "recipes/CreateNewRecipesWithoutIngredients.json" as req body
    When Send request create new recipes
    Then Status code 400
    And Response body message should be "ingredients field is required"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Create new recipes without name
    Given Create new recipes with "recipes/CreateNewRecipesWithoutRecipeName.json" as req body
    When Send request create new recipes
    Then Status code 400
    And Response body message should be "invalid input"
    And Validate JSON Schema "MessageSchema.json"


#PUT UPDATE USERS RECIPES


  @Positive
  Scenario: Update user's recipes with all field is valid
    Given Update recipes with "recipes/UpdateUsersRecipesWithAllFieldIsValid.json" as req body
    When Send request update users recipes
    Then Status code 200
    And Response body message should be "succesfully updating user's recipe"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update user's recipes with name field is empty
    Given Update recipes with "recipes/UpdateUsersRecipesWithDescriptionNameIsEmpty.json" as req body
    When Send request update users recipes
    Then Status code 400
    And Response body message should be "invalid input"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update user's recipes with description name field is empty
    Given Update recipes with "recipes/UpdateUsersRecipesWithNameFieldIsEmpty.json" as req body
    When Send request update users recipes
    Then Status code 400
    And Response body message should be "invalid input"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update user's recipes with id isn't exists
    Given Update recipes with "recipes/UpdateUsersRecipesWithNameFieldIsEmpty.json" as req body and "273812364"
    When Send request update users recipes
    Then Status code 400
    And Response body message should be "invalid input"
    And Validate JSON Schema "MessageSchema.json"


#DELETE USERS RECIPE


  @Positive
  Scenario: Delete user's recipe with valid id
    Given Delete users recipe with id
    When Send request delete users recipes
    Then Status code 200
    And Response body message should be "succesfully deleting user's recipe"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete user's recipe with id isn't exists
    Given Delete users recipe with "1204916429" as id
    When Send request delete users recipes
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"


#GET TIMELINE OF RECIPES


  @Positive
  Scenario: Get list user's recipe timeline
    Given Get list of recipes timeline
    When Send request get list of recipes timeline
    Then Status code 200
    And Response body message should be "succesfully read list of recipes"
    And Validate JSON Schema "recipes/GetListUsersRecipeTimelineSchema.json"

  @Positive
  Scenario: Get timeline of recipes with all query param
    Given Get list of recipes timeline with "1" as page "1" as limit
    When Send request get list of recipes timeline
    Then Status code 200
    And Response body message should be "succesfully read list of recipes"
    And Validate JSON Schema "recipes/GetListUsersRecipeTimelineSchema.json"

  @Negative
  Scenario: Get timeline of recipes without token
    Given Get list of recipes timeline without token
    When Send request get list of recipes timeline
    Then Status code 401
    And Response body message should be "missing or malformed jwt"
    And Validate JSON Schema "MessageSchema.json"


#GET LIST USER RECIPE TRENDING


  @Positive
  Scenario: Get list user's recipe trending
    Given Get list users recipe trending
    When Send request get list users trending
    Then Status code 200
    And Response body message should be "succesfully read list of recipes"
    And Validate JSON Schema "recipes/GetListUsersRecipeTrendingSchema.json"

  @Positive
  Scenario: Get trending of recipes with all query param
    Given Get list of recipes trending with "1" as page "1" as limit
    When Send request get list users trending
    Then Status code 200
    And Response body message should be "succesfully read list of recipes"
    And Validate JSON Schema "recipes/GetListUsersRecipeTrendingSchema.json"

  @Negative
  Scenario: Get trending of recipes without token
    Given Get list of recipes trending without token
    When Send request get list users trending
    Then Status code 401
    And Response body message should be "missing or malformed jwt"
    And Validate JSON Schema "MessageSchema.json"


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

# Like Recipe
  @Positive @test
  Scenario: Likes user recipes with valid param
    Given Like users recipe with recipe_id as parameter
    When Send request like recipes
    Then Status code 200
    And Response body message should be "succesfully like user's recipe"
    And Validate JSON Schema "MessageSchema.json"

  @Negative @test
  Scenario: likes user recipes with uncreated param
    Given Like users recipe with uncreated "575600"
    When Send request like recipes
    Then Status code 400
    And Response body message should be "invalid recipe"
    And Validate JSON Schema "MessageSchema.json"

#    Unlike Recipe

  @Positive
  Scenario: Unlike recipes with valid recipe_id
    Given Unlike recipes with valid recipe_id
    When Send request unlike recipes
    Then Status code 405
    And Response body message should be "succesfully unlike user's recipe"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Unlike recipes with exceed recipe_id
    Given Unlike recipes with exceed "999999"
    When Send request unlike recipes
    Then Status code 200
    And Response body message should be "record not found"
    And Validate JSON Schema "MessageSchema.json"