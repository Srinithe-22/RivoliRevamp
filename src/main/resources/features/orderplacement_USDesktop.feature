@OrderPlacement
Feature: Order Placement on Rivoli Shop UAT or Dev site

	@OrderPlacement_HD_COD_Watch
	Scenario: : Verify the Watch HD order placement with COD
		Given I landing to the home page and see the Rivoli Icon
		Then Login user "Testdata1"
		And Clear the cart
		Then Search a product "Watch"
		Then Goto PDP and verify product
		Then Add product to cart
		And Verify the Cart page
		Then Goto Checkout page
		And Select Home Delivery option
		Then Add Shipping Address
		And Add Billing Address
		Then Select COD option
		And Verify Order review page
		Then Check the order confirmation page
		And Check the order history page
		Then Cancel the Order "Testdata1"

	@OrderPlacement_HD_Visa
	Scenario: Verify the HD order placement with Visa Credit Card
		Given I landing to the home page and see the Rivoli Icon
		Then Login user "Testdata1"
		And Clear the cart
		Then Search a product "Watch"
		Then Goto PDP and verify product
		Then Add product to cart
		And Verify the Cart page
		Then Goto Checkout page
		And Select Home Delivery option
		Then Add Shipping Address
		And Add Billing Address
		Then Add Credit card payment method "Visa"
		And Verify Order review page
		Then verify checkout DS Auth
		Then Check the order confirmation page
		And Check the order history page

	@OrderPlacement_CC_Visa
	Scenario: Verify the CC order placement with Visa Card
		Given I landing to the home page and see the Rivoli Icon
		Then Login user "Testdata1"
		And Clear the cart
		Then Search a product "Watch"
		Then Goto PDP and verify product
		Then Add product to cart
		And Verify the Cart page
		Then Goto Checkout page
		And Select Click and Collect option
		Then Select pickup store
		And Add Billing Address
		Then Add Credit card payment method "Visa"
		And Verify Order review page
		Then verify checkout DS Auth
		Then Check the order confirmation page
		And Check the order history page

	@OrderPlacement_HD_Master
	Scenario: Verify the HD order placement with Master Credit Card
		Given I landing to the home page and see the Rivoli Icon
		Then Login user "Testdata1"
		And Clear the cart
		Then Search a product "Watch"
		Then Goto PDP and verify product
		Then Add product to cart
		And Verify the Cart page
		Then Goto Checkout page
		And Select Home Delivery option
		Then Add Shipping Address
		And Add Billing Address
		Then Add Credit card payment method "Master"
		And Verify Order review page
		Then Check the order confirmation page
		And Check the order history page

	@OrderPlacement_CC_Master
	Scenario: Verify the CC order placement with Master Card
		Given I landing to the home page and see the Rivoli Icon
		Then Login user "Testdata1"
		And Clear the cart
		Then Search a product "Watch"
		Then Goto PDP and verify product
		Then Add product to cart
		And Verify the Cart page
		Then Goto Checkout page
		And Select Click and Collect option
		Then Select pickup store
		And Add Billing Address
		Then Add Credit card payment method "Master"
		And Verify Order review page
		Then Check the order confirmation page
		And Check the order history page

	@OrderPlacement_tabby_Watch
	Scenario: Verify the HD order placement with Tabby
		Given I landing to the home page and see the Rivoli Icon
		Then Login user "Tabbydata"
		And Clear the cart
		Then Search a product "Tabby"
		Then Goto PDP and verify product
		Then Add product to cart
		And Verify the Cart page
		Then Goto Checkout page
		And Select Home Delivery option
		Then Add Shipping Address
		And Select Billing Address same as Shipping
		Then Select Tabby payment method
		Then Check the order confirmation page
		And Check the order history page

	@Scratch_and_Win
	Scenario: Verify all the coupon codes are applied
		Given I landing to the home page and see the Rivoli Icon
		Then Login user "Testdata1"
		And Clear the cart
		Then Search a product "Tissot"
		Then Goto PDP and verify product
		Then Add product to cart
		And Verify the Cart page
		And Apply coupon code
