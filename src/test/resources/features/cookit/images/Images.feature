@Images
Feature: Image
  As a user I want to do something in this web

  @Positive
  Scenario: Insert image into recipe with valid id
    Given Insert image into recipe with "cake.jpg" as file recipe_id as id
    When Send request insert image into recipe
    Then Status code 201
    And Response body message should be "succesfully insert recipe's image"
    And Validate JSON Schema "images/InsertImageIntoRecipeWithValidIdSchema.json"

  @Negative
  Scenario Outline: Insert image into recipe with id isn't exists
    Given Insert image into recipe with image as file "<recipe_id>" as id
    When Send request insert image into recipe
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"
    Examples:
      | recipe_id |
      | 571343    |

  @Negative
  Scenario: Insert image into recipe with id inputted by alphabet
    Given Insert image into recipe with image as file "asdkasa" as id
    When Send request insert image into recipe
    Then Status code 400
    And Response body message should be "invaild id param"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Insert image into recipe with valid id without token
    Given Insert image into recipe with image as file recipe_id as id without token
    When Send request insert image into recipe
    Then Status code 401
    And Response body message should be "missing or malformed jwt"
    And Validate JSON Schema "MessageSchema.json"

  @Positive
  Scenario: Delete recipe images with valid id
    Given Delete image into recipe with recipe_id as id
    When Send request delete image into recipe
    Then Status code 200
    And Response body message should be "succesfully delete recipe's image"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete recipe images with id isn't exists
    Given Delete image into recipe with "641923" as id
    When Send request delete image into recipe
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"