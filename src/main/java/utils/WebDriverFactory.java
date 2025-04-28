package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

    private static final String DRIVER_DIR = "src/test/resources/";

    public static WebDriver getWebDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                return getChromeDriver();
            case "firefox":
                return getFirefoxDriver();
            case "internet explorer":
                return getInternetExplorerDriver();
            default:
                throw new IllegalArgumentException("Match case not found for browser: "
                        + browserName);
        }
    }

    private static WebDriver getChromeDriver() {
//        System.setProperty("webdriver.chrome.driver", DRIVER_DIR + "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver getFirefoxDriver() {
//        System.setProperty("webdriver.gecko.driver", DRIVER_DIR + "geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver getInternetExplorerDriver() {
//        System.setProperty("webdriver.ie.driver", DRIVER_DIR + "IEDriverServer.exe");
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }
}
