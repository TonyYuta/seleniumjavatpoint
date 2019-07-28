package seleniumjavatpoint;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;


import static org.openqa.selenium.WebElement.*;

public class GoogleMainPage extends BasePage{

    public GoogleMainPage(WebDriver driver){
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, 5);

  //  private static String googleUrl = "https://google.com/";

    //cssSelector
    private String googleMainPageUrl = "https://google.com/";
    //private By searchBox = By.cssSelector(".RNNXgb>div>div");
    private By searchBox = By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input");
    private By aboutLink = By.cssSelector("#hptl>a:nth-child(1)");
    private By googleSearhBtn = By.cssSelector("div.FPdoLc.VlcLAe>center>input.gNO89b[value='Google Search']");

    //id
    private By resultStatsText = By.id("resultStats");

    public GoogleMainPage navigateToMainPage(){
        driver.navigate().to(googleMainPageUrl);
        return new GoogleMainPage(driver);
    }


/*    public void navigateToMainPage() {
        driver.navigate().to(googleMainPageUrl);
    }*/


    public GoogleAboutPage navigateToAboutPage(){
       // WebElement aboutLinkElement = driver.findElement(aboutLink);
        WebElement aboutLinkElement = wait.until(ExpectedConditions.presenceOfElementLocated(aboutLink));

        aboutLinkElement.click();
        return new GoogleAboutPage(driver);
    }

    /**
     * @param text
     * @return String of Search Statistics
     */
    public String searchText(String text){
        WebElement searchBoxElement = wait.until(ExpectedConditions.presenceOfElementLocated(searchBox));
        System.out.println("=======================debug1==================================");
        searchBoxElement.sendKeys(text);
        System.out.println("=======================debug2==================================");

        WebElement googleSearhBtnElement = wait.until(ExpectedConditions.elementToBeClickable(googleSearhBtn));
        System.out.println("=======================debug3==================================");

        //googleSearhBtnElement.click();
        googleSearhBtnElement.sendKeys(Keys.RETURN);
        System.out.println("=======================debug4==================================");

        WebElement resultStatsTextElement = wait.until(ExpectedConditions.presenceOfElementLocated(resultStatsText));
        System.out.println("=======================debug5==================================");

        return resultStatsTextElement.getText();
    }





}
