Feature: Product Details Page Functionality

  Scenario: Verify product details after searching for a valid keyword
    Given I am on the website homepage
    And I click on a product thumbnail or link from the product listing page
		Then I should see the product name
		And I should see the product description
    And I should see the product price
    And I should see the product images

  Scenario: Add a product to the cart with a valid quantity,size, and color
    Given I am on the website homepage
    And I click on a product thumbnail or link from the product listing page
    When I select the size
    And I choose color
    And I enter a valid quantity in the quantity field
    And I click the add to cart button
    Then I should see a success message indicating the product was added to the cart
    And the cart total should be updated

  Scenario: Attempt to add a product to the cart with a negative quantity
		Given I am on the website homepage
    And I click on a product thumbnail or link from the product listing page
    When I select the size
    And I choose color
    When I enter a negative quantity in the quantity field
    And I click the add to cart button
    Then I should see an error message indicating an invalid quantity

  Scenario: Attempt to add the maximum quantity of a product to the cart
    Given I am on the website homepage
    And I click on a product thumbnail or link from the product listing page
    When I select the size
    And I choose color
    When I enter the maximum quantity in the quantity field
    And I click the add to cart button
    Then I should see an error message indicating an invalid quantity

  Scenario: Add a product to the cart with a quantity of one
    Given I am on the website homepage
    And I click on a product thumbnail or link from the product listing page
    When I select the size
    And I choose color
    When I enter a quantity one in the quantity field
    And I click the add to cart button
    Then I should see a success message indicating the product was added to the cart
    And the cart total should be updated

  Scenario: Add a product to the cart without selecting/entrying inputs
  	Given I am on the website homepage
    And I click on a product thumbnail or link from the product listing page
    Then I clear quantity input
    And I click the add to cart button
    And I should see an required field error.
    
    
  	