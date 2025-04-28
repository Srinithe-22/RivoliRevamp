@OrderPlacement
Feature: Order Placement on Rivoli Shop UAT or Dev site

	@OrderPlacement_GPay_Watch
	Scenario: Verify the HD order placement with GPay
		 Given I landing to the home page and see the Rivoli Icon
		Then Login user "Testdata1"
		And Clear the cart
		Then Search a product "GPay"
		Then Goto PDP and verify product
		Then Add product to cart
		And Verify the Cart page
		Then Goto Checkout page
		And Select Home Delivery option
		Then Add Shipping Address
		And Select Billing Address same as Shipping
		Then Select GPay payment method
		#Then Check the order confirmation page
		#And Check the order history page

	@OrderPlacement_HD_COD_Eyewear
	Scenario: : Verify the Eyewear HD order placement with COD
		Given I landing to the home page and see the Rivoli Icon
		Then Login user "Testdata1"
		And Clear the cart
		Then Search a product "Sunglasses"
		Then Goto PDP and verify product
		Then Add Eyewear product to cart
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

