Feature: Logout Functionality on Saucedemo Website

  @Regression @Positive
  Scenario: User successfully logs out from the dashboard
    Given the user is logged into the website
    When the user clicks on the navigation button
    And selects the Logout option
    Then the user should be redirected back to the login page