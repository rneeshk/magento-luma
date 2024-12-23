Feature: User Profile Update on Magento

  Scenario: User is logged in and on the Edit Account Information page
    Given User is on the homepage and logged in
    Then verify User should be logged in successfully

  Scenario: Update password
    Given User is on the homepage and logged in
    Then verify User should be logged in successfully
    When User clicks on the change password button
    And User enters the current password
    And User enters a new password
    And User enters the confirmation password
    And User clicks the Save button
    Then User should see a success message

  Scenario: Update email with valid
    Given User is on the homepage and logged in
    Then verify User should be logged in successfully
    When User clicks on the edit button
    And User checks the change email checkbox
    And User clears the Email field
    And User enters email
    And User enters the current password
    And User clicks the Save button
    Then User should see a success message 

  Scenario: Attempt to save with mandatory fields left blank
    Given User is on the homepage and logged in
    Then verify User should be logged in successfully
    When User clicks on the manage address button
    And User clicks the Save Address button
    Then User should see a required message for the required fields

  Scenario: Update password with mismatched New Password and Confirm Password
    Given User is on the homepage and logged in
    Then verify User should be logged in successfully
    When User clicks on the change password button
    And User enters the current password
    And User enters a new password
    And User enters a different confirmation password
    And User clicks the Save button
    Then User should see an error message related to password mismatch

  Scenario: Attempt to update fields without making any changes
    Given User is on the homepage and logged in
    Then verify User should be logged in successfully
    When User clicks on the edit button
    And User clicks the Save button
    Then User should see a success message