package wdMethods;

import io.appium.java_client.AppiumDriver;
/*import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;*/
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;
import utils.Reporter;
import utils.WebDriverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class SeMethods extends Reporter implements WdMethods {

	protected static final ThreadLocal<SeMethods> driverThreadLocal = new ThreadLocal<SeMethods>();
	public RemoteWebDriver driver;
	public AppiumDriver appiumDriver;
	protected Properties prop;
	public boolean bRemote,mobileWeb,emulator;
	public String primaryWindowHandle,sHubUrl,sHubPort,browser,mobileDevice,toolName,os,browserVersion,browserName;
	public int short_wait, long_wait, waitTime;

	String userDir = System.getProperty("user.dir");
	Path paths = Paths.get(userDir);
	String project = String.valueOf(paths.getFileName());
	public String imagePath ="C:\\Results\\" + project + "\\Image";
	public void setDriver(SeMethods methods) {

		driverThreadLocal.set(methods);
	}

	public RemoteWebDriver getDriver() {

		return driverThreadLocal.get().driver;
	}

	public SeMethods() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/resources.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			bRemote = Boolean.parseBoolean(prop.getProperty("REMOTE"));
			//mobileWeb = Boolean.parseBoolean(prop.getProperty("MOBILEWEB"));
			browser = prop.getProperty("BROWSER");
			//browser = System.getenv("myvariable");
//			environment=GlobalVariables.getGlobalVariable("environment");
			short_wait = Integer.parseInt(prop.getProperty("SHORT_WAIT"));
			long_wait =Integer.parseInt(prop.getProperty("LONG_WAIT"));
			waitTime =Integer.parseInt(prop.getProperty("WAIT"));
			mobileDevice = prop.getProperty("device");
			toolName = prop.getProperty("toolName");
			os = prop.getProperty("os");
			browserVersion = prop.getProperty("browserVersion");
			browserName = prop.getProperty("browserName");
			emulator = Boolean.parseBoolean(prop.getProperty("emulator"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will launch the browser in local machine and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author    AutomationQA
	 * @paramURL  - The url with http or https
	 * @return
	 *
	 */
	public RemoteWebDriver startApp(String browser, String testCase) {
		return startApp(browser, testCase,false);
	}

	/**
	 * This method will launch the browser in grid node (if remote) and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author    AutomationQA
	 * @paramURL - The url with http or https
	 * @return
	 *
	 */

	public synchronized RemoteWebDriver startApp(String browser, String testCase, boolean bRemote) {
		try {

			// this is for remote run
			if (bRemote) {
				try {
					String URL = "";

					if(GlobalVariables.getGlobalVariable("mobileWeb").contains("true")) {
						System.out.println("Running Mobile web in Remote");
						prop = new Properties();
					prop.load(Files.newInputStream(new File("./src/main/resources/resources.properties").toPath()));
					DesiredCapabilities caps = new DesiredCapabilities();
					caps.setCapability("name", testCase);
					caps.setCapability("testFileNameTemplate", "{testName}_{browser}_{testStatus}");
					caps.setCapability("browserName", browserName);
					caps.setCapability("device", prop.getProperty("device"));
					caps.setCapability("realMobile", prop.getProperty("realMobile"));
					caps.setCapability("os_version", prop.getProperty("os_version"));
					caps.setCapability("name", prop.getProperty("name"));
						caps.setCapability("browserstack.performance", "report");
						HashMap<String, Boolean> networkLogsOptions = new HashMap<>();
						networkLogsOptions.put("captureContent", true);
						caps.setCapability("browserstack.networkLogs", true);
						caps.setCapability("browserstack.networkLogsOptions", networkLogsOptions);

						if(toolName.equalsIgnoreCase("browserstack")){
							URL = "https://" +  prop.getProperty("USERNAME") + ":" + prop.getProperty("AUTOMATE_KEY") + "@hub-cloud.browserstack.com/wd/hub";
						} else if (toolName.equalsIgnoreCase("saucelabs")) {
							URL = "https://" + prop.getProperty("USERNAME") + ":" + prop.getProperty("AUTOMATE_KEY") +
									"@ondemand.saucelabs.com:443/wd/hub";
						}
						driver = new RemoteWebDriver(new URL(URL) , caps);
					System.out.println("Started running on Mobile web Browser stack");

					}else {
						System.out.println("Running web browser in Remote");
						DesiredCapabilities caps = new DesiredCapabilities();


						if(toolName.equalsIgnoreCase("browserstack")){
							caps.setCapability("browserName", browserName);
							caps.setCapability("os_version", prop.getProperty("os_version"));
							caps.setCapability("os", prop.getProperty("os"));
							caps.setCapability("browserVersion", prop.getProperty("browserVersion"));
							caps.setCapability("resolution", "1920x1080");
							caps.setCapability("name", prop.getProperty("name"));
							caps.setCapability("networkLogs", true);
							HashMap<String, Boolean> networkLogsOptions = new HashMap<>();
							networkLogsOptions.put("captureContent", true);
							caps.setCapability("browserstack.networkLogs", true);
							caps.setCapability("browserstack.networkLogsOptions", networkLogsOptions);
							caps.setCapability("browserstack.performance", "report");

							URL = "https://" +  prop.getProperty("USERNAME") + ":" + prop.getProperty("AUTOMATE_KEY") + "@hub-cloud.browserstack.com/wd/hub";
						} else if (toolName.equalsIgnoreCase("saucelabs")) {
							URL = "https://" + prop.getProperty("USERNAME") + ":" + prop.getProperty("AUTOMATE_KEY") +
									"@ondemand.saucelabs.com:443/wd/hub";
						} else if (toolName.equalsIgnoreCase("testingbot")) {

							caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
							caps.setCapability(CapabilityType.BROWSER_VERSION, "122");
							caps.setCapability(CapabilityType.PLATFORM_NAME, "WIN10");
							caps.setCapability("build", System.getenv("TB_BUILD_NAME"));
							Map<String, Object> testingBotOptions = new HashMap<>();
							testingBotOptions.put("name", "Testing Selenium");
							caps.setCapability("tb:options", testingBotOptions);
							URL="https://" + System.getenv("TB_KEY") + ":" + System.getenv("TB_SECRET") + "@hub.testingbot.com/wd/hub";

							//URL = "https://f17f8e41bd07e813d62d2f3c1627310b:a48aec5f8f993ab1a8a9ddc009dbb1d1@hub.testingbot.com/wd/hub";
						}
						driver = new RemoteWebDriver(new URL(URL) , caps);
						System.out.println("Started running on Web Desktop ");

					}

					//reportStep("Running with this remote URL: http://"ava":"+remoteHubPort+"/wd/hub", "INFO");
					System.out.println("Script start to execuitng using "+browserName+" Browser" );

				} catch (MalformedURLException e) {
					e.printStackTrace();
					reportStep("Getting exception in Remote Run", "FAIL",false);
				}

			}

//			else if (emulator){
//				DesiredCapabilities capabilities = new DesiredCapabilities();
//				capabilities.setCapability("platformName", prop.getProperty("emu_platformName"));
//				capabilities.setCapability("deviceName", prop.getProperty("emu_deviceName"));
//				appiumDriver = new AndroidDriver<>(
//						new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
//
//			}

			else{ // this is for local run
				System.out.println(System.getProperty("os.name"));
				String os=System.getProperty("os.name");
				String driverFolder=System.getProperty("user.dir")+"/drivers/";
				System.out.println("Driver folder: "+driverFolder);
				//WebDriverFactory updateDriver=new WebDriverFactory();
				switch (browser){
					case "chrome":
						if(os.contains("Windows")){
							System.setProperty("webdriver.chrome.driver",driverFolder+"chromedriver.exe");
							//WebDriverFactory.getWebDriver("chrome");
						}else if (os.contains("mac")){
							System.setProperty("webdriver.chrome.driver",driverFolder+"chromedriver_mac");
						}
						else{
							System.setProperty("webdriver.chrome.driver",driverFolder+"chromedriver");
						}
					case "firefox":
						if(os.contains("Windows")){
							System.setProperty("webdriver.gecko.driver",driverFolder+"geckodriver.exe");
						}else{
							System.setProperty("webdriver.gecko.driver",driverFolder+"geckodriver-v0.34.0-linux64.tar.gz");
						}
					case "edge":
						if(os.contains("Windows")){
							System.setProperty("webdriver.edge.driver",driverFolder+"msedgedriver.exe");
						}else{
							System.setProperty("webdriver.edge.driver",driverFolder+"msedgedriver");
						}
				}

				/*System.out.println(System.getProperty("os.name"));
				switch (browser){
					case "chrome":
						if(System.getProperty("os.name").contains("Windows")){
							//updateDriver.getWebDriver("chrome");
							//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
						}else{
							System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver");
						}
					case "firefox":
						if(System.getProperty("os.name").contains("Windows")){
							System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
						}else{
							System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver-v0.34.0-linux64.tar.gz");
						}
					case "edge":
						if(System.getProperty("os.name").contains("Windows")){
							System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/drivers/msedgedriver.exe");
						}else{
							System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/drivers/msedgedriver");
						}
				}
*/
				if(browser.equalsIgnoreCase("chrome")){
					//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");

					if(GlobalVariables.getGlobalVariable("mobileWeb").contains("true")) {
						System.out.println("Running Mobile web in local");

						Map<String, Object> deviceMetrics = new HashMap<>();

						Map<String, Object> mobileEmulation = new HashMap<>();
						//mobileEmulation.put("deviceMetrics", deviceMetrics);
						mobileEmulation.put("deviceName", mobileDevice);

						ChromeOptions options = new ChromeOptions();
						options.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 6_0 like Mac OS X) AppleWebKit/536.26 (KHTML, "
						        + "like Gecko) Version/6.0 Mobile/10A5376e Safari/8536.25");
						    options.addArguments("--start-maximized");
						options.addArguments("disable-infobars");
						options.addArguments("--disable-extensions");
						options.setExperimentalOption("mobileEmulation", mobileEmulation);
						driver = new ChromeDriver(options);

					}else {

						System.out.println("Running web browser in local");
						driver = new ChromeDriver();
					}

				}else if (browser.equalsIgnoreCase("firefox")){
					//System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
					driver = new FirefoxDriver();
					System.out.println("Running in Firefox");

				}
				else if (browser.equalsIgnoreCase("edge")){
					//System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
					driver = new EdgeDriver();
					System.out.println("Running in Edge");

				}
				else if (browser.equalsIgnoreCase("safari")){
					driver = new SafariDriver();
					System.out.println("Running in Safari");
				}
			}
			SeMethods sm = new SeMethods();
			sm.driver = driver;
			setDriver(sm);
			Capabilities cap = driver.getCapabilities();
			if(!GlobalVariables.getGlobalVariable("mobileWeb").contains("true")) {
            if (cap.getPlatformName().toString().contains("MAC")) {
                driver.manage().window().fullscreen();
            }else {
                driver.manage().window().maximize();
            }
			}
			getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			String environment = prop.getProperty("ENVIRONMENT");
			//System.out.println(prop.getProperty("PROD_URL"));
			switch (GlobalVariables.getGlobalVariable("environment")) {
				case "US":
					//getDriver().get(prop.getProperty("US_URL"));
					if(environment.equalsIgnoreCase("PROD")){
						//System.out.println(prop.getProperty("PROD_URL"));
						getDriver().get(prop.getProperty("PROD_URL"));
					} else if (environment.equalsIgnoreCase("UAT")) {
						//System.out.println(prop.getProperty("PROD_URL"));
						getDriver().get(prop.getProperty("UAT_URL"));
					}
					break;
				case "CANADA":
					getDriver().get(prop.getProperty("CANADA_URL"));
					break;
				default:
					System.out.println("Could not find the specified environment "+GlobalVariables.getGlobalVariable("environment")+" please check it.");
					reportStep("Could not find the specified environment "+GlobalVariables.getGlobalVariable("environment")+" please check it.", "FAIL",false);
					break;
			}

			waitForServerToPerformAction(10);
			//Close the TOP Sale Banner
			try {
				getDriver().findElement(By.xpath("//button[@aria-label='Close']")).click();
			} catch (Exception e) {
			}
			//Close the Privacy Policy and Terms of Use
			try{
				getDriver().findElement(By.xpath("//div[@id='close_btn_target']")).click();
			}catch (Exception e ){
			}

			//reportStep("The browser:" + browser + " launched successfully", "PASS");

		} catch (Exception e) {
			e.printStackTrace();
			//reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}

		return getDriver();
	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator) {
			case("id"): return getDriver().findElement(By.id(locValue));
			case("link"): return getDriver().findElement(By.linkText(locValue));
			case("xpath"):return getDriver().findElement(By.xpath(locValue));
			case("name"): return getDriver().findElement(By.name(locValue));
			case("class"): return getDriver().findElement(By.className(locValue));
			case("tag"):return getDriver().findElement(By.tagName(locValue));
			}
		} catch (NoSuchElementException e) {
			reportStep("The element with locator "+locator+" not found.","FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while finding "+locator+" with the value "+locValue, "FAIL");
		}
		return null;
	}

	public WebElement locateElement(String locValue) {
		return getDriver().findElement(By.id(locValue));
	}

	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.clear();
			ele.sendKeys(data);

			reportStep("The data: "+data+" entered successfully in the desired field", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "FAIL");
		}
	}

	public void typeAndEnter(WebElement ele, String data) {
		try {
			ele.clear();
			ele.clear();
			ele.sendKeys(data,Keys.ENTER);
			reportStep("The data: "+data+" entered successfully in the desired field", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "FAIL");
		}
	}


	Logger localLogger = Logger.getLogger(this.getClass().getName());

	public void click(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			localLogger.info("this is useful information");
		} catch (InvalidElementStateException e) {
			scrollIntoViewTopOfScreen(ele);
			clickElementByJavaScript(ele);
		} catch (WebDriverException e) {
			e.printStackTrace();
			reportStep("Unknown exception occured while clicking in the "+ele+" field : "+e.getMessage(), "FAIL");
		}
	}

	public void clickWithNoSnap(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			reportStep("The element :"+ele+"  is clicked.", "PASS",false);
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+ele+" could not be clicked", "FAIL",false);
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :","FAIL",false);
		}
	}

	public String getText(WebElement ele) {
		String elementText = "";
		try {
			elementText = ele.getText();
		} catch (WebDriverException e) {
			e.printStackTrace();
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}
		return elementText;
	}

	public String getTitle() {
		String appTitle = "";
		try {
			appTitle =  getDriver().getTitle();
		} catch (WebDriverException e) {
			reportStep("Unknown Exception Occured While fetching Title", "FAIL");
		}
		return appTitle;
	}

	public String getAttribute(WebElement ele, String attribute) {
		String attributeName = "";
		try {
			attributeName=  ele.getAttribute(attribute);
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}
		return attributeName;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
        try {
            new Select(ele).selectByVisibleText(value);
            reportStep("The dropdown is selected with text "+value,"PASS");
        } catch (WebDriverException e) {
            reportStep("The element: "+ele+" could not be found."+e.getMessage(), "FAIL");
        }
    }

	public void selectAngularDropDownUsingText(WebElement ele, String value) {
        try {
             ele.click();
             click(getDriver().findElement(By.xpath("//mat-option/span[contains(.,'"+value+"')]")));
        } catch (WebDriverException e) {
            reportStep("The element: "+ele+" could not be found."+e.getMessage(), "FAIL");
        }
    }

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
			reportStep("The dropdown is selected with index "+index,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}

	}

	public boolean verifyTitle(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().equals(title)) {
				reportStep("The title of the page matches with the value :"+title,"PASS");
				bReturn= true;
			}else {
				reportStep("The title of the page:"+getDriver().getTitle()+" did not match with the value :"+title, "FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}


	public boolean verifyTitleContains(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().contains(title)) {
				reportStep("The title of the page matches with the value :"+title,"PASS");
				bReturn= true;
			}else {
				reportStep("The title of the page:"+getDriver().getTitle()+" did not match with the value :"+title, "FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).equals(expectedText)) {
				reportStep("The text: "+getText(ele)+" matches with the value :"+expectedText,"PASS");
			}else {
				reportStep("The text "+getText(ele)+" doesn't matches the actual "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
		}

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).contains(expectedText)) {
				reportStep("The expected text "+expectedText+" contains the actual "+getText(ele),"PASS");
			}else {
				reportStep("The expected text "+expectedText+" doesn't contain the actual "+getText(ele),"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
		}
	}

	 public void verifyIgnoreCaseText(WebElement ele, String expectedText) {
	        try {
	            if(getText(ele).equalsIgnoreCase(expectedText)) {
	                reportStep("The text: "+getText(ele)+" matches with the value :"+expectedText,"PASS");
	            }else {
	                reportStep("The text "+getText(ele)+" doesn't matches the actual "+expectedText,"FAIL");
	            }
	        } catch (WebDriverException e) {
	            reportStep("Unknown exception occured while verifying the Text", "FAIL");
	        }

	    }

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).equals(value)) {
				reportStep("The expected attribute :"+attribute+" value matches the actual "+value,"PASS");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not matches the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
		}

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).contains(value)) {
				reportStep("The expected attribute :"+attribute+" value contains the actual "+value,"PASS");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not contains the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
		}
	}

	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				reportStep("The element "+ele+" is selected","PASS");
			} else {
				reportStep("The element "+ele+" is not selected","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException as occured: In verifySelected: "+e.getMessage(), "FAIL");
		}
	}
	public void verifyEnabled(WebElement ele) {
		try {
			if(ele.isEnabled()) {
				reportStep("The element "+ele+" is Enabled","PASS");
			} else {
				reportStep("The element "+ele+" is not Enabled","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException as occured: In verifyEnabled"+e.getMessage(), "FAIL");
		}
	}

	public void verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				reportStep("The element "+ele+" is visible","PASS");
			} else {
				reportStep("The element "+ele+" is not visible","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException as occured: In VerifyDisplayed"+e.getMessage(), "FAIL");
		}
	}

	public boolean isDisplayed(WebElement ele) {
		boolean bReturn =false;
		try {
			if(ele.isDisplayed()) {
				bReturn= true;
			}
		} catch (WebDriverException e) {
			//reportStep("WebDriverException as occured: In VerifyDisplayed"+e.getMessage(), "FAIL");
		}
		return bReturn;
	}

	public void isNotDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				reportStep("The element "+ele+" is visible","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("The element "+ele+" is not visible"+e.getMessage(), "PASS");
		}

	}

	public boolean isExists(WebElement ele) {
		if(ele.getSize() != null) {
			return true;
		}
		else {
			return false;
		}
	}


	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = getDriver().getWindowHandles();
			List<String> allHandles = new ArrayList<>();
			allHandles.addAll(allWindowHandles);
			getDriver().switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			reportStep("The driver could not move to the given window by index "+index,"PASS");
		} catch (WebDriverException e) {
			reportStep("WebDriverException as occured in SwitchToWindow : "+e.getMessage(), "FAIL");
		}
	}

	public void switchToParentWindow() {
		try {

			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
				break;
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the first window.", "FAIL");
		}
	}

	public void switchToLastWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the last window.", "FAIL");
		}
	}

	public void switchToParentFrame() {
		try {
			driver.switchTo().defaultContent();
			reportStep("switch In to the Parent Frame ","PASS");
		} catch (NoSuchFrameException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException occured in switchToFrame: "+e.getMessage(), "FAIL");
		}
	}

	public void switchToFrame(WebElement ele) {
		try {
			getDriver().switchTo().frame(ele);
			reportStep("switch In to the Frame "+ele,"PASS");
		} catch (NoSuchFrameException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException occured in switchToFrame: "+e.getMessage(), "FAIL");
		}
	}

	public void acceptAlert() {
		String text = "";
		try {
			Alert alert = getDriver().switchTo().alert();
			text = alert.getText();
			alert.accept();
			reportStep("The alert "+text+" is accepted.","PASS");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException occured in acceptAlert: "+e.getMessage(), "FAIL");
		}
	}

	public void dismissAlert() {
		String text = "";
		try {
			Alert alert = getDriver().switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			reportStep("The alert "+text+" is dismissed.","PASS");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException occured in dismissAlert: "+e.getMessage(), "FAIL");
		}

	}

	public void waitForElementToLoad(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Exception e) {
        	e.printStackTrace();
            reportStep("WebDriverException occured in waitForElement:"+e.getMessage(), "Fail");
        }
    }

	public void waitTillElementNotVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.invisibilityOf(element));
			//reportStep("The Element is found", "INFO",true);

		}
		catch (Exception e) {
			e.printStackTrace();
			reportStep("WebDriverException occured in waitForElement:"+e.getMessage(), "Fail");
		}
	}

	public void waitForElementToLoad2(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(element)));
		}
		catch (Exception e) {
			e.printStackTrace();
			reportStep("WebDriverException occured in waitForElement:"+e.getMessage(), "Fail");
		}
	}

	public void clickElementByJavaScript(WebElement ele) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", ele);
			// reportStep("Element clicked successfully", "PASS");
		} catch (Exception e) {
			e.printStackTrace();
			reportStep("WebDriverException occured in waitForElement:" + e.getMessage(), "Fail");
		}
	}

	public String getAlertText() {
		String alertText = "";
		try {
			Alert alert = getDriver().switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException occured in getAlertText: "+e.getMessage(), "FAIL");
		}
		return alertText;
	}

	public long takeSnap(){
		long snapNumber = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(getDriver().getScreenshotAs(OutputType.FILE) , new File(imagePath+"\\"+snapNumber+".jpg"));

			//FileUtils.copyFile(getDriver().getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+snapNumber+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return snapNumber;
	}

	public void waitForServerToPerformAction(int second){
	//	System.out.println("Waiting for server second");
        try {
        	Thread.sleep(second*500);
        } catch (InterruptedException e) {
            reportStep("Unexpected error occured when waiting for server to perform action","FAIL", false);
        }
    }

	public void closeBrowser() {
		try {
			getDriver().close();
			reportStep("The browser is closed","PASS", false);
		} catch (Exception e) {
			reportStep("The browser could not be closed","FAIL", false);
		}
	}

	public void closeAllBrowsers() {
		try {
			getDriver().quit();
			reportStep("The opened browsers are closed","PASS", false);
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser","FAIL", false);
		}
	}

	public void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Boolean doesPageObjectExist(By locator){
		List<WebElement> ele = getDriver().findElements(locator);
		return !ele.isEmpty();
	}

	public void scrollIntoViewBottomOfScreen(WebElement element) {
		try {
			 getDriver().executeScript("arguments[0].scrollIntoView(false);", element);
			 waitForServerToPerformAction(1);
			 new WebDriverWait(getDriver(),Duration.ofSeconds(long_wait)).until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser"+e,"FAIL", false);
		}
	}

	public void scrollIntoViewTopOfScreen(WebElement element) {
		try {
			 getDriver().executeScript("arguments[0].scrollIntoView(true);", element);
			 waitForServerToPerformAction(1);
			 new WebDriverWait(getDriver(),Duration.ofSeconds(long_wait)).until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser"+e,"FAIL", false);
		}
	}
	public void clickWithSnap(WebElement ele,String name) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			reportStep("The element :"+name+"  is clicked.", "PASS",true);
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+name+" could not be clicked", "FAIL",true);
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :","FAIL",true);
		}
	}

	public void clickAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.clear();
			ele.click();
			ele.sendKeys(data);

			reportStep("The data: "+data+" entered successfully in the desired field", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "FAIL");
		}
	}

	public void openNewTab() {
		try {
			((JavascriptExecutor)getDriver()).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
			getDriver().switchTo().window(tabs.get(1));
			//getDriver().switchTo().newWindow(WindowType.TAB);
		} catch (NoSuchWindowException e) {
			reportStep("The driver could not move to the given window","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException as occured in SwitchToWindow : "+e.getMessage(), "FAIL");
		}
	}

	public void closeTab() {
		try {
			Set<String> allWindowHandles = getDriver().getWindowHandles();
			List<String> allHandles = new ArrayList<>();
			allHandles.addAll(allWindowHandles);
			int lastWindow=allHandles.size();
			//getDriver().switchTo().window(allHandles.get(index));
			getDriver().switchTo().window(allHandles.get(lastWindow-1)).close();
		} catch (NoSuchWindowException e) {
			reportStep("The driver could not move to the given window by index ","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException as occured in SwitchToWindow : "+e.getMessage(), "FAIL");
		}
	}
}