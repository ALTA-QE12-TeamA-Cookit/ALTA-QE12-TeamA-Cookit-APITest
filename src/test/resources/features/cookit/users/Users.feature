@Users
  Feature: Users

  #GET USER WITH SPECIFIC ID

    @Positive
    Scenario: Get users with specific id
      Given Get user with specific id "203"
      When Send request get specific users
      Then Status code 200
      And Response body message should be "success show profile"
      And Validate JSON Schema "users/GetUsersWithSpecificId.json"

    @Negative
    Scenario: Get users with specific id isn't exists
      Given Get user with specific id "37193"
      When Send request get specific users
      Then Status code 404
      And Response body message should be "data not found"
      And Validate JSON Schema "MessageSchema.json"

    @Negative
    Scenario: Get users with specific id inputted by alphabet
      Given Get user with specific id "asdjaskld"
      When Send request get specific users
      Then Status code 400
      And Response body message should be "bad request"
      And Validate JSON Schema "MessageSchema.json"

    @Negative
    Scenario: Get users with specific id without token
      Given Get user with specific id without token "203"
      When Send request get specific users
      Then Status code 401
      And Response body message should be "missing or malformed jwt"
      And Validate JSON Schema "MessageSchema.json"

  #GET LIST USER FOLLOWERS

    @Positive
    Scenario: Get list of user followers
      Given Get list of user followers
      When Send request get list of user followers
      Then Status code 200
      And Response body message should be "success show all follower users"
      And Validate JSON Schema "users/GetListOfUsersFollowersSchema.json"

    @Negative
    Scenario: Get list of users followers without token
      Given Get list of user followers without token
      When Send request get list of user followers
      Then Status code 401
      And Response body message should be "missing or malformed jwt"
      And Validate JSON Schema "MessageSchema.json"

  #GET LIST USER FOLLOWING

    @Positive
    Scenario: Get list of user following
      Given Get list of user following
      When Send request get list of user following
      Then Status code 200
      And Response body message should be "success show all following users"
      And Validate JSON Schema "users/GetListUserFollowingSchema.json"

    @Negative
    Scenario: Get list of users following without token
      Given Get list of user following without token
      When Send request get list of user following
      Then Status code 401
      And Response body message should be "missing or malformed jwt"
      And Validate JSON Schema "MessageSchema.json"

  #UPGRADE USERS ACCOUNT

    @Positive
    Scenario: Request upgrade account to admin
      Given Request upgrade account to admin
      When Send request post upgrade account to admin
      Then Status code 200
      And Response body message should be "success send your request to admin"
      And Validate JSON Schema "MessageSchema.json"

    @Negative
    Scenario: Request upgrade account to admin with already verified user
      Given Request upgrade account to admin
      When Send request post upgrade account to admin
      Then Status code 400
      And Response body message should be "your role already VerifiedUser"
      And Validate JSON Schema "MessageSchema.json"