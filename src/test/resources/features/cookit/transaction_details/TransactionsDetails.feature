@Transactions_Details
Feature: Transactions Details
  As a user i want to see transaction details

  @Positive 
  Scenario: Get transactions details with valid param
    Given Get transactions detail with param "414"
    When Send request get transactions detail
    Then Status code 200
    And Response body message should be "succesfully read user's transaction detail"
    And Validate JSON Schema "GetSingleTransactionsDetailsWithValidParam.json"


  @Negative 
  Scenario: Get transactions details with exceed param
    Given Get transactions detail with param "29989878969898"
    When Send request get transactions detail
    Then Status code 404
    And Response body message should be "data not found"
    And Validate JSON Schema "MessageSchema.json"
