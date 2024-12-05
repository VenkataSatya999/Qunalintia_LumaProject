Feature: Create Account Functionality

  Scenario: User successfully creates an account
    Given the user is on the Create Account page
    When the user enters "satya" in the First Name field
    And the user enters "reddy" in the Last Name field
    And the user enters "satyatester45@gmail.com" in the Email field
    And the user enters "Password@123" in the Password field
    And the user enters "Password@123" in the Confirm Password field
    And clicks the Create Account button
    Then the account should be created successfully, and the user should see a welcome message

  

  Scenario: Validation error for missing required fields
   Given the user is on the Create Account page
    When the user leaves the First Name field as empty ""
    And the user enters "reddy" in the Last Name field
    And the user enters "satyatester45@gmail.com" in the Email field
    And the user enters "Password@123" in the Password field
    And the user enters "Password@123" in the Confirm Password field
    And clicks the Create Account button
    Then an error message should appear stating First Name is required
