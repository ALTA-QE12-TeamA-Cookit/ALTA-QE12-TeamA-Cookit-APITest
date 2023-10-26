@Login
Feature: Login
  As a user i want to login and do something in this web

  @Positive
  Scenario: Login user with registered account and all field is valid
    Given Login user with "auth/LoginUserWithRegisteredAccountAndAllFieldIsValid.json" as request body
    When Send request login user
    Then Status code 200
    And Response body message should be "login success"
    And Validate JSON Schema "auth/LoginUserWithRegisteredAccountAndAllFieldIsValidSchema.json"