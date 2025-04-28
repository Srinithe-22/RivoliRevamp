@FunctionalTest @Smoke 
Feature: Sanity Test on any site

	@test1
	Scenario: Verify the Add to Cart Functionality
		Given I landing to the home page
		And The user login in account with the existing credentials
		Then the user searched and add product to cart
		And the user verifies the order details and moves to checkout page and verifies the product details
		Then the user is moved to review order page and places order


	@apitest
	Scenario Outline: Dummy Rest Api GET Students
		Given Get Call to "<url>"
		Then Response Code "<responseMessage>" is validated

		Examples:
			| url      | responseMessage |
			| /posts | 200 |

	@apitest1
	Scenario Outline:  Verify Code
		Given Get Call to "<url>"
		Then Response  is array total "<total>"

		Examples:
			| url      | total |
			| /posts | 2    |