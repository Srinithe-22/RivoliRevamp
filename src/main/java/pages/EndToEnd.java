package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.ReadExcel;
import wdMethods.ProjMethods;

import javax.mail.Session;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.*;

public class EndToEnd extends ProjMethods{


	protected Properties prop;
	public EndToEnd() {
		PageFactory.initElements(getDriver(), this);
	}
	// new repo
	@FindBy(how = How.XPATH, using="//*[@aria-label='cart icon']")
	public WebElement cartIcon;
	@FindBy(how = How.XPATH, using="//span[@class='sf-icon  color-green-primary size-lg remove-item']")
	public WebElement cartDeleteItemIcon;
	@FindBy(how = How.XPATH, using="//*[@class='sidebar-icon sidebar-icon--right sf-icon']")
	public WebElement sideMenuCloseIcon;
	//@FindBy(how = How.XPATH, using="(//*[@aria-label='Search'])[1]")
	@FindBy(how = How.XPATH, using="//div[contains(@class,'search-bar-desktop-icon')]")
	public WebElement searchBar;
	@FindBy(how = How.XPATH, using="(//div[@class='results-list']//div//div)[1]" )
	public WebElement searchResultItem;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Add to Cart')]")
	public WebElement addToCartPDPButton;
	@FindBy(how = How.XPATH, using="//span[@id='product-detail-information__brand-collection']")
	public WebElement brandNamePDP;
	@FindBy(how = How.XPATH, using="(//span[@id='product-detail-information__name'])[1]")
	public WebElement productNamePDP;
	@FindBy(how = How.XPATH, using="(//span[@id='product-detail-information__sku'])[1]")
	public WebElement skuProductPDP;
	@FindBy(how = How.XPATH, using="//div[@id='product-detail-information__price']")
	public WebElement priceProductPDP;
	@FindBy(how = How.XPATH, using="//div[@class='sf-quantity-selector sf-add-to-cart__select-quantity']")
	public WebElement quantitySelectorPDP;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Proceed To Buy')]")
	public WebElement proceedToBuyCartButton;
	@FindBy(how = How.XPATH, using="//h2[contains(text(),'Review your selection')]")
	public WebElement reviewTitleCartPage;
	@FindBy(how = How.XPATH, using="(//span[contains(text(),'Cart')])[1]")
	public WebElement cartPageTitle;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Order Subtotal')]")
	public WebElement orderSubtotalReviewSection;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Order Subtotal')]/following-sibling::span")
	public WebElement orderSutotalValueReviewSection;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Discount')]")
	public WebElement discountReviewSection;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Discount')]/following-sibling::span")
	public WebElement discountValueReviewSection;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Net Amount')]")
	public WebElement netAmountReviewSection;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Net Amount')]/following-sibling::span")
	public WebElement getNetAmountValueReviewSection;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'VAT')]")
	public WebElement vatReviewSection;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'VAT')]/following-sibling::span")
	public WebElement vatValurReviewSection;
	@FindBy(how = How.XPATH, using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")
	public WebElement addCouponCodeCart;
	@FindBy(how = How.XPATH, using="/div[@class='sf-property--full-width sf-property--large sf-property']//span[contains(text(),'Discounts')]")
	public WebElement discount;
	@FindBy(how = How.XPATH, using="//input[@id='promoCode']")
	public WebElement couponCodeInputCart;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Apply')]")
	public WebElement applyButtonCart;
	@FindBy(how = How.XPATH, using="//div[@class='sf-property--full-width sf-property--large total sf-property']//span[contains(text(),'Total')]/following-sibling::span")
	public WebElement totalValurCartPage;
	@FindBy(how = How.XPATH, using="//span[text()='(VAT included)']")
	public WebElement vatIncludedText;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Checkout')]")
	public WebElement checkoutButtonCart;
	@FindBy(how = How.XPATH, using="//div[@class='delivery__detail']//div[contains(text(),\"I'd like it delivered\")]")
	public WebElement homeDeliveryOption;
	@FindBy(how = How.XPATH, using="//div[@class='delivery__detail']//div[contains(text(),\"I'll pick it up from the store\")]")
	public WebElement storePickupOption;
	@FindBy(how = How.XPATH, using="//input[@name='firstName']")
	public WebElement firstNameShipping;
	@FindBy(how = How.XPATH, using="//input[@name='lastName']")
	public WebElement lastNameShipping;
	@FindBy(how = How.XPATH, using="//input[@name='streetName']")
	public WebElement addressShipping;
	@FindBy(how = How.XPATH, using="//input[@name='apartment']")
	public WebElement landmarkShipping;
	@FindBy(how = How.XPATH, using="//input[@name='city']")
	public WebElement cityShipping;
	@FindBy(how = How.XPATH, using="//input[@name='zipCode']")
	public WebElement postCodeShipping;
	@FindBy(how = How.XPATH, using="//select[@id='State / Province']")
	public WebElement stateDropdownShipping;
	@FindBy(how = How.XPATH, using="//input[@name='phoneNumber']")
	public WebElement phoneNumberShipping;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Add A New Address')]")
	public WebElement addNewAddressOption;
	@FindBy(how = How.XPATH, using="(//span[contains(text(),'Shipping Address')])[1]")
	public WebElement shippingAddressTitlePage;
	@FindBy(how = How.XPATH, using="//select[@id='State / Province']//option[4]")
	public WebElement dubaiStateOption;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Billing')]")
	public WebElement billingAddressButton;
	@FindBy(how = How.XPATH, using="//div[text()='Same as shipping address']")
	public WebElement copyShippingAddressBilling;
	@FindBy(how = How.XPATH, using="(//span[contains(text(),'Billing Address')])[1]")
	public WebElement billingAddressTitlePage;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Payment')]")
	public WebElement paymentButton;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Credit / Debit Card')]")
	public WebElement creditCardPaymentOption;
	@FindBy(how = How.XPATH, using="//iframe[@id='cardNumber']")
	public WebElement creditCardFrmae;
	@FindBy(how = How.XPATH, using="//input[@name='cardnumber']")//input[@aria-label='Credit / Debit Number']")
	public WebElement creditCardNumber;
	@FindBy(how = How.XPATH, using="//input[@aria-label='MM/YY']")
	public WebElement expiryYearCC;
	@FindBy(how = How.XPATH, using="//iframe[@id='expiryDate']")
	public WebElement expiryYearFrame;
	@FindBy(how = How.XPATH, using="//input[@aria-label='CVV']")
	public WebElement cvvCreditCard;
	@FindBy(how = How.XPATH, using="//iframe[@id='cvv']")
	public WebElement cvvCreditCardFrame;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Review & Checkout')]")
	public WebElement reviewButtonCreditCard;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Credit Card / Debit Card')]")
	public WebElement creditCardTitlePage;
	@FindBy(how = How.XPATH, using="(//span[contains(text(),'Order Review')])[1]")
	public WebElement orderReviewPageTitle;
	@FindBy(how = How.XPATH, using="//div[@class='checkout__aside desktop-only']//button[contains(text(),'Place Order')]")
	public WebElement placeOrderButton;
	@FindBy(how = How.XPATH, using="//input[@id='password']")
	public WebElement checkout3DSPassword;
	@FindBy(how = How.XPATH, using="//iframe[@name='cko-3ds2-iframe']")
	public WebElement checkout3DSFrame;
	@FindBy(how = How.XPATH, using="//input[@value='Continue']")
	public WebElement checkout3DSConfirm;
	@FindBy(how = How.XPATH, using="//h1[contains(text(),'Thank you for shopping with us')]")
	public WebElement orderConfirmationPage;
	@FindBy(how = How.XPATH, using="//h2[@class='sf-banner__subtitle']")
	public WebElement orderNumberConfrimPage;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Order History')]")
	public WebElement orderHistoryButton;
	@FindBy(how = How.XPATH, using="//span[text()='Order History']")
	public WebElement orderHistoryPage;
	@FindBy(how = How.XPATH, using="//*[@id=\"my-account\"]/div/section/div[2]/div/div/div/div/div[1]/div/div/div/div[1]/div/button/div[1]/div[1]/div[1]/span[2]")//span[contains(text(),'Order Number')]/following-sibling::span)[1]")
	public WebElement orderNumberHistoryPage;
	@FindBy(how = How.XPATH, using="//button//div[contains(text(),'Cash on delivery')]")
	public WebElement codButtonOption;
	@FindBy(how = How.XPATH, using="(//button[@class='sf-button sf-button sf-button--pure delivery__store'])[1]")
	public WebElement firstPickupStore;
	@FindBy(how = How.XPATH, using="//div[@class='sf-top-bar checkout-header__topbar']//span[contains(text(),'Select Store')]")
	public WebElement storePickupPage;
	@FindBy(how = How.XPATH, using="//*[@aria-label='account button']")
	public WebElement accountIcon;
	@FindBy(how = How.XPATH, using="//span[text()='Order History']")
	public WebElement orderHistoryMenu;
	@FindBy(how = How.XPATH, using="//h2[contains(text(),'Track Your Order')]")
	public WebElement trackYourOrderPage;
	@FindBy(how = How.XPATH, using="//input[@name='orderNumber']")
	public WebElement orderNumberTrack;
	@FindBy(how = How.XPATH, using="//input[@name='email']")
	public WebElement emailTrack;
	@FindBy(how = How.XPATH, using="//span[text()=' View Order Status']")
	public WebElement viewOrderStatus;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Cancel Order')]")
	public WebElement cancelOrderButton;
	@FindBy(how = How.XPATH, using="//div[@class='sf-sidebar__bottom']//button[contains(text(),'Cancel Order')]")
	public WebElement cancelOrderSideBarButton;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Cancelled')]")
	public WebElement cancelledOrderText;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'SELECT LENSES')]")
	public WebElement selectLenses_Eyewear;
	@FindBy(how = How.XPATH, using="//h2[contains(text(),'Select your vision need')]")
	public WebElement selectLensesPage_Eyewear;
	@FindBy(how = How.XPATH, using="//h3[contains(text(),'Non Prescription')]")
	public WebElement noPrescriptionOption_Eyewear;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'ADD TO CART')]")
	public WebElement addToCartButton_Eyewear;
	@FindBy(how = How.XPATH, using="//div[@id='product-detail--wrapper']//button[@class='sf-button sf-button--pure desktop-only']")
	public WebElement wishListicon_PDP;
	@FindBy(how = How.XPATH, using="//span[@id='product-detail-information__brand']")
	public WebElement brandName_PDP;
	@FindBy(how = How.XPATH, using="//*[@id='SpinnerId']")
	public WebElement checkout3DSSpinner;
	@FindBy(how = How.XPATH, using="//button[contains(@class,'tabby-eligibility-btn')]")
	public WebElement checkForEligibility;
	@FindBy(how = How.XPATH, using="//div[@class='checkout__aside desktop-only']//button[@class='sf-button sf-button--full-width confirm-and-pay__checkout-button']")
	public WebElement payWithTabby;
	@FindBy(how = How.XPATH, using="//input[@class='tss-166z3fw-input']")
	public WebElement enterCode;
	@FindBy(how = How.XPATH, using="//input[contains(@class,'ltr-direction-1x5jdmq')]")
	public WebElement cardNumberTabby;
	@FindBy(how = How.XPATH, using="//input[contains(@class,'ltr-direction-1o6z5ng')]")
	public WebElement ExpiryTabby;
	@FindBy(how = How.XPATH, using="//input[contains(@class,'ltr-direction-b52kj1')]")
	public WebElement cvvTabby;
	@FindBy(how = How.XPATH, using="//button[contains(@class,'MuiButtonBase-root')]")
	public WebElement payTabby;
	@FindBy(how = How.XPATH, using="//div[@class='checkout-header__topbar--desktop-title desktop-only']")
	public WebElement paymentMethod;
	@FindBy(how = How.XPATH, using="//span[@class='sf-icon size-xl']//img[@alt='Google Pay']")
	public WebElement gPayCTA;
	@FindBy(how = How.XPATH, using= "//div[@class='checkout__aside desktop-only']//div[@name='google-pay-container']")
	public WebElement buyWithGpay;
	//@FindBy(how = How.XPATH, using= "//div[@class='rFrNMe X3mtXb UOsO2 ToAxb zKHdkd sdJrJc Tyc9J']//input[@class='whsOnd zHQkBf']")
	@FindBy(how = How.XPATH, using="//input[@type='email']")
	public WebElement gPayMail;
	@FindBy(how = How.XPATH, using = "//div[@class='VfPpkd-Jh9lGc']/following-sibling::span[text()='Next']")
	public WebElement nextCTA;
	@FindBy(how = How.XPATH, using = "//div[@class='Xb9hP']/input[@class='whsOnd zHQkBf']")
	public WebElement passwordField;
	@FindBy(how = How.XPATH, using = "//input[@id='search-bar-desktop']")
	public WebElement searchBox;
	@FindBy(how = How.XPATH, using = "//button[@class='sf-button promo-code__button apply']")
	public WebElement cartApplyCTA;

	/////////////////////////////////////////////////////////////////////
	// Home Page Function
	ReadExcel user = new ReadExcel();
	String[][] data = user.getSheet("datasheet.xlsx","user");
	String[][] coupon = user.getSheet("datasheet.xlsx","coupon");
	String[][] productdata = user.getSheet("datasheet.xlsx","product");
	String[][] addressData = user.getSheet("datasheet.xlsx","address");
	String[][] paymentData = user.getSheet("datasheet.xlsx","payment");
	String emaildata = null,passworddata = null,firstname = null,lastname = null;
	String sku = null,productName = null,env = null,url=null;
	String firstNameAddress=null,lastNameAddress=null,streetAddress=null,landmarkAddress=null;
	String cityAddress=null,postcodeAddress=null,phoneAddress=null;
	String cardNumber=null,expDate=null,cvv=null;
	String orderNum;
	String[] couponCode;

	public void readProperties(){
		prop=new Properties();
		try {
			prop.load(Files.newInputStream(new File("./src/main/resources/resources.properties").toPath()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		env=prop.getProperty("ENVIRONMENT");

		if(prop.getProperty("ENVIRONMENT").equalsIgnoreCase("PROD")){
			url  = prop.getProperty("PROD_URL");
		} else if (prop.getProperty("ENVIRONMENT").equalsIgnoreCase("UAT")) {
			url = prop.getProperty("UAT_URL");
		}

	}

	public void readUserDetails(String mailid) {

		for (int i = 0; i < data.length; i++) {
			if(data[i][5].equalsIgnoreCase(env)) {
				if (data[i][6].equalsIgnoreCase("Y") || data[i][6].equalsIgnoreCase("Yes")) {
					if (data[i][7].equalsIgnoreCase(mailid)) {
						for (int j = 0; j < data[i].length; j++) {
							firstname = data[i][1];
							lastname = data[i][2];
							emaildata = data[i][3];
							passworddata = data[i][4];
						}
					}
				}
			}
		}

	}

	public void readCouponDetails() {
		couponCode= new String[coupon.length+1];
		for (int i = 0; i < coupon.length; i++)
			 {
						couponCode[i] = coupon[i][1];
				 System.out.println(couponCode[i]);
					}
	}


	public void readProductDetails(String str){
		readProperties();
		//System.out.println(env);
		for (int i = 0; i < productdata.length; i++) {
			if (productdata[i][4].equalsIgnoreCase(env) && productdata[i][2].equals(str)) {
				for (int j = 0; j < productdata[i].length; j++) {
					sku = productdata[i][3];
					productName= productdata[i][1];
				}
			}
		}
	}
	public void readAddressDetails() {
		for (int i = 0; i < addressData.length; i++) {
				if (addressData[i][8].equalsIgnoreCase("Y") || addressData[i][8].equalsIgnoreCase("Yes")) {
					for (int j = 0; j < addressData[i].length; j++) {
						firstNameAddress = addressData[i][1];
						lastNameAddress = addressData[i][2];
						streetAddress = addressData[i][3];
						landmarkAddress = addressData[i][4];
						cityAddress = addressData[i][5];
						phoneAddress = addressData[i][7];
					}
			}
		}
	}
	public void readPaymentDetails(String pay) {
		for (int i = 0; i < paymentData.length; i++) {
			if(paymentData[i][4].equalsIgnoreCase(pay)) {
					for (int j = 0; j < paymentData[i].length; j++) {
						cardNumber = paymentData[i][1];
						expDate = paymentData[i][2];
						cvv = paymentData[i][3];
					}
			}
		}
	}

	public void verifyOrderSummary() throws InterruptedException{
		isDisplayed(orderSubtotalReviewSection);
		//isDisplayed(discountReviewSection);
		isDisplayed(netAmountReviewSection);
		isDisplayed(vatReviewSection);
		scrollIntoViewBottomOfScreen(vatIncludedText);
		isDisplayed(totalValurCartPage);
		System.out.println("Subtotal : "+orderSutotalValueReviewSection.getText());
		try{
			if(isExists(discountReviewSection)){
				isDisplayed(discountReviewSection);
				System.out.println("Discount : "+discountValueReviewSection.getText());
			}
		}catch(Exception e){
			reportStep("The Discount section is not displayed","INFO",true);
		}
		System.out.println("net Amount : "+getNetAmountValueReviewSection.getText());
		System.out.println("VAT : "+vatValurReviewSection.getText());
		System.out.println("Total : "+totalValurCartPage.getText()+"\n");
	}
	public void clearTheCart() throws InterruptedException {
		waitForServerToPerformAction(3);
		waitForElementToLoad(cartIcon);
		clickWithSnap(cartIcon,"Cart icon is displayed");
		//reportStep("Hello "+cartDeleteItemIcon.isEnabled(),"INFO");
		try {
			if(cartDeleteItemIcon.isEnabled()) {
				int count = getDriver().findElements(By.xpath("//span[@class='sf-icon  color-green-primary size-lg remove-item']")).size();
				for (int i = 0; i < count; i++) {
					click(cartDeleteItemIcon);
					waitForServerToPerformAction(5);
				}
			}
		}catch (NoSuchElementException e){
			reportStep("No Product in cart","INFO");
		}
		clickWithSnap(sideMenuCloseIcon,"All item removed from cart");

	}
	public void searchProduct(String str) throws InterruptedException {
		waitForServerToPerformAction(3);
		waitForElementToLoad(searchBar);
		clickWithSnap(searchBar,"Search bar");
		clickWithSnap(searchBox,"Search box");
		readProductDetails(str);
		System.out.println("SKU : "+sku);
		typeAndEnter(searchBox,sku);
		waitForElementToLoad(searchResultItem);
	}
	public void verifyPDP() throws InterruptedException {

		waitForServerToPerformAction(6);
		clickWithSnap(searchResultItem,"Search Result");
		//clickElementByJavaScript(searchResultItem);
		//waitForElementToLoad(brandName_PDP);
		waitForElementToLoad(brandNamePDP);
		getDriver().navigate().refresh();
		isDisplayed(brandNamePDP);
		isDisplayed(productNamePDP);
		isDisplayed(skuProductPDP);
		isDisplayed(priceProductPDP);
		//isDisplayed(quantitySelectorPDP);
		//isDisplayed(addToCartPDPButton);
	}
	public void addEyewearToCart() throws InterruptedException {
		try{
			waitForServerToPerformAction(5);
			clickWithSnap(selectLenses_Eyewear,"Select Lenses is displayed");
			waitForElementToLoad(selectLensesPage_Eyewear);
			isDisplayed(noPrescriptionOption_Eyewear);
			clickWithSnap(noPrescriptionOption_Eyewear,"No Prescription Option");
			waitForElementToLoad(addToCartButton_Eyewear);
			clickWithSnap(addToCartButton_Eyewear,"Add to cart button");
			waitForElementToLoad(cartDeleteItemIcon);
			isDisplayed(proceedToBuyCartButton);
			clickWithSnap(proceedToBuyCartButton,"Prodcut added to cart");
			waitForElementToLoad(reviewTitleCartPage);
		}catch (Exception e){
		  e.printStackTrace();
		}
	}
	public void addToCart() throws InterruptedException {
		try{
			waitForServerToPerformAction(5);
			waitForElementToLoad(addToCartPDPButton);
			clickWithSnap(addToCartPDPButton,"Add to Cart button clicked");
			waitForElementToLoad(cartDeleteItemIcon);
			isDisplayed(proceedToBuyCartButton);
			clickWithSnap(proceedToBuyCartButton,"Prodcut added to cart");
			waitForElementToLoad(reviewTitleCartPage);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public void verifyCartPage() throws InterruptedException{
		isDisplayed(cartPageTitle);
		verifyOrderSummary();
		/*scrollIntoViewBottomOfScreen(checkoutButtonCart);
		System.out.println(isDisplayed(addCouponCodeCart));
		isDisplayed(addCouponCodeCart);
		clickWithSnap(addCouponCodeCart,"Coupon code field is displayed");
		isDisplayed(couponCodeInputCart);*/

	}
	public void deliveryOptions() throws InterruptedException{
		scrollIntoViewBottomOfScreen(checkoutButtonCart);
		isDisplayed(checkoutButtonCart);
		clickWithSnap(checkoutButtonCart,"Checkout Button is displayed");
		waitForElementToLoad(homeDeliveryOption);
		isDisplayed(homeDeliveryOption);
		isDisplayed(storePickupOption);
		verifyOrderSummary();
	}
	public void homeDeliveryOption() throws InterruptedException{
		waitForElementToLoad(homeDeliveryOption);
		isDisplayed(homeDeliveryOption);
		clickWithSnap(homeDeliveryOption,"Home Delivery Option is clicked");
	}
	public void storePickupOption() throws InterruptedException{
		waitForElementToLoad(storePickupOption);
		isDisplayed(storePickupOption);
		clickWithSnap(storePickupOption,"Store Pickup Option is clicked");
	}
	public void addShippingAddress() throws InterruptedException{
		waitForServerToPerformAction(5);
		waitForElementToLoad(shippingAddressTitlePage);
		verifyOrderSummary();
		try{
			if(isDisplayed(addNewAddressOption)){
				click(addNewAddressOption);
			}
		}catch (Exception e){
			reportStep("Default address is not present","INFO");
		}

		isDisplayed(firstNameShipping);
		isDisplayed(lastNameShipping);
		isDisplayed(addressShipping);
		isDisplayed(landmarkShipping);
		isDisplayed(stateDropdownShipping);
		isDisplayed(cityShipping);

		readAddressDetails();

		clickAndType(firstNameShipping,firstNameAddress);
		clickAndType(lastNameShipping,lastNameAddress);
		clickAndType(addressShipping,streetAddress);
		clickAndType(landmarkShipping,landmarkAddress);
		clickAndType(cityShipping,cityAddress);
		//click(stateDropdownShipping);
		selectDropDownUsingText(stateDropdownShipping,"Dubai");
		scrollIntoViewBottomOfScreen(postCodeShipping);
		isDisplayed(postCodeShipping);
		isDisplayed(phoneNumberShipping);

		clickAndType(postCodeShipping,"00000");
		clickAndType(phoneNumberShipping,phoneAddress);
		isDisplayed(billingAddressButton);
		clickWithSnap(billingAddressButton,"Shipping Address entered");
	}
	public void selectPickupStore() throws InterruptedException{

		waitForElementToLoad(storePickupPage);
		isDisplayed(firstPickupStore);
		click(firstPickupStore);
	}
	public void selectBillingAddress() throws InterruptedException{
		waitForElementToLoad(billingAddressTitlePage);
		verifyOrderSummary();
		waitForServerToPerformAction(3);
		isDisplayed(copyShippingAddressBilling);
		//clickElementByJavaScript(copyShippingAddressBilling);
		clickWithSnap(copyShippingAddressBilling,"Same as Shipping Address to billing");
		isDisplayed(paymentButton);
		clickWithSnap(paymentButton,"Billing Address Entered");
	}
	public void addBillingAddress() throws InterruptedException{
		waitForServerToPerformAction(5);
		waitForElementToLoad(billingAddressTitlePage);
		verifyOrderSummary();
		try {
			if(isDisplayed(addNewAddressOption)){
				click(addNewAddressOption);
			}
		}catch(NoSuchElementException e){
			reportStep("Default address not avaiable","INFO");
		}

		isDisplayed(firstNameShipping);
		isDisplayed(lastNameShipping);
		isDisplayed(addressShipping);
		isDisplayed(landmarkShipping);
		isDisplayed(stateDropdownShipping);
		isDisplayed(cityShipping);

		readAddressDetails();
		clickAndType(firstNameShipping,firstNameAddress);
		clickAndType(lastNameShipping,lastNameAddress);
		clickAndType(addressShipping,streetAddress);
		clickAndType(landmarkShipping,landmarkAddress);
		clickAndType(cityShipping,cityAddress);
		//click(stateDropdownShipping);
		selectDropDownUsingText(stateDropdownShipping,"Dubai");
		scrollIntoViewBottomOfScreen(postCodeShipping);
		isDisplayed(postCodeShipping);
		isDisplayed(phoneNumberShipping);

		clickAndType(postCodeShipping,"00000");
		clickAndType(phoneNumberShipping,phoneAddress);
		isDisplayed(paymentButton);
		clickWithSnap(paymentButton,"Billing Address Entered");
	}
	public void addCreditCard(String paymentType) throws InterruptedException{
		readPaymentDetails(paymentType);
		waitForElementToLoad(creditCardPaymentOption);
		verifyOrderSummary();
		isDisplayed(creditCardPaymentOption);
		clickWithSnap(creditCardPaymentOption,"Add Credit Card payment");
		waitForElementToLoad(creditCardTitlePage);
		verifyOrderSummary();
		switchToFrame(creditCardFrmae);
		isDisplayed(creditCardNumber);
		System.out.println(cardNumber);
		clickAndType(creditCardNumber,cardNumber);
		switchToParentFrame();
		switchToFrame(expiryYearFrame);
		isDisplayed(expiryYearCC);
		type(expiryYearCC,expDate);
		switchToParentFrame();
		switchToFrame(cvvCreditCardFrame);
		isDisplayed(cvvCreditCard);
		type(cvvCreditCard,cvv);
		switchToParentFrame();
		isDisplayed(reviewButtonCreditCard);
		clickWithSnap(reviewButtonCreditCard,"Review and Continue button");
	}
	public void orderReviewPage() throws InterruptedException{
		waitForElementToLoad(orderReviewPageTitle);
		verifyOrderSummary();
		waitForServerToPerformAction(5);
		isDisplayed(placeOrderButton);
		clickWithSnap(placeOrderButton,"Order Review Page is displayed");
	}
	public void checkoutAuth() throws InterruptedException{
		try{
			waitForServerToPerformAction(10);
			//waitForElementToLoad(checkout3DSSpinner);
			//verifyTitle("3DS2 Challenge");
			switchToFrame(checkout3DSFrame);
			waitForElementToLoad(checkout3DSPassword);
			isDisplayed(checkout3DSPassword);
			clickElementByJavaScript(checkout3DSPassword);
			type(checkout3DSPassword,"Checkout1!");
			isDisplayed(checkout3DSConfirm);
			click(checkout3DSConfirm);
			switchToParentFrame();
		}catch (StaleElementReferenceException e){
			reportStep("Checkout 3ds is displayed","Info");
		}
	}
	public void orderConfirmPage() throws InterruptedException{
		waitForElementToLoad(orderConfirmationPage);
		isDisplayed(orderConfirmationPage);
		isDisplayed(orderNumberConfrimPage);
		orderNum=orderNumberConfrimPage.getText().replace("Order No. #","").trim();
		System.out.println(orderNum);
		scrollIntoViewBottomOfScreen(orderHistoryButton);
		click(orderHistoryButton);
	}
	public void orderHistoryPage() throws InterruptedException{
		waitForServerToPerformAction(5);
		waitForElementToLoad(orderHistoryPage);
		String orderNumberHis=getDriver().findElement(By.xpath("(//span[contains(text(),'Order Number')]/following-sibling::span)[1]")).getAttribute("innerHTML").trim();
		if (orderNum.equals(orderNumberHis)){
			reportStep("Order is displayed in order history","Pass",true);
		}else{
			reportStep("Order is not displayed in order history","Fail",true);
		}

	}
	public void orderHistoryPageTest() throws InterruptedException{
		waitForServerToPerformAction(5);
		click(accountIcon);
		waitForServerToPerformAction(5);
		click(orderHistoryMenu);
		waitForElementToLoad(orderHistoryPage);
		String orderNumberHis=getDriver().findElement(By.xpath("(//span[contains(text(),'Order Number')]/following-sibling::span)[1]")).getAttribute("innerHTML").trim();
		System.out.println(orderNumberHis);
	}
	public void codOption() throws InterruptedException{
		waitForElementToLoad(codButtonOption);
		verifyOrderSummary();
		clickWithSnap(codButtonOption,"COD button is displayed");
	}
	public void cancelOrder(String userData) throws InterruptedException, FileNotFoundException {
		openNewTab();

		readProperties();

        //String url = prop.getProperty("US_URL");
		getDriver().get(url+"/track-your-order");
		waitForElementToLoad(trackYourOrderPage);
		isDisplayed(orderNumberTrack);
		isDisplayed(emailTrack);
		waitForServerToPerformAction(3);
		click(orderNumberTrack);
		waitForServerToPerformAction(2);
		type(orderNumberTrack,orderNum);
		readUserDetails(userData);
		type(emailTrack,emaildata);
		waitForElementToLoad(viewOrderStatus);
		clickWithSnap(viewOrderStatus,"View Order Button");
		waitForElementToLoad(cancelOrderButton);
		waitForServerToPerformAction(3);
		click(cancelOrderButton);
		waitForElementToLoad(cancelOrderSideBarButton);
		waitForServerToPerformAction(5);
		click(cancelOrderSideBarButton);
		waitForServerToPerformAction(5);
		try{
			if (isDisplayed(cancelledOrderText)){
				reportStep("Order is Cancelled","PASS",true);
			}
			else{
				reportStep("Order is not Cancelled","FAIL",true);
			}
		}catch (Exception e){
			reportStep("Order is not Cancelled","FAIL",true);
		}

	}
	public void selectTabbyPayment() throws InterruptedException {
		
		click(checkForEligibility);
		Thread.sleep(5000);
		isDisplayed(payWithTabby);
		clickWithSnap(payWithTabby, "Tabby button is displayed");
		waitForServerToPerformAction(3);
		waitForElementToLoad(enterCode);
		type(enterCode,"8888");
		Thread.sleep(3000);
		type(cardNumberTabby,"4111111111111111");
		type(ExpiryTabby,"1235");
		type(cvvTabby,"100");
		isDisplayed(payTabby);
		clickWithSnap(payTabby, "Tabby details are entered");
	}
	public void selectGPayPayment() {
		try {
			waitForElementToLoad(paymentMethod);
			click(gPayCTA);
			waitForServerToPerformAction(3);
			waitForElementToLoad(buyWithGpay);
			clickWithSnap(buyWithGpay, "GPay button is displayed");
			waitForServerToPerformAction(5);
			switchToWindow(1);
			waitForElementToLoad(gPayMail);
			click(gPayMail);
			isDisplayed(gPayMail);
			WebElement useremail = getDriver().findElement(By.id("identifierId"));
			JavascriptExecutor jse = (JavascriptExecutor)getDriver();
			jse.executeScript("arguments[0].value='subasrimaniraj98@gmail.com'", useremail);
			//clickAndType(gPayMail, "subasri.maniraju@nulogic.io");
			reportStep("Email is entered", "PASS", true);
			click(nextCTA);
			waitForElementToLoad(passwordField);
			click(passwordField);
			isDisplayed(passwordField);
			WebElement userpassword = getDriver().findElement(By.name("Passwd"));
			JavascriptExecutor jse1 = (JavascriptExecutor)getDriver();
			jse1.executeScript("arguments[0].value='Vin@yagay98'", userpassword);
			waitForServerToPerformAction(5);
			reportStep("Password is entered", "Pass", true);
			click(nextCTA);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//switchToFrame();
		
	}

	public void applyCoupon() {
		try {
			Actions action = new Actions(getDriver());
			action.click(getDriver().findElement(By.className("sf-accordion-item__header"))).build().perform();
			Thread.sleep(5000);
			reportStep("coupon is clicked", "Pass", true);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			for (int i=0 ; i < coupon.length ; i++) {
				action.sendKeys(getDriver().findElement(By.id("promoCode")),coupon[i]).build().perform();
				action.click(getDriver().findElement(By.className("apply"))).build().perform();
				Thread.sleep(5000);
				reportStep("coupon code is applied", "Pass", true);

				action.click(getDriver().findElement(By.className("remove"))).build().perform();
				Thread.sleep(2000);
			}


		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
