Feature: Add Items to Shopping Cart

  @Regression  @Positive
  Scenario: Successfully add an item to the shopping cart
    Given the user is on the products page of saucedemo
    When the user clicks the Add to Cart button for the product Sauce Labs Backpack
    Then the shopping cart badge should display 1 item
    And the user clicks the shopping cart icon
    Then the user should be redirected to the shopping cart page