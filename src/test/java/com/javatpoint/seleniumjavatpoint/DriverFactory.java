package com.javatpoint.seleniumjavatpoint;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 *  This class will be used to generate a WebDriver depending on the parameters from the user
 *  it will contain specefications for the particular drivers
 */
public class DriverFactory {

    public static WebDriver driver;
    public static DesiredCapabilities capabilities;
    public static String driverPath = "/seleniumjavatpoint/resources/webdrivers/mac/";

    public static WebDriver getDriver() {
        return driver;
    }

    protected static void setDriver(String browser, String appURL, String groups) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Library/chromedriver");
                //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/resources/webdrivers/mac/chromedriver");
                capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");
                options.addArguments("disable-extensions");
                options.addArguments("disable-infobars");
                options.addArguments("start-maximized");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(capabilities);
                driver.manage().window().maximize();
                driver.get(appURL);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/resources/webdrivers/mac/geckodriver");
                capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                driver = new FirefoxDriver(capabilities);
//		    driver.manage().window().maximize();
                driver.manage().window().setSize(new Dimension(1920, 1080));
                driver.get(appURL);
                break;
            default:
                System.out.println("browser : " + browser
                        + " is invalid, Launching Firefox as browser of choice..");
                driver = initFirefoxDriver(appURL);
        }
    }

    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching google chrome with new profile..");
        System.setProperty("webdriver.chrome.driver", driverPath
                + "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser..");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

}
