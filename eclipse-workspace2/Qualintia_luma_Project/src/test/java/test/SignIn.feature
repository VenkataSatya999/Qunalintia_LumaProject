Feature: Login Functionality

  Scenario: User successfully login into the application
    Given the user is on the Login page
    When the user enter "satyatester45@gmail.com" in the Email field
    And the user enter "Password@123" in the Password field
    And clicks the Login button
    Then the user should be redirected to the homepage

  Scenario: User enter invalid credentials
    Given the user is on the Login page
    When the user enter "sssssssss@example.com" in the Email field
    And the user enter "000000000000" in the Password field
    And clicks the Login button
    Then an error message should appear stating Invalid login credentials

  Scenario: User leaves the Email field empty
    Given the user is on the Login page
    When the user leaves the "" email field empty
    And the user enter "Password@123" in the Password field
    And clicks the Login button
    Then an error message should appear stating Email is required

  Scenario: User leaves the Password field empty
    Given the user is on the Login page
    When the user enter "satyatester45@gmail.com" in the Email field
    And leaves the "" password field empty
    And clicks the Login button
    Then an error message should appear stating Password is required
