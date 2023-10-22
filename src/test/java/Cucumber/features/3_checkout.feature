Feature: Verify Checkout feature

  @Regression  @Positive
  Scenario: Successful Checkout
    Given the user is on the checkout page of saucedemo
    When the user provides their first name
    And enters their last name
    And inputs the zip or postal code
    And clicks the Continue button
    Then the user should be redirected to the checkout overview page