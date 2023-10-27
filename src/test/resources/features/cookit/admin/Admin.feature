@Admin
Feature: Admin
  As a admin i want to do something in this web

  @Positive
  Scenario: Get list request users verify
    Given List request verify users
    When Send request list request verify users
    Then Status code 200
    And Response body message should be "success show all requested users"
    And Validate JSON Schema "admin/AdminGetAllReqUsersVerifyValidSchema.json"

  @Positive
  Scenario: Update users role for verify user with valid user_id and valid body
    Given Update users role for verify user with valid user_id and valid body "admin/UpdateUserRoleValidReqBody.json"
    When Send request update users role for verify user with valid user_id and valid body
    Then Status code 200
    And Response body message should be "success approve verified user request"
    And Validate JSON Schema "admin/UpdateUsersValidRoleVerifyReqSchema.json"

  @Positive
  Scenario Outline: Update users role for verify user with exceed user_id and valid body
    Given Update users role for verify user with exceed "<user_id>" and valid body "<reqBody>"
    When Send request update users role for verify user with exceed user_id and valid valid body
    Then Status code 404
    And Response body message should be "data not found"
    And Validate JSON Schema "admin/UpdateUsersValidRoleVerifyReqSchema.json"
    Examples:
      | user_id | reqBody                               |
      | 9999    | admin/UpdateUserRoleValidReqBody.json |

  @Positive
  Scenario Outline: Update users role for verify user with valid user_id and invalid body
    Given Update users role for verify user with valid user_id and invalid body "<reqBody>"
    When Send request update users role for verify user with valid user_id and invalid body
    Then Status code 400
    And Response body message should be "user request verified has been denied"
    And Validate JSON Schema "admin/UpdateUsersValidRoleVerifyReqSchema.json"
    Examples:
      | reqBody                                 |
      | admin/UpdateUserRoleInvalidReqBody.json |

  @Positive
  Scenario Outline: Update users role for verify user with alphabet user_id and invalid body
    Given Update users role for verify user with alphabet "<user_id>" and invalid body "<reqBody>"
    When Send request update users role for verify user with alphabet user_id and invalid body
    Then Status code 400
    And Response body message should be "user request verified has been denied"
    And Validate JSON Schema "admin/UpdateUsersValidRoleVerifyReqSchema.json"
    Examples:
      | user_id | reqBody                                 |
      | asdf    | admin/UpdateUserRoleInvalidReqBody.json |