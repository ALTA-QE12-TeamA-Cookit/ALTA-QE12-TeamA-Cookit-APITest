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

  @Negative
  Scenario: Login user with username is empty
    Given Login user with "auth/LoginUserWithUsernameIsEmpty.json" as request body
    When Send request login user
    Then Status code 400
    And Response body message should be "email or password cannot be empty"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Login user with password is empty
    Given Login user with "auth/LoginUserWithPasswordIsEmpty.json" as request body
    When Send request login user
    Then Status code 400
    And Response body message should be "email or password cannot be empty"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Login user with empty username and password
    Given Login user with "auth/LoginUserWithEmptyUsernameAndPassword.json" as request body
    When Send request login user
    Then Status code 400
    And Response body message should be "email or password cannot be empty"
    And Validate JSON Schema "MessageSchema.json"