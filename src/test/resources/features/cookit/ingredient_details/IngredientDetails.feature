@IngredientDetails
Feature: Ingredient Details
  As a user I want to login and do something in this web

#  Create
  @Positive @Test1
  Scenario: Insert new ingredient detail with valid recipes_id, valid ingredient_id and valid body
    Given Create ingredient detail with valid recipe_id, valid ingredient_id and valid "ingredient_details/CreateValidIngredientDetailReqBody.json"
    When Send create ingredient detail with valid recipe_id and ingredient_id
    Then Status code 201
    And Response body message should be "succesfully insert ingredient's detail"
    And Validate JSON Schema "ingredient_details/CreateValidIngredientDetailSchema.json"

  @Negative
  Scenario Outline: Insert new ingredient detail with exceed recipes_id, valid ingredient_id, and valid body
    Given Create ingredient detail with exceed "<recipe_id>", valid ingredient_id and valid "ingredient_details/CreateValidIngredientDetailReqBody.json"
    When Send create ingredient detail with valid recipe_id and ingredient_id
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"
    Examples:
      | recipe_id |
      | 9999      |

  @Negative
  Scenario Outline: Insert new ingredient detail with valid recipes_id, exceed ingredient_id and valid body
    Given Create ingredient detail with valid recipe_id, exceed "<ingredient_id>" and valid "ingredient_details/CreateValidIngredientDetailReqBody.json"
    When Send create ingredient detail with valid recipe_id and ingredient_id
    Then Status code 400
    And Response body message should be "invalid ingredient"
    And Validate JSON Schema "MessageSchema.json"
    Examples:
      | ingredient_id |
      | 9999          |

  @Negative
  Scenario: Insert new ingredient detail with valid recipes_id, valid ingredient_id and blank body
    Given Create ingredient detail with valid recipe_id, valid ingredient_id and blank "ingredient_details/CreateValidIngredientDetailBlankReqBody.json"
    When Send create ingredient detail with valid recipe_id and ingredient_id
    Then Status code 400
    And Response body message should be "invalid input"
    And Validate JSON Schema "MessageSchema.json"

#    Update
  @Positive
  Scenario: Update ingredient detail with valid recipes_id, valid ingredient_detail_id and valid body
    Given Update ingredient detail with valid recipe_id, valid ingredient_detail_id and valid "ingredient_details/UpdateValidIngredientDetailIDReqBody.json"
    When Send update ingredient detail with valid recipe_id and valid ingredient_detail_id
    Then Status code 200
    And Response body message should be "succesfully update ingredient's detail"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update ingredient detail with exceed recipes_id, valid ingredient_detail_id and valid body
    Given Update ingredient detail with exceed "9999", valid ingredient_detail_id and valid "ingredient_details/UpdateValidIngredientDetailIDReqBody.json"
    When Send update ingredient detail with valid recipe_id and valid ingredient_detail_id
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update ingredient detail with valid recipes_id, exceed ingredient_detail_id and valid body
    Given Update ingredient detail with valid recipe_id, exceed "9999" and valid "ingredient_details/UpdateValidIngredientDetailIDReqBody.json"
    When Send update ingredient detail with valid recipe_id and valid ingredient_detail_id
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update ingredient detail with valid recipes_id, valid ingredient_detail_id and blank body
    Given Update ingredient detail with valid recipe_id, valid ingredient_detail_id and blank "ingredient_details/CreateValidIngredientDetailBlankReqBody.json"
    When Send update ingredient detail with valid recipe_id and valid ingredient_detail_id
    Then Status code 400
    And Response body message should be "invalid input"
    And Validate JSON Schema "MessageSchema.json"

#    Delete
  @Positive
  Scenario: Delete ingredient detail with valid recipes_id and valid ingredient_detail_id
    Given Delete ingredient detail with valid recipe_id and valid ingredient_id
    When Send delete ingredient detail with recipe_id and ingredient_id
    Then Status code 200
    And Response body message should be "succesfully delete ingredient's detail"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete ingredient detail with exceed recipes_id and valid ingredient_detail_id
    Given Delete ingredient detail with exceed "9999" and valid ingredient_id
    When Send delete ingredient detail with recipe_id and ingredient_id
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete ingredient detail with valid recipes_id and exceed ingredient_detail_id
    Given Delete ingredient detail with valid recipe_id and exceed "9999"
    When Send delete ingredient detail with recipe_id and ingredient_id
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Delete ingredient detail with alphabet recipes_id and alphabet ingredient_detail_id
    Given Delete ingredient detail with alphabet "asdf" and alphabet "asdf"
    When Send delete ingredient detail with recipe_id and ingredient_id
    Then Status code 400
    And Response body message should be "invaild id param"
    And Validate JSON Schema "MessageSchema.json"