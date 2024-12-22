Feature: User Login Functionality

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters valid email
    And User enters valid password
    And User clicks the login button
    Then User should be redirected to the dashboard

  Scenario: Login with valid email and incorrect password
    Given User is on the login page
    When User enters valid email
    And User enters incorrect password
    And User clicks the login button
    Then User should see an error message indicating incorrect credentials

  Scenario: Login with an unregistered email
    Given User is on the login page
    When User enters an unregistered email
    And User enters a password
    And User clicks the login button
    Then User should see an error message indicating incorrect credentials

  Scenario: Attempt login with empty username and password
    Given User is on the login page
    When User clicks the login button
    Then User should see an error message prompting for username and password required

  Scenario: Login with invalid email and invalid password
    Given User is on the login page
    When User enters an invalid email
    And User enters an invalid password
    And User clicks the login button
    Then User should see an error message indicating incorrect credentials


  Scenario: Login with case-sensitive credentials (incorrect case)
    Given User is on the login page
    When User enters email with incorrect case
    And User enters password with incorrect case
    And User clicks the login button
    Then User should see an error message indicating incorrect credentials

  Scenario: Attempt login with SQL injection in email field
    Given User is on the login page
    When User enters email with SQL injection
    And User enters a password
    And User clicks the login button
    Then User should see an error message indicating incorrect email

  Scenario: Attempt login with SQL injection in password field
    Given User is on the login page
    When User enters a valid email
    And User enters password with SQL injection
    And User clicks the login button
    Then User should see an error message indicating incorrect credentials