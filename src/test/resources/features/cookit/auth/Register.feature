@Register
Feature: Register
  As a user i want to register account and do something in this web

  @Positive
  Scenario: Register user with all field is valid
    Given Register user with "auth/RegisterUserWithAllFieldIsValid.json" as request body
    When Send request register user
    Then Status code 201
    And Response body message should be "success create account"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Register user with username is empty
    Given Register user with "auth/RegisterUserWithUsernameIsEmpty.json" as request body
    When Send request register user
    Then Status code 400
    And Response body message should be "required fields must be filled"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Register user with email is empty
    Given Register user with "auth/RegisterUserWithEmailIsEmpty.json" as request body
    When Send request register user
    Then Status code 400
    And Response body message should be "required fields must be filled"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Register user with password is empty
    Given Register user with "auth/RegisterUserWithPasswordIsEmpty.json" as request body
    When Send request register user
    Then Status code 400
    And Response body message should be "required fields must be filled"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Register user with all field is empty
    Given Register user with "auth/RegisterUserWithAllFieldIsEmpty.json" as request body
    When Send request register user
    Then Status code 400
    And Response body message should be "required fields must be filled"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Register user with username is already exists
    Given Register user with "auth/RegisterUserWithUsernameIsAlreadyExists.json" as request body
    When Send request register user
    Then Status code 400
    And Response body message should be "required fields must be filled"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Register user with email is already exists
    Given Register user with "auth/RegisterUserWithEmailAlreadyExists.json" as request body
    When Send request register user
    Then Status code 400
    And Response body message should be "required fields must be filled"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Register user with email is invalid format
    Given Register user with "auth/RegisterUserWithEmailIsInvalidFormat.json" as request body
    When Send request register user
    Then Status code 400
    And Response body message should be "required fields must be filled"
    And Validate JSON Schema "MessageSchema.json"