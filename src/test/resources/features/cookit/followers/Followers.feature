@Followers
Feature: Followers
  As a user i want to follow someone and unfollow someone

#FOLLOW USERS

  @Positive
  Scenario: Follow an user with id is exists
    Given Follow user with id "264"
    When Send request post follow user
    Then Status code 201
    And Response body message should be "success follow this user"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Follow an user with id isn't exists
    Given Follow user with id "1237293"
    When Send request post follow user
    Then Status code 404
    And Response body message should be "data not found"
    And Validate JSON Schema "MessageSchema.json"

#UNFOLLOW USERS

  @Positive
  Scenario: Unfollow an user with id is exists
    Given Unfollow user with id "264"
    When Send request delete unfollow user
    Then Status code 201
    And Response body message should be "success unfollow this user"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Unfollow an user with id isn't exists
    Given Unfollow user with id "264"
    When Send request delete unfollow user
    Then Status code 404
    And Response body message should be "invalid user id, data not found"
    And Validate JSON Schema "MessageSchema.json"