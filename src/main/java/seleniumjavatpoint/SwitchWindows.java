package seleniumjavatpoint;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchWindows extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, 5);

    private By newBrowserWindowBtnCss = By.cssSelector("b > a");
    private By newBrowserWindowBtnXpath = By.xpath("//div/b/a");

    public SwitchWindows(WebDriver driver){
        super(driver);
    }

    /**
     * @return number of windows
     * test: testPracticeSwitchWindow
     */
    public int practiceSwitchWindow() {
        // Put an Implicit wait, this means that any search for elements on the page could take
        // the time the implicit wait is set for before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Launch the URL
        driver.get("http://www.echoecho.com/jswindows03.htm");

        // This  will scroll down the page by  500 pixel vertical
        js.executeScript("window.scrollBy(0,500)");

        // Store and Print the name of the First window on the console
        String handle = driver.getWindowHandle();

        // Click on the Button "New Message Window"
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(newBrowserWindowBtnXpath));
        //WebElement we = wait.until(ExpectedConditions.elementToBeClickable(newBrowserWindowBtnCss));
        we.click();

        // Store and Print the name of all the windows open
        Set handles = driver.getWindowHandles();

        try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}

        // Pass a window handle to the other window
        for (String handle1 : driver.getWindowHandles()) {
            System.out.println(handle1);
            driver.switchTo().window(handle1);
        }

        try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}

        // Closing Pop Up window
        driver.close();

        try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}

        // Close Original window
        driver.quit();

        return handles.size();
    }


}
