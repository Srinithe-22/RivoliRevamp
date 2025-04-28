package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ReadExcel;
import wdMethods.ProjMethods;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class HomePage extends ProjMethods{


	protected Properties prop;
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	// new repo
	//@FindBy(how = How.XPATH, using = "//*[@id='header']/div/div/header/a/img")
	@FindBy(how = How.XPATH, using = "(//img[@class='sf-header__logo-image'])[2]")
	public WebElement rivoliLogo;

	@FindBy(how = How.XPATH, using = "//*[@id='__layout']/div/div[1]/div/div[1]/a")
	public WebElement customerServiceHeader;

	@FindBy(how = How.XPATH, using = "//*[@id='__layout']/div/div[1]/div/div[3]/button")
	public WebElement countryChangeHeader;

	@FindBy(how = How.XPATH, using ="//*[@id='__layout']/div/div[9]/div/aside/div/div[1]/div/h2")
	public WebElement changeCountryTitle;

	@FindBy(how = How.XPATH, using ="(//*[contains(text(), 'By selecting your country, you will have all the products available in your region.')])[1]//div//h2")
	public WebElement changeCountryInfo;

	@FindBy(how = How.XPATH, using="//*[text()='United Arab Emirates']")
	public WebElement chaneCountry_UAE;
	@FindBy(how = How.XPATH, using="//*[text()='Bahrain']")
	public WebElement chaneCountry_Bahrain;
	@FindBy(how = How.XPATH, using="//*[text()='Qatar']")
	public WebElement chaneCountry_Qatar;
	@FindBy(how = How.XPATH, using="//*[text()='United Arab Emirates']")
	public WebElement chaneCountry_Oman;
	@FindBy(how = How.XPATH, using="//*[@class='sidebar-icon sidebar-icon--right sf-icon']")
	public WebElement sideMenuCloseIcon;

	@FindBy(how = How.XPATH, using="//a[contains(@aria-label, 'Watches')]")
	public WebElement watchesMenu;
	@FindBy(how = How.XPATH, using="//a[contains(@aria-label, 'Sunglasses')]")
	public WebElement sunglassesMenu;
	@FindBy(how = How.XPATH, using="//a[contains(@aria-label, 'Eyeglasses')]")
	public WebElement eyeglassesMenu;
	@FindBy(how = How.XPATH, using="//a[contains(@aria-label, 'Contact Lenses')]")
	public WebElement lensesMenu;
	@FindBy(how = How.XPATH, using="//a[contains(@aria-label, 'Jewelry')]")
	public WebElement jewelryMenu;
	@FindBy(how = How.XPATH, using="//a[contains(@aria-label, 'Accessories')]")
	public WebElement accessoriesMenu;
	@FindBy(how = How.XPATH, using="//a[contains(@aria-label, 'Offers')]")
	public WebElement offersMenu;

	@FindBy(how = How.XPATH, using="//*[text()='GENDER']")
	public WebElement genderMenu;

	@FindBy(how = How.XPATH, using="(//*[@aria-label='Search'])[1]")
	public WebElement searchBar;
	//@FindBy(how = How.XPATH, using="//*[@aria-label='account button']")
	@FindBy(how = How.XPATH, using="(//*[@aria-label='account button'])[2]")
	public WebElement accountIcon;
	@FindBy(how = How.XPATH, using="//*[@aria-label='wishlist icon']")
	public WebElement wishlistIcon;
	@FindBy(how = How.XPATH, using="//*[@aria-label='cart icon']")
	public WebElement cartIcon;
	@FindBy(how = How.XPATH, using="//h2[contains(text(),'Login')]")
	public WebElement loginSideMenu;
	@FindBy(how = How.XPATH, using="//div[contains(text(),'Cart')]")
	public WebElement cartSideMenu;
	@FindBy(how = How.XPATH, using="(//span[text()='Trending Searches'])[1]")
	public WebElement treandingSearch;

	@FindBy(how = How.XPATH, using="//ul[@class='glide__slides sf-hero__slides']")
	public WebElement glideSlideBannerImage;
	@FindBy(how = How.XPATH, using="//h2[contains(text(),'Shop By Category')]")
	public WebElement shopByCategoryTitle;
	@FindBy(how = How.XPATH, using="//h1[contains(text(),'Brand of the Month - Watches')]")
	public WebElement brandoftheMonthWatchesTitle;
	@FindBy(how = How.XPATH, using="//h2[contains(text(),'Bestseller Brands - Watches')]")
	public WebElement bestsellerBrandsWatchesTitle;
	@FindBy(how = How.XPATH, using="//h1[contains(text(),'Brand of the Month - Eyewear')]")
	public WebElement brandOfTheMonthEyewearTitle;
	@FindBy(how = How.XPATH, using="//h2[contains(text(),'Bestseller Brands - Eyewear')]")
	public WebElement bestsellerBrandEyewearTitle;
	@FindBy(how = How.XPATH, using="//h2[contains(text(),'Our Top Picks')]")
	public WebElement ourTopPicksTitle;
	@FindBy(how = How.XPATH, using="//h2[contains(text(),'Brands You May Like')]")
	public WebElement brandYouMayLikeTitle;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'About Us')]")
	public WebElement aboutUsFooter;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Shop')]")
	public WebElement shopFooter;
	@FindBy(how = How.XPATH, using="//button[contains(text(),'Support')]")
	public WebElement supportFooter;
	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Sign up to our newsletter')]")
	public WebElement newsletterSignUpFooter;
	@FindBy(how = How.XPATH, using="//*[@class='newsletter']//*[@id='e-mail']")
	public WebElement newsletterEmailField;
	@FindBy(how = How.XPATH, using="//*[@class='newsletter']//*[@aria-label='news letter button']")
	public WebElement newsletterSignUpButton;
	@FindBy(how = How.XPATH, using="//h2[contains(text(),'Newsletter')]")
	public WebElement newsletterSideBar;
	@FindBy(how = How.XPATH, using="//input[@id='first-name']")
	public WebElement newsletterSideBarFirstName;
	@FindBy(how = How.XPATH, using="//input[@id='last-name']")
	public WebElement newsletterSideBarLastName;
	@FindBy(how = How.XPATH, using="//div[@id='newsletter-sidebar']//input[@id='phoneNumber']")
	public WebElement newsletterSideBarMobileNumber;
	@FindBy(how = How.XPATH, using="//button[@type='submit']//*[contains(text(),'Submit')]")
	public WebElement newsletterSideBarSubmit;
	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Country')]")
	public WebElement countryTitleFooter;
	@FindBy(how = How.XPATH, using="//*[@id=\"footer\"]/footer/div/div[4]/div/p")
	public WebElement countryChangeFooter;
	@FindBy(how = How.XPATH, using="//h5[contains(text(),'Follow Us')]")
	public WebElement followUSFooter;
	@FindBy(how = How.XPATH, using="//footer//*[@alt='Facebook']")
	public WebElement facebookLinkFooter;
	@FindBy(how = How.XPATH, using="//footer//*[@alt='Instagram']")
	public WebElement instagramLinkFooter;
	@FindBy(how = How.XPATH, using="//footer//*[@alt='Youtube']")
	public WebElement youtubeLinkFooter;

	@FindBy(how = How.XPATH, using="//div[@class='bank-option']")
	public WebElement bankOptionFooter;
	@FindBy(how = How.XPATH, using="//*[text()='@ 2024 Rivoli Group LLC. All Rights Reserved.']")
	public WebElement rightsRivoliTextFooter;
	@FindBy(how = How.XPATH, using="//p[contains(text(),'Terms & Conditions')]")
	public WebElement termsAndConditionLinkFooter;
	@FindBy(how = How.XPATH, using="//p[contains(text(),'Privacy & Cookies Policy')]")
	public WebElement privacyCookieLinkFooter;
	@FindBy(how = How.XPATH, using="//p[contains(text(),'Delivery & Returns')]")
	public WebElement deliveryReturnLinkFooter;
	@FindBy(how = How.XPATH, using="//strong['Terms and Conditions']")
	public WebElement termsAndConditionPage;
	@FindBy(how = How.XPATH, using="//h1['Privacy Policy']")
	public WebElement privacyPolicyPage;
	@FindBy(how = How.XPATH, using="//h2[contains(text(),'Delivery & Returns')]")
	public WebElement deliveryReturnsPage;

	@FindBy(how = How.XPATH, using="//header//button//img[@alt='Menu']")
	public WebElement mHandBurgerIcon;
	@FindBy(how = How.XPATH, using="//button[@class='sf-button scroll-top-button sf-icon color-white  active sf-circle-icon']")
	public WebElement scrollUpIcon;
	@FindBy(how = How.XPATH, using="//div[@id='login']//h2['Login']")
	public WebElement loginTextSideBar;
	@FindBy(how = How.XPATH, using="//div[@id='login']//input[@id='email']")
	public WebElement emailInputLoginSideBar;
	@FindBy(how = How.XPATH, using="//div[@id='login']//input[@id='password']")
	public WebElement passwordInputLoginSideBar;

	@FindBy(how = How.XPATH, using="//div[@id='login']//a[contains(text(),'Forgot Your Password?')]")
	public WebElement forgotPasswordLoginSideBar;
	@FindBy(how = How.XPATH, using="//div[@id='login']//button//div[contains(text(),'Login')]")
	public WebElement loginButtonLoginSideBar;
	@FindBy(how = How.XPATH, using="//div[@id='login']//span[contains(text(),'Sign in with Google')]")
	public WebElement googleSignInLoginSideBar;
	@FindBy(how = How.XPATH, using="//*[text()=\"Continue with Facebook\"]")
	public WebElement facebookLoginSideBar;
	@FindBy(how = How.XPATH, using="//*[@id='login']/div/aside/div[2]/div/div/a")
	public WebElement registerLinkLoginSideBar;

	@FindBy(how = How.XPATH, using="//h2[contains(text(),'Forgot Password')]")
	public WebElement forgotPasswordSideBar;
	@FindBy(how = How.XPATH, using="//div[@class='recaptcha-checkbox-border']")
	public WebElement reCaptchaCheckboxSideBar;
	@FindBy(how = How.XPATH, using="//div[text()='Submit']")
	public WebElement submitButtonSideBar;
	@FindBy(how = How.XPATH, using="//span[@class='mobile-header__icons__back sf-icon color-black']")
	public WebElement backButtonSideBar;
	@FindBy(how = How.XPATH, using="//h1[text()='My Account']")
	public WebElement myAccountPage;
	@FindBy(how = How.XPATH, using="//div[@class='sf-tabs']//button[contains(text(),'Personal Data')]")
	public WebElement personalDetailsTab;
	@FindBy(how = How.XPATH, using="//span[contains(text(),'Log out')]")
	public WebElement logOutLinkAccount;

	@FindBy(how = How.XPATH, using="//h2[contains(text(),'Register')]")
	public WebElement registrationTitleSideBar;
	@FindBy(how = How.XPATH, using="//input[@id='first-name']")
	public WebElement registrationFirstName;
	@FindBy(how = How.XPATH, using="//input[@id='last-name']")
	public WebElement registrationSecondName;
	@FindBy(how = How.XPATH, using="//input[@id='phoneNumber']")
	public WebElement registrationPhoneNumber;
	@FindBy(how = How.XPATH, using="//input[@id='email']")
	public WebElement registrationEmail;
	@FindBy(how = How.XPATH, using="//input[@id='password']")
	public WebElement registrationPassword;
	@FindBy(how = How.XPATH, using="//input[@id='repeatPassword']")
	public WebElement registrationConfirmPassword;
	@FindBy(how = How.XPATH, using="//div[@class='sf-checkbox__checkmark']")
	public WebElement registrationNewsletter;
	@FindBy(how = How.XPATH, using="//div[@id='rc-anchor-container']")
	public WebElement registrationCaptcha;
	@FindBy(how = How.XPATH, using="//button//div[text()='Create an account']")
	public WebElement registrationSubmitButton;
	@FindBy(how = How.XPATH, using="//a[text()='Terms & Conditions']")
	public WebElement registrationTermsCondition;


	// (//nav[@class='sf-header__navigation']//div[@class='sf-mega-menu__menu'])[1]//button
	//	(//nav[@class='sf-header__navigation']//div[@class='sf-mega-menu__menu'])[1]//div//div//a



	/////////////////////////////////////////////////////////////////////
	// Home Page Function
	ReadExcel user = new ReadExcel();
	String[][] data = user.getSheet("datasheet.xlsx","user");
	//String[][] browserProp = user.getSheet("datasheet.xlsx","browserProperties");
	String emaildata = null;
	String passworddata = null;
	String firstname = null;
	String lastname = null;
	public void readUserDetails(String mailid) {
		prop=new Properties();
		try {
			prop.load(Files.newInputStream(new File("./src/main/resources/resources.properties").toPath()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		String env=prop.getProperty("ENVIRONMENT");
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
	public void verifyHomePage() {
		waitForElementToLoad(rivoliLogo);
		reportStep("Successfully Landed to Home Page", "INFO");
	}
	public void headerSectionHomePage() throws InterruptedException {
		verifyDisplayed(customerServiceHeader);
		verifyDisplayed(countryChangeHeader);

		// Click Customer Service Link and verify the page//

		clickWithSnap(customerServiceHeader,"customer service link");
		switchToWindow(1);
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleIs("Customer Service"));
		waitForElementToLoad(rivoliLogo);
		verifyTitle("Customer Service");
		reportStep("Customer Service page is displayed","INFO",true);
		closeTab();
		switchToWindow(0);
		wait.until(ExpectedConditions.titleIs("Shop Watches & Eyewear UAE | All Premium Brands | RivoliShop"));
		verifyTitle("Shop Watches & Eyewear UAE | All Premium Brands | RivoliShop");

		// Click Change Country Link and verify the options//
		clickWithSnap(countryChangeHeader,"Change country link");
		waitForElementToLoad(changeCountryTitle);
		verifyDisplayed(changeCountryInfo);
		verifyDisplayed(chaneCountry_Bahrain);
		verifyDisplayed(chaneCountry_UAE);
		verifyDisplayed(chaneCountry_Qatar);
		verifyDisplayed(chaneCountry_Oman);
		clickWithSnap(sideMenuCloseIcon,"Change Country Sidebar");
		reportStep("Change Country is displayed","INFO",true);

	}
	public void mainMenu() throws InterruptedException {

		/*if(isDisplayed(mHandBurgerIcon)){
			clickWithSnap(mHandBurgerIcon,"Hand Burger Menu is displayed");
		}*/
		verifyDisplayed(watchesMenu);
		verifyDisplayed(sunglassesMenu);
		verifyDisplayed(eyeglassesMenu);
		verifyDisplayed(lensesMenu);
		verifyDisplayed(jewelryMenu);
		verifyDisplayed(accessoriesMenu);
		verifyDisplayed(offersMenu);
		//moveToElement(watchesMenu);

	}
	public void iconHomePage() throws InterruptedException{
		verifyDisplayed(searchBar);
		verifyDisplayed(accountIcon);
		verifyDisplayed(wishlistIcon);
		verifyDisplayed(cartIcon);
		click(searchBar);
		waitForElementToLoad(treandingSearch);
		reportStep("Search option is displayed","Pass",true);

		click(accountIcon);
		waitForElementToLoad(loginSideMenu);
		clickWithSnap(sideMenuCloseIcon,"Login Sidebar");

		click(wishlistIcon);
		waitForElementToLoad(loginSideMenu);
		clickWithSnap(sideMenuCloseIcon,"Login Sidebar");
		click(cartIcon);
		waitForElementToLoad(cartSideMenu);
		clickWithSnap(sideMenuCloseIcon,"Login Sidebar");


	}
	public void promoBanner() throws InterruptedException{
		isDisplayed(glideSlideBannerImage);
		List<WebElement> slide = getDriver().findElements(By.cssSelector("div.sf-hero li"));
		System.out.println("List size is: " + slide.size());
		if(slide.size()>0){
			reportStep("The Hero banner slide images are displayed", "Pass",true);
		}

	}
	public void homepageSections() throws InterruptedException{

		WebElement[] ele={shopByCategoryTitle,brandoftheMonthWatchesTitle,bestsellerBrandsWatchesTitle,brandOfTheMonthEyewearTitle,bestsellerBrandEyewearTitle,ourTopPicksTitle,brandYouMayLikeTitle};
	for(int i=0;i<ele.length;i++){
		scrollIntoViewBottomOfScreen(ele[i]);
		if(isDisplayed(ele[i])){
			reportStep(ele[i].getText()+ " is displayed","Pass",true);
		}

	}
	reportStep("All Home page Titles are displayed","Pass");
	}
	public void aboutUsFooter() throws InterruptedException{
		scrollIntoViewBottomOfScreen(aboutUsFooter);
		List<WebElement> slide = getDriver().findElements(By.cssSelector("#footer > footer > div > div:nth-child(1) > div > ul li"));
		String[] aboutUSOptions={"Our Story","Store Locator","Rivoli Group","Rivoli Vision"};
		String[] aboutUSTabs={"About Us | Rivoli","Store Locator | Rivoli","Rivoli | LUXURY LIFESTYLE RETAIL","Vision Care | Rivoli"};
		for (int i=0;i<slide.size();i++) {
			//System.out.println(slide.get(i).getText());
			if(slide.get(i).getText().equals(aboutUSOptions[i])){
				reportStep(aboutUSOptions[i]+" is displayed","Pass",true);
				click(slide.get(i));
				switchToWindow(1);
				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
				wait.until(ExpectedConditions.titleIs(aboutUSTabs[i]));
				verifyTitle(aboutUSTabs[i]);
				reportStep(aboutUSTabs[i]+" is displayed","Pass",true);
				closeTab();
				switchToWindow(0);
			}


		}
	}
	public void shopFooter() throws InterruptedException{
		getDriver().navigate().refresh();
		scrollIntoViewBottomOfScreen(shopFooter);
		List<WebElement> slide = getDriver().findElements(By.cssSelector("#footer > footer > div > div:nth-child(2) > div > ul li"));
		String[] shopOptions={"Watches","Sunglasses","Eyeglasses","Contact Lenses","Jewelry","Accessories"};
		//String[] aboutUSTabs={"Watches","Shop Sunglasses Online With Free Shipping - RivoliShop.com","Shop Eyeglasses Online With Free Shipping - RivoliShop.com","Shop Online Contact Lenses & Color Lenses - RivoliShop.com","Shop & Save on Branded Jewelry Online - RivoliShop.com","Shop Writing Instruments, Belts, Straps & More - RivoliShop.com","Upto 60% Off on Watches With Free Shipping at RivoliShop.com"};

		for (int i=1;i<slide.size()-1;i++) {
			//System.out.println(slide.get(i).getText());
			//scrollIntoViewTopOfScreen(shopFooter);
			if(slide.get(i).getText().equals(shopOptions[i])){
				reportStep(shopOptions[i]+" option is displayed","Pass",true);
				click(slide.get(i));
				//switchToWindow(1);
				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
				//wait.until(ExpectedConditions.titleIs(aboutUSTabs[i]));
				waitForElementToLoad(getDriver().findElement(By.xpath("//h1[contains(text(),'"+shopOptions[i]+"')]")));
				//verifyTitle(aboutUSTabs[i]);
				reportStep(shopOptions[i]+" page is displayed","Pass",true);
				//closeTab();
				//switchToWindow(0);
				getDriver().navigate().back();
				waitForElementToLoad(shopFooter);
			}


		}
	}
	public void supportFooter() throws InterruptedException{
		getDriver().navigate().refresh();
		scrollIntoViewBottomOfScreen(supportFooter);
		List<WebElement> slide = getDriver().findElements(By.cssSelector("#footer > footer > div > div:nth-child(3) > div > ul li"));
		String[] supportOptions={"Track Your Order","Contact Us","FAQs","Corporate Gifting","Become an Affiliate","Tabby Buy Now Pay Later"};
		String[] supportTabs={"Track Your Order","Contact Us","FAQ - Rivoli Shop","Our Offerings | Rivoli","Become an affiliate","Shop now. Pay later with tabby."};
		for (int i=0;i<slide.size();i++) {
			if(slide.get(i).getText().equals(supportOptions[i])){
				reportStep(supportOptions[i]+" option is displayed","Pass",true);
				click(slide.get(i));
				if(supportOptions[i].equals("Corporate Gifting")){
					switchToWindow(1);
				}

				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
				wait.until(ExpectedConditions.titleIs(supportTabs[i]));
				//waitForElementToLoad(getDriver().findElement(By.xpath("//h1[contains(text(),'"+aboutUSOptions[i]+"')]")));
				verifyTitle(supportTabs[i]);
				reportStep(supportTabs[i]+" page is displayed","Pass",true);
				if(supportOptions[i].equals("Corporate Gifting")){
					closeTab();
					switchToWindow(0);
				}
				else {
					getDriver().navigate().back();
				}
				waitForElementToLoad(supportFooter);
			}

		}
	}
	public void newsletterSignupFooter() throws InterruptedException{
		scrollIntoViewTopOfScreen(newsletterSignUpFooter);
		reportStep("Sign up for newsletter is displayed","Pass",true);
		isDisplayed(newsletterEmailField);
		type(newsletterEmailField,"testaccount1@yopmail.com");
		isDisplayed(newsletterSignUpButton);
		clickWithSnap(newsletterSignUpButton,"Newsletter Sign up Button");
		waitForElementToLoad(newsletterSideBar);
		isDisplayed(newsletterSideBarFirstName);
		type(newsletterSideBarFirstName,"John");
		isDisplayed(newsletterSideBarLastName);
		type(newsletterSideBarLastName,"Doe");
		isDisplayed(newsletterSideBarMobileNumber);
		type(newsletterSideBarMobileNumber,"987654321");
		isDisplayed(newsletterSideBarSubmit);
		clickWithSnap(newsletterSideBarSubmit,"Newsletter Sign up Side Bar");
	}
	public void followUsLinksFooter() throws InterruptedException{
		scrollIntoViewTopOfScreen(followUSFooter);
		isDisplayed(followUSFooter);
		isDisplayed(facebookLinkFooter);
		isDisplayed(instagramLinkFooter);
		isDisplayed(youtubeLinkFooter);
		reportStep("Follow Us and Social links are displayed","Pass",true);
		click(facebookLinkFooter);
		switchToWindow(1);
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleIs("Hour Choice | Facebook"));
		verifyTitle("Hour Choice | Facebook");
		reportStep("Facebook page is displayed","Pass",true);
		closeTab();
		switchToWindow(0);

		click(instagramLinkFooter);
		switchToWindow(1);
		wait.until(ExpectedConditions.titleIs("Hour Choice (@hourchoice) • Instagram photos and videos"));
		verifyTitle("Hour Choice (@hourchoice) • Instagram photos and videos");
		reportStep("Instagram page is displayed","Pass",true);
		closeTab();
		switchToWindow(0);

		click(youtubeLinkFooter);
		switchToWindow(1);
		wait.until(ExpectedConditions.titleIs("Rivoli Group - YouTube"));
		verifyTitle("Rivoli Group - YouTube");
		reportStep("Youtube page is displayed","Pass",true);
		closeTab();
		switchToWindow(0);


	}
	public void countryChangeFooter() throws InterruptedException{
		scrollIntoViewTopOfScreen(countryTitleFooter);
		isDisplayed(countryTitleFooter);
		clickWithSnap(countryChangeFooter,"Change country at Footer link");
		waitForElementToLoad(changeCountryTitle);
		verifyDisplayed(changeCountryInfo);
		verifyDisplayed(chaneCountry_Bahrain);
		verifyDisplayed(chaneCountry_UAE);
		verifyDisplayed(chaneCountry_Qatar);
		verifyDisplayed(chaneCountry_Oman);
		clickWithSnap(sideMenuCloseIcon,"Change Country Sidebar");
		reportStep("Change Country is displayed","INFO",true);

	}
	public void privacyPolicyFooter() throws InterruptedException{
		scrollIntoViewTopOfScreen(bankOptionFooter);
		isDisplayed(bankOptionFooter);
		isDisplayed(rightsRivoliTextFooter);
		isDisplayed(termsAndConditionLinkFooter);
		isDisplayed(privacyCookieLinkFooter);
		isDisplayed(deliveryReturnLinkFooter);
		reportStep("Bank, Rights, Terms & Condition, Privacy Policy, Delivery Return links displayed","Pass",true);
		String[] banks={"Visa","Master Card"};
		for(int i=0;i<banks.length;i++){
			isDisplayed(getDriver().findElement(By.xpath("//div[@class='bank-option']//img[@alt='"+banks[i]+"']")));
		}
		click(termsAndConditionLinkFooter);
		waitForElementToLoad(termsAndConditionPage);
		reportStep("Terms And Condition Page is displayed","Pass",true);
		getDriver().navigate().back();

		scrollIntoViewTopOfScreen(bankOptionFooter);
		click(privacyCookieLinkFooter);
		waitForElementToLoad(privacyPolicyPage);
		reportStep("Privacy and Cookie Policy Page is displayed","Pass",true);
		getDriver().navigate().back();

		scrollIntoViewTopOfScreen(bankOptionFooter);
		click(deliveryReturnLinkFooter);
		waitForElementToLoad(deliveryReturnsPage);
		reportStep("Delivery and Return Page is displayed","Pass",true);
		waitForServerToPerformAction(10);
		getDriver().navigate().back();
	}
	public void scrollUpIconFunction() throws InterruptedException{
		scrollIntoViewBottomOfScreen(aboutUsFooter);
		isDisplayed(scrollUpIcon);
		clickWithSnap(scrollUpIcon,"Clicked scroll up Icon");
		waitForElementToLoad(shopByCategoryTitle);
		reportStep("Page scrolled up after clicking Icon","Pass",true);

	}
	public void  loginFunctionality(String data) throws InterruptedException {
		waitForElementToLoad(accountIcon);
		clickWithSnap(accountIcon, "Profile Icon");
		waitForElementToLoad(loginSideMenu);
		isDisplayed(sideMenuCloseIcon);
		reportStep("Login Side bar is displayed", "Pass", true);
		isDisplayed(loginTextSideBar);
		isDisplayed(emailInputLoginSideBar);
		isDisplayed(passwordInputLoginSideBar);
		readUserDetails(data);
		type(emailInputLoginSideBar, emaildata);
		type(passwordInputLoginSideBar, passworddata);
		reportStep("User Login data enter in input fields", "Pass", true);
		isDisplayed(forgotPasswordLoginSideBar);
		isDisplayed(loginButtonLoginSideBar);
		isDisplayed(googleSignInLoginSideBar);
		//scrollIntoViewBottomOfScreen(registerLinkLoginSideBar);
		isDisplayed(facebookLoginSideBar);
		isDisplayed(registerLinkLoginSideBar);

		clickWithSnap(forgotPasswordLoginSideBar, "CLicked forgot password");
		waitForElementToLoad(forgotPasswordSideBar);
		isDisplayed(emailInputLoginSideBar);
		isDisplayed(sideMenuCloseIcon);
		isDisplayed(backButtonSideBar);
		isDisplayed(reCaptchaCheckboxSideBar);
		isDisplayed(submitButtonSideBar);
		clickWithSnap(backButtonSideBar, "Forgot password Side Bar is displayed");
		waitForElementToLoad(emailInputLoginSideBar);
		click(loginButtonLoginSideBar);
		waitForServerToPerformAction(5);
		//System.out.println("Cart icon is displayed");
		//click(sideMenuCloseIcon);
		//waitTime(short_wait);

	}
	public void  loginUser(String data) throws InterruptedException {
		waitForElementToLoad(accountIcon);
		clickWithSnap(accountIcon, "Profile Icon");
		waitForElementToLoad(loginSideMenu);
		isDisplayed(sideMenuCloseIcon);
		reportStep("Login Side bar is displayed", "Pass", true);
		readUserDetails(data);
		type(emailInputLoginSideBar, emaildata);
		type(passwordInputLoginSideBar, passworddata);
		reportStep("User Login data enter in input fields", "Pass", true);
		click(loginButtonLoginSideBar);
		waitForServerToPerformAction(5);
	}
	public void logoutFunctionality() throws InterruptedException{
			//waitForElementToLoad(loginSideMenu);
			//click(loginButtonLoginSideBar);
			waitForElementToLoad(accountIcon);
			click(accountIcon);
			waitForElementToLoad(myAccountPage);
			isDisplayed(personalDetailsTab);
			clickWithSnap(logOutLinkAccount,"My Accout page is displayed");

	}
	public void registrationLink() throws InterruptedException{
		waitForElementToLoad(accountIcon);
		clickWithSnap(accountIcon, "Profile Icon");
		waitForElementToLoad(loginSideMenu);
		isDisplayed(registerLinkLoginSideBar);
		clickWithSnap(registerLinkLoginSideBar,"Registration link clicked");

	}
	public void registrationFormPage() throws InterruptedException{
		waitForElementToLoad(registrationTitleSideBar);
		isDisplayed(registrationFirstName);
		isDisplayed(registrationSecondName);
		isDisplayed(registrationPhoneNumber);
		isDisplayed(registrationEmail);
		isDisplayed(registrationPassword);
		isDisplayed(registrationConfirmPassword);
		isDisplayed(registrationNewsletter);
		isDisplayed(registrationCaptcha);

		String email = generateRandomEmail();
		String phoneNum = generateRandomCellPhoneNum();
		System.out.println(email);
		System.out.println(phoneNum);

		type(registrationFirstName,"John");
		type(registrationSecondName,"Doe");
		type(registrationPhoneNumber,phoneNum);
		type(registrationEmail,email);
		type(registrationPassword,"Rivoli@2024");
		type(registrationConfirmPassword,"Rivoli@2024");
		click(registrationNewsletter);
		scrollIntoViewBottomOfScreen(registrationTermsCondition);
		//clickElementByJavaScript(registrationCaptcha);
		//click(registrationCaptcha);
		//ReCaptcha_click();
		click(registrationSubmitButton);
		waitForElementToLoad(registrationTitleSideBar);

	}
	public void watchesCategory() throws InterruptedException{
		verifyDisplayed(watchesMenu);
		//moveToElement(watchesMenu);

	}

}
