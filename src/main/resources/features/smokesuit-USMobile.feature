@mSmoke
Feature: Sanity Test on Rivoli Shop UAT or Dev site

	@mHomePage
	Scenario: Verify the Home Page
		Given I landing to the home page and see the Rivoli Icon
		Then The user sees the main menus
		And the user able to see the search, Profile, Wishlist and Cart icon
		Then The user sees the promotion glide banner
		And the users sees the shop by category, brand of the month, bestseller, Eyewear brand of the month, Eyewear bestseller, Our Top picks, Brands you may like
		Then The user sees the About us in footer
		And The user sees the Shop in footer
		Then The user sees the Support in footer
		And The user sees the Sign up for newsletters in footer
		Then The user sees the follow us in footer
		And The user sees the country in footer
		Then The user sees the privacy policy in footer
		And The user sees the move to top icon


	@Category
	Scenario: Verify All Categories in homepage
		Given I landing to the home page and see the Rivoli Icon
		Then Verify the Watches category
		And Verify the Sunglasses category
		#Then Verify the Eyeglasses category
		#And Verify the Lenses category
		Then Verify the Jelwery category
		And Verify the Accessories category