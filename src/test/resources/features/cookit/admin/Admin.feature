@Admin
Feature: Admin
  As a admin i want to do something in this web

  @Positive
  Scenario: Get list request users verify
    Given List request verify users
    When Send request list request verify users
    Then Status code 200
    And Response body message should be "success show all requested users"
    And Validate JSON Schema "admin/AdminGetAllReqUsersVerify.json"

