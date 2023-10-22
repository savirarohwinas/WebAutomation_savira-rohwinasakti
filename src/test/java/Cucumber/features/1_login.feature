Feature: Verify Login Feature

  @Regression @Positive
  Scenario: Successful login with valid credentials
    Given the user is on the login page saucedemo
    When the user enters a valid username
    And the user enters a valid password
    And clicks the login button
    Then the user should be redirected to the dashboard

  @Regression   @Negative
  Scenario: Login with an invalid password
    Given the user is on the login page saucedemo
    When the user enters a valid username
    And the user enters an invalid password
    And clicks the login button
    Then the user should see an error message