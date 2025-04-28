@FunctionalTest @Smoke 
Feature: Sanity Test on anysite

	
@mobiletest
Scenario: Verify the Add to Cart Functionality
	Given I landing to the home page
	And The user login in account with the existing credentials
	Then the user searched and add product to cart
	And the user verifies the order details and moves to checkout page and verifies the product details
	Then the user is moved to review order page and places order
