package seleniumjavatpoint;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDrivers {

    public static void main(String[] args) {
        firefoxDriver();
        chromeDriver();
    }

    public static void chromeDriver(){
        //Creating a driver object referencing WebDriver interface
        WebDriver driver;

//Setting the webdriver.chrome.driver property to its executable's location
        System.setProperty("webdriver.chrome.driver", "/Library/chromedriver");

//Instantiating driver object
        driver = new ChromeDriver();

//Using get() method to open a webpage
        driver.get("http://javatpoint.com");

//Closing the browser
        driver.quit();
    }

    public static void ieDriver(){

    //Creating a driver object referencing WebDriver interface
    WebDriver driver;

//Setting the webdriver.ie.driver property to its executable's location
    System.setProperty("webdriver.ie.driver", "/lib/IEDriverServer/IEDriverServer.exe");

//Instantiating driver object
    driver = new InternetExplorerDriver();

//Using get() method to open a webpage
    driver.get("http://javatpoint.com");

//Closing the browser
    driver.quit();
    }


    public static void firefoxDriver() {

        // System Property for Gecko Driver
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/resources/webdrivers/mac/geckodriver");

        // Initialize Gecko Driver using Desired Capabilities Class
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette",true);
        WebDriver driver= new FirefoxDriver(capabilities);

        // Launch Website
        driver.navigate().to("http://www.javatpoint.com/");

        //Closing the browser
        driver.quit();
    }




}
