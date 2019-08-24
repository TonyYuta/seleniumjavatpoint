package seleniumjavatpoint;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    private By sourceImageCss = By.cssSelector("#sourceImage");
    private By sourceImageXpath = By.xpath("//img[@id=\"sourceImage\"]");
    private By radioBtnFemaleXpath = By.xpath("//input[@id=\"female\"]");
    private By radioBtnFemaleCss = By.cssSelector("#female");

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
        //try{Thread.sleep(5000);} catch(InterruptedException e){e.printStackTrace();}
        return null;
    }


    public void dragAndDrop02(){
        driver.get("https://www.testandquiz.com/selenium/testing.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        WebElement element = driver.findElement(By.cssSelector("#sourceImage"));
        WebElement target = driver.findElement(By.cssSelector("#targetDiv"));
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(element).moveToElement(target).release(target).build();
        dragAndDrop.perform();
        try{Thread.sleep(3000);}catch(InterruptedException e){e.printStackTrace();}
    }


    /**
     * @return LinkedHashMap
     * test: testRadioBtnMale
     */
    public Map<String, Boolean> radioBtnMale(){
        driver.get("https://www.testandquiz.com/selenium/testing.html");
        //try{Thread.sleep(5000);} catch(InterruptedException e){e.printStackTrace();}

        we = driver.findElement(By.cssSelector("#male"));
        we2 = driver.findElement(By.cssSelector("#female"));

        we.click();

        //try{Thread.sleep(2000);} catch(InterruptedException e){e.printStackTrace();}

        System.out.println(we.isSelected());
        System.out.println(we2.isSelected());

        Map<String, Boolean> result = new LinkedHashMap<>();
        result.put("male", we.isSelected());
        result.put("female", we2.isSelected());

        return result;
    }

    /**
     * @param at Automation Testing
     * @param pt Performance Testing
     * @return check box state
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
     * @return page title after selection dropdown element
     * test: testDropdown2
     */
    public String dropdown2(String url){
        StringBuilder result = new StringBuilder();

        driver.get(url);

        By dropdownById = By.id("fruits");
        WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(dropdownById));
        Select dropdown = new Select(we);
        dropdown.selectByIndex(1);
        result.append(dropdown.getFirstSelectedOption().getText());
     //   dropdown.selectByValue("Orange");
        //dropdown.selectByVisibleText("Grape");
    //    result.append(" ").append(dropdown.getFirstSelectedOption().getText());

        return result.toString();
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

    /**
     * @param url
     * @return boolean isEnabled
     * test: testIsDisplayed
     */
    public boolean isDisplayed(String url){
        driver.navigate().to(url);
        we = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceImageXpath));
        return we.isDisplayed();
    }


    /**
     * @param url
     * @return boolean is female selected
     * test: testIsEnabled
     */
    public boolean isEnabled(String url){
        driver.get(url);
        we = wait.until(ExpectedConditions.elementToBeClickable(radioBtnFemaleXpath));
        we.click();
        return we.isSelected();
    }


    /**
     * @param text
     * @return getAttribute("value") - entered text
     * test: testTypeCommands
     */
    public String typeCommands(String text){
        String url = "https://www.testandquiz.com/selenium/testing.html";
        driver.get(url);
        By textBoxXpatx = By.xpath("//input[@id='fname']");
        we = wait.until(ExpectedConditions.presenceOfElementLocated(textBoxXpatx));
        we.sendKeys(text);
        return we.getAttribute("value");
    }


    /**
     * @return
     * test: testRightClick
     */
    public void rightClick(){
        String url = "https://www.testandquiz.com/selenium/testing.html";
        driver.get(url);
        By imageXpath = By.xpath("//img[@id='sourceImage']");
        By imageCss = By.cssSelector("#sourceImage");
        we = wait.until(ExpectedConditions.presenceOfElementLocated(imageXpath));
        Actions action = new Actions(driver);
        action.contextClick(we).perform();
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }


    /**
     * test: testMouseHover
     */
    public void mouseHover() {
        String url = "https://www.testandquiz.com/selenium/testing.html";
        driver.get(url);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)"); //scroll down the page by  300 pixel vertical

        By generateAlertBoxBtnCss = By.cssSelector("div.row:nth-child(20)>div>p>button");
        By generateAlertBoxBtnXpath = By.xpath("//button[contains(text(),'Generate Alert Box')]");
        we = wait.until(ExpectedConditions.elementToBeClickable(generateAlertBoxBtnCss));
        Actions action = new Actions(driver);
        action.moveToElement(we).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * test: testRefreshThePage
     */
    public void refreshThePage(){
        String url = "https://www.testandquiz.com/selenium/testing.html";
        driver.navigate().to(url);
        By textBoxXpatx = By.xpath("//input[@id='fname']");
        we = wait.until(ExpectedConditions.presenceOfElementLocated(textBoxXpatx));

        //1. Using driver.navigate command -
        driver.navigate().refresh();

        //2. Using driver.getCurrentUrl() with driver.get() command -
        driver.get(driver.getCurrentUrl());

        //3. Using driver.getCurrentUrl() with driver.navigate() command -
        driver.navigate().to(driver.getCurrentUrl());

        //4. Pressing an F5 key on any textbox using the sendKeys command -

        driver.findElement(textBoxXpatx).sendKeys(Keys.F5);

        //5. Passing ascii value of the F5 key, i.e., "\uE035" using the sendKeys command -
        driver.findElement(textBoxXpatx).sendKeys("\uE035");
    }

    /**
     * submit button
     */
    void submit(){
        String url = "https://www.testandquiz.com/selenium/testing.html";
        driver.get(url);
        By submitBtn = By.xpath("//button[@id='idOfButton']");
        we = wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        we.submit();

        WebElement element = driver.findElement(By.id("SubmitButton"));
        String attValue = element.getAttribute("id"); //This will return "SubmitButton"
    }


    /**
     * @return getSize
     * test: testGetSize
     */
    public int[]  getSize(){
        String url = "https://www.testandquiz.com/selenium/testing.html";
        int[] result = new int[2];
        driver.get(url);
        By textBoxCss = By.cssSelector("#fname");
        WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(textBoxCss));
        Dimension dimennsions = we.getSize();
        result[0] = dimennsions.height;
        result[1] = dimennsions.width;
        return result;
    }


    /**
     * @return x & y
     * test: testGetLocation
     */
    public int[] getLocation(){
        String url = "https://www.testandquiz.com/selenium/testing.html";
        driver.get(url);
        int[] result = new int[2];
        By textBoxCss = By.cssSelector("#fname");
        WebElement we = wait.until(ExpectedConditions.presenceOfElementLocated(textBoxCss));
        Point point = we.getLocation();
        result[0] = point.x;
        result[1] = point.y;
        return result;
    }

    /**
     * test: testHandlingAlerts
     */
    public boolean handlingAlerts(){
        driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // This  will scroll down the page by  500 pixel vertical
        js.executeScript("window.scrollBy(0,500)");

        //Handling alert boxes
        //Click on generate alert button
        By generateAlertBoxBtn = By.xpath("//button[contains(text(),'Generate Alert Box')]");
        we = wait.until(ExpectedConditions.elementToBeClickable(generateAlertBoxBtn));
        we.click();
        //driver.findElement(By.linkText("Generate Alert Box")).click();

        //Using Alert class to first switch to or focus to the alert box
        Alert alert = (Alert) driver.switchTo().alert();

        //Using accept() method to accept the alert box
        alert.accept();

        try{Thread.sleep(2000);} catch(InterruptedException e){e.printStackTrace();}

        return true;
    }

    /**
     * read file and manage the data before write out the file for output
     * @return number of lines
     * @throws Exception
     * test: testIoData
     */
    public int ioData(String inputData, String outputData) throws Exception{
        File fileInput = new File(inputData);
        FileWriter fileWriter = new FileWriter(outputData);
        String interm = "";
        Scanner sc = new Scanner(fileInput);

        while (sc.hasNextLine()) {
            interm = (sc.nextLine()).replaceAll("    private By ", "");
            fileWriter.write(interm + '\n');
        }
        sc.close();
        fileWriter.close();

        return interm.length(); // length of the last line
    }






}
