package seleniumjavatpoint;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMainPage extends BasePage{

    public GoogleMainPage(WebDriver driver){
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, 5);

    //cssSelector
    private String googleMainPageUrl = "https://google.com/";
    //private By searchBox = By.cssSelector(".RNNXgb>div>div");
    private By searchBox = By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input");
    private By aboutLink = By.cssSelector("#hptl>a:nth-child(1)");
    private By googleSearhBtn = By.cssSelector("div.FPdoLc.VlcLAe>center>input.gNO89b[value='Google Search']");

    //xpath
    private By googleStoreBtn = By.xpath("//*[@id=\"hptl\"]/a[2]");

    //id
    private By resultStatsText = By.id("resultStats");


    public GoogleMainPage navigateToMainPage(){
        driver.navigate().to(googleMainPageUrl);
        return new GoogleMainPage(driver);
    }


    public GoogleAboutPage navigateToAboutPage(){
        WebElement aboutLinkElement = wait.until(ExpectedConditions.presenceOfElementLocated(aboutLink));
        aboutLinkElement.click();
        return new GoogleAboutPage(driver);
    }


    public GoogleStorePage navigateToGoogleStorePage(){
        WebElement googleStoreBtnElement = wait.until(ExpectedConditions.presenceOfElementLocated(googleStoreBtn));
        googleStoreBtnElement.click();
        return new GoogleStorePage(driver);
    }

    /**
     * @param text
     * @return String of Search Statistics
     */
    public String searchText(String text){
        WebElement searchBoxElement = wait.until(ExpectedConditions.presenceOfElementLocated(searchBox));
        searchBoxElement.sendKeys(text);

        WebElement googleSearhBtnElement = wait.until(ExpectedConditions.elementToBeClickable(googleSearhBtn));
        googleSearhBtnElement.sendKeys(Keys.RETURN);

        WebElement resultStatsTextElement = wait.until(ExpectedConditions.presenceOfElementLocated(resultStatsText));
        return resultStatsTextElement.getText();
    }








}
