package seleniumjavatpoint;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearch extends BasePage{

    public GoogleSearch(WebDriver driver){
        super(driver);
    }

    private static String googleUrl = "https://google.com/";

    // cssSelector
    private String homePageTab = "#orb-nav-links > ul > li.orb-nav-homedotcom.orb-w > a";

    //private String aboutLink = "#hptl>a:nth-child(1)";
    private By aboutLink = By.cssSelector("#hptl>a:nth-child(1)");


    public AboutPage navigateToAboutPage(){
        WebElement aboutLinkElement = driver.findElement(aboutLink);
        aboutLinkElement.click();
        return new AboutPage(driver);
    }



}
