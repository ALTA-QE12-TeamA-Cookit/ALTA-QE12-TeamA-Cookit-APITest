@Transactions
Feature: Transactions
  As a user i want to make a new transactions

  @Positive
  Scenario: Get list user transactions
    Given Get list user transactions
    When Send request get list user transactions
    Then Status code 200
    And Response body message should be "succesfully read list of user's transactions"
    And Validate JSON Schema "transactions/GetListUserTransactionsSchema.json"

  @Positive
  Scenario: Create new user transactions with valid input
    Given Create user transactions with "transactions/CreateNewUserTransactionsWithValidInput.json"
    When Send request post create user transactions
    Then Status code 201
    And Response body message should be "succesfully insert user's transaction"
    And Validate JSON Schema "transactions/CreateNewUserTransactionsWithValidInputSchema.json"

  @Negative
  Scenario: Create new user transactions ingredient_id isn't exists
    Given Create user transactions with "transactions/CreateNewUsersTransactionsIngredient_IdIsNotExists.json"
    When Send request post create user transactions
    Then Status code 400
    And Response body message should be "invalid ingredient"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Create new user transactions quantity is zero
    Given Create user transactions with "transactions/CreateNewUsersTransactionsQuantityIsZero.json"
    When Send request post create user transactions
    Then Status code 400
    And Response body message should be "invalid input"
    And Validate JSON Schema "MessageSchema.json"

  @Positive
  Scenario: Update status user transaction with valid id
    Given Update user transactions with "362" as transactions_id
    When Send request update user transactions
    Then Status code 200
    And Response body message should be "succesfully update user's status transaction"
    And Validate JSON Schema "MessageSchema.json"

  @Positive
  Scenario: Update status user transaction with id isn't exists
    Given Update user transactions with "362571234" as transactions_id
    When Send request update user transactions
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"