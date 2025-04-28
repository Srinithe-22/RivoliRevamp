package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import wdMethods.ProjMethods;

import java.awt.*;
import java.io.IOException;

public class HomePage_StepDefinitions extends ProjMethods {

	private HomePage homePage;

	public HomePage_StepDefinitions() {
		homePage = new HomePage();
	}

	@Given("I landing to the home page and see the Rivoli Icon")
	public void iLandingToTheHomePageAndSeeTheRivoliIcon() throws IOException, InterruptedException, AWTException {
		homePage.verifyHomePage();
	}

	@And("The user sees the header with customer Service and Language selection")
	public void theUserSeesTheHeaderWithCustomerServiceAndLanguageSelection() throws InterruptedException {
        homePage.headerSectionHomePage();
    }

	@Then("The user sees the main menus")
	public void theUserSeesTheMainMenus() throws InterruptedException {
		try{
			homePage.mainMenu();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	@And("the user able to see the search, Profile, Wishlist and Cart icon")
	public void theUserAbleToSeeTheSearchProfileWishlistAndCartIcon() throws InterruptedException {
		homePage.iconHomePage();
	}

	@Then("The user sees the promotion glide banner")
	public void theUserSeesThePromotionGlideBanner() throws InterruptedException {
		homePage.promoBanner();
	}

	@And("the users sees the shop by category, brand of the month, bestseller, Eyewear brand of the month, Eyewear bestseller, Our Top picks, Brands you may like")
	public void theUsersSeesTheShopByCategoryBrandOfTheMonthBestsellerEyewearBrandOfTheMonthEyewearBestsellerOurTopPicksBrandsYouMayLike() throws InterruptedException {
		homePage.homepageSections();
	}

	@Then("The user sees the About us in footer")
	public void theUserSeesTheAboutUsInFooter() throws InterruptedException {
		homePage.aboutUsFooter();
	}

	@And("The user sees the Shop in footer")
	public void theUserSeesTheShopInFooter() throws InterruptedException {
		homePage.shopFooter();
	}

	@Then("The user sees the Support in footer")
	public void theUserSeesTheSupportInFooter() throws InterruptedException {
		homePage.supportFooter();
	}

	@And("The user sees the Sign up for newsletters in footer")
	public void theUserSeesTheSignUpForNewslettersInFooter() throws InterruptedException {
		homePage.newsletterSignupFooter();
	}

	@Then("The user sees the follow us in footer")
	public void theUserSeesTheFollowUsInFooter() throws InterruptedException {
		homePage.followUsLinksFooter();
	}

	@And("The user sees the country in footer")
	public void theUserSeesTheCountryInFooter() throws InterruptedException {
		homePage.countryChangeFooter();
	}

	@Then("The user sees the privacy policy in footer")
	public void theUserSeesThePrivacyPolicyInFooter() throws InterruptedException {
		homePage.privacyPolicyFooter();
	}

	@And("The user sees the move to top icon")
	public void theUserSeesTheMoveToTopIcon() throws InterruptedException {
		homePage.scrollUpIconFunction();
	}

    @Then("Click on the profile icon and enter Login Information {string}")
    public void clickOnTheProfileIconAndEnterLoginInformation(String data) throws InterruptedException {
		homePage.loginFunctionality(data);
    }

	@And("Goto profile page, check the user data and logout")
	public void gotoProfilePageCheckTheUserDataAndLogout() throws InterruptedException {
		homePage.logoutFunctionality();
	}

	@Then("Click on the profile icon and click register link")
	public void clickOnTheProfileIconAndClickRegisterLink() throws InterruptedException {
		homePage.registrationLink();
	}

	@And("Enter new user details and register")
	public void enterNewUserDetailsAndRegister() throws InterruptedException {
		homePage.registrationFormPage();
	}


	@Then("Verify the Watches category")
	public void verifyTheWatchesCategory() {

	}

	@And("Verify the Sunglasses category")
	public void verifyTheSunglassesCategory() {
	}

	@Then("Verify the Eyeglasses category")
	public void verifyTheEyeglassesCategory() {
	}

	@And("Verify the Lenses category")
	public void verifyTheLensesCategory() {
	}

	@Then("Verify the Jelwery category")
	public void verifyTheJelweryCategory() {
	}

	@And("Verify the Accessories category")
	public void verifyTheAccessoriesCategory() {
	}

	@Then("Login user {string}")
	public void loginUser(String data) throws InterruptedException {
		homePage.loginUser(data);
	}
}
