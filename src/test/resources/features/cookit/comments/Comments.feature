@Comments
Feature: Comments
  As a user I want to login and do something in this web


#  Create comments in recipe
  @Positive
  Scenario: Create comments in valid recipe_id and valid request body
    Given Create comments with valid recipe_id and valid reqBody "cake.jpg"
    When Send create comments with recipe_id
    Then Status code 201
    And Response body message should be "succesfully insert recipe's comment"
    And Validate JSON Schema "comments/CreateValidCommentSchema.json"

  @Negative
  Scenario: Create comments in exceed recipe_id and valid request body
    Given Create comments with exceed "9999" and valid reqBody
    When Send create comments with recipe_id
    Then Status code 400
    And Response body message should be "invalid recipe"
    And Validate JSON Schema "MessageSchema.json"

#  Get list comments in recipe
  @Positive
  Scenario: Get list recipe comments with valid recipe_id
    Given List recipe comments with valid recipe_id
    When Send list recipe comments with recipe_id
    Then Status code 200
    And Response body message should be "succesfully read list of recipe's comments"
    And Validate JSON Schema "comments/GetListRecipesCommentsSchema.json"

  @Negative
  Scenario: Get list recipe comments with exceed recipe_id
    Given List recipe comments with exceed "9999"
    When Send list recipe comments with recipe_id
    Then Status code 400
    And Response body message should be "recipes not found"
    And Validate JSON Schema "MessageSchema.json"

#  Update comment with recipe id and comment id
  @Positive
  Scenario: Update comment in valid recipe_id, comment_id and valid request body
    Given Update comments with valid recipe_id, comment_id and valid reqBody
    When Send update comments with recipe and comment id
    Then Status code 200
    And Response body message should be "succesfully update recipe's comment"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update comment in exceed recipe_id, valid comment_id and valid request body
    Given Update comment in exceed "9999", valid comment_id and valid reqBody
    When Send update comments with recipe and comment id
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update comment in valid recipe_id, exceed comment_id and valid request body
    Given Update comment in valid recipe_id, exceed "9999" and valid reqBody
    When Send update comments with recipe and comment id
    Then Status code 400
    And Response body message should be "record not found"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update recipe comment with valid recipe_id and comment_id inputted by alphabet
    Given Update recipe comment with valid recipe_id and "asdf" inputted by alphabet
    When Send update comments with recipe and comment id
    Then Status code 400
    And Response body message should be "invaild id param"
    And Validate JSON Schema "MessageSchema.json"

# DELETE COMMENT

  @Negative
  Scenario: Delete recipe comment with valid recipe_id and comment_id isn't exists
    Given Delete comments with valid recipe_id and "1289361924" as comment_id
    When Send delete comments
    Then Status code 400
    And Response body message should be "record not found"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete recipe comment with valid recipe_id comment_id inputted by alphabet
    Given Delete comments with valid recipe_id and "aklsdhklasdj" as comment_id
    When Send delete comments
    Then Status code 400
    And Response body message should be "invaild id param"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete recipe comment with valid recipe_id and valid comment_id without token
    Given Delete comments with valid recipe_id comment_id without token
    When Send delete comments
    Then Status code 401
    And Response body message should be "missing or malformed jwt"
    And Validate JSON Schema "MessageSchema.json"

  @Positive
  Scenario: Delete recipe comment with valid recipe_id and valid comment_id
    Given Delete comments with valid recipe_id comment_id
    When Send delete comments
    Then Status code 200
    And Response body message should be "succesfully delete recipe's comment"
    And Validate JSON Schema "MessageSchema.json"