@Carts
Feature: Carts
  As a user I want to do something on this web

#  Create carts for user
  @Positive
  Scenario: Create new user cart with valid request body
    Given create new user cart with valid "carts/createvalidReqBody.json"
    When Send create new user cart
    Then Status code 201
    And Response body message should be "succesfully insert user's cart"
    And Validate JSON Schema "carts/createNewUserCartWithValidSchema.json"

  @Negative
  Scenario: Create new user cart with empty value request body
    Given create new user cart with invalid reBody "carts/createNewUserCartWithEmptyValueRequestBody.json"
    When Send create new user cart
    Then Status code 400
    And Response body message should be "invalid input"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Create new user cart with empty key request body
    Given create new user cart with empty key "carts/createNewUserCartWithEmptyKeyRequestBody.json"
    When Send create new user cart
    Then Status code 400
    And Response body message should be "invalid input"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Create new user cart with empty request body
    Given create new user cart with invalid "carts/createNewUserCartEmptyRequestBody.json"
    When Send create new user cart
    Then Status code 400
    And Response body message should be "invalid input"
    And Validate JSON Schema "MessageSchema.json"


#    Get list carts

  @Positive
  Scenario: Get list cart
    Given Get list cart
    When Send request get list cart
    Then Status code 200
    And Response body message should be "succesfully read list of user's carts"
    And Validate JSON Schema "carts/getListcartSchema.json"

  @Negative
  Scenario: Get list cart with exceed page path param
    Given Get list cart with page param path "999999900000009090"
    When Send request get list cart
    Then Status code 400
    And Response body message should be "invalid page param"
    And Validate JSON Schema "MessageSchema.json"

  @Positive
  Scenario: Get single cart with valid page param
    Given Get list cart with page param path "1"
    When Send request get list cart
    Then Status code 200
    And Response body message should be "succesfully read list of user's carts"
    And Validate JSON Schema "carts/getListcartSchema.json"

  @Negative
  Scenario: Get single cart with exceed limit param
    Given Get single cart with exceed limit param "99999"
    When Send request get list cart
    Then Status code 400
    And Response body message should be "invalid limit param"
    And Validate JSON Schema "MessageSchema.json"

  # Update user cart
  @Positive @Negative 
  Scenario Outline: Update user's cart
    Given Update user's cart with <cartId> as param and "<reqBody>" as reqBody
    When Send update user's cart
    Then Status code <statusCode>
    And Response body message should be "<message>"
    And Validate JSON Schema "MessageSchema.json"
    Examples:
      | cartId  | statusCode | message                        | reqBody                                         |
      | 171     | 200        | succesfully update user's cart | carts/UpdateUser'sCartWithValidRequestBody.json |
      | 9999999 | 400        | forbidden request              | carts/UpdateUser'sCartWithValidRequestBody.json |
      | 171     | 400        | invalid input                  | carts/UpdateUser'sCartWithEmptyRequestBody.json |

  # Delete cart
  @Positive 
  Scenario Outline: Delete cart
    Given Delete users cart valid param "<param>"
    When Send Delete users cart with valid param
    Then Status code <statusCode>
    And Response body message should be "<message>"
    And Validate JSON Schema "MessageSchema.json"
    Examples:
      | param  | statusCode | message                        |
      | 999999 | 400        | forbidden request              |
      | 173    | 200        | succesfully delete user's cart |