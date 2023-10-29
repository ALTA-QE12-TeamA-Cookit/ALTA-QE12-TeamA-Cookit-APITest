@Carts
Feature: Carts
  As a user I want to do something on this web

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
