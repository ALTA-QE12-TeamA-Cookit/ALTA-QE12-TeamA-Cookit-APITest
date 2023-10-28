@Images
Feature: Image
  As a user I want to do something in this web

  @Positive @Test1
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

#    update image by recipe_id and image_id
  @Positive
  Scenario: Update images into recipe with valid recipe_id and valid
  image_id and valid body
    Given Update image into recipe with "salad.jpg" as file recipe_id as recipe_id image_id as image_id
    When Send request update image into recipe
    Then Status code 200
    And Response body message should be "succesfully update recipe's image"
    And Validate JSON Schema "images/InsertImageIntoRecipeWithValidIdSchema.json"

  @Negative
  Scenario: Update images into recipe with valid recipe_id and
  image_id isn't exists and valid body
    Given Update image into recipe with image as file recipe_id as recipe_id "1923" as image_id
    When Send request update image into recipe
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update images into recipe with valid recipe_id and
  image_id inputted by alphabet and valid body
    Given Update image into recipe with image as file recipe_id as recipe_id "asdf" as image_id
    When Send request update image into recipe
    Then Status code 400
    And Response body message should be "invaild id param"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update images into recipe with valid recipe_id and valid
  image_id and without key image
    Given Update image into recipe without key image as file recipe_id as recipe_id image_id as image_id
    When Send request update image into recipe
    Then Status code 400
    And Response body message should be "invalid body"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update images into recipe with valid recipe_id and
  valid image_id and without image
    Given Update image into recipe without image as file recipe_id as recipe_id image_id as image_id
    When Send request update image into recipe
    Then Status code 400
    And Response body message should be "invalid body"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update images into recipe with valid recipe_id and valid
  image_id and valid body without token
    Given Update image into recipe with "salad.jpg" as file recipe_id as recipe_id image_id as image_id without token
    When Send request update image into recipe
    Then Status code 401
    And Response body message should be "missing or malformed jwt"
    And Validate JSON Schema "MessageSchema.json"

#    Delete image with recipe_id and image_id
  @Positive
  Scenario: Delete images into recipe with valid recipe_id and valid
  image_id
    Given Delete specific image into recipe with recipe_id as recipe_id and image_id as image_id
    When Send request delete specific image into recipe
    Then Status code 200
    And Response body message should be "succesfully delete recipe's image"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete specific image with valid recipe_id and image_id
  isn't exists
    Given Delete specific image into recipe with recipe_id as recipe_id "3671284" as image_id
    When Send request delete specific image into recipe
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete specific image with valid recipe_id and image_id
  inputted by alphabet
    Given Delete specific image into recipe with recipe_id as recipe_id "asdf" as image_id
    When Send request delete specific image into recipe
    Then Status code 400
    And Response body message should be "invaild id param"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete specific image with valid recipe_id and valid
  image_id without token
    Given Delete specific image into recipe with recipe_id as recipe_id image_id as image_id without token
    When Send request delete specific image into recipe
    Then Status code 401
    And Response body message should be "missing or malformed jwt"
    And Validate JSON Schema "MessageSchema.json"