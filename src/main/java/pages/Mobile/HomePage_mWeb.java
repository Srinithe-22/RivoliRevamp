/*
package pages.Mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.webElementsList;
import utils.ReadExcel;
import wdMethods.ProjMethods;

import java.util.List;
import java.util.Properties;

public class HomePage_mWeb extends ProjMethods implements webElementsList{


	protected Properties prop;
	public HomePage_mWeb() {
		PageFactory.initElements(getDriver(), this);
	}
	// new repo

	@FindBy(how = How.XPATH, using = "//*[@id='header']/div/div/header/a/img")
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
	@FindBy(how = How.XPATH, using="//*[contains(@class,'sidebar-icon sidebar-icon--right sf-icon')]")
	public WebElement sideMenuCloseIcon;

	@FindBy(how = How.XPATH, using="//div[text()='Watches']")
	public WebElement watchesMenu;
	@FindBy(how = How.XPATH, using="//div[text()='Sunglasses']")
	public WebElement sunglassesMenu;
	@FindBy(how = How.XPATH, using="//div[text()='Eyeglasses']")
	public WebElement eyeglassesMenu;
	@FindBy(how = How.XPATH, using="//div[text()='Contact Lenses']")
	public WebElement lensesMenu;
	@FindBy(how = How.XPATH, using="//div[text()='Jewelry']")
	public WebElement jewelryMenu;
	@FindBy(how = How.XPATH, using="//div[text()='Accessories']")
	public WebElement accessoriesMenu;
	@FindBy(how = How.XPATH, using="//a[contains(text(),'Offers')]")
	public WebElement offersMenu;

	@FindBy(how = How.XPATH, using="//*[text()='GENDER']")
	public WebElement genderMenu;

	@FindBy(how = How.XPATH, using="(//*[@aria-label='Search'])[1]")
	public WebElement searchBar;
	@FindBy(how = How.XPATH, using="//*[@aria-label='account button']")
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

	@FindBy(how = How.XPATH, using="(//ul[@class='glide__slides sf-hero__slides']")
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
	@FindBy(how = How.XPATH, using="//h2['Delivery & Returns']")
	public WebElement deliveryReturnsPage;

	@FindBy(how = How.XPATH, using="//header//button//img[@alt='Menu']")
	public WebElement mHandBurgerIcon;






	/////////////////////////////////////////////////////////////////////
	// Home Page Function
	ReadExcel user = new ReadExcel();
	String[][] data = user.getSheet("datasheet.xlsx","user");
	String emaildata = null;
	String passworddata = null;
	String firstname = null;
	String lastname = null;
	public void readUserDetails() {
		for (int i = 0; i < data.length; i++) {
			if (data[i][6].equalsIgnoreCase("Y") || data[i][6].equalsIgnoreCase("Yes")) {
				for (int j = 0; j < data[i].length; j++) {
					firstname = data[i][1];
					lastname = data[i][2];
					emaildata = data[i][3];
					passworddata = data[i][4];
				}
			}
		}
	}


	public void verifyHomePage() {
		waitForElementToLoad(rivoliLogo);
		reportStep("Successfully Landed to Home Page", "INFO");
	}
	public void mainMenu() throws InterruptedException {
		isDisplayed(mHandBurgerIcon);
		clickWithSnap(mHandBurgerIcon,"Hand Burger Menu is displayed");

		verifyDisplayed(watchesMenu);
		verifyDisplayed(sunglassesMenu);
		verifyDisplayed(eyeglassesMenu);
		verifyDisplayed(lensesMenu);
		verifyDisplayed(jewelryMenu);
		verifyDisplayed(accessoriesMenu);
		verifyDisplayed(offersMenu);
		//moveToElement(watchesMenu);
		clickWithSnap(sideMenuCloseIcon,"All menus are displayed");
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
				WebDriverWait wait = new WebDriverWait(getDriver(), 30);
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
				WebDriverWait wait = new WebDriverWait(getDriver(), 30);
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
		String[] supportOptions={"Contact Us","FAQs","Corporate Gifting","Become an Affiliate"};
		String[] supportTabs={"Contact Us","FAQ","Our Offerings | Rivoli","Become an affiliate"};
		for (int i=0;i<slide.size();i++) {
			if(slide.get(i).getText().equals(supportOptions[i])){
				reportStep(supportOptions[i]+" option is displayed","Pass",true);
				click(slide.get(i));
				if(supportOptions[i].equals("Corporate Gifting")){
					switchToWindow(1);
				}

				WebDriverWait wait = new WebDriverWait(getDriver(), 30);
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
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
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
		String[] banks={"Visa","Master Card","Union Pay","Cash on Delivery"};
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
		getDriver().navigate().back();
	}
}
*/
