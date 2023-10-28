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
  Scenario: Update ingredient with exceed recipe_id, valid ingredient_id and valid body
    Given Update ingredients with exceed recipe_id "9999" valid req body "ingredients/UpdateIngredientValidIngredientIdBodySchema.json"
    When Send update ingredient with exceed recipe_id, valid ingredient_id and valid body
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario: Update ingredient with valid recipe_id, exceed ingredient_id and valid body
    Given Update ingredient with valid recipe_id, exceed ingredient_id "9999" and valid "ingredients/UpdateIngredientValidIngredientIdBodySchema.json"
    When Send update ingredient with valid recipe_id, exceed ingredient_id and valid body
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"

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

  @Positive
  Scenario: Delete ingredient with valid recipe_id and valid ingredient_id
    Given Delete ingredient with valid recipe_id and valid ingredient_id
    When Send delete ingredient with valid recipe_id and valid ingredient_id
    Then Status code 200
    And Response body message should be "succesfully delete recipe's ingredient"
    And Validate JSON Schema "MessageSchema.json"

  @Negative
  Scenario Outline: Delete ingredient with exceed recipe_id and valid ingredient_id
    Given Delete ingredient with exceed "<recipe_id>" and valid ingredient_id
    When Send delete ingredient with exceed recipe_id and valid ingredient_id
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"
    Examples:
      | recipe_id |
      | 9999      |

  @Negative
  Scenario Outline: Delete ingredient with valid recipe_id and exceed ingredient_id
    Given Delete ingredient with valid recipe_id and exceed "<ingredient_id>"
    When Send delete ingredient with valid recipe_id and exceed ingredient_id
    Then Status code 400
    And Response body message should be "forbidden request"
    And Validate JSON Schema "MessageSchema.json"
    Examples:
      | ingredient_id |
      | 9999          |

  @Negative
  Scenario Outline: Delete ingredient with alphabet recipe_id and alphabet ingredient_id
    Given Delete ingredient with alphabet "<recipe_id>" and alphabet "<ingredient_id>"
    When Send delete ingredient with alphabet recipe_id and alphabet ingredient_id
    Then Status code 400
    And Response body message should be "invaild id param"
    And Validate JSON Schema "MessageSchema.json"
    Examples:
      | recipe_id | ingredient_id |
      | asdf      | asdf          |