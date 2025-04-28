@Regression
Feature: Regression Test on Rivoli Shop UAT or Dev site

	@HomePage
	Scenario: Verify the Home Page
		Given I landing to the home page and see the Rivoli Icon
		And The user sees the header with customer Service and Language selection
		Then The user sees the main menus
		And the user able to see the search, Profile, Wishlist and Cart icon
		Then The user sees the promotion glide banner
		#And the users sees the shop by category, brand of the month, bestseller, Eyewear brand of the month, Eyewear bestseller, Our Top picks, Brands you may like
		Then The user sees the About us in footer
		And The user sees the Shop in footer
		Then The user sees the Support in footer
		And The user sees the Sign up for newsletters in footer
		Then The user sees the follow us in footer
		And The user sees the country in footer
		Then The user sees the privacy policy in footer
		And The user sees the move to top icon

	@Login
	Scenario: Verify the Login Functionality
		Given I landing to the home page and see the Rivoli Icon
		Then Click on the profile icon and enter Login Information "testdata1"
		And Goto profile page, check the user data and logout

	@Registration
	Scenario: Verify the registration Functionality
		Given I landing to the home page and see the Rivoli Icon
		Then Click on the profile icon and click register link
		And Enter new user details and register
		And Goto profile page, check the user data and logout

	@OrderHistoryPage
	Scenario: Verify the order history Page in My account
		Given I landing to the home page and see the Rivoli Icon
		Then Login user
		Then Check order number

	@CartPage
	Scenario: Verify the cart page with products
		Given I landing to the home page and see the Rivoli Icon
		Then Click on the profile icon and enter Login Information


