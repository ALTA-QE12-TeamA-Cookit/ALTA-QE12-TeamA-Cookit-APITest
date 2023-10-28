@Ingredients
Feature: Ingredients
  As a user i want to login and do something in this web

  @Positive
  Scenario: Create new ingredient with valid recipe_id and valid body
    Given Create ingredient with valid recipe_id and valid "ingredients/CreateValidIngredientSchema.json"
    When Send create ingredient with valid recipe_id and valid body
    Then Status code 201
    And Response body message should be "succesfully insert recipe's ingredient"
    And Validate JSON Schema "ingredients/CreateValidIngredientSchema.json"

  @Negative
  Scenario: Create new ingredient with valid recipe_id and invalid body
    Given Create ingredient with valid recipe_id and invalid "ingredients/CreateIngredientInvalidBodySchema.json"
    When Send create ingredient with valid recipe_id and invalid body
    Then Status code 400
    And Response body message should be "invalid input"
    And Validate JSON Schema "MessageSchema.json"

  @Positive @Test1
  Scenario: Update ingredient with valid recipe_id, valid ingredient_id and valid body
    Given Update ingredient with valid recipe_id, valid ingredient_id and valid "ingredients/UpdateIngredientValidIngredientIdBodySchema.json"
    When Send update ingredient with valid recipe_id, valid ingredient_id and valid body
    Then Status code 200
    And Response body message should be "succesfully update recipe's ingredient"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario Outline: Update ingredient with exceed recipe_id, valid ingredient_id and valid body
    Given Update ingredients with exceed recipe_id "<recipe_id>", valid ingredient_id and valid "<reqBody>"
    When Send update ingredient with exceed recipe_id, valid ingredient_id and valid body
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"
    Examples:
      | recipe_id | reqBody                                                        |
      | 9999      | "ingredients/UpdateIngredientValidIngredientIdBodySchema.json" |

  @Negative
  Scenario Outline: Update ingredient with valid recipe_id, exceed ingredient_id and valid body
    Given Update ingredient with valid recipe_id, exceed ingredient_id "<ingredient_id>" and valid "<reqBody>"
    When Send update ingredient with valid recipe_id, exceed ingredient_id and valid body
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"
    Examples:
      | ingredient_id | reqBody                                                        |
      | 9999          | "ingredients/UpdateIngredientValidIngredientIdBodySchema.json" |

  @Negative
  Scenario: Update ingredient with valid recipe_id, valid ingredient_id and blank body
    Given Update ingredient with valid recipe_id, valid ingredient_id and blank "ingredients/UpdateIngredientBlankBodySchema.json"
    When Send update ingredient with valid recipe_id, valid ingredient_id and blank body
    Then Status code 400
    And Response body message should be "invalid input"
    And Validate JSON Schema "MessageSchema.json"

  @Positive
  Scenario: Delete ingredient with valid recipe_id
    Given Delete ingredient with valid recipe_id
    When Send delete ingredient with valid recipe_id
    Then Status code 200
    And Response body message should be "succesfully delete recipe's ingredient"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario Outline: Delete ingredient with exceed recipe_id
    Given Delete ingredient with exceed "<recipe_id>"
    When Send delete ingredient with exceed recipe_id
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"
    Examples:
      | recipe_id |
      | 9999      |

