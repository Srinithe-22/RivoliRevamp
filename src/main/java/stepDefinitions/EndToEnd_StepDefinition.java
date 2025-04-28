package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.EndToEnd;
import pages.HomePage;

import java.io.FileNotFoundException;


public class EndToEnd_StepDefinition {

    private EndToEnd e2e;

    public EndToEnd_StepDefinition() {
        e2e = new EndToEnd();
    }

    @And("Clear the cart")
    public void clearTheCart() throws InterruptedException {
        e2e.clearTheCart();
    }


    @Then("Goto PDP and verify product")
    public void gotoPDPAndVerifyProduct() throws InterruptedException {
        e2e.verifyPDP();
    }

    @Then("Add product to cart")
    public void addProductToCart() throws InterruptedException {
        e2e.addToCart();
    }

    @And("Verify the Cart page")
    public void verifyTheCartPage() throws InterruptedException {
        e2e.verifyCartPage();
    }

    @Then("Goto Checkout page")
    public void gotoCheckoutPage() throws InterruptedException {
        e2e.deliveryOptions();
    }

    @And("Select Home Delivery option")
    public void selectHomeDeliveryOption() throws InterruptedException {
        e2e.homeDeliveryOption();
    }

    @Then("Add Shipping Address")
    public void addShippingAddress() throws InterruptedException {
        e2e.addShippingAddress();
    }

    @And("Add Billing Address")
    public void addBillingAddress() throws InterruptedException {
        e2e.addBillingAddress();
    }


    @And("Verify Order review page")
    public void verifyOrderReviewPage() throws InterruptedException {
        e2e.orderReviewPage();
    }

    @Then("Check the order confirmation page")
    public void checkTheOrderConfirmationPage() throws InterruptedException {
        e2e.orderConfirmPage();
    }

    @And("Check the order history page")
    public void checkTheOrderHistoryPage() throws InterruptedException {
        e2e.orderHistoryPage();
    }


    @Then("Add Credit card payment method {string}")
    public void addCreditCardPaymentMethod(String payType) throws InterruptedException {
        e2e.addCreditCard(payType);
    }

    @Then("verify checkout DS Auth")
    public void verifyCheckoutDSAuth() throws InterruptedException {
        e2e.checkoutAuth();
    }

    @Then("Select COD option")
    public void selectCODOption() throws InterruptedException {
        e2e.codOption();
    }

    @Then("Check order number")
    public void checkOrderNumber() throws InterruptedException {
        e2e.orderHistoryPageTest();
    }

    @And("Select Click and Collect option")
    public void selectClickAndCollectOption() throws InterruptedException {
        e2e.storePickupOption();
    }

    @Then("Select pickup store")
    public void selectPickupStore() throws InterruptedException {
        e2e.selectPickupStore();
    }

    @And("Select Billing Address same as Shipping")
    public void selectBillingAddressSameAsShipping() throws InterruptedException {
        e2e.selectBillingAddress();
    }

    @Then("Cancel the Order {string}")
    public void cancelTheOrder(String userData) throws InterruptedException, FileNotFoundException {
        e2e.cancelOrder(userData);
    }

    @Then("Search a product {string}")
    public void searchAProduct(String str) throws InterruptedException {
        e2e.searchProduct(str);
    }

    @Then("Add Eyewear product to cart")
    public void addEyewearProductToCart() throws InterruptedException {
        e2e.addEyewearToCart();
    }

    @Then("Select Tabby payment method")
    public void selectTabbyPaymentMethod() throws InterruptedException {
    	e2e.selectTabbyPayment();
    }
    
    @Then("Select GPay payment method")
    public void selectGPayPaymentMethod() throws InterruptedException {
    	e2e.selectGPayPayment();
    }

    @And("Apply coupon code")
    public void applyCouponCode() throws InterruptedException {
        e2e.readCouponDetails();
        e2e.applyCoupon();
    }
}
