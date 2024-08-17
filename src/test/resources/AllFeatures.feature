Feature: All Features

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be redirected to the homepage

  Scenario: Buying a T-Shirt
    Given the user is on the home page
    When the user cursor is over the woman link
    And click on the submenu "T-shirts"
    Then the T-shirt
