Feature: User Profile Update on Magento

  Scenario: User is logged in and on the Edit Account Information page
    Given User is on the Magento website
    And User navigates to the Sign In page 
    When User enters the valid email
    And User enters the valid password
    And User clicks the Sign In button 
    Then User should be logged in successfully
    And User navigates to the My Account page

  Scenario: Update password
  	Given User is on the Magento website
    And User navigates to the Sign In page 
    When User enters the valid email
    And User enters the valid password
    And User clicks the Sign In button 
    Then User should be logged in successfully
    And User navigates to the My Account page
  	When User click on change password button
    And User enters current password
    And User enters new password
    And User enters confirmation password
    And User clicks the Save button
    Then User should see a success message

  Scenario: Update email valid input
  	Given User is on the Magento website
    And User navigates to the Sign In page 
    When User enters the valid email
    And User enters the valid password
    And User clicks the Sign In button 
    Then User should be logged in successfully
    And User navigates to the My Account page
  	When User click on edit button
  	And User check the change email checkbox
    And User clears the Email field
    And User enters new valid email
    And User enters current password
    And User clicks the Save button
    Then User should see a success message

  Scenario: Attempt to save with mandatory fields left blank
  	Given User is on the Magento website
    And User navigates to the Sign In page 
    When User enters the valid email
    And User enters the valid password
    And User clicks the Sign In button 
    Then User should be logged in successfully
    And User navigates to the My Account page
  	When User click manage address button
    And User clicks the Save Address button
    Then User should see an reqired message for the required fields.

  Scenario: Enter an email address with incorrect format
  	Given User is on the Magento website
    And User navigates to the Sign In page 
    When User enters the valid email
    And User enters the valid password
    And User clicks the Sign In button 
    Then User should be logged in successfully
    And User navigates to the My Account page
    When User click on edit button
  	And User check the change email checkbox
    And User clears the Email field
    And User enters invalid email
    And User enters current password
    And User clicks the save button
    Then User should see an error message for enter invalid email

  Scenario: Update password with mismatched New Password Confirm Password
  	Given User is on the Magento website
    And User navigates to the Sign In page 
    When User enters the valid email
    And User enters the valid password
    And User clicks the Sign In button 
    Then User should be logged in successfully
    And User navigates to the My Account page
  	When User click on change password button
    And User enters current password
    And User enters new password
    And User enters different confirmation password
    And User clicks the save button
    Then User should see an error message related to password mismatch

  Scenario: Attempt to update fields without making any changes
  	Given User is on the Magento website
    And User navigates to the Sign In page 
    When User enters the valid email
    And User enters the valid password
    And User clicks the Sign In button 
    Then User should be logged in successfully
    And User navigates to the My Account page
  	When User click on edit button
    And User clicks the Save button
    Then User should see a success message

  Scenario: Attempt to update the email address to one already registered
  	Given User is on the Magento website
    And User navigates to the Sign In page 
    When User enters the valid email
    And User enters the valid password
    And User clicks the Sign In button 
    Then User should be logged in successfully
    And User navigates to the My Account page
    When User click on edit button
  	And User check the change email checkbox
    And User clears the Email field
    And User enters existing email
    And User enters current password
    And User clicks the Save button
    Then User should see an error message indicating the email is already in use