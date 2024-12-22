Feature: User Sign-Up Validation
  This feature verifies the sign-up functionality of the website.

	Scenario: Valid Sign-Up with all valid inputs
    Given the user is on the sign-up page
    When the user enters first name
    And the user enters last name
    And the user enters email
    And the user enters password
    And the user enters confirm password
    And clicks the Create an Account button
    Then the user should see a successful sign up message
    
	Scenario: Sign-Up with the Maximum Allowed Length for Fields
		Given the user is on the sign-up page
    When the user enters data of maximum allowed length for the first name field
    And the user enters data of maximum allowed length for the last name field
    And the user enters data of maximum allowed length for the email field
    And the user enters data of maximum allowed length for the password field
    And the user enters data of maximum allowed length for the confirm password field
    And clicks the Create an Account button
    Then the user should see a successful sign up message

	Scenario: Sign-Up with Missing Required Fields
    Given the user is on the sign-up page
    And clicks the Create an Account button
    Then the user should see an required message below all fields

	Scenario: Invalid Email Format
    Given the user is on the sign-up page
    When the user enters firstname
    And the user enters lastname
    And the user enters invalid email
    And the user enters password
    And the user enters confirm password
    And clicks the Create an Account button
    Then the user should see an error message indicating invalid email format

  Scenario: Password and Confirm Password Mismatch
    Given the user is on the sign-up page
    When the user enters firstname
    And the user enters lastname
    And the user enters email
    And the user enters password
    And the user enters different confirm password
    And clicks the Create an Account button
    Then the user should see an error message indicating password and confirm password mismatch

  Scenario: Password Without Special Characters
    Given the user is on the sign-up page
    When the user enters firstname
    And the user enters lastname
    And the user enters invalid email
    And the user enters without special characters password
    And the user enters without special characters confirm password
    And clicks the Create an Account button
    Then the user should see an error message indicating password without special characters

  Scenario: Password Too Short
    Given the user is on the sign-up page
    When the user enters firstname
    And the user enters lastname
    And the user enters email
    And the user enters too short password
    And the user enters too short confirm password
    And clicks the Create an Account button
    Then the user should see an error message indicating password is weak

  Scenario: Existing Email Address
    Given the user is on the sign-up page
    When the user enters firstname
    And the user enters lastname
    And the user enters existing email
    And the user enters password
    And the user enters confirm password
    And clicks the Create an Account button
    Then the user should see an error message indicating existing email address


  Scenario: First Name Field Minimum Length Boundary
    Given the user is on the sign-up page
    When the user enters data of minimum allowed length for the First Name field
		And the user enters lastname
    And the user enters email
    And the user enters password
    And the user enters confirm password
    And clicks the Create an Account button
    Then the user should see an error message indicating existing email address