Feature: Search Bar Functionality

  Scenario: User is on the homepage
    Given User is on the website homepage

  Scenario: Valid Keyword Search
  	Given User is on the website homepage
    When User enters a valid keyword in the search bar
    And User presses enter
    Then Search results containing relevant products are displayed

  Scenario: Search with Partial Keywords
  	Given User is on the website homepage
    When User enters a partial keyword in the search bar
    And User presses enter
    Then Search results containing items related to the partial keyword are displayed
    And Related search terms are suggested

  Scenario: Search with Special Characters
  	Given User is on the website homepage
    When User enters special characters in the search bar
    And User presses enter
    Then No relevant search results are displayed
    And An appropriate message indicating no results is displayed

  Scenario: Search for Non-Existent Product
  	Given User is on the website homepage
    When User enters a non-existent product in the search bar
    And User presses enter
    Then No relevant search results are displayed
    And An appropriate message indicating no results is displayed

  Scenario: Search with Maximum Input Length
  	Given User is on the website homepage
    Given User enters a search string with maximum characters in the search bar
    When User presses enter
    Then No relevant search results are displayed
    And An appropriate message indicating no results is displayed

  Scenario: Minimum Length Search Query
  	Given User is on the website homepage
    When User enters a search query with a single character in the search bar
    And User presses enter
    Then Search results containing relevant items are displayed
    And An appropriate message indicating the minimum length requirement is displayed

