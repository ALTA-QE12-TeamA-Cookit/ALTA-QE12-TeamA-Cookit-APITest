@Users
  Feature: Users

    @Positive @TEST
    Scenario: Get users with specific id
      Given Get user with specific id 203
      When Send request get specific users
      Then Status code 200
      And Response body message should be "success show profile"
      And Validate JSON Schema "users/GetUsersWithSpecificId.json"