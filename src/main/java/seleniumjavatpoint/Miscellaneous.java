package seleniumjavatpoint;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Miscellaneous extends BasePage{

    WebDriverWait wait = new WebDriverWait(driver, 5);
    WebElement we;
    WebElement we2;

    private String googleMainPageUrl = "https://google.com/";

    private By googleSearchBox = By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input");
    private By googleGmailLinkCss = By.cssSelector("#gbw > div > div > div > div > a");
    private By googleGmailLinkXpath = By.xpath("//*[@id=\"gbw\"]/div/div/div/div[1]/a");
    private By newBrowserWindowBtnCss = By.cssSelector("b > a");
    private By newBrowserWindowBtnXpath = By.xpath("//div/b/a");
    private By pictureElementXpath = By.xpath("//*[@id=\"sourceImage\"]");
    private By pictureElementCss = By.cssSelector("#sourceImage");
    private By targetXpath = By.xpath("//*[@id=\"targetDiv\"]");
    private By targetCss = By.cssSelector("#targetDiv");
    private By dropdownXpath = By.xpath("//*[@id=\"testingDropdown\"]");
    private By dropdownCss = By.cssSelector("#testingDropdown");

    public Miscellaneous(WebDriver driver){
        super(driver);
    }


    /**
     * @param searchText
     * @return
     * @throws InterruptedException
     * test: testGoogleInputByBy
     */
    public String googleInputByBy(String searchText) throws InterruptedException {
        driver.get("https://google.com");
        WebElement googleSearchBoxElement = wait.until(ExpectedConditions.presenceOfElementLocated(googleSearchBox));
        googleSearchBoxElement.click();
        googleSearchBoxElement.sendKeys(searchText);
        WebElement googleGmailLinkCssElement = wait.until(ExpectedConditions.presenceOfElementLocated(googleGmailLinkCss));
       // WebElement googleGmailLinkCssElement = wait.until(ExpectedConditions.presenceOfElementLocated(googleGmailLinkXpath));
        googleGmailLinkCssElement.click();
        return driver.getTitle();
    }


    /**
     * @return page title
     * test: testNavigatingBackwardInBrowserHistory
     */
    public String navigatingBackwardForwardInBrowserHistory(){
        driver.get("https://google.com");

        WebElement googleGmailLinkElement = wait.until(ExpectedConditions.presenceOfElementLocated(googleGmailLinkXpath));
        googleGmailLinkElement.click();

        String result = driver.getTitle() + " | ";

        driver.navigate().back();
        result+=driver.getTitle() + " | ";

        driver.navigate().forward();
        result+=driver.getTitle();

        return result;
    }


    /**
     * @return page title
     * test: testRefreshReloadAWebPage
     */
    public String refreshReloadAWebPage(){
        driver.navigate().to("https://google.com");
        String result = driver.getTitle() + " | ";

        driver.navigate().refresh();
        result += driver.getTitle();

        return result;
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
            // try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            driver.switchTo().window(handle1);

            // try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
        }

        try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}

        // Closing Pop Up window
        driver.close();

        try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}

        // Close Original window
        driver.quit();

        try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}

        return handles.size();
    }


    /**
     * @return
     * test: testDragAndDrop
     */
    public String dragAndDrop(){
        driver.get("https://www.testandquiz.com/selenium/testing.html");

        WebElement element = driver.findElement(By.cssSelector("#sourceImage"));
        WebElement target = driver.findElement(By.cssSelector("#targetDiv"));
        (new Actions(driver)).dragAndDrop(element, target).perform();

       // try{Thread.sleep(5000);} catch(InterruptedException e){e.printStackTrace();}
        return null;
    }


    /**
     * @return LinkedHashMap
     * test: testRadioBtnMale
     */
    public Map<String, Boolean> radioBtnMale(){
        driver.get("https://www.testandquiz.com/selenium/testing.html");
        //try{Thread.sleep(5000);} catch(InterruptedException e){e.printStackTrace();}

        we = driver.findElement(By.cssSelector("#male"));
        we.click();

        //try{Thread.sleep(2000);} catch(InterruptedException e){e.printStackTrace();}

        System.out.println(driver.findElement(By.xpath("//*[@id=\"male\"]")).isSelected());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"female\"]")).isSelected());

        Map<String, Boolean> result = new LinkedHashMap<>();
        result.put("male", driver.findElement(By.xpath("//*[@id=\"male\"]")).isSelected());
        result.put("female", driver.findElement(By.cssSelector("#female")).isSelected());

        return result;
    }


    /**
     * @param at Automation Testing
     * @param pt Performance Testing
     * @return dropdown state
     */
    public Map checkBox(boolean at, boolean pt){
        Map<String,Boolean> result = new HashMap<>();
        result.put("Automation Testing", false);
        result.put("Performance Testing", false);

        driver.get("https://www.testandquiz.com/selenium/testing.html");

        //we = driver.findElement(By.cssSelector("input[type='checkbox'][class='Automation']"));
        we = driver.findElement(By.xpath("//div[8]/div/form/input[1]"));
        if(at==true) {
            we.click();
        }
        we2 = driver.findElement(By.xpath("//div[8]/div/form/input[2]"));
        if(pt==true){
            we2.click();
        }

        result.put("Automation Testing",  we.isSelected());
        result.put("Performance Testing", we2.isSelected());

        return result;
    }


    /**
     * Use Select class for selecting value from dropdown
     * @return text of selected element
     * test: testDropdown
     */
    public String dropdown(String url, String element){
        driver.get(url);
        we = wait.until(ExpectedConditions.elementToBeClickable(dropdownXpath));
        Select dropdown = new Select(we);
        dropdown.selectByVisibleText(element);
        return dropdown.getFirstSelectedOption().getText();
    }


    /**
     * @param url
     * @return current url
     * test: testGetCurrentUrl
     */
    public String getCurrentUrl(String url){
        driver.get(url);
        return driver.getCurrentUrl();
    }


    /**
     * @param url
     * @return page source
     * test: testGetPageSource
     */
    public String getPageSource(String url){
        driver.get(url);
        return driver.getPageSource();
    }


    /**
     * @param url
     * @return page title
     * test: testNavigate
     */
    public String navigate(String url){
        driver.navigate().to(url);
        return driver.getTitle();
    }

}
